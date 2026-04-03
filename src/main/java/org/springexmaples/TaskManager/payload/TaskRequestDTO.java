package org.springexmaples.TaskManager.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequestDTO {
    private Long taskMangerId;
    private String task;

}
