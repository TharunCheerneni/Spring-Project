
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.right {
	display: flex;
	flex-direction: row;
	justify-content: end;
	align-items: end;
}

.btn-transparent {
	background-color: transparent;
	border: none;
	outline: none;
	color: inherit;
	padding: 0;
	transition: color 0.3s;
}

.btn-transparent:hover {
	color: #f8f9fa; /* Change text color on hover */
	text-decoration: none;
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<a class="navbar-brand text-success">Welcome <sec:authentication
				property="principal.username" />!
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse " id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<sec:authorize access="hasRole('ADMIN')">
					<ul class="nav">
						<li class="nav-item"><a
							class="nav-link text-white btn btn-transparent"
							href="addCourseForm">Add Course</a></li>
						<li class="nav-item"><a
							class="nav-link text-white btn btn-transparent"
							href="addInstructorForm">Add Instructor</a></li>
						<li class="nav-item"><a
							class="nav-link text-white btn btn-transparent"
							href="addStudentForm">Add Student</a></li>
						<li class="nav-item"><a
							class="nav-link text-white btn btn-transparent"
							href="getAllCourses">Courses</a></li>
						<li class="nav-item"><a
							class="nav-link text-white btn btn-transparent"
							href="getAllInstructors">Instructors</a></li>
						<li class="nav-item"><a
							class="nav-link text-white btn btn-transparent"
							href="getAllStudents">Students</a></li>
						<li class="nav-item"><a
							class="nav-link text-white btn btn-transparent"
							href="assignCourseToInstuctorForm">Add Course to Instructor</a></li>
					</ul>
				</sec:authorize>

				<sec:authorize access="hasRole('INSTRUCTOR')">
					<li class="nav-item"><a
						class="nav-link text-white btn btn-transparent"
						href="getInstructorCourse">Your Course</a></li>
					<li class="nav-item"><a
						class="nav-link text-white btn btn-transparent"
						href="getInstructorStudents">Your Students</a></li>
					<li class="nav-item"><a
						class="nav-link text-white btn btn-transparent"
						href="assigningCourseToStudentForm">Add Course to Student</a></li>
				</sec:authorize>
				<sec:authorize access="hasRole('STUDENT')">
					<li class="nav-item"><a
						class="nav-link text-white btn btn-transparent"
						href="getStudentCourses">Your Courses</a></li>
					<li class="nav-item"><a
						class="nav-link text-white btn btn-transparent"
						href="getStudentInstructors">Your Instructors</a></li>
				</sec:authorize>

				<li class="nav-item align-right"></li>
			</ul>
			<div class="right">
				<a class=" right nav-link" href=logout>
					<button class="btn btn-primary">Logout</button>
				</a>
			</div>
		</div>
	</nav>

	<center>
		<h5>
			<sec:authorize access="hasRole('ADMIN')">
				ROLE: ADMIN
				
			</sec:authorize>
			<sec:authorize access="hasRole('INSTRUCTOR')">
			ROLE: INSTRUCTOR
			
			</sec:authorize>
			<sec:authorize access="hasRole('STUDENT')">
				ROLE: STUDENT
				
			</sec:authorize>
		</h5>
	</center>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>

</body>
</html>
