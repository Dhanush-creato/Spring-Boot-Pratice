package org.springexmaples.StudentMangament.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponseDTO {

    private List<DepartmentDTO> dept;
}
