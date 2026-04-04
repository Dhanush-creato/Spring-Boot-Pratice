package org.springexmaples.StudentMangament.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDTO {

    private List<StudentRequestDTO> studentData;
    private Integer pageNumber;
    private  Integer pageSize;
    private Long totalElements;
    private Integer totalPages;
    private Boolean isLast;
    private String orderBy;


}
