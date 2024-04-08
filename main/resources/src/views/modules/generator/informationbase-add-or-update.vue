<template>
  <el-dialog
    :title="!dataForm.iId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="iTitle">
      <el-input v-model="dataForm.iTitle" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="iContent">
      <el-input v-model="dataForm.iContent" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="isDeleted">
      <el-input v-model="dataForm.isDeleted" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          iId: 0,
          iTitle: '',
          iContent: '',
          isDeleted: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          iTitle: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          iContent: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          isDeleted: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.iId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.iId) {
            this.$http({
              url: this.$http.adornUrl(`/generator/informationbase/info/${this.dataForm.iId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.iTitle = data.informationbase.iTitle
                this.dataForm.iContent = data.informationbase.iContent
                this.dataForm.isDeleted = data.informationbase.isDeleted
                this.dataForm.createTime = data.informationbase.createTime
                this.dataForm.updateTime = data.informationbase.updateTime
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/generator/informationbase/${!this.dataForm.iId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'iId': this.dataForm.iId || undefined,
                'iTitle': this.dataForm.iTitle,
                'iContent': this.dataForm.iContent,
                'isDeleted': this.dataForm.isDeleted,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
