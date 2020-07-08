## Task Manager数据库设计

#### 用户表

```
id - 用户编号
username - 用户名
password - 密码
powerId - 权限ID
nickName - 昵称
email - 邮箱号
```

#### 任务表

```
taskId
taskTitle
taskContent
taskLevelId
taskNatureId
taskStatus
taskPreFinishedDate
taskStartDate
taskFinishDate
```

#### 任务等级表

```
taskLevelId
taskLevelName
```

#### 任务性质表

```
taskNatureId
taskNatureName
```

