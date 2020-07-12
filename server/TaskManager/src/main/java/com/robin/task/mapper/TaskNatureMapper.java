package com.robin.task.mapper;

import com.robin.task.domain.TaskNature;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TaskNatureMapper {

    List<TaskNature> findAllTaskNature();

    int insertTaskNature(TaskNature taskNature);

    int updateTaskNature(TaskNature taskNature);

    int deleteTaskNature(Integer id);
}
