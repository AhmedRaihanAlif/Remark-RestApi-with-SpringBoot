package com.example.latestdemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
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

    @PutMapping (path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false)String name,
            @RequestParam(required = false) String email)
    {
        studentService.updateNewStudent(studentId,name,email);
    }


    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
}
