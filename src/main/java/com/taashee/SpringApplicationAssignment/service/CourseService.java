package com.taashee.SpringApplicationAssignment.service;

import java.util.List;

import com.taashee.SpringApplicationAssignment.entity.Course;

public interface CourseService {
	List<Course> getCourses();

	Course addCourse(Course course);
}
