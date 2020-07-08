package com.robin.task.mapper;

import com.robin.task.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    int isExistNickName(String nickName);

    int isExistUserName(String username);

    int insertUser(User user);

    int findUser(String username, String password);

}
