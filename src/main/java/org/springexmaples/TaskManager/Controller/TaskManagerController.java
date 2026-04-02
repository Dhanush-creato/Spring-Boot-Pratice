package org.springexmaples.TaskManager.Controller;

import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;
import org.springexmaples.TaskManager.Model.TaskManager;
import org.springexmaples.TaskManager.Service.TaskManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController

public class TaskManagerController {
    @Autowired
    private TaskManagerService taskManagerService;
    
    @GetMapping("/public/getTask")
    public List<TaskManager> getTask(){
        return taskManagerService.getTask();
    }
    @PostMapping("/admin/createTask")
    public ResponseEntity<String> createTask(@Valid @RequestBody TaskManager taskManager){

           taskManagerService.createTask(taskManager);
           return new ResponseEntity<>("Task has been Added Successfully",HttpStatus.CREATED);

    }
    @DeleteMapping("/admin/deleteTask/{taskManagerId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long taskManagerId){

            String status =  taskManagerService.deleteTask(taskManagerId);
            return new ResponseEntity<>(status,HttpStatus.OK);


        
    }
    @PutMapping("/admin/updateTask/{taskManagerId}")
    public ResponseEntity< String> updatTask(@Valid @RequestBody TaskManager taskManager, @PathVariable Long taskManagerId){

        taskManagerService.updateTask(taskManager,taskManagerId);
        return new ResponseEntity<>("Category id :"+taskManagerId +" is Updated", HttpStatus.OK);

          // one type Respone Enity Usage

    }
}
