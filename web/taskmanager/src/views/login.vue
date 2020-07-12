<template>
     <div class="login-container">
        <div class="login-box">
          <span >Todo List</span>
            <!-- 登录 -->
            <el-form :model="loginForm" :rules="loginFormRules" ref="loginFormRef" label-width="0px" class="login-form">
                <el-form-item prop="userName">
                    <el-input  prefix-icon="iconfont icon-user"
                     v-model="loginForm.userName"></el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input type="password" prefix-icon="iconfont icon-3702mima"
                     v-model="loginForm.password" @keyup.enter.native="login" show-password></el-input>
                </el-form-item>
                 <!-- <el-checkbox label="记住密码" name="type" v-model="checked"></el-checkbox> -->
                <!-- 按钮 -->
                <el-form-item class="btns">
                    <el-button type="primary" @click="login">登录</el-button>
                    <el-button type="info" @click="register">注册</el-button>
                </el-form-item>
            </el-form>
        </div>
        <!-- 注册对话框 -->
         <el-dialog
              :close-on-click-modal="false"
              title='用户注册'
              :visible.sync="addDialogVisible"
              width="500px"
              @closed="addUserDialogClodsed"
              style="margin-top:10vh"
            >
                <el-form :model= "addUsersForm" :rules="addUsers" ref="addUsersRef" label-width="100px" >
                    <el-form-item label="用户名称:" prop="userName">
                        <el-input v-model="addUsersForm.userName"></el-input>
                    </el-form-item>
                    <el-form-item label="用户昵称:" prop="nickName">
                        <el-input v-model="addUsersForm.nickName"></el-input>
                    </el-form-item>
                <el-form-item label="密 码" prop="password">
                 <el-input v-model="addUsersForm.password" show-password></el-input>
                </el-form-item>
                    <el-form-item label="邮 箱:" prop="email">
                      <el-input v-model="addUsersForm.email"></el-input>
                    </el-form-item>
                    <el-form-item label="验证码:" >
                      <el-input v-model="addUsersForm.code" style="width:225px"></el-input>
                      <el-button type="success" style="margin-left:20px" @click="getCode">获取验证码</el-button>
                    </el-form-item>

                </el-form>
                <span slot="footer" class="dialog-footer">
                    <el-button type="primary" @click="addUser()">确 定</el-button>
                </span>
            </el-dialog>
    </div>
</template>

