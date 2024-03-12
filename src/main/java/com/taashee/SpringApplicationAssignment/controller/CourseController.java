package com.taashee.SpringApplicationAssignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.taashee.SpringApplicationAssignment.entity.Course;
import com.taashee.SpringApplicationAssignment.service.CourseService;

@Controller
public class CourseController {
	private CourseService courseService;

	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	//lists out all the courses that are there
	@GetMapping("/courses")
	public List<Course> getCourses() {
		return courseService.getCourses();
	}

	//directs you to addCourseForm
	@GetMapping(path = "/addCourseForm")
	public String addCourseForm() {
		return "add-course";
	}

	//saves the course into list
	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}
}
