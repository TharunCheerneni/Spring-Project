package com.taashee.SpringApplicationAssignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taashee.SpringApplicationAssignment.entity.Course;
import com.taashee.SpringApplicationAssignment.entity.Instructor;
import com.taashee.SpringApplicationAssignment.entity.Student;
import com.taashee.SpringApplicationAssignment.service.StudentService;

@RestController
public class StudentController {
	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	// return the student objects
	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	// returns the courses which that particular student have assigned
	@GetMapping("/studentcourses/{studentId}")
	public List<Course> getStudentCourses(@PathVariable int studentId) {
		return studentService.getStudentCourses(studentId);
	}

	// returns the courses of particular student,it'll be get by the courses that
	// student does
	@GetMapping("/studentinstructors/{studentId}")
	public List<Instructor> getStudentInstructors(@PathVariable int studentId) {
		return studentService.getStudentInstructors(studentId);
	}

	// adds student
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}

	// student is assigned to course by instructor
	@PutMapping("/student/{studentId}/course/{courseId}")
	public Student assignCourseToStudent(@PathVariable int studentId, @PathVariable int courseId) {
		return studentService.assignCourseToStudent(studentId, courseId);
	}

	// returns the id of the particular student if we pass name to it
	public int getId(String name) {
		return studentService.getId(name);
	}

}
