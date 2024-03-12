package com.taashee.SpringApplicationAssignment.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int instructorId;
	private String instructorName;
	private String instructorMail;
	private String instructorPhoneNumber;
	private int instructorExperience;

	@OneToOne
	private Course course;

	@OneToMany(mappedBy = "instructor")
	private Set<Student> students = new HashSet<>();

	public Instructor(String instructorName, String instructorMail, String instructorPhoneNumber,
			int instructorExperience) {
		this.instructorName = instructorName;
		this.instructorMail = instructorMail;
		this.instructorPhoneNumber = instructorPhoneNumber;
		this.instructorExperience = instructorExperience;
	}

	public Course getCourse() {
		return course;
	}

	public Instructor(int instructorId, String instructorName, String instructorMail, String instructorPhoneNumber,
			int instructorExperience, Course course, Set<Student> students) {
		super();
		this.instructorId = instructorId;
		this.instructorName = instructorName;
		this.instructorMail = instructorMail;
		this.instructorPhoneNumber = instructorPhoneNumber;
		this.instructorExperience = instructorExperience;
		this.course = course;
		this.students = students;
	}

	public Instructor() {
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public String getInstructorMail() {
		return instructorMail;
	}

	public void setInstructorMail(String instructorMail) {
		this.instructorMail = instructorMail;
	}

	public String getInstructorPhoneNumber() {
		return instructorPhoneNumber;
	}

	public void setInstructorPhoneNumber(String instructorPhoneNumber) {
		this.instructorPhoneNumber = instructorPhoneNumber;
	}

	public int getInstructorExperience() {
		return instructorExperience;
	}

	public void setInstructorExperience(int instructorExperience) {
		this.instructorExperience = instructorExperience;
	}

}
