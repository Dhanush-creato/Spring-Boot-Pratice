package org.springexmaples.StudentMangament.Repo;

import org.springexmaples.StudentMangament.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Students,Long> {
}
