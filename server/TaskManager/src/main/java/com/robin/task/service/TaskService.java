package com.robin.task.service;

import com.robin.task.domain.Task;

import java.util.Date;
import java.util.List;

public interface TaskService {


    int insertTask(Task task);

    int updateTask(Task task);

    int deleteTask(Integer id);

    List<Task> findAllTask();
}
