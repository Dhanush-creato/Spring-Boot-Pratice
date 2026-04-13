package org.springexmaples.StudentMangament.Repo;

import org.springexmaples.StudentMangament.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Long> {
    Department findByDeptName(String deptName);
}
