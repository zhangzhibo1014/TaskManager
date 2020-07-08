package com.robin.task.service;

import com.robin.task.domain.User;

public interface UserService {

    int findUser(String username, String password);

    int isExistNickName(String nickName);

    int isExistUserName(String username);

    int insertUser(User user);

    boolean sendMail(String to, String subject, String content);
}
