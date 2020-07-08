package com.robin.task.service.impl;

import com.robin.task.domain.User;
import com.robin.task.mapper.UserMapper;
import com.robin.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class UserServiceImpl implements UserService {

    @Value("${sendMailAddress}")
    private String form;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public int findUser(String username, String password) {
        return userMapper.findUser(username, password);
    }

    @Override
    public int isExistNickName(String nickName) {
        return userMapper.isExistNickName(nickName);
    }

    @Override
    public int isExistUserName(String username) {
        return userMapper.isExistUserName(username);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public boolean sendMail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(this.form);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            mailSender.send(message);
            return true;
        } catch (Exception e) {
            System.out.println("邮件发送失败" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

}
