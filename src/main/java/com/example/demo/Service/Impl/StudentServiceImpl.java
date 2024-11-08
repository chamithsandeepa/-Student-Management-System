package com.example.demo.Service.Impl;

import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepository; // Ensure the correct repository for Student is imported
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository; // Inject StudentRepository

    // Save student in database
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get all students from database
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student using id
    @Override
    public Student getStudentById(long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }

    // Update student
    @Override
    public Student updateStudent(Student student, long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found with id: " + id)
        );
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        // save
        studentRepository.save(existingStudent);
        return existingStudent;
    }

    // Delete student
    @Override
    public void deleteStudent(long id) {
        // Check if student exists
        studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        // Delete student
        studentRepository.deleteById(id);
    }
}
