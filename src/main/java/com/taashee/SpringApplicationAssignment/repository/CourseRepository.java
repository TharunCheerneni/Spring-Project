package com.taashee.SpringApplicationAssignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taashee.SpringApplicationAssignment.entity.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
