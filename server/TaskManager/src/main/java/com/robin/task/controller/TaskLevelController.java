package com.robin.task.controller;

import com.robin.task.domain.TaskLevel;
import com.robin.task.service.TaskLevelService;
import com.robin.task.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TaskLevelController {

    @Autowired
    private TaskLevelService taskLevelService;

    @GetMapping("/taskLevel")
    public Result findAllTaskLevel() {
        List<TaskLevel> taskLevelList = taskLevelService.findAllTaskLevel();
        System.out.println(taskLevelList);
        if (taskLevelList != null) {
            return Result.ok("查询成功").put("taskLevels", taskLevelList);
        } else {
            return Result.error(20000, "当前无任务等级");
        }
    }

    @PostMapping("/taskLevel")
    public Result insertTaskLevel(TaskLevel taskLevel) {
        System.out.println(taskLevel);
        int result = taskLevelService.insertTaskLevel(taskLevel);
        if (1 == result) {
            return Result.ok("添加任务性质成功");
        } else {
            return Result.error(20000, "添加任务性质失败");
        }
    }

    @PostMapping("/taskLevel/update")
    public Result updateTaskLevel(TaskLevel taskLevel) {
        System.out.println(taskLevel);
        int result = taskLevelService.updateTaskLevel(taskLevel);
        if (1 == result) {
            return Result.ok("修改任务性质成功");
        } else {
            return Result.error(20000, "修改任务性质失败");
        }
    }

    @PostMapping("/taskLevel/delete")
    public Result deleteTaskLevel(Integer taskLevelId) {
        System.out.println("taskLevelId = " + taskLevelId);
        int result = taskLevelService.deleteTaskLevel(taskLevelId);
        if (1 == result) {
            return Result.ok("删除任务性质成功");
        } else {
            return Result.error(20000, "删除任务性质失败");
        }
    }

}
