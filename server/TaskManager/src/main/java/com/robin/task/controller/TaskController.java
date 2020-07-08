package com.robin.task.controller;


import com.robin.task.domain.Task;
import com.robin.task.dto.TaskDto;
import com.robin.task.service.TaskService;
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
    }


    @GetMapping("/task")
    public List<Task> finAll() {
        List<Task> tasks = new ArrayList<>();
        tasks = taskService.findAllTask();
        return tasks;
    }


    @PostMapping("/task")
    public void insertTask(TaskDto taskDto) {
        Task task = new Task();
        task.setTaskTitle(taskDto.getTaskTitle());
        task.setTaskContent(taskDto.getTaskContent());

        System.out.println(taskDto);
    }
}
