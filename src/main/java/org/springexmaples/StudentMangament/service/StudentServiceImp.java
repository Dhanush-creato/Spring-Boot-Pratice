package org.springexmaples.StudentMangament.service;

import org.springexmaples.StudentMangament.Repo.StudentRepo;
import org.springexmaples.StudentMangament.model.Students;
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

    @Override
    public List<Students> getStudentDetiles() {

        return studentRepo.findAll();
    }

    @Override
    public void createStudentDetiles(Students students) {
//        students.setRoll_no(nextId++);
        studentRepo.save(students);
    }

    @Override
    public String deleteStudentDetiles(Long roll_no) {
//        Students getStudent = studentsList.stream()
//                .filter(s->s.getRoll_no().equals(roll_no))
//                .findFirst().orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Not Found"));
//
//        studentsList.remove(getStudent);
       Students deleteStudent  = studentRepo.findById(roll_no)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found to Delete"));
        studentRepo.delete(deleteStudent);
    return "Student Detiles roll no"+roll_no+" delete";


}

    @Override
    public Students updateStudentsDetiles(Long roll_no, Students students) {
//       Optional< Students>getStudent = studentsList.stream()
//                .filter(s->s.getRoll_no().equals(roll_no))
//                .findFirst();
//
//       if(getStudent.isPresent()){
//           Students get = getStudent.get();
////           get.setName(students.getName());
////           get.setDept(students.getDept());
//
//           return get.setMarks(students.getMarks());
//       }
//       else{
//           throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Student roll no not found");
//       }

        Students updateStudent = studentRepo.findById(roll_no)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not found to Update"));
        students.setRoll_no(roll_no);

        return studentRepo.save(students);
    }


}
