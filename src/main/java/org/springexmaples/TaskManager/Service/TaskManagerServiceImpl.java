package org.springexmaples.TaskManager.Service;

import org.springexmaples.TaskManager.Model.TaskManager;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskManagerServiceImpl implements  TaskManagerService{
    private List<TaskManager> taskManagers = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<TaskManager> getTask() {
        return taskManagers;
    }

    @Override
    public void createTask(TaskManager taskManager) {
        taskManager.setTaskMangerId(nextId++);
        taskManagers.add(taskManager);
    }

    @Override
    public String deleteTask(Long taskManagerId) {
        TaskManager taskManager = (taskManagers.stream()
                .filter(c -> c.getTaskMangerId().equals(taskManagerId)).findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task is Not found ")));



        taskManagers.remove(taskManager);
        return "task "+ taskManagerId +"is deleted";



    }

    @Override
    public TaskManager updateTask(TaskManager taskManager,Long taskManagerId) {
        Optional<TaskManager> updateManager = (taskManagers.stream()
                .filter(c -> c.getTaskMangerId().equals(taskManagerId)).findFirst());
        if(updateManager.isPresent()) {
            TaskManager get = updateManager.get();
            return get.setTask(taskManager.getTask());
        }
         else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Task Id not found");
        }

}}
