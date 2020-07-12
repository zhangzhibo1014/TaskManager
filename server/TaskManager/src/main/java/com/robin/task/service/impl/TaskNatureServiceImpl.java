package com.robin.task.service.impl;

import com.robin.task.domain.TaskNature;
import com.robin.task.mapper.TaskNatureMapper;
import com.robin.task.service.TaskNatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskNatureServiceImpl implements TaskNatureService {
    @Autowired
    private TaskNatureMapper taskNatureMapper;

    @Override
    public List<TaskNature> findAllTaskNature() {
        return taskNatureMapper.findAllTaskNature();
    }

    @Override
    public int insertTaskNature(TaskNature taskNature) {
        return taskNatureMapper.insertTaskNature(taskNature);
    }

    @Override
    public int updateTaskNature(TaskNature taskNature) {
        return taskNatureMapper.updateTaskNature(taskNature);
    }

    @Override
    public int deleteTaskNature(Integer id) {
        return taskNatureMapper.deleteTaskNature(id);
    }
}
