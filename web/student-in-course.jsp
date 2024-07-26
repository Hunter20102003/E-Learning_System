<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Enrolled Users</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
            position: relative; /* Để cho phép vị trí tuyệt đối của nút back */
        }
        .user-card {
            border: 1px solid #ddd;
            border-radius: 10px;
            padding: 15px;
            margin-bottom: 20px;
            background-color: #fff;
        }
        .pagination {
            justify-content: center;
        }
        .search-bar {
            margin-bottom: 20px;
        }
        .search-bar .input-group {
            display: flex;
            align-items: center;
        }
        .search-bar .input-group .input-group-append {
            flex: none;
        }
        .lock-indicator {
            color: red;
            font-weight: bold;
            margin-left: 10px;
        }
    </style>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <h1 class="text-center course-title">Enrolled Users in course: 
        <c:choose>
            <c:when test="${not empty courseName}">
                ${courseName}
            </c:when>
            <c:otherwise>
                (Course Name Not Available)
            </c:otherwise>
        </c:choose>
    </h1>
    <p class="text-center">Total Enrolled Users: ${totalUsers}</p>

    <!-- Search bar -->
    <div class="search-bar text-center">
        <form method="post" action="${pageContext.request.contextPath}/student-in-course">
            <input type="hidden" name="action" value="search">
            <input type="hidden" name="courseId" value="${courseId}">
            <div class="input-group">
                <input type="text" name="search" class="form-control" placeholder="Search users..." value="${search}">
                <div class="input-group-append">
                    <button type="submit" class="btn btn-primary">Search</button>
                </div>
            </div>
        </form>
    </div>

    <div id="userList">
        <c:forEach var="userWithEnrollment" items="${enrolledUsers}">
            <div class="user-card">
                <h5>
                    ${userWithEnrollment.user.firstName} ${userWithEnrollment.user.lastName}
                    <c:if test="${userWithEnrollment.user.is_looked == 1}">
                        <span class="lock-indicator">LOCK</span>
                    </c:if>
                </h5>
                <p>Username: ${userWithEnrollment.user.username}</p>
                <p>Email: ${userWithEnrollment.user.email}</p>
                <p>Enrollment Date: <fmt:formatDate value="${userWithEnrollment.enrollmentDate}" pattern="yyyy-MM-dd" /></p>
            </div>
        </c:forEach>
    </div>

    <!-- Pagination -->
    <nav>
        <ul class="pagination">
            <c:forEach begin="1" end="${pageCount}" var="i">
                <li class="page-item ${i == page ? 'active' : ''}">
                    <a class="page-link" href="${pageContext.request.contextPath}/student-in-course?courseId=${courseId}&page=${i}&search=${search}">${i}</a>
                </li>
            </c:forEach>
        </ul>
    </nav>
</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
