<<<<<<< HEAD
<<<<<<< HEAD
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Learning Page</title>
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

        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <style>
            body {
                font-family: 'Poppins', sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f8f9fa;
            }

            .container {
                display: grid;
                grid-template-columns: 2fr 1fr;
                gap: 20px;
                padding: 20px;
            }

            .video-container {
                display: flex;
                flex-direction: column;
            }

            .video {
                width: 100%;
                height: 400px;
                background-color: #000;
                border-radius: 10px;
                overflow: hidden;
            }

            .lesson-info {
                margin-top: 20px;
                background-color: #fff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }

            .lesson-info h1 {
                font-size: 2em;
                margin-bottom: 10px;
            }

            .lesson-info p {
                font-size: 1em;
                color: #555;
            }

            .comments {
                background-color: #fff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }

            .comments h2 {
                font-size: 1.5em;
                margin-bottom: 10px;
            }

            .comment-input {
                display: flex;
                align-items: flex-start;
                margin-bottom: 20px;
            }

            .comment-input img.avatar {
                width: 40px;
                height: 40px;
                border-radius: 50%;
                margin-right: 10px;
            }

            .comment-input textarea {
                flex-grow: 1;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 1em;
            }

            .comment-input button {
                margin-left: 10px;
                padding: 10px 20px;
                background-color: #FF6600;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            .comment-input button:hover {
                background-color: #e65c00;
            }

            .comment-list {
                margin-top: 20px;
            }

            .comment {
                display: flex;
                align-items: flex-start;
                margin-bottom: 20px;
                position: relative;
            }

            .comment img.avatar {
                width: 40px;
                height: 40px;
                border-radius: 50%;
                margin-right: 10px;
            }

            .comment-content {
                background-color: #f1f1f1;
                padding: 10px;
                border-radius: 5px;
                flex-grow: 1;
            }

            .comment-content p {
                margin: 5px 0;
            }

            .comment-actions {
                display: flex;
                gap: 10px;
                font-size: 0.9em;
                color: #555;
            }

            .comment-actions span {
                cursor: pointer;
            }

            .comment-actions span:hover {
                text-decoration: underline;
            }

            .timestamp {
                font-size: 0.8em;
                color: #888;
            }

            .comment-menu {
                position: absolute;
                right: 0;
                top: 10px;
            }

            .comment-menu-button {
                cursor: pointer;
                font-size: 1.5em;
                padding: 5px;
            }

            .comment-menu-content {
                display: none;
                position: absolute;
                right: 0;
                top: 20px;
                background-color: #fff;
                border: 1px solid #ccc;
                border-radius: 5px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                z-index: 10;
            }

            .comment-dropdown {
                padding: 5px;
                border: none;
                background: transparent;
                cursor: pointer;
                font-size: 1em;
            }

            .comment-menu-button:hover+.comment-menu-content,
            .comment-menu-content:hover {
                display: block;
            }

            .sidebar {
                display: flex;
                flex-direction: column;
                gap: 20px;
            }

            .section {
                background-color: #fff;
                padding: 25px;
                border-radius: 10px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }

            .section h3 {
                margin: 0 0 10px;
                font-size: 1.5em;
                color: #333;
            }

            .video-list ul,
            .progress ul {
                list-style: none;
                padding: 0;
            }

            .video-list li,
            .progress li {
                padding: 10px;
                border-bottom: 1px solid #ddd;
                cursor: pointer;
            }

            .video-list li:hover,
            .progress li:hover {
                background-color: #f1f1f1;
            }

            .progress li {
                display: flex;
                justify-content: space-between;
            }

            .progress-content {
                max-height: 200px;
                overflow-y: auto;
            }

            .progress-content ul {
                padding: 0;
                margin: 0;
                list-style: none;
            }

            .progress-content ul li {
                display: flex;
                justify-content: space-between;
                padding: 10px;
                border-bottom: 1px solid #ddd;
            }

            .progress-content ul li:last-child {
                border-bottom: none;
            }

            .video-item {
                display: flex;
                flex-direction: column;
            }

            .video-item .video-item-title {
                font-weight: 500;
                cursor: pointer;
            }

            .video-item-content {
                display: none;
            }

            .video-item-content.active {
                display: block;
            }

            .fa-check-circle {
                color: green;
            }

            .reply-input {
                display: flex;
                flex-direction: column;
                margin-top: 10px;
            }

            .reply-input textarea {
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 1em;
            }

            .reply-buttons {
                display: flex;
                margin-top: 10px;
            }

            .reply-buttons button {
                padding: 8px 16px; /* Smaller size */
                background-color: #FF6600;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin-left: 10px;
            }

            .reply-buttons button:hover {
                background-color: #e65c00;
=======
<%-- 
    Document   : videoLearn1
    Created on : Jun 4, 2024, 4:22:44 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Learning Page</title>

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
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <style>
            body {
                font-family: 'Poppins', sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f8f9fa;
            }

=======
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Learning Page</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">
        <script src="./js/scripts.js"></script>

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

        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <style>
            body {
                font-family: 'Poppins', sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f8f9fa;
            }

>>>>>>> origin/front-end
            .container {
                display: grid;
                grid-template-columns: 2fr 1fr;
                gap: 20px;
                padding: 20px;
            }
<<<<<<< HEAD

            .video-container {
=======

            .video-container {
                display: flex;
                flex-direction: column;
            }

            .video {
                width: 100%;
                height: 400px;
                background-color: #000;
                border-radius: 10px;
                overflow: hidden;
            }

            .lesson-info {
                margin-top: 20px;
                background-color: #fff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }

            .lesson-info h1 {
                font-size: 2em;
                margin-bottom: 10px;
            }

            .lesson-info p {
                font-size: 1em;
                color: #555;
            }

            .comments {
                background-color: #fff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }

            .comments h2 {
                font-size: 1.5em;
                margin-bottom: 10px;
            }

            .comment-input {
                display: flex;
                align-items: flex-start;
                margin-bottom: 20px;
            }

            .comment-input img.avatar {
                width: 40px;
                height: 40px;
                border-radius: 50%;
                margin-right: 10px;
            }

            .comment-input textarea {
                flex-grow: 1;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 1em;
            }

            .comment-input button {
                margin-left: 10px;
                padding: 10px 20px;
                background-color: #FF6600;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            .comment-input button:hover {
                background-color: #e65c00;
            }

            .comment-list {
                margin-top: 20px;
            }

            .comment {
                display: flex;
                align-items: flex-start;
                margin-bottom: 20px;
                position: relative;
            }

            .comment img.avatar {
                width: 40px;
                height: 40px;
                border-radius: 50%;
                margin-right: 10px;
            }

            .comment-content {
                background-color: #f1f1f1;
                padding: 10px;
                border-radius: 5px;
                flex-grow: 1;
            }

            .comment-content p {
                margin: 5px 0;
            }

            .comment-actions {
                display: flex;
                gap: 10px;
                font-size: 0.9em;
                color: #555;
            }

            .comment-actions span {
                cursor: pointer;
            }

            .comment-actions span:hover {
                text-decoration: underline;
            }

            .timestamp {
                font-size: 0.8em;
                color: #888;
            }

            .comment-menu {
                position: absolute;
                right: 0;
                top: 10px;
            }

            .comment-menu-button {
                cursor: pointer;
                font-size: 1.5em;
                padding: 5px;
            }

            .comment-menu-content {
                display: none;
                position: absolute;
                right: 0;
                top: 20px;
                background-color: #fff;
                border: 1px solid #ccc;
                border-radius: 5px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                z-index: 10;
            }

            .comment-dropdown {
                padding: 5px;
                border: none;
                background: transparent;
                cursor: pointer;
                font-size: 1em;
            }

            .comment-menu-button:hover+.comment-menu-content,
            .comment-menu-content:hover {
                display: block;
            }

            .sidebar {
                display: flex;
                flex-direction: column;
                gap: 20px;
            }

            .section {
                background-color: #fff;
                padding: 25px;
                border-radius: 10px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }

            .section h3 {
                margin: 0 0 10px;
                font-size: 1.5em;
                color: #333;
            }

            .video-list ul,
            .progress ul {
                list-style: none;
                padding: 0;
            }

            .video-list li,
            .progress li {
                padding: 10px;
                border-bottom: 1px solid #ddd;
                cursor: pointer;
            }

            .video-list li:hover,
            .progress li:hover {
                background-color: #f1f1f1;
            }

            .progress li {
                display: flex;
                justify-content: space-between;
            }

            .progress-content {
                max-height: 200px;
                overflow-y: auto;
            }

            .progress-content ul {
                padding: 0;
                margin: 0;
                list-style: none;
            }

            .progress-content ul li {
                display: flex;
                justify-content: space-between;
                padding: 10px;
                border-bottom: 1px solid #ddd;
            }

            .progress-content ul li:last-child {
                border-bottom: none;
            }
            
             .progress-section {
            display: flex;
            align-items: center;
        }
        .progress-section h3 {
            margin-right: 150px;
        }
        .progress-circle {
            width: 40px; /* Adjust size as needed */
            height: 40px;
        }

            .video-item {
>>>>>>> origin/front-end
                display: flex;
                flex-direction: column;
            }

<<<<<<< HEAD
            .video {
                width: 100%;
                height: 405px;
                background-color: #000;
                border-radius: 10px;
                overflow: hidden;
            }

            .comments {
                margin-top: 20px;
                background-color: #fff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            }

            .comments h2 {
                font-size: 1.5em;
                margin-bottom: 10px;
            }

            .comments textarea {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 1em;
            }

            .comments button {
                margin-top: 10px;
                padding: 10px 20px;
                background-color: #FF6600;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            .comments button:hover {
                background-color: #FF6600;
            }

            .comments div {
                margin-top: 20px;
            }

            .comments p {
                margin: 10px 0;
                padding: 10px;
                background-color: #f1f1f1;
                border-radius: 5px;
            }

            .sidebar {
                display: flex;
                flex-direction: column;
                gap: 20px;
            }

            .section {
                background-color: #fff;
                padding: 25px;
                border-radius: 10px;
                box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            }

            .section h3 {
                margin: 0 0 10px;
                font-size: 1.5em;
                color: #333;
            }

            .video-list ul,
            .progress ul {
                list-style: none;
                padding: 0;
            }

            .video-list li,
            .progress li {
                padding: 10px;
                border-bottom: 1px solid #ddd;
                cursor: pointer;
            }

            .video-list li:hover,
            .progress li:hover {
                background-color: #f1f1f1;
            }

            .progress li {
                display: flex;
                justify-content: space-between;
            }

            .progress-content {
                max-height: 200px; /* Điều chỉnh độ cao tối đa của phần progress */
                overflow-y: auto; /* Tạo thanh cuộn theo chiều dọc khi cần */
            }

            .progress-content ul {
                padding: 0;
                margin: 0;
                list-style: none;
            }

            .progress-content ul li {
                display: flex;
                justify-content: space-between;
                padding: 10px;
                border-bottom: 1px solid #ddd;
            }

            .progress-content ul li:last-child {
                border-bottom: none; /* Loại bỏ đường viền dưới cùng */
            }

            /* .... Click function */
            .video-item {
                display: flex;
                flex-direction: column;
            }

            .video-item .video-item-title {
                font-weight: 500;
>>>>>>> origin/Authentication
            }

        </style>
    </head>
<<<<<<< HEAD

=======
>>>>>>> origin/Authentication
    <body>
        <!-- Navbar Start -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Navbar End -->

<<<<<<< HEAD
            <div class="container">
                <div class="video-container">
                    <div class="video">
                        <!-- Video Embed Here -->                    
                        <iframe src="${subLesson.video_link}" height="100%" width="100%" frameborder="0" allowfullscreen></iframe>
                </div>


=======
            .video-item .video-item-title {
                font-weight: 500;
                cursor: pointer;
            }

            .video-item-content {
                display: none;
            }

            .video-item-content.active {
                display: block;
            }

            .fa-check-circle {
                color: green;
            }

            .reply-input {
                display: flex;
                flex-direction: column;
                margin-top: 10px;
            }

            .reply-input textarea {
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 1em;
            }

            .reply-buttons {
                display: flex;
                margin-top: 10px;
            }

            .reply-buttons button {
                padding: 8px 16px; /* Smaller size */
                background-color: #FF6600;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin-left: 10px;
            }

            .reply-buttons button:hover {
                background-color: #e65c00;
            }

        </style>
    </head>

    <body>
        <!-- Navbar Start -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Navbar End -->

            <div class="container">
                <div class="video-container">
                    <div class="video">
                        <!-- Video Embed Here -->                    
                        <iframe src="${subLesson.video_link}" height="100%" width="100%" frameborder="0" allowfullscreen></iframe>
                </div>


>>>>>>> origin/front-end
                <div class="lesson-navigation-button" style="display: flex; justify-content: center; margin-top: 20px;">
                    <button class="previous-button"
                            style="border-style: solid; border-color: #FF6600; border-width: 1px; margin: 0 10px; background-color: #FF6600; color: white;">
                      <i class="fas fa-chevron-left"></i>Previous lesson
                    </button>
<<<<<<< HEAD
                    <a href="${pageContext.request.contextPath}/course/learning?sub_lesson_id=${subLesson.id+1}"><button  class="next-button"
                            style="border-style: solid; border-color: #FF6600; border-width: 1px; margin: 0 10px; background-color: #FF6600; color: white;">
                        Next lesson <i class="fas fa-chevron-right"></i>
                    </button></a>
                </div>
                
                
                
                <div class="lesson-info">
                    <h1>${subLesson.title}</h1>
                    <p>${subLesson.content}</p>
                </div>               
=======
                    <button class="next-button"
                            style="border-style: solid; border-color: #FF6600; border-width: 1px; margin: 0 10px; background-color: #FF6600; color: white;">
                        Next lesson <i class="fas fa-chevron-right"></i>
                    </button>
                </div>
                <div class="lesson-info">
                    <h1>${subLesson.title}</h1>
                    <p>${subLesson.content}</p>
                </div>
>>>>>>> origin/front-end
                <div class="comments">
                    <h2>Comments</h2>
                    <form action="${pageContext.request.contextPath}/course/learning?sub_lesson_id=${subLesson.id}" method="post">
                        <div class="comment-input">
<<<<<<< HEAD
                           
                            <img src="${pageContext.request.contextPath}/${user.avatar}" alt="User Avatar" class="avatar">
=======
                            <img src="https://w7.pngwing.com/pngs/340/946/png-transparent-avatar-user-computer-icons-software-developer-avatar-child-face-heroes-thumbnail.png" alt="User Avatar" class="avatar">
>>>>>>> origin/front-end
                            <textarea  name="content" rows="1" placeholder="Add a comment..."></textarea>
                            <input type="hidden" name="comment" value="0">
                            <button type="submit" >Submit</button>
                        </div>
                    </form>


                    <div class="comment-list">
                        <c:forEach var="c" items="${comment}">
                            <div class="comment">
<<<<<<< HEAD
                                <img src="${pageContext.request.contextPath}/${c.avatar}" alt="User1 Avatar" class="avatar">    
=======
                                <img src="https://w7.pngwing.com/pngs/340/946/png-transparent-avatar-user-computer-icons-software-developer-avatar-child-face-heroes-thumbnail.png" alt="User1 Avatar" class="avatar">    
>>>>>>> origin/front-end
                                <div class="comment-content">
                                    <p><strong>${c.name}</strong> <span class="timestamp">${c.timeDifference}</span></p>
                                    <p>${c.content}</p>


                                    <form action="${pageContext.request.contextPath}/course/learning?sub_lesson_id=${subLesson.id}" method="post">
                                        <input type="hidden" name="comment" value="1">
                                        <input type="hidden" name="comment_id" value="${c.commentId}">
                                        <div class="comment-actions">
                                            <span onclick="showReplyForm(this)">Reply</span>
                                        </div>
                                        <div class="reply-input" style="display:none; margin-top:10px;">
                                            <textarea  name="content"  rows="3" placeholder="Add a reply..."></textarea>
                                            <div class="reply-buttons">
                                                <button type="submit" >Submit</button>
                                                <button type="button" onclick="cancelReply(this)">Cancel</button>
                                            </div>
                                        </div>
                                    </form>


                                    <div class="replies">
                                        <c:forEach var="reply" items="${c.replies}">
                                            <div class="comment">
<<<<<<< HEAD
                                                    <img src="${pageContext.request.contextPath}/${reply.avatar}" alt="User1 Avatar" class="avatar">    
=======
                                                <img src="https://w7.pngwing.com/pngs/340/946/png-transparent-avatar-user-computer-icons-software-developer-avatar-child-face-heroes-thumbnail.png" alt="User1 Avatar" class="avatar">    
>>>>>>> origin/front-end
                                                <div class="comment-content">
                                                    <p><strong>${reply.name}</strong> <span class="timestamp">${reply.timeDifference}</span></p>
                                                    <p>${reply.content}</p>
                                                </div>


                                                <div class="comment-menu">
                                                    <span class="comment-menu-button" onclick="toggleMenu(this)">...</span>
                                                    <div class="comment-menu-content">
                                                        <form id="commentForm" action="${pageContext.request.contextPath}/course/learning/comment" method="post">
                                                            <input type="hidden" name="sub_lesson_id" value="${subLesson.id}">
                                                            <input type="hidden" name="commentId" value="${reply.commentId}">
                                                            <input type="hidden" name="userId" value="${reply.userId}">
                                                            <select name="action" class="comment-dropdown"  onchange="submitForm(this)">
                                                                <option value="">Select action</option>
                                                                <option value="delete">Delete</option>
                                                            </select>
                                                        </form>
                                                    </div>
                                                </div>

                                            </div>          
                                        </c:forEach>
                                    </div> 
                                    <!-- Container for replies -->

                                </div>
                                <div class="comment-menu">
                                    <span class="comment-menu-button" onclick="toggleMenu(this)">...</span>
                                    <div class="comment-menu-content">
                                        <form id="commentForm" action="${pageContext.request.contextPath}/course/learning/comment" method="post">
                                            <input type="hidden" name="sub_lesson_id" value="${subLesson.id}">
                                            <input type="hidden" name="commentId" value="${c.commentId}">
                                            <input type="hidden" name="userId" value="${c.userId}">
                                            <select name="action" class="comment-dropdown"  onchange="submitForm(this)">
                                                <option value="">Select action</option>
                                                <option value="delete">Delete</option>
                                            </select>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>











<<<<<<< HEAD
=======

        <div class="container">
            <div class="video-container">

                <div class="video">
                    <!-- Video Embed Here -->

                    <iframe src="${subLesson.video_link}" height="100%" width="100%" frameborder="0" allowfullscreen></iframe>



                </div>
                <div class="comments">
                    <h2>Comments</h2>
                    <textarea rows="5" placeholder="Add your comment..."></textarea>
                    <button>Submit</button>
                    <!-- List of comments -->
                    <div>
                        <p><strong>User1:</strong> This is a comment.</p>
                        <p><strong>User2:</strong> This is another comment.</p>
                    </div>
>>>>>>> origin/Authentication
                </div>
=======
                </div>
>>>>>>> origin/front-end

                <script>
                    //reply
                    function showReplyForm(element) {
                        const replyForm = element.parentElement.nextElementSibling;
                        replyForm.style.display = replyForm.style.display === 'none' ? 'block' : 'none';
                    }

                    function submitReply(button) {
                        const replyInput = button.closest('.reply-input').querySelector('textarea').value;
                        if (replyInput.trim() === "")
                            return;

                        const repliesContainer = button.closest('.comment-content').querySelector('.replies');

                        const replyComment = document.createElement('div');
                        replyComment.className = 'comment';
                        replyComment.innerHTML = `
            <img src="img/user-avatar.png" alt="User Avatar" class="avatar">
            <div class="comment-content">
                <p><strong>You</strong> <span class="timestamp">Just now</span></p>
                <p>${replyInput}</p>
                <div class="comment-actions">
                    <span>Like</span>
                    <span onclick="showReplyForm(this)">Reply</span>
                </div>
                <div class="reply-input" style="display:none; margin-top:10px;">
                    <textarea rows="1" placeholder="Add a reply..."></textarea>
                    <div class="reply-buttons">
                        <button onclick="submitReply(this)">Submit</button>
                        <button onclick="cancelReply(this)">Cancel</button>
                    </div>
                </div>
                <div class="replies"></div>
            </div>
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/front-end
        `;

                        repliesContainer.appendChild(replyComment);

                        button.closest('.reply-input').querySelector('textarea').value = "";
                        button.closest('.reply-input').style.display = 'none';
                    }

                    function cancelReply(button) {
                        button.closest('.reply-input').querySelector('textarea').value = "";
                        button.closest('.reply-input').style.display = 'none';
                    }

                    function cancelReply(button) {
                        const replyForm = button.closest('.reply-input');
                        replyForm.querySelector('textarea').value = ""; // Clear the textarea
                        replyForm.style.display = 'none'; // Hide the reply form
                    }
                </script>

                <script>
                    function toggleMenu(element) {
                        var menuContent = element.nextElementSibling;
                        if (menuContent.style.display === "none" || menuContent.style.display === "") {
                            menuContent.style.display = "block";
                        } else {
                            menuContent.style.display = "none";
                        }
                    }


                    function submitForm(selectElement) {
                        if (selectElement.value !== "") {
                            selectElement.form.submit();
                        }
                    }



                    window.onclick = function (event) {
                        if (!event.target.matches('.comment-menu-button')) {
                            const dropdowns = document.getElementsByClassName("comment-menu-content");
                            for (let i = 0; i < dropdowns.length; i++) {
                                const openDropdown = dropdowns[i];
                                if (openDropdown.style.display === "block") {
                                    openDropdown.style.display = "none";
                                }
                            }
                        }
                    }
                </script>
            </div>
<<<<<<< HEAD
=======
>>>>>>> origin/Authentication
=======
>>>>>>> origin/front-end
            <div class="sidebar">
                <div class="section video-list">
                    <h3>Video List</h3>
                    <ul>
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/front-end
                        <c:forEach var="l" items="${listLesson}">
                            <li>
                                <div class="video-item">
                                    <label class="video-item-title" onclick="toggleContent(this)">${l.title}</label>
                                    <div class="video-item-content">
                                        <ul>
                                            <c:forEach var="sl" items="${l.sub_lesson_list}">
                                                <span>${youtobeDuration.convertToMinutesAndSeconds(sl.video_duration)}</span>
                                                <li>
                                                    <a href="/E-Learning_System/course/learning?sub_lesson_id=${sl.id}">${sl.title}</a>
                                                </li>
                                            </c:forEach> 
                                        </ul>

<<<<<<< HEAD
=======

                        <c:forEach var="l" items="${listLesson}">
                            <li>
                                <div class="video-item">
                                    <span id="toggleBtnV1"  class="video-item-title">${l.title}</span>
                                    <div id="vic1"  class="video-item-content">
                                        <ul>
                                            <c:forEach var="sl" items="${l.sub_lesson_list}">
                                                <li><a href="/E-Learning_System/course/learning?sub_lesson_id=${sl.id}">${sl.title}</a></li>


                                            </c:forEach>                                         
                                        </ul>
>>>>>>> origin/Authentication
=======
>>>>>>> origin/front-end
                                    </div>
                                </div>
                            </li>
                        </c:forEach>

<<<<<<< HEAD
<<<<<<< HEAD
=======
                    
>>>>>>> origin/Authentication
                    </ul>
                </div>
                <div class="section video-list">
                    <h3>Progress</h3>
                    <div class="progress-content">
                        <ul>
                            <li><span>Part 1:</span> <span>50%</span></li>
                            <li><span>Part 2:</span> <span>20%</span></li>
                            <li><span>Part 3:</span> <span>Not started</span></li>
<<<<<<< HEAD
                        </ul>
                    </div>
                </div>
=======
                    </ul>
                </div>
                 <div class="section progress-section">
        <h3>Progress</h3>
        <svg class="progress-circle" viewBox="0 0 36 36">
            <path
                d="M18 2.0845
                a 15.9155 15.9155 0 0 1 0 31.831
                a 15.9155 15.9155 0 0 1 0 -31.831"
                fill="none"
                stroke="#eee"
                stroke-width="4"
            />
            <path
                d="M18 2.0845
                a 15.9155 15.9155 0 0 1 0 31.831"
                fill="none"
                stroke="#00f"
                stroke-width="4"
                stroke-dasharray="70, 100" <!-- Adjust this value to represent the percentage -->
            />
        </svg>
    </div>
>>>>>>> origin/front-end
            </div>
        </div>

        <script>
            function toggleContent(label) {
                const content = label.nextElementSibling;
                if (content.classList.contains('active')) {
                    content.classList.remove('active');
                } else {
                    content.classList.add('active');
                }
            }
        </script>
<<<<<<< HEAD
=======
                            <!-- Add more parts as needed -->
                        </ul>
                    </div>
                </div>            
            </div>
        </div>
    <body/>
    <!-- Bootstrap and necessary libraries -->
>>>>>>> origin/Authentication
=======
>>>>>>> origin/front-end

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/front-end
        <!-- Contact Javascript File -->
        <script src="mail/jqBootstrapValidation.min.js"></script>
        <script src="mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
<<<<<<< HEAD
    </body>

</html>
=======

    <Script src="${pageContext.request.contextPath}/js/videoLearn.js"></Script>

>>>>>>> origin/Authentication
=======
        <script src="./js/scripts.js"></script>
    </body>

</html>
>>>>>>> origin/front-end
