<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>assign courseToStudent form</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
	<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f8f9fa;
	margin: 0;
	padding: 0;
}

.content {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin-top: -25px;
}

.courses-list {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	align-items: center;
	max-width: 800px;
	margin: 0 auto;
}

.course-card {
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	margin: 10px;
	padding: 20px;
	text-align: center;
	transition: box-shadow 0.3s ease;
	width: 200px;
}

.course-card:hover {
	box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
}

.course-title {
	font-size: 20px;
	font-weight: bold;
	margin-bottom: 10px;
}

.course-description {
	color: #666;
	margin-bottom: 20px;
}

button[type="submit"] {
	background-color: #007bff;
	border: none;
	border-radius: 5px;
	color: white;
	cursor: pointer;
	font-size: 16px;
	padding: 10px 20px;
	transition: background-color 0.3s ease;
}

button[type="submit"]:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<h4 class="d-flex align-items-center justify-content-center mt-5">Choose One Student And Assign To Your Course</h4>
	<div class="content">
	

		<c:if test="${course == null}">
			<h3 class="d-flex justify-content-center">You are not assigned
				with any course</h3>
		</c:if>
		<c:if test="${course != null && students.size() ==0}">
			<h1>No Students Available Under Instructor</h1>
		</c:if>
		<c:if test="${course != null && students.size() >0}">
			<div class="courses-list">
				<c:forEach var="student" items="${students}">
					<div class="course-card">
						<form action="assigningCourseToStudent" method="post">
							<input type="hidden" name="id" value="${student.studentId}" />
							<h2 class="course-title">
								<c:out value="${student.studentName}"></c:out>
							</h2>
							<p class="course-description">
								<c:out value="${student.studentEmail}"></c:out>
							</p>
							<button type="submit">Assign</button>
						</form>
					</div>
				</c:forEach>
			</div>
		</c:if>
	</div>
</body>
</html>
