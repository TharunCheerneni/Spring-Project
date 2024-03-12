<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-JkcbkNojlBDIKGfY5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
    <title>Add Student</title>
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
        <form method="post" action="addStudent" class="container">
            <div class="row mb-3">
                <label for="studentName" class="col-sm-2 col-form-label"><strong>Student Name:</strong></label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="studentName" placeholder="Enter the Student Name" name="studentName" required>
                </div>
            </div>
              <div class="row mb-3">
                <label for="studentEmail" class="col-sm-2 col-form-label"><strong>Student Email:</strong></label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="studentEmail" placeholder="Enter the Student Email" name="studentEmail" required>
                </div>
            </div>
             <div class="row mb-3">
                <label for="studentPhoneNumber" class="col-sm-2 col-form-label"><strong>Student PhoneNumber:</strong></label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="studentPhoneNumber" placeholder="Enter the Student PhoneNumber" name="studentPhoneNumber" required>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-sm-10 offset-sm-2">
                    <button type="submit" class="btn btn-primary">ADD STUDENT</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>