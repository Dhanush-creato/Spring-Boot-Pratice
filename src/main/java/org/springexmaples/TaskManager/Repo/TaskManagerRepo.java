package org.springexmaples.TaskManager.Repo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springexmaples.TaskManager.Model.TaskManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskManagerRepo extends JpaRepository<TaskManager,Long> {
    TaskManager findByTask(@NotBlank(message = "task should not be blank") @Size(min=4,message = "task should more than 3 char") String task);
}
