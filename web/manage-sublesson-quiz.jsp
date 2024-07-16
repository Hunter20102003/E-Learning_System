<%-- 
    Document   : manage-sublesson-quiz
    Created on : Jul 12, 2024, 11:03:01 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Manage lesson</title>
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

        <link rel="stylesheet" href="styles.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <style>
            /* Basic Reset */
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: 'Arial', sans-serif;
            }

            body {
                background-color: #f2f2f2;
            }

            /* Header Styling */
            header {
                width: 100%;
                background-color: #FF6600;
                color: white;
                padding: 10px 0;
                text-align: center;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            }

            header h1 {
                margin: 0;
                font-size: 1.5em;
            }

            /* Footer Styling */
            footer {
                width: 100%;
                background-color: #333;
                color: white;
                padding: 10px 0;
                text-align: center;
            }

            footer p {
                margin: 0;
                font-size: 0.9em;
            }

            /* Sidebar Styling */
            .sidebar {
                width: 80%;
                max-width: 1200px;
                background-color: #fff;
                border: 1px solid #dee2e6;
                margin: 20px auto;
                padding: 20px;
                overflow-y: auto;
                box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);
            }

            .sidebar-header {
                display: flex;
                justify-content: center;
                align-items: center;
                margin-bottom: 20px;
            }

            .sidebar-header h1 {
                font-size: 1.5em;
                color: #333;
            }

            .sidebar-content .side-bar-header {
                margin-bottom: 20px;
                text-align: left;
            }

            .sidebar-content .side-bar-header a {
                text-decoration: none;
                color: white;
                background-color: #FF6600;
                padding: 10px 20px;
                border-radius: 5px;
                display: inline-block;
            }

            .big-lesson {
                margin-bottom: 20px;
                background-color: #f8f9fa;
                border: 1px solid #dee2e6;
                border-radius: 5px;
                padding: 15px;
            }

            .big-lesson-title {
                font-size: 1.2em;
                color: #FF6600;
                margin-bottom: 15px;
                cursor: pointer;
            }

            .sublesson-list {
                display: none;
                margin-top: 10px;
            }

            .sublesson-list .sublesson {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 10px 0;
                border-bottom: 1px solid #dee2e6;
            }

            .sublesson-list .sublesson:last-child {
                border-bottom: none;
            }

            .sublesson-list .sublesson span {
                font-size: 1em;
                color: #333;
            }

            .btn {
                border: none;
                cursor: pointer;
            }

            .btn-primary {
                background-color: #FF6600;
                color: white;
                padding: 5px 10px;
                border-radius: 5px;
            }

            .btn-edit,
            .btn-delete {
                background: none;
                color: #FF6600;
                margin-left: 5px;
            }

            .btn-edit:hover,
            .btn-delete:hover {
                color: #cc5200;
            }

            .btn-add {
                background: #FF6600;
                color: white;
                padding: 5px 10px;
                border-radius: 5px;
                margin-top: 10px;
            }

            /* Quiz Styling */
            .sublesson.quiz {
                background-color: #ffebcc;
                border-left: 5px solid #FF6600;
            }

            .sublesson.quiz span {
                color: #FF6600;
                font-weight: bold;
            }

            /* Center the sidebar content */
            .content-wrapper {
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                min-height: calc(100vh - 120px);
                /* Adjusted height to consider header and footer height */
                padding: 20px 0;
            }
        </style>
    </head>

    <body>

        <!-- Topbar Start -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Navbar End -->
        <c:if test="${mess != null}">
            <script>
                alert("${mess}");

            </script>
        </c:if>
        <div class="content-wrapper">
            <div class="sidebar">
                <div class="sidebar-header">
                    <h1>Lessons</h1>
                </div>
                <div class="btnAdd" style="margin-bottom: 15px;">
                    <a href="lessonManagement?action=addLesson" class="btn btn-primary">+ Add new</a>
                </div>
                <div class="sidebar-content">
                    <c:forEach var="i" items="${lessonList}">

                        <div class="big-lesson">
                            <div class="big-lesson-title" style="margin-bottom: 0px;display: flex; justify-content: space-between;">
                                <span>${i.title}</span>
                                <div class="action" style="display: flex;justify-content: flex-end;"> 
                                    <a href="lessonManagement?lessonId=${i.id}&action=editLesson" class="btn btn-edit"><i class="fas fa-edit"></i></a>
                                    <a href="#" onclick="confirmDeleteLesson('${i.id}')"  class="btn btn-delete"><i class="fas fa-trash"></i></a>
                                </div>
                            </div>
                            <div class="sublesson-list">
                                <c:forEach var="j" items="${i.sub_lesson_list}">
                                    <div class="sublesson">
                                        <span>${j.title}</span>
                                        <div>   
                                            <a href="sublessonManagement?lessonId=${i.id}&subLessonId=${j.id}&action=editSublesson" class="btn btn-edit">
                                            <i class="fas fa-edit"></i>
                                            </a>
                                            <a href="#" onclick="confirmDeleteSubLesson('${j.id}')"  class="btn btn-delete"><i class="fas fa-trash"></i></a>
                                        </div>
                                    </div>
                                </c:forEach>
                                <c:forEach var="e" items="${i.quiz_lesson_list}">
                                    <div class="sublesson quiz">
                                        <span>${e.quizName}</span>
                                        <div>
                                            <a href="QuizzesManagement?lessonId=${i.id}&quizId=${e.quizId}&action=quizEdit" class="btn btn-edit"><i class="fas fa-edit"></i></a>
                                            <a href="#" onclick="deleteQuizConfirm('${e.quizId}')" class="btn btn-delete"><i class="fas fa-trash"></i></a>
                                            <!--                                            <a class="btn btn-primary btn-edit">Edit</a>
                                                                                        <a class="btn btn-primary btn-delete">Delete</a>-->
                                        </div>
                                    </div>
                                </c:forEach>

                                <a href="sublessonManagement?lessonId=${i.id}&action=addSublesson" class="btn btn-add">Add Sublesson</a>
                                <a href="QuizzesManagement?lessonId=${i.id}&action=quizAdd" class="btn btn-add">Add Quiz</a>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </div>
    </div>


    <!-- Footer Start -->
    <jsp:include page="footer.jsp"></jsp:include>
        <!-- Footer End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="fa fa-angle-double-up"></i></a>


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
        <script src="./js/scripts.js"></script>

        <script>
                                                function confirmDeleteLesson(lessonId) {
                                                    var x = confirm('Confirm remove lesson');
                                                    if (x) {
                                                        window.location.href = 'lessonManagement?lessonId=' + lessonId + '&action=removeLesson';
                                                    }
                                                }
                                                function confirmDeleteSubLesson(subLessonId) {
                                                    var x = confirm('Confirm remove lesson');
                                                    if (x) {
                                                        window.location.href = 'sublessonManagement?subLessonId=' + subLessonId + '&action=removeSublesson';
                                                    }
                                                }
                                                function deleteQuizConfirm(quizId) {
                                                    var confirmed = confirm("Confirm deleting this quiz");
                                                    if (confirmed) {
                                                        window.location.href = 'QuizzesManagement?quizId=' + quizId + '&action=quizRemove';
                                                    } else {

                                                    }
                                                }
                                                document.querySelectorAll('.big-lesson-title').forEach(title => {
                                                    title.addEventListener('click', () => {
                                                        const sublessonList = title.nextElementSibling;
                                                        sublessonList.style.display = sublessonList.style.display === 'block' ? 'none' : 'block';
                                                    });
                                                });
        </script>

    </body>

