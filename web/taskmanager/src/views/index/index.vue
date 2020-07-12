<template>
    <div class="wrapper">
      <header class="header">
        <div class="avater"></div>
        
      </header>
      <!-- sideBar -->
      <div class="sidebarMenu">
      </div>

      



      <!-- 任务展示 -->
       <div class="taskAxis">
         <div class="taskSeriesH">
           本周任务：

          <el-button type="primary" 
          style="margin-left:20px;padding:6px 10px 6px 10px; float:right;" 
          @click="addTaskBtn" >
          <i class="el-icon-circle-plus-outline" style="font-weight:1000">
            </i>添加任务</el-button>

         </div>
         <div class="cardWrapper">
           <taskCard v-for="(o,index) in taskData" :key="index" :msg="taskData[index]"></taskCard>
           
         </div>
       </div>

             <!-- subCard -->
      <div class="subCard">

        <el-button type="primary" 
          style="margin-left:20px;padding:6px 10px 6px 10px; float:right;" 
          @click="addTaskLevelBtn" >
          <i class="el-icon-circle-plus-outline" style="font-weight:1000">
          </i>添加任务等级 </el-button>

        <div style="height:200px;width:300px;border:1px solid blue;margin-top:60px;margin-bottom:30px"> {{taskLevel}}</div>

        <el-button type="primary" 
          style="margin-left:20px;padding:6px 10px 6px 10px; float:right;" 
          @click="addTaskNatureBtn" >
          <i class="el-icon-circle-plus-outline" style="font-weight:1000">
          </i>添加任务性质 </el-button>

          <div style="height:200px;width:300px;border:1px solid blue ; margin-top:90px"> {{taskNature}}</div>

      </div>


       <!-- 添加任务对话框 -->
        <el-dialog
         :before-close="handleClose"
          title="添加任务"
          :visible.sync="addTaskDialogVisible"
          width="30%">
          <el-form :model="addTaskForm"  ref="addTaskFormRef" >
            
                  <el-form-item label="任务标题：" label-width="100px" prop="taskTitle">
                    <el-input v-model="addTaskForm.taskTitle"
                    ></el-input>
                  </el-form-item>             

                <el-form-item label="任务内容：" prop="taskContent" label-width="100px" >
                  <el-input
                    type="textarea"
                    placeholder="请输入内容"
                    v-model="addTaskForm.taskContent">
                  </el-input>
                </el-form-item>

                <el-form-item label="任务等级：" label-width="100px" prop= "taskLevelId">
                <el-select v-model="addTaskForm.taskLevelId" placeholder="请选择">
                  <el-option
                    v-for="item in tadkLevel"
                    :key="item.taskLevelId"
                    :label="item.taskLevelId"
                    :value="item.taskLevelId">
                    </el-option>
                  </el-select>
                </el-form-item>

                <el-form-item label="任务性质：" label-width="100px" prop= "taskNatureId">
                  <el-select v-model="addTaskForm.taskNatureId" placeholder="请选择">
                    <el-option
                      v-for="item in taskNature"
                      :key="item.taskNatureId"
                      :label="item.taskNatureId"
                      :value="item.taskNatureId">
                    </el-option>
                  </el-select>
                </el-form-item>

                <el-form-item label="任务时间：" label-width="100px" prop= "taskPreFinishedDate">
                 <el-time-picker
                    is-range
                    v-model="value1"
                    range-separator="至"
                    start-placeholder="开始时间"
                    end-placeholder="结束时间"
                    placeholder="选择时间范围">
                  </el-time-picker>
                </el-form-item>

            </el-form>
            <span slot="footer" class="dialog-footer">
              <el-button @click="handleClose">取 消</el-button>
              <el-button type="primary" @click="confirmAdd">确 定</el-button>
            </span>
        </el-dialog>

         <!-- 添加任务对话框 -->
        <el-dialog
         :before-close="subHandleClose"
          :title="'添加任务'+ level? '等级':'性质'"
          :visible.sync="addTaskAttrDialogVisible"
          width="30%">
          <el-form   ref="addTaskFormRef" >


                <el-form-item label="任务等级：" label-width="100px"  v-if="level">
                   <el-input
                      placeholder="请输入内容"
                      v-model="addTaskLevelForm">
                    </el-input>
                </el-form-item>

                <el-form-item label="任务性质：" label-width="100px"  v-else>
                  <el-input
                    placeholder="请输入内容"
                    v-model="addTaskNatureForm">
                  </el-input>
                </el-form-item>

 

            </el-form>
            <span slot="footer" class="dialog-footer">
              <el-button @click="subHandleClose">取 消</el-button>
              <el-button type="primary" @click="confirmAdd">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
