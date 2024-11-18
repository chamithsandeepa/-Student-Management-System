package com.example.demo.Service;

import com.example.demo.Model.Student;

import java.util.List;

public interface StudentService {

    // Other methods...

    List<Student> getStudentsByYearOfEnrollment(int yearOfEnrollment);

    String getDepartmentByStudentId(long id);

    void deleteStudentsByYearOfEnrollment(int yearOfEnrollment);
}
