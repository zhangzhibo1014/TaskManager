package com.robin.task.domain;

import java.util.Date;

public class Task {
    private Integer taskId;
    private String taskTitle;
    private String taskContent;
    private Integer taskStatus;
    private Date taskPreFinishedDate;
    private Date taskStartDate;
    private Date taskFinishDate;
    private TaskLevel taskLevel;
    private TaskNature taskNature;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

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

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Date getTaskPreFinishedDate() {
        return taskPreFinishedDate;
    }

    public void setTaskPreFinishedDate(Date taskPreFinishedDate) {
        this.taskPreFinishedDate = taskPreFinishedDate;
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

    public TaskLevel getTaskLevel() {
        return taskLevel;
    }

    public void setTaskLevel(TaskLevel taskLevel) {
        this.taskLevel = taskLevel;
    }

    public TaskNature getTaskNature() {
        return taskNature;
    }

    public void setTaskNature(TaskNature taskNature) {
        this.taskNature = taskNature;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskTitle='" + taskTitle + '\'' +
                ", taskContent='" + taskContent + '\'' +
                ", taskStatus=" + taskStatus +
                ", taskPreFinishedDate=" + taskPreFinishedDate +
                ", taskStartDate=" + taskStartDate +
                ", taskFinishDate=" + taskFinishDate +
                ", taskLevel=" + taskLevel +
                ", taskNature=" + taskNature +
                '}';
    }
}
