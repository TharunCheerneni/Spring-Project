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
import com.taashee.SpringApplicationAssignment.service.InstructorService;
import com.taashee.SpringApplicationAssignment.service.StudentService;

@RestController
public class InstructorController {
	//instances of the interfaces implementations
	private StudentService studentService;
	private InstructorService instructorService;

	@Autowired
	public InstructorController(StudentService studentService, InstructorService instructorService) {
		this.studentService = studentService;
		this.instructorService = instructorService;
	}

	//gives the instructors who are enrolled
	@GetMapping("/instructors")
	public List<Instructor> getInstructors() {
		return instructorService.getInstructors();
	}

	//gives the course (Since oneToOne Mapping) of the particular instructor
	@GetMapping("/instructorscourse/{instructorId}")
	public Course getInstructorsCourse(@PathVariable int instructorId) {
		return instructorService.getInstructorsCourse(instructorId);
	}

	//gives the students (Since oneToOne Mapping) of the particular instructor
	@GetMapping("/instructorstudents/{instructorId}")
	public List<Student> getInstructorsStudents(@PathVariable int instructorId) {
		return instructorService.getInstructorsStudents(instructorId);
	}

	//adds the instructor
	@PostMapping("/instructor")
	public Instructor addInstructor(@RequestBody Instructor instructor) {
		return instructorService.addInstructor(instructor);
	}

	//the method assigns the particular course to particular instructor
	@PutMapping("/instructor/{instructorId}/course/{courseId}")
	public Instructor assignCourseToInstructor(@PathVariable int instructorId, @PathVariable int courseId) {
		return instructorService.assignCourseToInstructor(instructorId, courseId);
	}

	//it returns the id of the instructor if we pass the name to it(used in different functions)
	public int getId(String name) {
		return instructorService.getId(name);
	}

	//to avoid the student getting similar course names I removed the students which are already assigned that particular course
	//a instructor can add his own course to other students who are not assigned to that course
	public List<Student> getStudentsOtherThanUnderInstructor(@PathVariable int instructor_id) {
		List<Student> allStudents = studentService.getStudents();

		List<Student> instructorStudents = getInstructorsStudents(instructor_id);

		allStudents.removeAll(instructorStudents);

		return allStudents;
	}
}
