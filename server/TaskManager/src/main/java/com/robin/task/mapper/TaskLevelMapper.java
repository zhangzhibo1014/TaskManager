package com.robin.task.mapper;

import com.robin.task.domain.TaskLevel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TaskLevelMapper {

    List<TaskLevel> findAllTaskLevel();

    int insertTaskLevel(TaskLevel taskLevel);

    int updateTaskLevel(TaskLevel taskLevel);

    int deleteTaskLevel(Integer id);
}
