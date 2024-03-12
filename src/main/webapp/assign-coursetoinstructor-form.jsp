<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assign a Course To Instructor</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<style>
body {
	background-color: #f8f9fa; /* Light grey background */
}

.container {
	min-height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: -15vh;
}

form {
	background-color: #fff;
	border-radius: 10px;
	padding: 20px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

label {
	font-weight: bold;
}

select {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #ced4da;
	border-radius: 5px;
}

button[type="submit"] {
	padding: 10px 20px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

button[type="submit"]:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<div class="col-md-6">
			<c:if test="${courses.size() == 0}">
				<p class="text-warning">All Courses are Assigned!!!</p>
				<br>
			</c:if>
			<c:if test="${instructors.size() == 0}">
				<p class="text-warning">All Instructors are Assigned!!!</p>
			</c:if>
			<c:if test="${courses.size() > 0 && instructors.size() > 0}">
				<h4 class="text-center mb-4">Assign a Course To Instructor</h4>
				<form action="assignCourseToInstructorMap" method="post">
					<div class="form-group">
						<label for="instructors">Select an Instructor</label> <select
							name="instructorId" id="instructors" class="form-control">
							<c:forEach var="instructor" items="${instructors}">
								<option value="${instructor.instructorId }">${instructor.instructorName}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="courses">Select a Course</label> <select
							name="courseId" id="courses" class="form-control">
							<c:forEach var="course" items="${courses}">
								<option value="${course.courseId }">${course.courseName}</option>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-primary btn-block">Submit</button>
				</form>
			</c:if>
		</div>
	</div>
</body>
</html>
