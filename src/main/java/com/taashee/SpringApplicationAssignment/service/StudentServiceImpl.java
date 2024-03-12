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
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private InstructorRepository instructorRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Student> getStudents() {
		return studentRepo.findAll();
	}

	
	//it automatically adds the student type user in the user table with the password "password"
	@Override
	public Student addStudent(Student student) {
		userRepo.save(new User(student.getStudentName(),
				"$2a$10$CDhbsrh9p8eH6yJISUvXJ.HAJlGrw0pqvGXt7eLOX4oSPuFJlTMCa", "STUDENT"));
		return studentRepo.save(student);
	}

	@Override
	public Student assignCourseToStudent(int studentId, int courseId) {
		Student student = studentRepo.findById(studentId).get();
		Course course = courseRepo.findById(courseId).get();
		student.getCourses().add(course);
		return studentRepo.save(student);
	}

	@Override
	public List<Course> getStudentCourses(int studentId) {
		Student student = studentRepo.findById(studentId).get();
		return new ArrayList<>(student.getCourses());
	}

	@Override
	public List<Instructor> getStudentInstructors(int studentId) {
		Student student = studentRepo.findById(studentId).get();
		List<Course> courses = new ArrayList<>(student.getCourses());
		List<Instructor> instructors = new ArrayList<>();
		for (Course course : courses) {
			if (Objects.nonNull(instructorRepo.findByCourse(course)))
				instructors.add(instructorRepo.findByCourse(course));
		}
		return instructors;
	}

	@Override
	public int getId(String name) {
		return studentRepo.findByStudentName(name).getStudentId();
	}

}
