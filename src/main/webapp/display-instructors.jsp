<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Instructors</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-JkcbkNojlBDIKGfY5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous">
<style>
/* Custom CSS */
.course-container {
	min-height: 100vh;
	background-color: #f8f9fa; /* Light grey background */
	padding: 20px;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

.card {
	border-radius: 15px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	transition: box-shadow 0.3s ease;
}

.card:hover {
	box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="course-container">
		<c:if test="${instructors.size() == 0}">
			<h3 class="d-flex justify-content-center">No Instructors
				Available</h3>
			<br>
		</c:if>
		<c:if test="${instructors.size() > 0}">
			<h4 class="mt-4 mb-3 text-center">
				<sec:authorize access="hasRole('ADMIN')">
			The List of Instructors
	
					</sec:authorize>
				<sec:authorize access="hasRole('STUDENT')">
				Your Instructors
					</sec:authorize>
			</h4>
			<div class="container">
				<div class="row justify-content-center">
					<c:forEach var="instructor" items="${instructors}">
						<div class="col-md-6 col-lg-4 mb-4">
							<div class="card">
								<div class="card-body">

									<h5 class="card-title text-center">
										<c:out value="${instructor.instructorName}" />
									</h5>
<%-- 									<p class="card-text text-center">
										<strong>ID:</strong>
										<c:out value="${instructor.instructorId}" />
									</p> --%>
									<p class="card-text text-center">
										<strong>Email:</strong>
										<c:out value="${instructor.instructorMail}" />
									</p>
									<p class="card-text text-center">
										<strong>Phone:</strong>
										<c:out value="${instructor.instructorPhoneNumber}" />
									</p>
									<p class="card-text text-center">
										<strong>Experience:</strong>
										<c:out value="${instructor.instructorExperience}" />
									</p>

									<p class="card-text text-center">
										<strong>Course:</strong>
										<c:if test="${instructor.course.courseName == null}">
											<span> No Course Assigned</span>
										</c:if>
										<c:if test="${instructor.course.courseName != null}">
											<c:out value="${instructor.course.courseName}" />
										</c:if>
									</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</c:if>
	</div>
</body>
</html>