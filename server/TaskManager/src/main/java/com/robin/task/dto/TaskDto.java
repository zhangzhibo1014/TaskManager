package com.robin.task.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class TaskDto {

    private String taskTitle;
    private String taskContent;
    private Integer taskLevelId;
    private Integer taskNatureId;
    private Integer taskStatus;
    private Date taskPreFinishedDate;
    private Date taskStartDate;
    private Date taskFinishDate;


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

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Date getTaskStartDate() {
        return taskStartDate;
    }

    public void setTaskStartDate(Date taskStartDate) {
        this.taskStartDate = taskStartDate;
    }

    public Date getTaskFinishDate() {
        return taskFinishDate;
    }

    public void setTaskFinishDate(Date taskFinishDate) {
        this.taskFinishDate = taskFinishDate;
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "taskTitle='" + taskTitle + '\'' +
                ", taskContent='" + taskContent + '\'' +
                ", taskLevelId=" + taskLevelId +
                ", taskNatureId=" + taskNatureId +
                ", taskStatus=" + taskStatus +
                ", taskPreFinishedDate=" + taskPreFinishedDate +
                ", taskStartDate=" + taskStartDate +
                ", taskFinishDate=" + taskFinishDate +
                '}';
    }
}
