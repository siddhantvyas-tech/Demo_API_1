package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studservice;

    @GetMapping("/")
    public String index()
    {
        return "Hello there";
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student)
    {
        return studservice.saveStudent(student);
    }

    @GetMapping("/getStudentById/{id}")
    public Student findStudent(@PathVariable int id)
    {
        return studservice.getStudent(id);
    }

    @GetMapping("/students")
    public List<Student> findAllStudents()
    {
        return studservice.getStudents();
    }

    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student)
    {
        return studservice.updateStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id)
    {
        return studservice.deleteStudent(id);
    }
}
