package org.springexmaples.TaskManager.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDTO {
    private List<TaskRequestDTO> taskData;
    private Integer pageNumber;
    private  Integer pageSize;
    private Long totalElements;
    private Integer totalPages;
    private Boolean isLast;
    private String sortBy;
}