<script>
import axios from 'axios'
import Qs from 'qs'
export default {
  data () {
    // 自定义用户名验证规则
    var checkUserName = (rule, value, callback) => {
      const regUser = /^[A-Za-z\u4e00-\u9fa50-9]+$/
      if (regUser.test(value)) {
        // 合法
        return callback()
      }
      callback(new Error('用户名可输入数字、字母和中文字符'))
    }
    var isExistUserName = async (rule, value, callback) => {
      const { data: res } = await this.$http.post('/isExistUserName', {username:value})
      if (res.code === 10000) {
        return callback()
      }else{
      callback(new Error('用户名重复，请重新输入'))
      }
    }
    // 自定义名用户密码验证规则
    var checkpassword = (rule, value, callback) => {
      const regUser = /^[A-Za-z\d@$!%*?&.]+$/
      if (regUser.test(value)) {
        // 合法
        return callback()
      }
      callback(new Error('非法的特殊字符'))
    }
    var checkEmail = (rule, value, callback) => {
      const regEmail = /^\w+@[a-z0-9]+\.[a-z]{2,4}$/
      if (regEmail.test(value) || !value) {
        return callback()
      }
      callback(new Error('请输入合法的邮箱'))
    }
    return {
      addDialogVisible: false,
      addUsersForm: {
        password: '',
        userName: '',
        nickName: '',
        email: '',
        code: ''
      },
      loginForm: {
        userName: '',
        password: ''
      },
      loginFormRules: {
        userName: [
          { required: true, message: '请输入用户名', trigger: 'blur' },

          {
            min: 2,
            message: '用户名最少两个字符',
            trigger: 'blur'
          }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { validator: checkpassword, trigger: 'blur' }
          // {
          //   min: 6,
          //   max: 18,
          //   message: '用户密码的长度在6～18个字符',
          //   trigger: 'blur'
          // }
        ]
      },
      addUsers: {

        userName: [
          { required: true, message: '请确认输入用户名', trigger: 'blur' },
          { min: 2, max: 8, message: '长度在 2 到 8 个字符', trigger: 'blur' },
          { validator: isExistUserName, trigger: 'blur' }
        ],
        nickName: [
          { required: true, message: '请确认输入用户昵称', trigger: 'blur' },
          { validator: isExistUserName, trigger: 'blur' }
        ],

        email: [
          { required: true, message: '请确认输入邮箱', trigger: 'blur' },
          { message: '请确认输入邮箱', trigger: 'blur' },
          { validator: checkEmail, trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请确认输入密码', trigger: 'blur' },
          { message: '请确认输入密码', trigger: 'blur' },
          { validator: checkpassword, trigger: 'blur' }
        ]
      },
      checked: false
    }
  },
  methods: {
    addUserDialogClodsed () {
      this.$refs.addUsersRef.clearValidate()
    },
    login () {
      this.$refs.loginFormRef.validate(async valid => {
        if (!valid) return
        const { data: res } = await this.$http.post('/login', this.loginForm)
        if (res.code !== 100) {return this.$message.error(res.message)}else{
          this.$http.push('/index')
        }
      })
      // this.$router.push('/index')
    },
  register () {
      // var nickName = 123
              // 前后端传输转码
    //     var params = new URLSearchParams()
    //     params.append('nickName', '123')
    // this.$http.post('/isExistNickName', {nickName:123})
      
      axios({
          url: 'http://zhangzb.qicp.vip/isExistNickName',
          method: 'post',
          transformRequest: [function (data) {
              // 对 data 进行任意转换处理
              return Qs.stringify(data)
          }],
          headers: {
              'deviceCode': 'A95ZEF1-47B5-AC90BF3'
          },
          data: {
             nickName: 'admin'
          }
      })
      // this.addDialogVisible = true
    },
    
    addUser () {    
      this.$refs.addUsersRef.validate(async valid => {
        if (!valid) return
        // 确认用户名是否重复
        const { data: resA } = await this.$http.post('/isExistUserName', this.loginForm.userName)
        if (resA.code !== 10000) {
          return this.$message.error('请求失败！')
        }
        if (resA.data !== true) {
          return this.$message.error(resA.message)
        }
        // 确认昵称是否重复
        const { data: resB } = await this.$http.post('/isExistNickName', this.loginForm.nickName)
        if (resB.code !== 10000) {
          return this.$message.error('请求失败！')
        }
        if (resB.data !== true) {
          return this.$message.error(resB.message)
        }
        if (!this.addUsersForm.code) {
          return this.$message.error('请输入验证码！')
        }
        // 发起注册用户的网络请求
        const { data: res } = await this.$http.post('/user/add', this.addUsersForm)
        if (res.code !== 10000) {
          return this.$message.error('注册用户失败')
        }
        this.$message.success('注册用户成功')
      })

      this.addDialogVisible = false
    },
    // 邮箱验证
    async getCode () {
      if (!this.addUsersForm.nickName) {
        return this.$message.error('请输入用户昵称！')
      }
      var sendData = {}
      // sendData.nickName = this.addUsersForm.nickName
      sendData.email = this.addUsersForm.email
      const postData = qs.pa({
        email: this.addUsersForm.email
      })
      const { data: res } = await this.$http.get('/checkEmail', JSON.stringify(sendData))
      this.addUsersForm.code = res.data.code
    }
  }
}
</script>

<style lang="less" scoped>
.login-container{
    width: 100%;
    height: 970px;
    background: url('../assets/img/login-bg.jpg') no-repeat;
    background-size: 100% 100%;
}
.login-box{
    border: 1px solid #ccc;
    width: 450px;
    height: 300px;
    background-color: #ffffff;
    border-radius: 3px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%,-50%);
}
.avatar-box{
    height: 130px;
    width: 130px;
    border: 1px solid #eee;
    border-radius: 50%;
    padding: 10px;
    box-shadow: 0 0 10px;
    position: absolute;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: #eee;
    img{
        padding-left: 2.5%;
        width: 95%;
        height: 95%;
        // border-radius: 50%;
        // background-color: #eee;

    }
}
.btns{
    display: flex;
    justify-content: flex-end;
}
.login-form{
    position: absolute;
    bottom: 0px;
    width: 100%;
    padding: 0 20px;
    box-sizing: border-box;
}
</style>
