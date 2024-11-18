package com.example.demo.Service.Impl;

import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Other methods...

    @Override
    public List<Student> getStudentsByYearOfEnrollment(int yearOfEnrollment) {
        return studentRepository.findByYearOfEnrollment(yearOfEnrollment);
    }

    @Override
    public String getDepartmentByStudentId(long id) {
        return studentRepository.findDepartmentByStudentId(id);
    }

    @Override
    public void deleteStudentsByYearOfEnrollment(int yearOfEnrollment) {
        studentRepository.deleteByYearOfEnrollment(yearOfEnrollment);
    }
}
