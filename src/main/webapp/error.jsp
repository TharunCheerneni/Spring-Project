<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
    <link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7f6; /* Background color */
            color: #333; /* Text color */
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .card {
            width: 400px; /* Card width */
            background-color: #fff; /* Card background color */
            border-radius: 15px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1); /* Box shadow */
            padding: 30px; /* Card padding */
        }
        h1 {
            margin-top: 0;
            color: #e74c3c; /* Header color */
        }
        .message {
            margin-bottom: 20px;
            color: #555; /* Message text color */
        }
        .link {
            text-decoration: none;
            background-color: #3498db; /* Button color */
            color: #fff; /* Button text color */
            padding: 12px 25px;
            border-radius: 8px;
            transition: background-color 0.3s;
            display: inline-block;
            margin-top: 20px;
        }
        .link:hover {
            background-color: #2980b9; /* Hover state color */
        }
    </style>
</head>
<body>
    <div class="card">
        <h1 style="align-center">Error</h1>
        <div class="message">
            <p><h3>${error}</h3></p>
            <p><strong>Status:</strong> ${status}</p>
            <p><strong>Date:</strong> ${timestamp}</p>
        </div>
        <h3>
            <sec:authorize access="hasRole('ADMIN')">
                <a href="getAllCourses" class="link">GO TO COURSES AREA</a>
            </sec:authorize>
            <sec:authorize access="hasRole('INSTRUCTOR')">
                <a href="getInstructorCourse" class="link">GO TO COURSES AREA</a>
            </sec:authorize>
            <sec:authorize access="hasRole('STUDENT')">
                <a href="getStudentCourses" class="link">GO TO COURSES AREA</a>
            </sec:authorize>
            <p class="btn btn-primary"><a class="text-white" href="/updateLogin">Try Again</a></p>
        </h3>
    </div>
</body>
</html>
