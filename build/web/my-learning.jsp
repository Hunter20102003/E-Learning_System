

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Learning</title>

    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet"> 

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style.css" rel="stylesheet">

    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
        }
        .btn-primary {
            background-color: #ff6600;
            border: none;
        }
        .btn-primary:hover {
            background-color: #e65c00;
        }
        .course-container {
            display: none;
        }
        .course {
            display: flex;
            align-items: center;
            background: #fff;
            border: 1px solid #ddd;
            margin: 10px 0;
            padding: 15px;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        .course img {
            width: 80px;
            height: 80px;
            object-fit: cover;
            border-radius: 5px;
            margin-right: 15px;
        }
        .course-info {
            flex-grow: 1;
        }
        .course h3 {
            font-size: 18px;
            margin-bottom: 10px;
        }
        .course p {
            margin: 5px 0;
            color: #555;
        }
        .course .progress {
            width: 100%;
            height: 8px;
            background-color: #ddd;
            border-radius: 5px;
            overflow: hidden;
            margin-top: 10px;
            margin-bottom: 10px;
        }
        .course .progress-bar {
            height: 100%;
            background-color: #ff6600;
        }
        .buttons {
            margin-bottom: 20px;
            text-align: center;
        }
        .buttons button {
            padding: 10px 20px;
            margin-right: 10px;
            cursor: pointer;
            border: none;
            border-radius: 5px;
            background-color: #ff6600;
            color: #fff;
            font-weight: 500;
        }
        .buttons button:hover {
            background-color: #e65c00;
        }
        .btn-primary a {
            color: #fff;
            text-decoration: none;
        }
        .btn-primary a:hover {
            color: #fff;
        }
    </style>
</head>
<body>
    
    <!-- Topbar Start -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Navbar End -->

    <div class="container">
        <h1 class="text-center">My Learning</h1>
        <div class="buttons">
            <button id="btnInProgress">In Progress</button>
            <button id="btnCompleted">Completed</button>
        </div>

        <div id="inProgressCourses" class="course-container">
            <h2>In Progress</h2>
            <!-- Add your in-progress courses here -->
            <c:forEach var="c" items="${listP}">
                    <div class="course">
                        <img src=" ${c.courseDBO.img}" alt="Course Image">
                        <div class="course-info">
                            <h3>${c.courseDBO.name}</h3>
                            <p>${c.courseDBO.title}</p>
                            <div class="progress">
                                <div class="progress-bar" style="width: ${c.progress}%;"></div>
                            </div>
                            <button class="btn btn-primary"><a href="course/detail?course_id=${c.courseDBO.id}">Continue</a></button>
                        </div>
                    </div>
            </c:forEach>
        </div>

        <div id="completedCourses" class="course-container">
            <h2>Completed</h2>
            <c:forEach var="c" items="${listCP}">
                    <div class="course">
                        <img src=" ${c.img}" alt="Course Image">
                        <div class="course-info">
                            <h3><a href="course/detail?course_id=${c.id}">${c.name}</a></h3>
                            <p>${c.title}</p>
                            <button class="btn btn-primary"><a href="review?course_id=${c.id}">Review</a></button>
                        </div>
                    </div>
            </c:forEach>
        </div>
        
    </div>

    <script>
        document.getElementById('btnInProgress').addEventListener('click', function() {
            document.getElementById('inProgressCourses').style.display = 'block';
            document.getElementById('completedCourses').style.display = 'none';
        });

        document.getElementById('btnCompleted').addEventListener('click', function() {
            document.getElementById('inProgressCourses').style.display = 'none';
            document.getElementById('completedCourses').style.display = 'block';
        });

        // Show completed courses by default
        document.getElementById('btnCompleted').click();
    </script>

   <!-- Footer Start -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Footer End -->
    
     <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="mail/jqBootstrapValidation.min.js"></script>
    <script src="mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>
</html>
