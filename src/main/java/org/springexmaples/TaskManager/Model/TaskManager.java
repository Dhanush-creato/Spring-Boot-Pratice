package org.springexmaples.TaskManager.Model;

public class TaskManager {

    private Long taskMangerId;
    private String task;


    public String getTask() {
        return task;
    }

    public TaskManager setTask(String task) {
        this.task = task;
        return this;
    }

    public Long getTaskMangerId() {
        return taskMangerId;
    }

    public TaskManager setTaskMangerId(Long taskMangerId) {
        this.taskMangerId = taskMangerId;
        return this;
    }

    public TaskManager(Long taskMangerId, String task) {
        this.taskMangerId = taskMangerId;
        this.task = task;
    }
}
