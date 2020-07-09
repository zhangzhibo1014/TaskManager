## 后端接口

### 登陆 & 注册

#### 登陆

```
接口地址：zhangzb.qicp.vip/login
请求方式：post
参数：
    username（用户名）
    password（密码）
```

#### 用户名校验是否重复

```
接口地址：zhangzb.qicp.vip/isExistUserName
请求方式：post
参数：
	username（用户名）
```

#### 昵称校验是否重复

```
接口地址：zhangzb.qicp.vip/isExistNickName
请求方式：post
参数：
    nickName（昵称）
```

#### 邮箱验证码发送

```
接口地址：zhangzb.qicp.vip/sendEmail
请求方式：post
参数：
    nickName（昵称）
    email（邮箱）
```

#### 用户注册校验

```
接口地址：zhangzb.qicp.vip/register
请求方式：post
参数：
    username（用户名）
    password（密码）
    nickName（昵称）
    email（邮箱）
    code (邮箱中的验证码)
```

### 任务管理

#### 获取所有任务

```
接口地址：/task
请求方式：get
参数：
	None
```

#### 添加任务

```
接口地址：/task
请求方式：post
参数：
    taskTitle（任务标题）
    taskContent（任务内容）
    taskLevel.taskLevelId（任务等级id）
    taskNature.taskNatureId（任务性质id）
    taskPreFinishedDate(任务预完成时间)
```

#### 修改任务

```
接口地址：/task/update
请求方式：post
参数：
	taskId（任务id）
	taskTitle（任务标题）
    taskContent（任务内容）
    taskLevel.taskLevelId（任务等级id）
    taskNature.taskNatureId（任务性质id）
    taskStatus（任务状态，0代表未完成，1代表完成）
    taskPreFinishedDate(任务预完成时间)
    taskFinishDate（任务完成时间）
```

#### 删除任务

```
接口地址：/task/delete
请求方式：post
参数：
	id(要删除的任务id)
```

