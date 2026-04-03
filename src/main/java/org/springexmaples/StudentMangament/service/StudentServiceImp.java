package org.springexmaples.StudentMangament.service;

import org.modelmapper.ModelMapper;
import org.springexmaples.BankingApiCustomerDetiles.Exception.ResourceNotFoundException;
import org.springexmaples.StudentMangament.Repo.StudentRepo;
import org.springexmaples.StudentMangament.model.Students;
import org.springexmaples.StudentMangament.payload.StudentRequestDTO;
import org.springexmaples.StudentMangament.payload.StudentResponseDTO;
import org.springexmaples.ecommerce.Category.Execption.ApiExecption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService{

//    List<Students> studentsList = new ArrayList<>();
    @Autowired
    StudentRepo studentRepo;
//    Long nextId = 1L;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentResponseDTO getStudentDetiles() {
       List<Students> studentsList= studentRepo.findAll();
       if(studentsList.isEmpty()){
           throw new ApiExecption("No Student Details..!");
       }

       List<StudentRequestDTO> studentDetiles = studentsList.stream()
               .map(student -> modelMapper.map(student,StudentRequestDTO.class))
               .toList();

       StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
       studentResponseDTO.setStudentData(studentDetiles);

        return studentResponseDTO;
    }

    @Override
    public StudentRequestDTO createStudentDetiles(StudentRequestDTO studentsRequestDTO) {
        Students students = modelMapper.map(studentsRequestDTO, Students.class);


         Students savedStudent = studentRepo.findByName(students.getName());
         if(savedStudent!=null){
             throw new ApiExecption("Student name:"+students.getName()+" is Available");
         }

       Students cretedStudents = studentRepo.save(students);
         StudentRequestDTO createdStudentDto = modelMapper.map(cretedStudents, StudentRequestDTO.class);
         return createdStudentDto;

    }

    @Override
    public StudentRequestDTO deleteStudentDetiles(Long roll_no) {

       Students deleteStudent  = studentRepo.findById(roll_no)
                .orElseThrow(()->new ResourceNotFoundException("Student Detiles","Student Roll No",roll_no));
    studentRepo.delete(deleteStudent);


    StudentRequestDTO studentdeletedDataDto = modelMapper.map(deleteStudent, StudentRequestDTO.class);
    return studentdeletedDataDto;


}

    @Override
    public StudentRequestDTO updateStudentsDetiles(Long roll_no, StudentRequestDTO studentRequestDTO) {
 Students students = modelMapper.map(studentRequestDTO, Students.class);


        Students updateStudentFind = studentRepo.findById(roll_no)
                .orElseThrow(()->new ResourceNotFoundException("Student Detiles ","Student Roll No " ,roll_no));
        students.setRoll_no(roll_no);

       Students updatedStudent =studentRepo.save(students);
       StudentRequestDTO updatedStudentDTO = modelMapper.map(updatedStudent, StudentRequestDTO.class);

        return updatedStudentDTO;
    }


}
