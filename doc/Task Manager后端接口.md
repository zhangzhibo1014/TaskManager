## 后端接口

### 登陆 & 注册

#### 登陆

```
接口地址：zhangzb.qicp.vip/login
请求方式：post
参数：
    String username
    String password
```

#### 用户名校验是否重复

```
接口地址：zhangzb.qicp.vip/isExistUserName
请求方式：post
参数：
	String username
```

#### 昵称校验是否重复

```
接口地址：zhangzb.qicp.vip/isExistNickName
请求方式：post
参数：
    String nickName
```

#### 邮箱验证码发送

```
接口地址：zhangzb.qicp.vip/sendEmail
请求方式：post
参数：
    String nickName
    String email
```

#### 用户注册校验

```
接口地址：zhangzb.qicp.vip/register
请求方式：post
参数：
    String username
    String password
    String nickName
    String email
    String code (邮箱中的验证码)
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

参数：
String taskTitle
String taskContent
Date taskPreFinishedDate

```

