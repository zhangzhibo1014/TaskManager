package com.robin.task.domain;

import java.util.List;

public class TaskNature {

    private Integer taskNatureId;
    private String taskNatureName;

    public Integer getTaskNatureId() {
        return taskNatureId;
    }

    public void setTaskNatureId(Integer taskNatureId) {
        this.taskNatureId = taskNatureId;
    }

    public String getTaskNatureName() {
        return taskNatureName;
    }

    public void setTaskNatureName(String taskNatureName) {
        this.taskNatureName = taskNatureName;
    }

    @Override
    public String toString() {
        return "TaskNature{" +
                "taskNatureId=" + taskNatureId +
                ", taskNatureName='" + taskNatureName + '\'' +
                '}';
    }
}
