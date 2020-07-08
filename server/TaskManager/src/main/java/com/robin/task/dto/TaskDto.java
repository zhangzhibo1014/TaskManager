package com.robin.task.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class TaskDto {
    private String taskTitle;
    private String taskContent;
    private Integer taskLevelId;
    private Integer taskNatureId;
    private Date taskPreFinishedDate;


    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public Integer getTaskLevelId() {
        return taskLevelId;
    }

    public void setTaskLevelId(Integer taskLevelId) {
        this.taskLevelId = taskLevelId;
    }

    public Integer getTaskNatureId() {
        return taskNatureId;
    }

    public void setTaskNatureId(Integer taskNatureId) {
        this.taskNatureId = taskNatureId;
    }

    public Date getTaskPreFinishedDate() {
        return taskPreFinishedDate;
    }

    public void setTaskPreFinishedDate(Date taskPreFinishedDate) {
        this.taskPreFinishedDate = taskPreFinishedDate;
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "taskTitle='" + taskTitle + '\'' +
                ", taskContent='" + taskContent + '\'' +
                ", taskLevelId=" + taskLevelId +
                ", taskNatureId=" + taskNatureId +
                ", taskPreFinishedDate='" + taskPreFinishedDate + '\'' +
                '}';
    }
}
