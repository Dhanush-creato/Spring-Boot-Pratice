package org.springexmaples.TaskManager.Service;

import org.springexmaples.TaskManager.Model.TaskManager;
import org.springexmaples.TaskManager.Repo.TaskManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskManagerServiceImpl implements  TaskManagerService{
//    private List<TaskManager> taskManagers = new ArrayList<>();
    @Autowired
    TaskManagerRepo taskManagerRepo;
//    private Long nextId = 1L;

    @Override
    public List<TaskManager> getTask() {

        return taskManagerRepo.findAll();
    }

    @Override
    public void createTask(TaskManager taskManager) {
//        taskManager.setTaskMangerId(nextId++);
       taskManagerRepo.save(taskManager);
    }

    @Override
    public String deleteTask(Long taskManagerId) {
//        TaskManager taskManager = (taskManagers.stream()
//                .filter(c -> c.getTaskMangerId().equals(taskManagerId)).findFirst()
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task is Not found ")));
TaskManager deleteTask= taskManagerRepo.findById(taskManagerId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not found"));


        taskManagerRepo.delete(deleteTask);
        return "task "+ taskManagerId +"is deleted";



    }

    @Override
    public TaskManager updateTask(TaskManager taskManager,Long taskManagerId) {
//        Optional<TaskManager> updateManager = (taskManagers.stream()
//                .filter(c -> c.getTaskMangerId().equals(taskManagerId)).findFirst());
//        if(updateManager.isPresent()) {
//            TaskManager get = updateManager.get();
//            return get.setTask(taskManager.getTask());
//        }
//         else{
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Task Id not found");
//        }
       taskManagerRepo.findById(taskManagerId)
                 .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not found to Update"));

         taskManager.setTaskMangerId(taskManagerId);

        return  taskManagerRepo.save(taskManager);
    }}
