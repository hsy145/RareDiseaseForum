<template>
  <el-dialog
    :title="!dataForm.communicationFriendId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="uId">
      <el-input v-model="dataForm.uId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="diseaseId">
      <el-input v-model="dataForm.diseaseId" placeholder=""></el-input>
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
          communicationFriendId: 0,
          uId: '',
          diseaseId: '',
          content: '',
          isDeleted: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          uId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          diseaseId: [
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
        this.dataForm.communicationFriendId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.communicationFriendId) {
            this.$http({
              url: this.$http.adornUrl(`/generator/communicationfriend/info/${this.dataForm.communicationFriendId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.uId = data.communicationFriend.uId
                this.dataForm.diseaseId = data.communicationFriend.diseaseId
                this.dataForm.content = data.communicationFriend.content
                this.dataForm.isDeleted = data.communicationFriend.isDeleted
                this.dataForm.createTime = data.communicationFriend.createTime
                this.dataForm.updateTime = data.communicationFriend.updateTime
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
              url: this.$http.adornUrl(`/generator/communicationfriend/${!this.dataForm.communicationFriendId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'communicationFriendId': this.dataForm.communicationFriendId || undefined,
                'uId': this.dataForm.uId,
                'diseaseId': this.dataForm.diseaseId,
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
