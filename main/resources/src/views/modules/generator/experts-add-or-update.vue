<template>
  <el-dialog
    :title="!dataForm.expertId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="uId">
      <el-input v-model="dataForm.uId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="specialty">
      <el-input v-model="dataForm.specialty" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="credentials">
      <el-input v-model="dataForm.credentials" placeholder=""></el-input>
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
          expertId: 0,
          uId: '',
          specialty: '',
          credentials: '',
          isDeleted: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          uId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          specialty: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          credentials: [
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
        this.dataForm.expertId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.expertId) {
            this.$http({
              url: this.$http.adornUrl(`/generator/experts/info/${this.dataForm.expertId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.uId = data.experts.uId
                this.dataForm.specialty = data.experts.specialty
                this.dataForm.credentials = data.experts.credentials
                this.dataForm.isDeleted = data.experts.isDeleted
                this.dataForm.createTime = data.experts.createTime
                this.dataForm.updateTime = data.experts.updateTime
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
              url: this.$http.adornUrl(`/generator/experts/${!this.dataForm.expertId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'expertId': this.dataForm.expertId || undefined,
                'uId': this.dataForm.uId,
                'specialty': this.dataForm.specialty,
                'credentials': this.dataForm.credentials,
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
