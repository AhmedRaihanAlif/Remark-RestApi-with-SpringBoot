package com.example.latestdemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public Optional<Student> getStudents(Long studentId){
        return studentRepository.findById(studentId);
    }


    public Object addNewStudent(Student student) {
      return  studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);

    }

@Transactional
    public void updateNewStudent(Long studentId,Student newStudent) {
    studentRepository.findById(studentId)
                .map(user -> {
                    user.setName(newStudent.getName());
                    user.setEmail(newStudent.getEmail());
                    user.setAge(newStudent.getAge());
                    return studentRepository.save(user);
                });

//        Student student = studentRepository.findById(studentId).orElseThrow(()-> new IllegalStateException("student " + studentId+"does not exist" ));
//
//          if(name!=null && !Objects.equals(student.getName(),name)){
//              student.setName(name);
//
//          }
//
//          if(email!=null && !Objects.equals(student.getEmail(),email)){
//              student.setEmail(email);
//
//          }

    }
}
