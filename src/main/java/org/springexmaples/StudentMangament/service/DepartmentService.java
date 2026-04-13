package org.springexmaples.StudentMangament.service;

import org.springexmaples.StudentMangament.model.Department;
import org.springexmaples.StudentMangament.payload.DepartmentDTO;
import org.springexmaples.StudentMangament.payload.DepartmentResponseDTO;

public interface DepartmentService {
    DepartmentDTO createDept(Department department, Long rollNo);

    DepartmentResponseDTO getDeptById(Long departmentId);
}
