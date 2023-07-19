package com.example.latestdemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Object addNewStudent(Student student) {
      return  studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);

    }

@Transactional
    public void updateNewStudent(Long studentId,String name,String email) {

        Student student = studentRepository.findById(studentId).orElseThrow(()-> new IllegalStateException("student " + studentId+"does not exist" ));

          if(name!=null && !Objects.equals(student.getName(),name)){
              student.setName(name);

          }

          if(email!=null && !Objects.equals(student.getEmail(),email)){
              student.setEmail(email);

          }

    }
}
