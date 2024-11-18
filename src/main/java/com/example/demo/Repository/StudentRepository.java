package com.example.demo.Repository;

import com.example.demo.Model.Student;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Find all students by year of enrollment
    List<Student> findByYearOfEnrollment(int yearOfEnrollment);

    // Find the department name by student ID
    @Query("SELECT s.department FROM Student s WHERE s.id = :id")
    String findDepartmentByStudentId(@Param("id") long id);

    // Delete all students by year of enrollment
    @Transactional
    @Modifying
    void deleteByYearOfEnrollment(int yearOfEnrollment);
}
