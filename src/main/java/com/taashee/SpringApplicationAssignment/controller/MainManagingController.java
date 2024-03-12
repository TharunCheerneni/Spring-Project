package com.taashee.SpringApplicationAssignment.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taashee.SpringApplicationAssignment.entity.Course;
import com.taashee.SpringApplicationAssignment.entity.Instructor;
import com.taashee.SpringApplicationAssignment.entity.Student;

@Controller
@RequestMapping("/")
public class MainManagingController {

	private CourseController courseController;
	private StudentController studentController;
	private InstructorController instructorController;

	//instances of all the controllers
	@Autowired
	public MainManagingController(CourseController courseController, StudentController studentController,
			InstructorController instructorController) {
		this.courseController = courseController;
		this.studentController = studentController;
		this.instructorController = instructorController;
	}

	
	//main-display does nothing
	@GetMapping("/mainDisplay")
	public String mainDisplay(ModelMap modelMap) {
		return "main-display";
	}
	
	
	//you'll direct to instructor form only if you are an ADMIN
	@PreAuthorize(value = "hasRole('ADMIN')")
	@GetMapping(path = "/addInstructorForm")
	public String addInstructorForm() {
		return "add-instructor";
	}
	
	//you'll direct to student form only if you are an ADMIN
	@PreAuthorize(value = "hasRole('ADMIN')")
	@GetMapping(path = "/addStudentForm")
	public String addStudentForm() {
		return "add-student";
	}
	
	
	//you'll direct to course form only if you are an ADMIN
	@PreAuthorize(value = "hasRole('ADMIN')")
	@GetMapping(path = "/addCourse")
	public String addCourse() {
		return "add-course";
	}
	
	
	//results from course form are posted here
	@PostMapping("/addCourse")
	public String addCourse(@RequestParam String courseName, @RequestParam String courseDescription,
			ModelMap modelMap) {
		courseController.addCourse(new Course(courseName, courseDescription));
		return "redirect:/getAllCourses";

	}

	
	//results from instructor form
	@PostMapping("/addInstructor")
	public String addInstructor(@RequestParam String instructorName, @RequestParam String instructorEmail,
			@RequestParam String instructorPhoneNumber, @RequestParam int instructorExperience) {
		instructorController.addInstructor(
				new Instructor(instructorName, instructorEmail, instructorPhoneNumber, instructorExperience));
		return "redirect:/getAllInstructors";
	}
	
	
	//results from student form
	@PostMapping("/addStudent")
	public String addStudent(@RequestParam String studentName, @RequestParam String studentEmail,
			@RequestParam String studentPhoneNumber) {
		studentController.addStudent(new Student(studentName, studentEmail, studentPhoneNumber));
		return "redirect:/getAllStudents";
	}

	
	//directs you to the view all the courses if you an ADMIN
	@PreAuthorize(value = "hasRole('ADMIN')")
	@GetMapping("/getAllCourses")
	public String getAllCourses(ModelMap modelMap, Principal principal) {
		modelMap.put("courses", courseController.getCourses());
		return "display-courses";
	}

	
	//directs you to the view all the instructors if you an ADMIN
	@PreAuthorize(value = "hasRole('ADMIN')")
	@GetMapping("/getAllInstructors")
	public String getAllInstructors(ModelMap modelMap) {
		modelMap.put("instructors", instructorController.getInstructors());
		return "display-instructors";
	}

	//directs you to the view all the students if you an ADMIN
	@PreAuthorize(value = "hasRole('ADMIN')")
	@GetMapping("/getAllStudents")
	public String getAllStudents(ModelMap modelMap, Principal principal) {
		modelMap.put("students", studentController.getStudents());
		return "display-students";
	}
	
	
	//only INSTRUCTOR has an access to view his own courses
	@PreAuthorize(value = "hasRole('INSTRUCTOR')")
	@GetMapping("/getInstructorCourse")
	public String getInstructorCourses(ModelMap modelMap, Principal principal) {
		int id = getUserId("INSTRUCTOR", principal);
		List<Course> courses = new ArrayList<>();
		//if instructors course is null then we shouldn't need to add the students to assign course
		if(Objects.nonNull(instructorController.getInstructorsCourse(id)))
			courses.add(instructorController.getInstructorsCourse(id));
		modelMap.put("courses", courses);
		return "display-courses";
	}
	
	
	//only INSTRUCTOR has an access to view students under him
	@PreAuthorize(value = "hasRole('INSTRUCTOR')")
	@GetMapping("/getInstructorStudents")
	public String getInstructorStudents(ModelMap modelMap, Principal principal) {
		int id = getUserId("INSTRUCTOR", principal);

		modelMap.put("students", instructorController.getInstructorsStudents(id));
		return "display-students";
	}
	
