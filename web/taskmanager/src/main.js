import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import cors from 'cors'

Vue.use(ElementUI)
Vue.use(cors)
Vue.config.productionTip = false

axios.defaults.headers.post['content-Type'] = 'text/plain'
axios.defaults.baseURL = 'http://zhangzb.qicp.vip'
Vue.prototype.$http = axios

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
