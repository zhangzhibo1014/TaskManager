import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import cors from 'cors'
// 导入全局样式表
import './assets/css/global.css'


Vue.use(ElementUI)
Vue.use(cors)
Vue.config.productionTip = false

// axios.defaults.headers.post['content-Type'] = 'application/x-www-form-urlencoded'
axios.defaults.transformRequest=(data) =>{return Qs.stringify(data)}
// -------全局设置transformRequest



axios.defaults.baseURL = 'http://zhangzb.qicp.vip'
Vue.prototype.$http = axios



new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