</html>
<!--      <div id="sidebar-${i.id}" class="sidebar">
                                                <div class="sidebar-header">
                                                    <h1>Lessons</h1>
                                                    <button class="btn btn-primary close-sidebar">Close</button>
                                                </div>
                                                <div class="sidebar-content">
                                                    <div class="side-bar-header" style="margin-bottom: 15px;">
                                                        <a href="lessonManagement?courseId=${i.id}&action=addLesson" class="btn btn-primary">+ Add new</a>
                                                    </div>
<c:forEach var="j" items="${courseDao.getListLessonByCourseID(i.id)}">
    <div class="big-lesson">
        <div class="big-lesson-title">
            <span>${j.title}</span>
            <div>
                <input type="radio" class="show-hide-sublesson" ${j.is_locked eq "false"?"checked":""}>
                <a href="lessonManagement?courseId=${i.id}&lessonId=${j.id}&action=editLesson" class="btn btn-edit"><i class="fas fa-edit"></i></a>
                <a href="#" onclick="confirmDeleteLesson('${j.id}')"  class="btn btn-delete"><i class="fas fa-trash"></i></a>

            </div>

        </div>
        <div class="sublesson-list">
    <c:forEach var="k" items="${j.sub_lesson_list}">
        <div class="sublesson">
            <span>${k.title}</span>
            <div>
                <input type="radio" class="show-hide-sublesson" ${k.is_locked eq "false"?"checked":""}>
                <a href="sublessonManagement?lessonId=${i.id}&subLessonId=${k.id}&action=editSublesson" class="btn btn-edit"><i class="fas fa-edit"></i></a>
                <a href="#" onclick="confirmDeleteSubLesson('${k.id}')" class="btn btn-delete"><i class="fas fa-trash"></i></a>
            </div>
        </div>

    </c:forEach>
    <c:forEach var="a" items="${quizDao.getListQuizByLessonID(j.id)}">
        <div class="sublesson">
            <span>QUIZ: ${a.quizName}</span>
            <div>
                <input type="radio" class="show-hide-sublesson" ${a.is_locked eq "false"?"checked":""}>
             
            </div>
        </div>

    </c:forEach>

    

</div>
</div>
</c:forEach>
</div>
</div>-->