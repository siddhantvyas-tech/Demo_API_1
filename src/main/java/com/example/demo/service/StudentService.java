package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studrepo;


    public Student saveStudent(Student student)
    {
        return studrepo.save(student);
    }

    public Student getStudent(int id)
    {
        return studrepo.findById(id).orElse(null);
    }

    public List<Student> getStudents()
    {
        return studrepo.findAll();
    }

    public Student updateStudent(Student student)
    {
        Student existingstudent = studrepo.findById(student.getStudentId()).orElse(null);
        existingstudent.setName(student.getName());
        existingstudent.setAddress(student.getAddress());
        existingstudent.setContact(student.getContact());
        existingstudent.setEmail(student.getEmail());
        existingstudent.setPassword(student.getPassword());
        existingstudent.setMarks(student.getMarks());
        return studrepo.save(existingstudent);
    }

    public String deleteStudent(int id)
    {
        studrepo.deleteById(id);
        return "Student Removed"+id;
    }

}
