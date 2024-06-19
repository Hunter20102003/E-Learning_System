<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="utf-8">
    <title>Detail Teacher - ECOURSES</title>
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
        .teacher-img {
            width: 100%;
            height: auto;
            border-radius: 10px;
            margin-bottom: 20px;
        }
    </style>
</head>

<body>
    <!-- Topbar Start -->
    <jsp:include page="header.jsp"></jsp:include>
    <!-- Navbar End -->

    <!-- Header Start -->
    <div class="container-fluid page-header" style="margin-bottom: 90px;">
        <div class="container">
            <div class="d-flex flex-column justify-content-center" style="min-height: 300px">
                <h3 class="display-4 text-white text-uppercase">Detail teacher</h3>
                <div class="d-inline-flex text-white">
                    <p class="m-0 text-uppercase"><a class="text-white" href="${pageContext.request.contextPath}/home">Home</a></p>
                    <i class="fa fa-angle-double-right pt-1 px-3"></i>
                    <p class="m-0 text-uppercase">Detail teacher</p>
                </div>
            </div>
        </div>
    </div>
    <!-- Header End -->

    <!-- Teacher Detail Start -->
    <div class="container-fluid py-5">
  
        <div class="container py-5">
            <div class="row">
                  <c:set var="d" value="${detailT}"/>
                <div class="col-lg-4">
                    <img class="teacher-img mb-4" src="${d.avatar}" alt="avatar">
                </div>
                <div class="col-lg-8">
                    <div class="mb-5">
                        <h2 class="mt-4">${d.getFirstName()} ${d.getLastName()}</h2>
                        <h4 class="mt-4">List courses</h4>
                        <c:forEach var="o" items="${listC}">
                        <ul>    
                            <li><a href="course/detail?course_id=${o.id}"><i class="fa fa-check text-primary mr-2"></i>${o.name} (${o.created_at})</a></li>
                        </ul>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Teacher Detail End -->

    <!-- Footer Start -->
    <jsp:include page="footer.jsp"></jsp:include>
    <!-- Footer End -->
    <script src="./js/scripts.js"></script>
</body>

</html>
