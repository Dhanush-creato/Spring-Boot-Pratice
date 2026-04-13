package org.springexmaples.StudentMangament.controller;

import org.springexmaples.StudentMangament.model.Department;
import org.springexmaples.StudentMangament.payload.DepartmentDTO;
import org.springexmaples.StudentMangament.payload.DepartmentResponseDTO;
import org.springexmaples.StudentMangament.service.DepartmentService;
import org.springexmaples.StudentMangament.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;



    @PostMapping("/student/{rollNo}/department")
    public ResponseEntity<DepartmentDTO> createDept(@RequestBody Department department, @PathVariable Long rollNo){
        DepartmentDTO departmentDTO = departmentService.createDept(department,rollNo);
        return  new ResponseEntity<>(departmentDTO, HttpStatus.CREATED);

    }

    @GetMapping("/depatment{departmentId}")
    public ResponseEntity<DepartmentResponseDTO> getDeptById(@PathVariable Long departmentId){
        DepartmentResponseDTO departmentResponseDTO = departmentService.getDeptById(departmentId);
        return new ResponseEntity<>(departmentResponseDTO,HttpStatus.OK);
    }

}
