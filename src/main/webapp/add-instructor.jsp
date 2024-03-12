<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-JkcbkNojlBDIKGfY5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
    <title>Add Instructor</title>
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
        <form method="post" action="addInstructor" class="container">
            <div class="row mb-3">
                <label for="instructorName" class="col-sm-2 col-form-label">Instructor Name:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="instructorName" placeholder="Enter the Instructor Name" name="instructorName" required>
                </div>
            </div>
              <div class="row mb-3">
                <label for="instructorEmail" class="col-sm-2 col-form-label">Instructor Email:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="instructorEmail" placeholder="Enter the Instructor Email" name="instructorEmail" required>
                </div>
            </div>
             <div class="row mb-3">
                <label for="instructorPhoneNumber" class="col-sm-2 col-form-label">Instructor PhoneNumber:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="instructorPhoneNumber" placeholder="Enter the Instructor PhoneNumber" name="instructorPhoneNumber" required>
                </div>
            </div>
             <div class="row mb-3">
                <label for="instructorExperience" class="col-sm-2 col-form-label">Instructor Experience:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="instructorExperience" placeholder="Enter the Instructor Experience" name="instructorExperience" required>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-sm-10 offset-sm-2">
                    <button type="submit" class="btn btn-primary">ADD INSTRUCTOR</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
