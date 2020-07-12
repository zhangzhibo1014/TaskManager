package com.robin.task.controller;


import com.robin.task.domain.TaskNature;
import com.robin.task.service.TaskNatureService;
import com.robin.task.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskNatureController {

    @Autowired
    private TaskNatureService taskNatureService;

    @GetMapping("/taskNature")
    public Result findAllTaskNature() {
        List<TaskNature> taskNatures = taskNatureService.findAllTaskNature();
        if (taskNatures != null) {
            return Result.ok("查询任务性质成功").put("taskNatures", taskNatures);
        } else {
            return Result.error(20000, "查询任务性质失败");
        }
    }

    @PostMapping("/taskNature")
    public Result insertTaskNature(TaskNature taskNature) {
        System.out.println(taskNature);
        int result = taskNatureService.insertTaskNature(taskNature);
        if (1 == result) {
            return Result.ok("添加任务性质成功");
        } else {
            return Result.error(20000, "添加任务性质失败");
        }
    }

    @PostMapping("/taskNature/update")
    public Result updateTaskNature(TaskNature taskNature) {
        System.out.println(taskNature);
        int result = taskNatureService.updateTaskNature(taskNature);
        if (1 == result) {
            return Result.ok("修改任务性质成功");
        } else {
            return Result.error(20000, "修改任务性质失败");
        }
    }

    @PostMapping("/taskNature/delete")
    public Result deleteTaskNature(Integer taskNatureId) {
        System.out.println("taskNatureId = " + taskNatureId);
        int result = taskNatureService.deleteTaskNature(taskNatureId);
        if (1 == result) {
            return Result.ok("删除任务性质成功");
        } else {
            return Result.error(20000, "删除任务性质失败");
        }
    }
}
