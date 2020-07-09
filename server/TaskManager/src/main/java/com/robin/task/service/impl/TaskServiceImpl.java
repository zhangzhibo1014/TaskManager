package com.robin.task.service.impl;

import com.robin.task.domain.Task;
import com.robin.task.mapper.TaskMapper;
import com.robin.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;


    @Override
    public int insertTask(Task task) {
        return taskMapper.insertTask(task);
    }

    @Override
    public int updateTask(Task task) {
        return taskMapper.updateTask(task);
    }

    @Override
    public int deleteTask(Integer id) {
        return taskMapper.deleteTask(id);
    }

    @Override
    public List<Task> findAllTask() {
        return taskMapper.findAllTask();
    }


}
