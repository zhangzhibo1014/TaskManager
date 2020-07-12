package com.robin.task.domain;


public class TaskLevel {

    private Integer taskLevelId;
    private String taskLevelName;

    public Integer getTaskLevelId() {
        return taskLevelId;
    }

    public void setTaskLevelId(Integer taskLevelId) {
        this.taskLevelId = taskLevelId;
    }

    public String getTaskLevelName() {
        return taskLevelName;
    }

    public void setTaskLevelName(String taskLevelName) {
        this.taskLevelName = taskLevelName;
    }

    @Override
    public String toString() {
        return "TaskLevel{" +
                "taskLevelId=" + taskLevelId +
                ", taskLevelName='" + taskLevelName + '\'' +
                '}';
    }
}
