package org.springexmaples.StudentMangament.controller;

import org.jspecify.annotations.Nullable;
import org.springexmaples.StudentMangament.model.Students;
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
    public List<Students> getStudentDetiles(){
       return studentService.getStudentDetiles();
    }



    @PostMapping("/createDetiles")
    public String createStudentDetiles(@RequestBody Students students){
        studentService.createStudentDetiles(students);
        return "Student Detiles Added";
    }


    @DeleteMapping("/deleteStudent/{roll_no}")
    public ResponseEntity< String> deleteStudentDetiles(@PathVariable Long roll_no){
        try{
      String status = studentService.deleteStudentDetiles(roll_no);
      return new ResponseEntity<>(status,HttpStatus.OK);
        } catch (ResponseStatusException e) {
           return  new ResponseEntity<>( e.getReason(),e.getStatusCode());

        }
    }
    
    @PutMapping("/updateStudent/{roll_no}")
    public ResponseEntity<String> updateStudentDetiles(@PathVariable Long roll_no , @RequestBody Students students){
        try {
            studentService.updateStudentsDetiles(roll_no, students);
            return new ResponseEntity<>("Category id :"+roll_no +" is Updated", HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());  // one type Respone Enity Usage
        }
    }
}
