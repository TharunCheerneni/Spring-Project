package com.taashee.SpringApplicationAssignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taashee.SpringApplicationAssignment.entity.Course;
import com.taashee.SpringApplicationAssignment.entity.Instructor;
import com.taashee.SpringApplicationAssignment.entity.Student;
import com.taashee.SpringApplicationAssignment.entity.User;
import com.taashee.SpringApplicationAssignment.repository.CourseRepository;
import com.taashee.SpringApplicationAssignment.repository.InstructorRepository;
import com.taashee.SpringApplicationAssignment.repository.StudentRepository;
import com.taashee.SpringApplicationAssignment.repository.UserRepository;

@Service
public class InstructorServiceImpl implements InstructorService {
	@Autowired
	private InstructorRepository instructorRepo;
	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Instructor> getInstructors() {
		return instructorRepo.findAll();
	}

	//it automatically adds the instructor type user in the user table with the password "password"
	@Override
	public Instructor addInstructor(Instructor instructor) {
		userRepo.save(new User(instructor.getInstructorName(),
				"$2a$10$CDhbsrh9p8eH6yJISUvXJ.HAJlGrw0pqvGXt7eLOX4oSPuFJlTMCa", "INSTRUCTOR"));
		return instructorRepo.save(instructor);
	}

	@Override
	public Instructor assignCourseToInstructor(int instructorId, int courseId) {
		Instructor instructor = instructorRepo.findById(instructorId).get();
		Course course = courseRepo.findById(courseId).get();
		instructor.setCourse(course);
		return instructorRepo.save(instructor);
	}

	@Override
	public Course getInstructorsCourse(int instructorId) {
		Instructor instructor = instructorRepo.findById(instructorId).get();
		return instructor.getCourse();
	}

	@Override
	public List<Student> getInstructorsStudents(int instructorId) {
		Instructor instructor = instructorRepo.findById(instructorId).get();
		if(!Objects.nonNull(instructor.getCourse()))return new ArrayList<>();
		Course course = instructor.getCourse();
		return studentRepo.findByCourses(course);
	}

	@Override
	public int getId(String name) {
		return instructorRepo.findByInstructorName(name).getInstructorId();
	}

}
