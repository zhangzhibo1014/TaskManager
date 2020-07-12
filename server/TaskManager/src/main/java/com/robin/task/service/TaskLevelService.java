package com.robin.task.service;

import com.robin.task.domain.TaskLevel;

import java.util.List;

public interface TaskLevelService {

    List<TaskLevel> findAllTaskLevel();

    int insertTaskLevel(TaskLevel taskLevel);

    int updateTaskLevel(TaskLevel taskLevel);

    int deleteTaskLevel(Integer id);
}
