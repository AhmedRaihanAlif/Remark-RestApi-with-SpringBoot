package com.example.latestdemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;
    StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
    return studentService.getStudents();
    }

    @GetMapping(path = "{studentId}")
    public Optional<Student> getStudents(@PathVariable("studentId") Long studentId){
        return studentService.getStudents(studentId);
    }
    @PostMapping
    public Object registerNewRegister(@RequestBody Student student){
       return studentService.addNewStudent(student);
    }

//    @PutMapping (path = "{studentId}")
//    public void updateStudent(
//            @PathVariable("studentId") Long studentId,
//            @RequestParam(required = false)String name,
//            @RequestParam(required = false) String email)
//    {
//        studentService.updateNewStudent(studentId,name,email);
//    }
@PutMapping (path = "{studentId}")
public void updateStudent(
        @PathVariable("studentId") Long studentId,
        @RequestBody Student newstudent)

{
    studentService.updateNewStudent(studentId,newstudent);
}

//    @PutMapping("/user/{id}")
//    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
//        return userRepository.findById(id)
//                .map(user -> {
//                    user.setUsername(newUser.getUsername());
//                    user.setName(newUser.getName());
//                    user.setEmail(newUser.getEmail());
//                    return userRepository.save(user);
//                }).orElseThrow(() -> new UserNotFoundException(id));
//    }


    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
}
