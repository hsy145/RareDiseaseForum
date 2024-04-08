<template>
  <el-dialog
    :title="!dataForm.discoverId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="uId">
      <el-input v-model="dataForm.uId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="discoverTitle">
      <el-input v-model="dataForm.discoverTitle" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="discoverContent">
      <el-input v-model="dataForm.discoverContent" placeholder=""></el-input>
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
          discoverId: 0,
          uId: '',
          discoverTitle: '',
          discoverContent: '',
          isDeleted: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          uId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          discoverTitle: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          discoverContent: [
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
        this.dataForm.discoverId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.discoverId) {
            this.$http({
              url: this.$http.adornUrl(`/generator/forumdiscover/info/${this.dataForm.discoverId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.uId = data.forumDiscover.uId
                this.dataForm.discoverTitle = data.forumDiscover.discoverTitle
                this.dataForm.discoverContent = data.forumDiscover.discoverContent
                this.dataForm.isDeleted = data.forumDiscover.isDeleted
                this.dataForm.createTime = data.forumDiscover.createTime
                this.dataForm.updateTime = data.forumDiscover.updateTime
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
              url: this.$http.adornUrl(`/generator/forumdiscover/${!this.dataForm.discoverId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'discoverId': this.dataForm.discoverId || undefined,
                'uId': this.dataForm.uId,
                'discoverTitle': this.dataForm.discoverTitle,
                'discoverContent': this.dataForm.discoverContent,
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
