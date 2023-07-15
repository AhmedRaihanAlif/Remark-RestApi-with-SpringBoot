package com.example.latestdemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
    return studentService.getStudents();
    }
    @PostMapping
    public Object registerNewRegister(@RequestBody Student student){
       return studentService.addNewStudent(student);
    }
}
