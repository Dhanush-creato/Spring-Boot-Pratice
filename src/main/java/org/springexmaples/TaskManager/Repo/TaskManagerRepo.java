package org.springexmaples.TaskManager.Repo;

import org.springexmaples.TaskManager.Model.TaskManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskManagerRepo extends JpaRepository<TaskManager,Long> {
}
