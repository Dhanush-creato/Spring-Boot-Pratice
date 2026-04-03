package org.springexmaples.StudentMangament.service;

import org.springexmaples.StudentMangament.model.Students;
import org.springexmaples.StudentMangament.payload.StudentRequestDTO;
import org.springexmaples.StudentMangament.payload.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    StudentResponseDTO getStudentDetiles();

    StudentRequestDTO createStudentDetiles(StudentRequestDTO studentRequestDTO);

    StudentRequestDTO deleteStudentDetiles(Long roll_no);



    StudentRequestDTO updateStudentsDetiles(Long rollNo,StudentRequestDTO studentRequestDTO);
}
