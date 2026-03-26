package org.springexmaples.TaskManager.Service;

import org.springexmaples.TaskManager.Model.TaskManager;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TaskManagerService {
     List<TaskManager> getTask();
     void createTask(TaskManager taskManager);

    String deleteTask(Long taskManagerId);
    TaskManager updateTask(TaskManager taskManager, Long taskManagerId);
}
