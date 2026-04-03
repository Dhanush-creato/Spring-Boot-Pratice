package org.springexmaples.TaskManager.Controller;

import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;
import org.springexmaples.TaskManager.Model.TaskManager;
import org.springexmaples.TaskManager.Service.TaskManagerService;
import org.springexmaples.TaskManager.payload.TaskRequestDTO;
import org.springexmaples.TaskManager.payload.TaskResponseDTO;
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
    public TaskResponseDTO getTask(){
        TaskResponseDTO getTask =taskManagerService.getTask();
        return  getTask;
    }


    @PostMapping("/admin/createTask")
    public ResponseEntity<TaskRequestDTO> createTask(@Valid @RequestBody TaskRequestDTO taskRequestDTO){

        TaskRequestDTO task =   taskManagerService.createTask(taskRequestDTO);
           return new ResponseEntity<>(task,HttpStatus.CREATED);

    }
    @DeleteMapping("/admin/deleteTask/{taskManagerId}")
    public ResponseEntity<TaskRequestDTO> deleteTask(@PathVariable Long taskManagerId){

            TaskRequestDTO status =  taskManagerService.deleteTask(taskManagerId);
            return new ResponseEntity<>(status,HttpStatus.OK);


        
    }
    @PutMapping("/admin/updateTask/{taskManagerId}")
    public ResponseEntity< TaskRequestDTO> updatTask(@Valid @RequestBody TaskRequestDTO taskRequestDTO, @PathVariable Long taskManagerId){

        TaskRequestDTO updatedTask = taskManagerService.updateTask(taskRequestDTO,taskManagerId);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);

          // one type Respone Enity Usage

    }
}
