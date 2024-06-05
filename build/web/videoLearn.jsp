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
                <div class="comments">
                    <h2>Comments</h2>
                    <textarea rows="5" placeholder="Add your comment..."></textarea>
                    <button>Submit</button>
                    <!-- List of comments -->
                    <div>
                        <p><strong>User1:</strong> This is a comment.</p>
                        <p><strong>User2:</strong> This is another comment.</p>
                    </div>
                </div>
            </div>
            <div class="sidebar">
                <div class="section video-list">
                    <h3>Video List</h3>
                    <ul>

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
                                    </div>
                                </div>
                            </li>
                        </c:forEach>

                        <!--                            <li>
                                                        <div class="video-item">
                                                            <span id="toggleBtnV2" onclick="toggleBtn('vic2')" class="video-item-title">Java servlet</span>
                                                            <div id="vic2" style="display: none;" class="video-item-content">
                                                                <ul>
                                                                    <li>Bài học 4</li>
                                                                    <li>Bài học 5</li>
                                                                    <li>Bài học 6</li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </li>
                                                    <li>
                                                        <div class="video-item">
                                                            <span id="toggleBtnV3" onclick="toggleBtn('vic3')" class="video-item-title">Java jsp</span>
                                                            <div id="vic3" style="display: none;" class="video-item-content">
                                                                <ul>
                                                                    <li>Bài học 7</li>
                                                                    <li>Bài học 8</li>
                                                                    <li>Bài học 9</li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </li>-->
                        <!-- Add more videos as needed -->
                    </ul>
                </div>
                <div class="section video-list">
                    <h3>Progress</h3>
                    <div class="progress-content">
                        <ul>
                            <li><span>Part 1:</span> <span>50%</span></li>
                            <li><span>Part 2:</span> <span>20%</span></li>
                            <li><span>Part 3:</span> <span>Not started</span></li>
                            <!-- Add more parts as needed -->
                        </ul>
                    </div>
                </div>            
            </div>
        </div>
    <body/>
    <!-- Bootstrap and necessary libraries -->



    <Script src="${pageContext.request.contextPath}/js/videoLearn.js"></Script>

