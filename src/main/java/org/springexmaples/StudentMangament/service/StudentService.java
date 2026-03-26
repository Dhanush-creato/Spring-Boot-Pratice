package org.springexmaples.StudentMangament.service;

import org.springexmaples.StudentMangament.model.Students;

import java.util.List;

public interface StudentService {
    List<Students> getStudentDetiles();

    void createStudentDetiles(Students students);

    String deleteStudentDetiles(Long roll_no);



    Students updateStudentsDetiles(Long rollNo, Students students);
}
