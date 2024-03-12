package com.taashee.SpringApplicationAssignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taashee.SpringApplicationAssignment.entity.Course;
import com.taashee.SpringApplicationAssignment.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByCourses(Course course);

	Student findByStudentName(String name);

}
