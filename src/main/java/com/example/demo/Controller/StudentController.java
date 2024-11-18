package com.example.demo.Controller;

import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Other endpoints...

    // Endpoint to get students by enrollment year
    @GetMapping("/enrollment-year/{year}")
    public List<Student> getStudentsByYearOfEnrollment(@PathVariable int year) {
        return studentService.getStudentsByYearOfEnrollment(year);
    }

    // Endpoint to get department by student ID
    @GetMapping("/{id}/department")
    public String getDepartmentByStudentId(@PathVariable long id) {
        return studentService.getDepartmentByStudentId(id);
    }

    // Endpoint to delete students by enrollment year
    @DeleteMapping("/enrollment-year/{year}")
    public String deleteStudentsByYearOfEnrollment(@PathVariable int year) {
        studentService.deleteStudentsByYearOfEnrollment(year);
        return "Deleted students who enrolled in the year " + year;
    }
}
