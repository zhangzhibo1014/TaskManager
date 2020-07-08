package com.robin.task.controller;


import com.robin.task.domain.User;
import com.robin.task.dto.UserDto;
import com.robin.task.service.UserService;
import com.robin.task.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@RestController
@CrossOrigin
public class UserController {

    private Integer code;

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private TemplateEngine templateEngine;

    /**
     * 判断用户名密码是否匹配，匹配则登录，否则提示错误
     * @param username 用户名
     * @param password 密码
     * @return 返回message
     */
    @PostMapping("/login")
    public Result login(String username, String password) {
        System.out.println("username=" + username);
        System.out.println("password=" + password);
        int isExistUserName = userService.isExistUserName(username);
        int result = userService.findUser(username, password);
        if (0 == isExistUserName) {
            return Result.error(20000, "用户名不存在");
        }
        if (0 == result) {
            return Result.error(20000, "用户名或密码不匹配");
        } else  {
            return Result.ok();
        }
    }

    /**
     * 判断昵称是否可用
     * @param nickName 昵称
     * @return 返回message
     */
    @PostMapping("/isExistNickName")
    public Result isExistNickName(String nickName) {
        System.out.println("nickName=" + nickName);
        int result = userService.isExistNickName(nickName);
        if (0 == result) {
            return Result.ok("可用的昵称");
        } else {
            return Result.error(20000, "重复的昵称");
        }
    }

    /**
     * 判断用户名是否可用
     * @param username 用户名
     * @return 返回message
     */
    @PostMapping("/isExistUserName")
    public Result isExistUserName(String username)  {
        System.out.println("username=" + username);
        int result = userService.isExistUserName(username);
        if (0 == result) {
            return Result.ok("可用的用户名");
        } else {
            return Result.error(20000, "重复的用户名");
        }
    }

    /**
     * 发送邮件
     * @param nickName 昵称
     * @param email 收件人邮箱
     * @return 返回message
     */
    @PostMapping("/sendEmail")
    public Result sendEmail(String nickName, String email) {
        System.out.println("nickName=" + nickName);
        System.out.println("email=" + email);
        this.code = ((int)(Math.random()*8999 + 1000));
        String subject = "Task Manager 邮箱验证";
        Context context = new Context();
        context.setVariable("code", code);
        context.setVariable("username", nickName);
        String emailContent = templateEngine.process("email", context);

        boolean flag = userService.sendMail(email, subject, emailContent);
        if (flag) {
            return Result.ok("邮件发送成功");
        } else {
            return Result.error(20000, "邮件发送失败");
        }
    }

    /**
     * 用户注册
     * @param userDto 用户接收参数实体类
     * @return 返回message
     */
    @PostMapping("/register")
    public Result register(UserDto userDto) {
        System.out.println(this.code);
        System.out.println(userDto);
        if (Integer.valueOf(userDto.getCode()).equals(this.code)) {
            User user = new User();
            user.setUsername(userDto.getUsername());
            user.setNickName(userDto.getNickName());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            int result = userService.insertUser(user);
            if (result == 0) {
                return Result.error(20000, "添加用户失败");
            } else {
                return Result.ok("添加用户成功");
            }
        } else {
            return Result.error(20000, "邮箱验证码错误");
        }
    }

}
