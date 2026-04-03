package org.springexmaples.StudentMangament.controller;

import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;
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
    public StudentResponseDTO getStudentDetiles(){
       return studentService.getStudentDetiles();
    }



    @PostMapping("/createDetiles")
    public StudentRequestDTO createStudentDetiles( @Valid @RequestBody StudentRequestDTO studentsRequestDTO){

        return studentService.createStudentDetiles(studentsRequestDTO);
    }


    @DeleteMapping("/deleteStudent/{roll_no}")
    public ResponseEntity< StudentRequestDTO> deleteStudentDetiles(@PathVariable Long roll_no){

            StudentRequestDTO status = studentService.deleteStudentDetiles(roll_no);
      return new ResponseEntity<>(status,HttpStatus.OK);
    }
    
    @PutMapping("/updateStudent/{roll_no}")
    public ResponseEntity<StudentRequestDTO> updateStudentDetiles(@PathVariable Long roll_no , @RequestBody StudentRequestDTO studentRequestDTO){

        StudentRequestDTO updatedStudents =  studentService.updateStudentsDetiles(roll_no, studentRequestDTO);
            return new ResponseEntity<>(updatedStudents, HttpStatus.OK);

    }
}
