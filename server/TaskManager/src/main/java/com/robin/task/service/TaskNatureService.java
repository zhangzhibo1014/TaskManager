package com.robin.task.service;

import com.robin.task.domain.TaskNature;

import java.util.List;

public interface TaskNatureService {
    List<TaskNature> findAllTaskNature();

    int insertTaskNature(TaskNature taskNature);

    int updateTaskNature(TaskNature taskNature);

    int deleteTaskNature(Integer id);
}
