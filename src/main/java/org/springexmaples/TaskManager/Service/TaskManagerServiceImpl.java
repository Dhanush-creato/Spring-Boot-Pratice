package org.springexmaples.TaskManager.Service;

import org.springexmaples.BankingApiCustomerDetiles.Exception.ResourceNotFoundException;
import org.springexmaples.TaskManager.Model.TaskManager;
import org.springexmaples.TaskManager.Repo.TaskManagerRepo;
import org.springexmaples.ecommerce.Category.Execption.ApiExecption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskManagerServiceImpl implements  TaskManagerService{

    @Autowired
    TaskManagerRepo taskManagerRepo;


    @Override
    public List<TaskManager> getTask() {
        if(taskManagerRepo.findAll().isEmpty()){
            throw new ApiExecption("No Task -->Create a Task!!!");
        }
        return taskManagerRepo.findAll();
    }

    @Override
    public void createTask(TaskManager taskManager) {
        TaskManager availableTask = taskManagerRepo.findByTask(taskManager.getTask());
        if(availableTask !=null){
            throw new ApiExecption("This Task:"+taskManager.getTask()+" is Available");
        }
       taskManagerRepo.save(taskManager);
    }

    @Override
    public String deleteTask(Long taskManagerId) {
TaskManager deleteTask= taskManagerRepo.findById(taskManagerId)
                .orElseThrow(()->new ResourceNotFoundException("Task","Task ID",taskManagerId));


        taskManagerRepo.delete(deleteTask);
        return "task "+ taskManagerId +"is deleted";



    }

    @Override
    public TaskManager updateTask(TaskManager taskManager,Long taskManagerId) {
       taskManagerRepo.findById(taskManagerId)
                 .orElseThrow(()-> new ResourceNotFoundException("Task","Task ID",taskManagerId));

         taskManager.setTaskMangerId(taskManagerId);

        return  taskManagerRepo.save(taskManager);
    }}
