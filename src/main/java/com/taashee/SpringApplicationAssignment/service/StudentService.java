package com.taashee.SpringApplicationAssignment.service;

import java.util.List;

import com.taashee.SpringApplicationAssignment.entity.Course;
import com.taashee.SpringApplicationAssignment.entity.Instructor;
import com.taashee.SpringApplicationAssignment.entity.Student;

public interface StudentService {
	List<Student> getStudents();

	Student addStudent(Student student);

	Student assignCourseToStudent(int studentId, int courseId);

	List<Course> getStudentCourses(int studentId);

	List<Instructor> getStudentInstructors(int studentId);

	int getId(String name);
}
