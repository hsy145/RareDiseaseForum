<template>
  <el-dialog
    :title="!dataForm.diseaseId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="diseasesName">
      <el-input v-model="dataForm.diseasesName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="description">
      <el-input v-model="dataForm.description" placeholder=""></el-input>
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
          diseaseId: 0,
          diseasesName: '',
          description: '',
          isDeleted: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          diseasesName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          description: [
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
        this.dataForm.diseaseId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.diseaseId) {
            this.$http({
              url: this.$http.adornUrl(`/generator/diseases/info/${this.dataForm.diseaseId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.diseasesName = data.diseases.diseasesName
                this.dataForm.description = data.diseases.description
                this.dataForm.isDeleted = data.diseases.isDeleted
                this.dataForm.createTime = data.diseases.createTime
                this.dataForm.updateTime = data.diseases.updateTime
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
              url: this.$http.adornUrl(`/generator/diseases/${!this.dataForm.diseaseId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'diseaseId': this.dataForm.diseaseId || undefined,
                'diseasesName': this.dataForm.diseasesName,
                'description': this.dataForm.description,
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
