package com.robin.task.controller;


import com.robin.task.domain.Task;
import com.robin.task.service.TaskService;
import com.robin.task.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class TaskController {

    @Autowired
    private TaskService taskService;


    @InitBinder
    protected void initBinder(WebDataBinder dataBinder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
    }


    @GetMapping("/task")
    public List<Task> finAll() {
        List<Task> tasks = new ArrayList<>();
        tasks = taskService.findAllTask();
        return tasks;
    }


    @PostMapping("/task")
    public Result insertTask(Task task) {
        System.out.println(task);
        task.setTaskStartDate(new Date());
        int result = taskService.insertTask(task);
        if (1 == result) {
            return Result.ok("发布任务成功");
        } else {
            return Result.error(20000, "发布任务失败");
        }
    }

    @PostMapping("/task/update")
    public Result updateTask(Task task) {
        System.out.println(task);
        int result = taskService.updateTask(task);
        if (1 == result) {
            return Result.ok("修改任务成功");
        } else {
            return Result.error(20000, "修改任务失败");
        }
    }

    @PostMapping("/task/delete")
    public  Result deleteTask(Integer id) {
        System.out.println("id = " + id);
        int result = taskService.deleteTask(id);
        if (1 == result) {
            return Result.ok("删除任务成功");
        } else {
            return Result.error(20000, "删除任务失败");
        }
    }
}
