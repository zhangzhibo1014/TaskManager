package com.robin.task.service.impl;

import com.robin.task.domain.TaskLevel;
import com.robin.task.mapper.TaskLevelMapper;
import com.robin.task.service.TaskLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskLevelServiceImpl implements TaskLevelService {

    @Autowired
    private TaskLevelMapper taskLevelMapper;

    @Override
    public List<TaskLevel> findAllTaskLevel() {
        return taskLevelMapper.findAllTaskLevel();
    }

    @Override
    public int insertTaskLevel(TaskLevel taskLevel) {
        return taskLevelMapper.insertTaskLevel(taskLevel);
    }

    @Override
    public int updateTaskLevel(TaskLevel taskLevel) {
        return taskLevelMapper.updateTaskLevel(taskLevel);
    }

    @Override
    public int deleteTaskLevel(Integer id) {
        return taskLevelMapper.deleteTaskLevel(id);
    }
}
