package org.springexmaples.TaskManager.Service;

import org.modelmapper.ModelMapper;
import org.springexmaples.BankingApiCustomerDetiles.Exception.ResourceNotFoundException;
import org.springexmaples.StudentMangament.payload.StudentRequestDTO;
import org.springexmaples.TaskManager.Model.TaskManager;
import org.springexmaples.TaskManager.Repo.TaskManagerRepo;
import org.springexmaples.TaskManager.payload.TaskRequestDTO;
import org.springexmaples.TaskManager.payload.TaskResponseDTO;
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
    @Autowired
    ModelMapper modelMapper;


    @Override
    public TaskResponseDTO getTask() {
        List<TaskManager> getTaskData = taskManagerRepo.findAll();

        if(getTaskData.isEmpty()){
            throw new ApiExecption("No Task -->Create a Task!!!");
        }
        List<TaskRequestDTO> getTaskListDTO = getTaskData.stream()
                .map(taskManager -> modelMapper.map(taskManager,TaskRequestDTO.class))
                .toList();

        TaskResponseDTO taskResponseDTO = new TaskResponseDTO();
       taskResponseDTO.setTaskData(getTaskListDTO);

        return taskResponseDTO;
    }

    @Override
    public TaskRequestDTO createTask(TaskRequestDTO taskRequestDTO) {
        TaskManager taskManager = modelMapper.map(taskRequestDTO, TaskManager.class);

        TaskManager availableTask = taskManagerRepo.findByTask(taskManager.getTask());
        if(availableTask !=null){
            throw new ApiExecption("This Task:"+taskManager.getTask()+" is Available");
        }
       TaskManager createdTask = taskManagerRepo.save(taskManager);
        TaskRequestDTO savedTask = modelMapper.map(createdTask, TaskRequestDTO.class);
        return savedTask;

    }

    @Override
    public TaskRequestDTO deleteTask(Long taskManagerId) {

TaskManager deleteTask= taskManagerRepo.findById(taskManagerId)
                .orElseThrow(()->new ResourceNotFoundException("Task","Task ID",taskManagerId));


        taskManagerRepo.delete(deleteTask);
        TaskRequestDTO deletedTaskDTO = modelMapper.map(deleteTask, TaskRequestDTO.class);
        return deletedTaskDTO;



    }

    @Override
    public TaskRequestDTO updateTask(TaskRequestDTO taskRequestDTO,Long taskManagerId) {
        TaskManager taskManager = modelMapper.map(taskRequestDTO, TaskManager.class);
       taskManagerRepo.findById(taskManagerId)
                 .orElseThrow(()-> new ResourceNotFoundException("Task","Task ID",taskManagerId));

         taskManager.setTaskMangerId(taskManagerId);

        TaskManager updatedTask = taskManagerRepo.save(taskManager);
        TaskRequestDTO  updatedTaskDTO = modelMapper.map(updatedTask, TaskRequestDTO.class);
        return updatedTaskDTO ;
    }}
