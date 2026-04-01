package org.springexmaples.TaskManager.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

//@Getter
//@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="taskManager")
public class TaskManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskMangerId;
    @NotBlank(message = "task should not be blank")
    @Size(min=4,message = "task should more than 3 char")
    private String task;


//    public String getTask() {
//        return task;
//    }
//
//    public TaskManager setTask(String task) {
//        this.task = task;
//        return this;
//    }
//
//    public Long getTaskMangerId() {
//        return taskMangerId;
//    }
//
//    public TaskManager setTaskMangerId(Long taskMangerId) {
//        this.taskMangerId = taskMangerId;
//        return this;
//    }
//
//    public TaskManager(Long taskMangerId, String task) {
//        this.taskMangerId = taskMangerId;
//        this.task = task;
//    }
//
//    public TaskManager() {
//    }
}
