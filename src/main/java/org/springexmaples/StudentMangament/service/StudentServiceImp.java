package org.springexmaples.StudentMangament.service;

import org.modelmapper.ModelMapper;
import org.springexmaples.BankingApiCustomerDetiles.Exception.ResourceNotFoundException;
import org.springexmaples.StudentMangament.Repo.StudentRepo;
import org.springexmaples.StudentMangament.model.Students;
import org.springexmaples.StudentMangament.payload.StudentRequestDTO;
import org.springexmaples.StudentMangament.payload.StudentResponseDTO;
import org.springexmaples.ecommerce.Category.Execption.ApiExecption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public StudentResponseDTO getStudentDetiles(Integer pageNumber ,Integer pageSize,String orderBy, String orderDirection) {
        Sort sortByAndDirection = orderDirection.equalsIgnoreCase("asc")? Sort.by(orderBy).ascending():
                Sort.by(orderBy).descending();

        Pageable studentPagesCreation = PageRequest.of(pageNumber,pageSize,sortByAndDirection);
        Page<Students> studentPages =  studentRepo.findAll(studentPagesCreation);

       List<Students> studentsList= studentPages.getContent();
       if(studentsList.isEmpty()){
           throw new ApiExecption("No Student Details..!");
       }

       List<StudentRequestDTO> studentDetiles = studentsList.stream()
               .map(student -> modelMapper.map(student,StudentRequestDTO.class))
               .toList();

       StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
       studentResponseDTO.setStudentData(studentDetiles);
       studentResponseDTO.setPageNumber(studentPages.getNumber());
       studentResponseDTO.setPageSize(studentPages.getSize());
       studentResponseDTO.setTotalElements(studentPages.getTotalElements());
       studentResponseDTO.setTotalPages(studentPages.getTotalPages());
       studentResponseDTO.setIsLast(studentPages.isLast());
       studentResponseDTO.setOrderBy(String.valueOf(studentPages.getSort()));

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
    public StudentRequestDTO deleteStudentDetiles(Long rollNo) {

       Students deleteStudent  = studentRepo.findById(rollNo)
                .orElseThrow(()->new ResourceNotFoundException("Student Detiles","Student Roll No",rollNo));
    studentRepo.delete(deleteStudent);


    StudentRequestDTO studentdeletedDataDto = modelMapper.map(deleteStudent, StudentRequestDTO.class);
    return studentdeletedDataDto;


}

    @Override
    public StudentRequestDTO updateStudentsDetiles(Long rollNo, StudentRequestDTO studentRequestDTO) {
 Students students = modelMapper.map(studentRequestDTO, Students.class);


        Students updateStudentFind = studentRepo.findById(rollNo)
                .orElseThrow(()->new ResourceNotFoundException("Student Detiles ","Student Roll No " ,rollNo));
        students.setRollNo(rollNo);

       Students updatedStudent =studentRepo.save(students);
       StudentRequestDTO updatedStudentDTO = modelMapper.map(updatedStudent, StudentRequestDTO.class);

        return updatedStudentDTO;
    }


}
