package org.springexmaples.StudentMangament.Repo;

import jakarta.validation.constraints.NotBlank;
import org.springexmaples.StudentMangament.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Students,Long> {
    Students findByName(@NotBlank(message = "Name should be contain") String name);
}
