<template>
    <div>
        <div class="taskCard"> {{msg}}</div>
    </div>
</template>

<script>
export default {
  name:'taskCard',
  props:['msg'],
  data() {
    return {

    }
  },
  methods: {

  }
}
</script>

<style scoped lang="less">
.taskCard{
  background-color: #fff;
  width: 400px;
  height: 50px;
  border-radius: 8px;
  // box-shadow: 0px 5px 10px  10px#aaa ;
  margin-bottom: 60px;
}
.taskCard:hover{
  position: relative;
  top: 5px;
  transition: .25s;
  box-shadow: 0px 1px 5px #d9dbe0 ;
}
</style>