import taskCard from '../../components/taskCard'
export default {
  components: {taskCard},
  name: 'index',
  data () {
    return {
      addTaskLevelForm:'',
      addTaskNatureForm:'',
      level: false,
      taskData: [],
      addTaskDialogVisible: false,
      addTaskAttrDialogVisible:false,
      taskLevel:{},
      taskNature:{},
      addTaskForm:{
        taskTitle: '',
        taskContent: '',
        taskLevelId: '',
        taskNatureId: '',
        taskPreFinishedDate: ''
      },
      // 任务性质
      taskNature:[],
      // 任务等级
      tadkLevel:[]
    }
  },
  created(){
    this.getTaskData()
    this.getTaskNature()
    this.getTaskLevel()
  },
  methods: {
    // *************************************************************查询任务数据
    async  getTaskData(){
      const {data:res} = await this.$http.get('zhangzb.qicp.vip/task')
      if(res.code !==100){
        this.$message.error(res.message)
      }else{
        this.taskData= res.data
      }
    },

    // *************************************************************添加任务
    addTaskBtn(){
      this.addTaskDialogVisible = true
    },
    // 添加任务确定按钮
    async confirmAdd(){
      const {data:res} = this.$http.post('/task',this.addTaskForm)
         if(res.code !==100){
        this.$message.error('添加失败！')
      }else{
        this.$message.sucess('添加成功！')
      }
      this.getTaskData()
      this.addTaskDialogVisible =false
    },
    handleClose(){
      this.addTaskDialogVisible = false
      this.$refs.addTaskFormRef.resetFields()
    },
    // *************************************************************查询任务等级
    async getTaskLevel(){
      const {data:res} = await this.$http.get('/taskLevel')
         if(res.code !==100){
        this.$message.error(res.message)
      }else{
          this.taskLevel = res.data
      }
    },
    addTaskLevelBtn(){
      this.level = true
      this.addTaskAttrDialogVisible = true
    },
    // *************************************************************查询任务性质
    async getTaskNature(){
      const {data:res} = await this.$http.get('/taskNature')
         if(res.code !==100){
        this.$message.error(res.message)
      }else{
          this.taskNature = res.data
      }
    },
    addTaskNatureBtn(){
      this.level = false
      this.addTaskAttrDialogVisible = true
    }

  }
}
</script>

<style scoped lang="less">
.wrapper{
  width: 100%;
  
}
.header{
  height: 70px;
  background-color: #fefefe;
  border-bottom: 1px solid #d9dee3;
  box-shadow: 0 8px 8px #e3e6eb;
}
.avater{
  margin: 10px 50px 0 0;  
  float: right;
  border-radius: 50%;
  height: 50px;
  width: 50px;
  background:url('../../assets/img/user.jpg') no-repeat;
  background-size: 140% 100%;
}
.sidebarMenu{
  position: relative;
  margin: 60px  0 0 75vw;
  width: 300px;
  height: 46px;
  border-radius: 23px;
  border: 1px solid #f8f9fb;
  box-shadow: 0 8px 15px #c4c7ce inset;
}
.taskAxis{
  margin: -46px 0 0 150px;
  position: relative;
  width: 60vw;
  height: 750px;
    border-radius: 23px;
  border: 1px solid #f8f9fb;
  box-shadow: 0 8px 15px #c4c7ce inset;
}
.taskSeriesH{
  margin: 0 auto;
width: 92%;
height: 70px;
border-bottom: 1px solid #d8e0ea;
box-shadow: 0 1px 2px #f8f9fb;
}
.cardWrapper{
  overflow: hidden;
  width: 40%;
  margin: 40px 0 0 70px;
}
.subCard{
  height: 662px;
  width: 328px;
  position: relative;
  top:-666px;
  left:1429px;
  border: 1px solid green;

}

</style>
