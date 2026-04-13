package org.springexmaples.StudentMangament.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private Long dept_id;
    private String deptName;
}
