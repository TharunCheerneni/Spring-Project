<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-JkcbkNojlBDIKGfY5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
    <title>Add Course</title>
    <style>
        .centered-form {
        	margin-top:-15vh;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
    </style>
</head>
<body>
    <%@ include file="header.jsp"%>
    <div class="centered-form">
        <form method="post" action="addCourse" class="container">
            <div class="row mb-3">
                <label for="courseName" class="col-sm-2 col-form-label"><strong>Course Name:</strong></label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="courseName" placeholder="Enter the Course Name" name="courseName" required>
                </div>
            </div>
            <div class="row mb-3">
                <label for="courseDescription" class="col-sm-2 col-form-label"><strong>Description of Course:</strong></label>
           
                 <div class="col-sm-10">
                   <textarea class="form-control" rows="6" id="courseDescription" placeholder="Enter Description of the course"  name="courseDescription" required></textarea>
                   
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-sm-10 offset-sm-2">
                    <button type="submit" class="btn btn-primary">ADD COURSE</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
