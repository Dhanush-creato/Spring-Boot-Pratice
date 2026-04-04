package org.springexmaples.TaskManager.Service;

import org.springexmaples.TaskManager.Model.TaskManager;
import org.springexmaples.TaskManager.payload.TaskRequestDTO;
import org.springexmaples.TaskManager.payload.TaskResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TaskManagerService {
     TaskResponseDTO getTask(Integer pageNumber,Integer pageSize,String sortBy,String sortDirection);
     TaskRequestDTO createTask( TaskRequestDTO taskRequestDTO);

    TaskRequestDTO deleteTask(Long taskManagerId);
    TaskRequestDTO updateTask( TaskRequestDTO taskRequestDTO, Long taskManagerId);
}
