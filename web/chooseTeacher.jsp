<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Choose Teacher</title>
<!-- Include your CSS and JS files as needed -->
</head>
<body>
    <h1>Choose Teacher</h1>
    
    <form id="chooseTeacherForm" action="updateTeacher" method="POST">
        <input type="hidden" id="courseId" name="courseId" value="${param.courseId}">
        <div class="form-group">
            <label for="teacherSelect">Teacher</label>
            <select class="form-control" id="teacherSelect" name="teacherId">
                <c:forEach var="teacher" items="${teachers}">
                    <option value="${teacher.id}">${teacher.firstName} ${teacher.lastName}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary" name="action" value="update">Save</button>
        <button type="submit" class="btn btn-danger" name="action" value="delete">Delete</button>
    </form>
    
    <!-- Include jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
    <!-- Optional: Include Bootstrap JS library if using Bootstrap -->
    <!-- <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> -->
    
    <!-- Your custom JavaScript -->
    <script>
        // Optional: Example of handling select change event
        $('#teacherSelect').change(function() {
            var teacherId = $(this).val();
            console.log('Selected Teacher ID:', teacherId);
            // You can perform additional actions based on the selected teacher ID if needed
        });
    </script>
</body>
</html>
