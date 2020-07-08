package com.robin.task.mapper;


import com.robin.task.domain.Task;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface TaskMapper {


    int insertDate(Date date);

    int insertTask(Task task);

    int updateTask(Task task);

    int deleteTask(Integer id);

    List<Task> findAllTask();

}
