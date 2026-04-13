package org.springexmaples.StudentMangament.service;

import org.modelmapper.ModelMapper;
import org.springexmaples.StudentMangament.Repo.DepartmentRepo;
import org.springexmaples.StudentMangament.Repo.StudentRepo;
import org.springexmaples.StudentMangament.model.Department;
import org.springexmaples.StudentMangament.model.Students;
import org.springexmaples.StudentMangament.payload.DepartmentDTO;
import org.springexmaples.StudentMangament.payload.DepartmentResponseDTO;
import org.springexmaples.ecommerce.Category.Execption.ApiExecption;
import org.springexmaples.ecommerce.Category.Execption.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
  private DepartmentRepo departmentRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
   private StudentRepo studentRepo;

    @Override
    public DepartmentDTO createDept(Department department, Long rollNo) {
        Department errorCheck = departmentRepo.findByDeptName(department.getDeptName());

        if(errorCheck != null){
            throw  new ApiExecption("Dept Name "+ department.getDeptName()+"is Already available");
        }

      Students students = studentRepo.findById(rollNo).orElseThrow(()-> new ResourceNotFoundException("Student","Roll No",rollNo));


        Department department1 = departmentRepo.save(department);
        DepartmentDTO departmentDTO = modelMapper.map(department1, DepartmentDTO.class);

        return departmentDTO;
    }

    @Override
    public DepartmentResponseDTO getDeptById(Long departmentId) {

return null;
    }
}