	//only student can view courses he enrolled
	@PreAuthorize(value = "hasRole('STUDENT')")
	@GetMapping("/getStudentCourses")
	public String getStudentCourses(ModelMap modelMap, Principal principal) {
		int id = getUserId("STUDENT", principal);
		modelMap.put("courses", studentController.getStudentCourses(id));
		return "display-courses";
	}
	
	
	//only student can view instructor he enrolled
	@PreAuthorize(value = "hasRole('STUDENT')")
	@GetMapping("/getStudentInstructors")
	public String getStudentInstructors(ModelMap modelMap, Principal principal) {
		int id = getUserId("STUDENT", principal);
		modelMap.put("instructors", studentController.getStudentInstructors(id));
		return "display-instructors";
	}
	
	
	//instructor has authority to assign the student to course
	@PreAuthorize(value = "hasRole('INSTRUCTOR')")
	@GetMapping("/assigningCourseToStudentForm")
	public String assigningCourseToStudentForm(ModelMap modelMap, Principal principal) {
		modelMap.put("students",
				instructorController.getStudentsOtherThanUnderInstructor(getUserId("INSTRUCTOR", principal)));
		modelMap.put("course", instructorController.getInstructorsCourse(getUserId("INSTRUCTOR",principal)));
		return "assign-coursetostudent-form";
	}

	
	//results of the form assign-courseToStudent-from
	@PostMapping("/assigningCourseToStudent")
	public String assigningCourseToStudent(@RequestParam int id, ModelMap modelMap, Principal principal) {
		int instructorId = getUserId("INSTRUCTOR", principal);
		int courseId = instructorController.getInstructorsCourse(instructorId).getCourseId();
		studentController.assignCourseToStudent(id, courseId);

		return "redirect:/getInstructorStudents";
	}

	//ADMIN has authority to assign the course to instructor
	@PreAuthorize(value = "hasRole('ADMIN')")
	@GetMapping("/assignCourseToInstuctorForm")
	public String getStudentsNotUnderInstructor(ModelMap modelMap) {
		modelMap.put("instructors", getInstructorsWithoutCourse());
		modelMap.put("courses", getCoursesWithoutInstructor());
		return "assign-coursetoinstructor-form";
	}

	//results of the form assignCourseToInstructorForm
	@PostMapping("/assignCourseToInstructorMap")
	public String assignCourseToInstructorFun(@RequestParam int instructorId, @RequestParam int courseId) {
		 instructorController.assignCourseToInstructor(instructorId, courseId);
		return "redirect:/getAllInstructors";
	}
 
	
	//Methods that have used in routes..
	
	
	
	//returns the users id based on the role
	public int getUserId(String role, Principal principal) {
		String name = principal.getName();
		if (role.equals("INSTRUCTOR")) {
			return instructorController.getId(name);
		}
		return studentController.getId(name);

	}
	
	
	//returns the instructors without have assigned the course
	public List<Instructor> getInstructorsWithoutCourse() {
		List<Instructor> instructors = instructorController.getInstructors();
		List<Instructor> newInstructors = new ArrayList<>();
		for (Instructor instructor : instructors) {
			if (!(Objects.nonNull(instructor.getCourse()))) {
				newInstructors.add(instructor);
			}
		}
		return newInstructors;
	}


	//return the courses without have been assigned the instructors
	public List<Course> getCoursesWithoutInstructor() {
		List<Instructor> instructors = instructorController.getInstructors();
		List<Course> allocatedCourses = new ArrayList<>();
		for (Instructor instructor : instructors) {
			if (instructor.getCourse() != null) {
				allocatedCourses.add(instructor.getCourse());
			}
		}
		List<Course> allCourses = courseController.getCourses();
		allCourses.removeAll(allocatedCourses);
		return allCourses;
	}
}
