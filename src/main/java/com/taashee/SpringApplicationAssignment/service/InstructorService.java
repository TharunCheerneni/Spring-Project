package com.taashee.SpringApplicationAssignment.service;

import java.util.List;

import com.taashee.SpringApplicationAssignment.entity.Course;
import com.taashee.SpringApplicationAssignment.entity.Instructor;
import com.taashee.SpringApplicationAssignment.entity.Student;

public interface InstructorService {
	List<Instructor> getInstructors();

	Instructor addInstructor(Instructor instructor);

	Instructor assignCourseToInstructor(int instructorId, int courseId);

	Course getInstructorsCourse(int instructorId);

	List<Student> getInstructorsStudents(int instructorId);

	int getId(String name);
}
