package org.springexmaples.TaskManager.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="taskManager")
public class TaskManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public TaskManager() {
    }
}
