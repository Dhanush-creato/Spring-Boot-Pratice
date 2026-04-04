package org.springexmaples.StudentMangament.controller;

import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;
import org.springexmaples.StudentMangament.config.AppConst;
import org.springexmaples.StudentMangament.model.Students;
import org.springexmaples.StudentMangament.payload.StudentRequestDTO;
import org.springexmaples.StudentMangament.payload.StudentResponseDTO;
import org.springexmaples.StudentMangament.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;



    @GetMapping("/getDetiles")
    public ResponseEntity<StudentResponseDTO> getStudentDetiles( @RequestParam( name= "pageNumber",defaultValue = AppConst.PAGE_NUMBER,required = false) Integer pageNumber,
                                                 @RequestParam(name= "pageSize",defaultValue = AppConst.PAGE_SIZE,required = false) Integer pageSize,
                                                                 @RequestParam(name= "orderBy",defaultValue = AppConst.ORDER_BY ,required = false) String orderBy,
                                                                 @RequestParam(name= "orderDirection",defaultValue = AppConst.ORDER_DIRECTION,required = false ) String orderDirection){

        StudentResponseDTO allStudents = studentService.getStudentDetiles(pageNumber,pageSize,orderBy,orderDirection);
        return new ResponseEntity<>(allStudents,HttpStatus.OK);
    }



    @PostMapping("/createDetiles")
    public StudentRequestDTO createStudentDetiles( @Valid @RequestBody StudentRequestDTO studentsRequestDTO){

        return studentService.createStudentDetiles(studentsRequestDTO);
    }


    @DeleteMapping("/deleteStudent/{rollNo}")
    public ResponseEntity< StudentRequestDTO> deleteStudentDetiles(@PathVariable Long rollNo){

            StudentRequestDTO status = studentService.deleteStudentDetiles(rollNo);
      return new ResponseEntity<>(status,HttpStatus.OK);
    }
    
    @PutMapping("/updateStudent/{rollNo}")
    public ResponseEntity<StudentRequestDTO> updateStudentDetiles(@PathVariable Long rollNo , @RequestBody StudentRequestDTO studentRequestDTO){

        StudentRequestDTO updatedStudents =  studentService.updateStudentsDetiles(rollNo, studentRequestDTO);
            return new ResponseEntity<>(updatedStudents, HttpStatus.OK);

    }
}
