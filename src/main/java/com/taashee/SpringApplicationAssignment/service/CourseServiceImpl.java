package com.taashee.SpringApplicationAssignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taashee.SpringApplicationAssignment.entity.Course;
import com.taashee.SpringApplicationAssignment.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public List<Course> getCourses() {
		return courseRepo.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		return courseRepo.save(course);
	}

}
