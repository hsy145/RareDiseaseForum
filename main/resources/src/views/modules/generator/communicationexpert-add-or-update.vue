<template>
  <el-dialog
    :title="!dataForm.communicationExpertId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="expertId">
      <el-input v-model="dataForm.expertId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uId">
      <el-input v-model="dataForm.uId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="content">
      <el-input v-model="dataForm.content" placeholder=""></el-input>
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
          communicationExpertId: 0,
          expertId: '',
          uId: '',
          content: '',
          isDeleted: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          expertId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          content: [
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
        this.dataForm.communicationExpertId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.communicationExpertId) {
            this.$http({
              url: this.$http.adornUrl(`/generator/communicationexpert/info/${this.dataForm.communicationExpertId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.expertId = data.communicationExpert.expertId
                this.dataForm.uId = data.communicationExpert.uId
                this.dataForm.content = data.communicationExpert.content
                this.dataForm.isDeleted = data.communicationExpert.isDeleted
                this.dataForm.createTime = data.communicationExpert.createTime
                this.dataForm.updateTime = data.communicationExpert.updateTime
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
              url: this.$http.adornUrl(`/generator/communicationexpert/${!this.dataForm.communicationExpertId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'communicationExpertId': this.dataForm.communicationExpertId || undefined,
                'expertId': this.dataForm.expertId,
                'uId': this.dataForm.uId,
                'content': this.dataForm.content,
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
