package org.springexmaples.StudentMangament.service;

import org.springexmaples.StudentMangament.model.Students;
import org.springexmaples.StudentMangament.payload.StudentRequestDTO;
import org.springexmaples.StudentMangament.payload.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    StudentResponseDTO getStudentDetiles(Integer pageNumber,Integer pageSize,String orderBy,String orderDirection);

    StudentRequestDTO createStudentDetiles(StudentRequestDTO studentRequestDTO);

    StudentRequestDTO deleteStudentDetiles(Long rollNo);



    StudentRequestDTO updateStudentsDetiles(Long rollNo,StudentRequestDTO studentRequestDTO);
}
