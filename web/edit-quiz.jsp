<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">


    <!-- Mirrored from learnplus.frontendmatter.com/fixed-instructor-quiz-edit.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 09 Jun 2018 08:43:05 GMT -->

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Instructor - Create quiz - Fixed layout</title>

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        <!-- Prevent the demo from appearing in search engines (REMOVE THIS) -->
        <meta name="robots" content="noindex">
=======
        <!-- <meta name="robots" content="noindex">
>>>>>>> origin/create-course1
=======
        <!-- <meta name="robots" content="noindex">
>>>>>>> origin/crud_quiz
=======
        <!-- <meta name="robots" content="noindex">
>>>>>>> origin/front-end

        <!-- Simplebar -->
        <link type="text/css" href="assets/vendor/simplebar.css" rel="stylesheet">

        <!-- Material Design Icons  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <!-- Roboto Web Font -->
        <link
            href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en"
            rel="stylesheet">

        <!-- MDK -->
        <link type="text/css" href="assets/vendor/material-design-kit.css" rel="stylesheet">

        <!-- Sidebar Collapse -->
        <link type="text/css" href="assets/vendor/sidebar-collapse.min.css" rel="stylesheet">

        <!-- App CSS -->
        <link type="text/css" href="assets/css/style.css" rel="stylesheet">


        <!-- Touchspin -->
        <link rel="stylesheet" href="assets/css/bootstrap-touchspin.css">

        <!-- Vendor CSS -->
        <link rel="stylesheet" href="assets/css/nestable.css">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <link rel="stylesheet" href="./css/bootstrap.css">
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

        <style>
=======
        

        <style>
=======
        

        <style>
>>>>>>> origin/crud_quiz
=======
        

        <style>
>>>>>>> origin/front-end
            body {
            font-family: 'Arial', sans-serif;
        }

<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/front-end
            .breadcrumb-item a {
                color: #ff6600;
                text-decoration: none;
                background-color: transparent;
            }

            .btn-success {
                color: #fff;
                background-color: #ff6600;
                border-color: #ff6600;
            }

            .btn-success:hover {
                background-color: #ff8800;
                border-color: #ff6600;
            }

            .btn-primary {
                color: #fff;
                background-color: #ff6600;
                border-color: #ff6600;
            }

            .btn-primary:hover {
                background-color: #ff8800;
                border-color: #ff6600;
            }

            .answer {
                display: none;
                margin-left: 20px;
                margin-top: 10px;
            }
            .nestable-handle {
                cursor: pointer;
            }
        </style>
    </head>

    <body>

        <!-- Topbar Start -->
        <div class="container-fluid d-none d-lg-block" style="width: 100%;
             padding-right: 15px;
             padding-left: 15px;
             margin-right: auto;
             margin-left: auto;">
            <div class="row align-items-center py-4 px-xl-5" style="align-items: center !important;">
                <div class="col-lg-3">
                    <a href="" class="text-decoration-none" style="text-decoration: none !important">
                        <h1 class="m-0" style="font-weight: 700; color: #444254;"><span class="text-primary"
                                                                                        style="color: #FF6600 !important">E</span>COURSES</h1>
                    </a>
                </div>
                <div class="col-lg-3 text-right" style="text-align: right !important;">
                    <div class="d-inline-flex align-items-center" style="align-items: center !important;">
                        <i class="fa fa-2x fa-map-marker-alt text-primary mr-3" style="color: #FF6600 !important;"></i>
                        <div class="text-left" style="text-align: left !important;">
                            <h6 class="font-weight-semi-bold mb-1" style="font-weight: 700;">Our Office</h6>
                            <small>123 Street, New York, USA</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 text-right" style="text-align: right !important;">
                    <div class="d-inline-flex align-items-center" style="align-items: center !important;">
                        <i class="fa fa-2x fa-envelope text-primary mr-3" style="color: #FF6600 !important;"></i>
                        <div class="text-left" style="text-align: left !important;">
                            <h6 class="font-weight-semi-bold mb-1" style="font-weight: 700;">Email Us</h6>
                            <small>info@example.com</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 text-right" style="text-align: right !important;">
                    <div class="d-inline-flex align-items-center" style="align-items: center !important;">
                        <i class="fa fa-2x fa-phone text-primary mr-3" style="color: #FF6600 !important;"></i>
                        <div class="text-left" style="text-align: left !important;">
                            <h6 class="font-weight-semi-bold mb-1" style="font-weight: 700;">Call Us</h6>
                            <small>+012 345 6789</small>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Topbar End -->


        <c:if test="${alertChangeQuizSuccess != null}">
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
            <script>alert('${alertChangeQuizSuccess}')</script>
=======
=======
>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/front-end
            <script>alert('${alertChangeQuizSuccess}');</script>
        </c:if>
        <c:if test="${questionAddSuccess != null}">
            <script>alert('${questionAddSuccess}');</script>
        </c:if>
        <c:if test="${questionAddFailed != null}">
            <script>alert('${questionAddFailed}');</script>
        </c:if>
        <c:if test="${answerFailed != null}">
            <script>alert('${answerFailed}');</script>
        </c:if>
        <c:if test="${questionRemoveSuccess != null}">
            <script>alert('${questionRemoveSuccess}');</script>
        </c:if>
        <c:if test="${questionRemoveFailed != null}">
            <script>alert('${questionRemoveFailed}');</script>
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/front-end
        </c:if>

        <div class="container">

            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                <li class="breadcrumb-item"><a href="CourseContentManagement">Course Content Management</a></li>
                <li class="breadcrumb-item active">Edit Quiz</li>
            </ol>
            <h1 class="page-heading h2">Course Title</h1>
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title">Basic</h4>
                </div>
                <div class="card-body">
                    <form action="QuizzesManagement" method="post">
                        <input type="text" name="quizId" value="${quiz.quizId}" hidden/>
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

                        <input type="text" name="lessonId" value="${lesson.id}" hidden/>
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/front-end
                        <input type="text" name="action" value="${action}" hidden/>

                        <c:if test="${not empty errorMess}">
                            <div class="alert alert-danger">${errorMess}</div>
                        </c:if>
                        <c:if test="${not empty successMess}">
                            <div class="alert alert-success">${successMess}</div>
                        </c:if>
                        <div class="form-group row">
                            <label for="course_title" class="col-sm-3 col-form-label">Lesson:</label>
                            <div class="col-sm-9 col-md-4">
                                <div class="input-group">

                                    <input type="text" class="form-control"readonly aria-describedby="sizing-addon2" value="${lesson.title}">
                                </div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="course_title" class="col-sm-3 col-form-label">Quiz Title:</label>
                            <div class="col-sm-9 col-md-4">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Title" name="quizTitle" aria-describedby="sizing-addon2" value="${quiz.quizName}">
                                </div>
                            </div>
                        </div>





                        <div class="form-group row">
                            <label for="time_toggle" class="col-sm-3 col-form-label">Timeframe</label>
                            <div class="col-sm-9">
                                <div class="switch">
                                    <input id="cmn-toggle" class="switch-toggle switch-toggle-round" name="time" type="checkbox" ${quiz.quizMinutes>0?'checked':''}>
                                    <label for="cmn-toggle"></label>
                                </div>
                                <div class="form-inline">
                                    <div class="form-group">
                                        <c:choose>
                                            <c:when test="${quiz.quizMinutes >= 60}">
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                                                <c:set var="result" value="${fn:substringBefore((quizMinutes / 60), '.')}" />
=======
                                                <c:set var="result" value="${fn:substringBefore((quiz.quizMinutes / 60), '.')}" />
>>>>>>> origin/create-course1
=======
                                                <c:set var="result" value="${fn:substringBefore((quiz.quizMinutes / 60), '.')}" />
>>>>>>> origin/crud_quiz
=======
                                                <c:set var="result" value="${fn:substringBefore((quiz.quizMinutes / 60), '.')}" />
>>>>>>> origin/front-end
                                            </c:when>
                                            <c:otherwise>
                                                <c:set var="result" value="${quiz.quizMinutes}" />
                                            </c:otherwise>
                                        </c:choose>
                                        <input type="text" class="form-control text-center" name="timeSet" value="${result}" style="width:50px;">
                                    </div>
                                    <div class="form-group">
                                        <select class="custom-select" name="typeOfTime">
                                            <option value="hour" ${quiz.quizMinutes>=60?'selected':''}>Hours</option>
                                            <option value="minutes" ${quiz.quizMinutes<60?'selected':''}>Minutes</option>
                                        </select>
                                    </div>
                                </div>

                            </div>
                            <label for="time_toggle" class="col-sm-3 col-form-label">Active</label>
                            <div class="col-sm-9">
                                <div class="switch">
                                    <input id="cmn-toggles" class="switch-toggle switch-toggle-round" name="active" type="checkbox" value="false" ${quiz.is_locked eq false?'checked':''}/>
                                    <label for="cmn-toggles"></label>
                                </div>


                            </div>

                        </div>
                        <div class="card-header bg-white">
                            <button type="submit" class="btn btn-success">Save change</button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title">Questions</h4>
                </div>
                <div class="card-header bg-white">
                    <a href="#" data-toggle="modal" data-target="#addQuestion" class="btn btn-success">Add Question <i
                            class="material-icons">add</i></a>
                    <div class="modal fade" id="addQuestion">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header" style="background-color: #ff6600;">
                                    <h5 class="modal-title">Add/Edit Question</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                                    <form action="QuizzesManagement" method="get" id="quiz-form">
=======
=======
>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/front-end
                                    <form action="QuizzesManagement" method="post" id="quiz-form">
                                        <input type="text" name="quizId" value="${quiz.quizId}" hidden/>
                                        <input type="text" name="action" value="questionAdd" hidden/>

<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/front-end
                                        <div class="form-group row">
                                            <label for="questionTitle" class="col-form-label col-md-3">Title:</label>
                                            <div class="col-md-9">
                                                <input type="text" class="form-control" id="questionTitle" name="questionTitle" placeholder="Enter title of question" value="${questionTitle}">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="typeOfQuestion" class="col-form-label col-md-3">Type:</label>
                                            <div class="col-md-4">
                                                <select class="custom-control custom-select form-control" id="typeOfQuestion" name="typeOfQuestion">
                                                    <option value="checkbox">Checkbox</option>
                                                    <option value="radio">Radio</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-form-label col-md-3">Answers:</label>
                                            <div class="col-md-9">
                                                <a href="#" class="btn btn-default" id="add-answer-btn"><i class="material-icons">add</i> Add Answer</a>
                                            </div>
                                        </div>
                                        <div id="answers-container" class="form-group row"></div>

                                        <div class="form-group row">
                                            <div class="col-md-8 offset-md-3">
                                                <button type="submit" class="btn btn-success">Save</button>
                                            </div>
                                        </div>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="nestable" id="nestable">
                    <ul class="list-group list-group-fit nestable-list-plain mb-0">
                        <c:forEach var="i" items="${listQuestion}">
                            <li class="list-group-item nestable-item">
                                <div class="media">
                                    <div class="media-body media-middle">
                                        ${i.questionText}
                                    </div>
                                    <div class="media-right text-right">
                                        <div style="width:100px">
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                                            <a href="#" data-toggle="modal" data-target="#editQuiz" class="btn btn-primary btn-sm">
                                                <i class="material-icons">edit</i>
                                            </a>

                                            <a href="#" data-toggle="modal" class="btn btn-primary btn-sm">
=======
=======
>>>>>>> origin/front-end
                                            <a href="QuizzesManagement?action=questionEdit&quizId=${quiz.quizId}&questionId=${i.questionId}" class="btn btn-primary btn-sm">
                                                <i class="material-icons">edit</i>
                                            </a>

                                            <a href="#" onclick="deleteQuestionConfirm('${i.questionId}')" class="btn btn-primary btn-sm">
<<<<<<< HEAD
>>>>>>> origin/create-course1
=======
                                            <a href="QuizzesManagement?action=questionEdit&quizId=${quiz.quizId}&questionId=${i.questionId}" class="btn btn-primary btn-sm">
                                                <i class="material-icons">edit</i>
                                            </a>

                                            <a href="#" onclick="deleteQuestionConfirm('${i.questionId}')" class="btn btn-primary btn-sm">
>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/front-end
                                                <i class="fas fa-trash"></i>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <ul class="answers list-group list-group-fit nestable-list-plain mb-0" style="display: none;">
                                    <c:forEach var="j" items="${i.answers_list}">
                                        <li class="list-group-item nestable-item"> 

                                            ${j.answerText}
                                            <c:if test="${j.isCorrect}">
                                                <i class="material-icons" style="color: green;">check_circle</i>
                                            </c:if>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </li>
                        </c:forEach>


                        <!-- Add more questions and answers as needed -->
                    </ul>
                </div>
                <div class="modal fade" id="editQuiz">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header" style="background-color: #ff6600;">
                                <h5 class="modal-title">Add/Edit Question</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="#">
                                    <div class="form-group row">
                                        <label for="" class="col-form-label col-md-3">Title:</label>
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" value="Database Access">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="" class="col-form-label col-md-3">Type:</label>
                                        <div class="col-md-4">
                                            <select class="custom-control custom-select form-control" id="input-type">
                                                <option value="checkbox">Checkbox</option>
                                                <option value="radio">Radio</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="" class="col-form-label col-md-3">Answers:</label>
                                        <div class="col-md-9">
                                            <a href="#" class="btn btn-default" id="add-answer-btn"><i class="material-icons">add</i> Add Answer</a>
                                        </div>
                                    </div>
                                    <div id="answers-container" class="form-group row"></div>

                                    <div class="form-group row">
                                        <div class="col-md-8 offset-md-3">
                                            <button type="submit" class="btn btn-success">Save</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
                <script>
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/front-end
                    function deleteQuestionConfirm (questionId){
                        var confirmed=confirm("Confirm to delete question");
                        if (confirmed){
                            window.location.href='QuizzesManagement?action=questionRemove&quizId=${quiz.quizId}&questionId='+questionId;    
                        }else{}
                        
                    }
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/front-end
                $(document).ready(function () {
                    $('.nestable-handle').on('click', function () {
                        // Toggle the answers list visibility
                        $(this).closest('.nestable-item').find('.answers').slideToggle();
                    });
                });
                </script>

            </div>
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
            <!--            <div class="card-header bg-white">
                            <a href="#" data-toggle="modal" data-target="#editQuiz" class="btn btn-success">Save change</a>
                        </div>-->
=======

>>>>>>> origin/create-course1
=======

>>>>>>> origin/crud_quiz
=======

>>>>>>> origin/front-end


        </div>







        <!-- jQuery -->
        <script src="assets/vendor/jquery.min.js"></script>

        <!-- Bootstrap -->
        <script src="assets/vendor/popper.min.js"></script>
        <script src="assets/vendor/bootstrap.min.js"></script>

        <!-- Simplebar -->
        <!-- Used for adding a custom scrollbar to the drawer -->
        <script src="assets/vendor/simplebar.js"></script>

        <!-- MDK -->
        <script src="assets/vendor/dom-factory.js"></script>
        <script src="assets/vendor/material-design-kit.js"></script>

        <!-- Sidebar Collapse -->
        <script src="assets/vendor/sidebar-collapse.js"></script>

        <!-- App JS -->
        <script src="assets/js/main.js"></script>


        <!-- Vendor JS -->
        <script src="assets/vendor/jquery.nestable.js"></script>
        <script src="assets/vendor/jquery.bootstrap-touchspin.js"></script>



        <!-- Initialize -->
        <script src="assets/js/nestable.js"></script>
        <script src="assets/js/touchspin.js"></script>




<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script>
$(document).ready(function () {
    var answerCounter = 0; // Biến đếm số lượng câu trả lời
    var currentType = ''; // Biến lưu loại câu trả lời hiện tại
=======
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script>
        $(document).ready(function () {
            var answerCounter = 0; // Biến đếm số lượng câu trả lời
            var currentType = ''; // Biến lưu loại câu trả lời hiện tại
>>>>>>> origin/crud_quiz

            $('#add-answer-btn').on('click', function (e) {
                e.preventDefault();
                var inputType = $('#typeOfQuestion').val();
        
                // Kiểm tra xem nếu đã có loại câu trả lời khác trong container, hiển thị cảnh báo
                if (currentType && inputType !== currentType) {
                    alert('You have to remove all ' + currentType + ' type before adding ' + inputType + ' type');
                    return;
                }

                // Tạo một định danh duy nhất cho câu trả lời
                var answerId = '' + answerCounter;
                answerCounter++;

                // Thêm câu trả lời mới vào container
                var inputHTML = '';

                if (inputType === 'checkbox') {
                    inputHTML = 
                    '<div class="col-md-12 mb-2 answer-item">' +
                        '<div class="input-group">' +
                            '<div class="input-group-prepend">' +
                                '<div class="input-group-text">' +
                                    '<input type="checkbox" id="' + answerId + '-checkbox" name="answers_" value="' + answerId + '" aria-label="Checkbox for following text input">' +
                                '</div>' +
                            '</div>' +
                            '<input type="text" id="' + answerId + '-text" name="answerText_' + answerId + '" class="form-control" aria-label="Text input with checkbox" placeholder="Answer">' +
                            '<button class="btn btn-danger delete-answer-btn"><i class="fa fa-trash"></i></button>' +
                        '</div>' +
                    '</div>';
                } else if (inputType === 'radio') {
                    inputHTML = 
                    '<div class="col-md-12 mb-2 answer-item">' +
                        '<div class="input-group">' +
                            '<div class="input-group-prepend">' +
                                '<div class="input-group-text">' +
                                    '<input type="radio" id="' + answerId + '-radio" class="answer-radio" name="answers_" value="' + answerId + '" aria-label="Radio button for following text input">' +
                                '</div>' +
                            '</div>' +
                            '<input type="text" id="' + answerId + '-text" name="answerText_' + answerId + '" class="form-control" aria-label="Text input with radio button" placeholder="Answer">' +
                            '<button class="btn btn-danger delete-answer-btn"><i class="fa fa-trash"></i></button>' +
                        '</div>' +
                    '</div>';
                }

                $('#answers-container').append(inputHTML);
                currentType = inputType; // Cập nhật loại câu trả lời hiện tại
            });

            // Xử lý sự kiện xóa câu trả lời
            $(document).on('click', '.delete-answer-btn', function(e) {
                e.preventDefault();
                $(this).closest('.answer-item').remove();

                // Kiểm tra nếu không còn câu trả lời nào, đặt currentType về ''
                if ($('.answer-item').length === 0) {
                    currentType = '';
                }
            });

            // Xử lý sự kiện chọn radio button
            $(document).on('change', '.answer-radio', function() {
                $('.answer-radio').not(this).prop('checked', false);
            });

            // Xử lý trước khi submit form
            $('#quiz-form').submit(function() {
                // Đảm bảo rằng ít nhất một câu trả lời được chọn
                if ($('input[name^="answers_"]:checked').length === 0) {
                    alert('You have to choose at least one answer');
                    return false; // Ngăn không submit form nếu không có câu trả lời nào được chọn
                }

                // Kiểm tra tiêu đề của câu hỏi
                if ($('#questionTitle').val().trim() === '') {
                    alert('The question title cannot be empty');
                    return false;
                }

                // Kiểm tra nội dung các câu trả lời
                var allAnswersFilled = true;
                $('input[name^="answerText_"]').each(function() {
                    if ($(this).val().trim() === '') {
                        allAnswersFilled = false;
                        return false; // Dừng kiểm tra ngay khi phát hiện một câu trả lời rỗng
                    }
                });

                if (!allAnswersFilled) {
                    alert('All answer fields must be filled');
                    return false; // Ngăn không submit form nếu có câu trả lời rỗng
                }

                // Hiển thị các ID của câu trả lời trong console (tùy chọn)
                $('input[name^="answers_"]').each(function() {
                    var answerId = $(this).attr('name').split('_')[1];
                    var answerText = $('input[name="answerText_' + answerId + '"]').val();
                    console.log('Answer ID: ' + answerId + ', Answer Text: ' + answerText);
                });

                // Điều chỉnh dữ liệu trước khi gửi lên server (nếu cần)
                // Ví dụ: thu thập dữ liệu, xử lý validate,...

                return true; // Cho phép submit form nếu đã kiểm tra xong
            });
        });
        </script>





<<<<<<< HEAD
        return true; // Cho phép submit form nếu đã kiểm tra xong
    });
});
</script>
=======
=======
>>>>>>> origin/front-end
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script>
        $(document).ready(function () {
            var answerCounter = 0; // Biến đếm số lượng câu trả lời
            var currentType = ''; // Biến lưu loại câu trả lời hiện tại

            $('#add-answer-btn').on('click', function (e) {
                e.preventDefault();
                var inputType = $('#typeOfQuestion').val();
        
                // Kiểm tra xem nếu đã có loại câu trả lời khác trong container, hiển thị cảnh báo
                if (currentType && inputType !== currentType) {
                    alert('You have to remove all ' + currentType + ' type before adding ' + inputType + ' type');
                    return;
                }

                // Tạo một định danh duy nhất cho câu trả lời
                var answerId = '' + answerCounter;
                answerCounter++;

                // Thêm câu trả lời mới vào container
                var inputHTML = '';

                if (inputType === 'checkbox') {
                    inputHTML = 
                    '<div class="col-md-12 mb-2 answer-item">' +
                        '<div class="input-group">' +
                            '<div class="input-group-prepend">' +
                                '<div class="input-group-text">' +
                                    '<input type="checkbox" id="' + answerId + '-checkbox" name="answers_" value="' + answerId + '" aria-label="Checkbox for following text input">' +
                                '</div>' +
                            '</div>' +
                            '<input type="text" id="' + answerId + '-text" name="answerText_' + answerId + '" class="form-control" aria-label="Text input with checkbox" placeholder="Answer">' +
                            '<button class="btn btn-danger delete-answer-btn"><i class="fa fa-trash"></i></button>' +
                        '</div>' +
                    '</div>';
                } else if (inputType === 'radio') {
                    inputHTML = 
                    '<div class="col-md-12 mb-2 answer-item">' +
                        '<div class="input-group">' +
                            '<div class="input-group-prepend">' +
                                '<div class="input-group-text">' +
                                    '<input type="radio" id="' + answerId + '-radio" class="answer-radio" name="answers_" value="' + answerId + '" aria-label="Radio button for following text input">' +
                                '</div>' +
                            '</div>' +
                            '<input type="text" id="' + answerId + '-text" name="answerText_' + answerId + '" class="form-control" aria-label="Text input with radio button" placeholder="Answer">' +
                            '<button class="btn btn-danger delete-answer-btn"><i class="fa fa-trash"></i></button>' +
                        '</div>' +
                    '</div>';
                }

                $('#answers-container').append(inputHTML);
                currentType = inputType; // Cập nhật loại câu trả lời hiện tại
            });

            // Xử lý sự kiện xóa câu trả lời
            $(document).on('click', '.delete-answer-btn', function(e) {
                e.preventDefault();
                $(this).closest('.answer-item').remove();

                // Kiểm tra nếu không còn câu trả lời nào, đặt currentType về ''
                if ($('.answer-item').length === 0) {
                    currentType = '';
                }
            });

            // Xử lý sự kiện chọn radio button
            $(document).on('change', '.answer-radio', function() {
                $('.answer-radio').not(this).prop('checked', false);
            });

            // Xử lý trước khi submit form
            $('#quiz-form').submit(function() {
                // Đảm bảo rằng ít nhất một câu trả lời được chọn
                if ($('input[name^="answers_"]:checked').length === 0) {
                    alert('You have to choose at least one answer');
                    return false; // Ngăn không submit form nếu không có câu trả lời nào được chọn
                }

                // Kiểm tra tiêu đề của câu hỏi
                if ($('#questionTitle').val().trim() === '') {
                    alert('The question title cannot be empty');
                    return false;
                }

                // Kiểm tra nội dung các câu trả lời
                var allAnswersFilled = true;
                $('input[name^="answerText_"]').each(function() {
                    if ($(this).val().trim() === '') {
                        allAnswersFilled = false;
                        return false; // Dừng kiểm tra ngay khi phát hiện một câu trả lời rỗng
                    }
                });

                if (!allAnswersFilled) {
                    alert('All answer fields must be filled');
                    return false; // Ngăn không submit form nếu có câu trả lời rỗng
                }

                // Hiển thị các ID của câu trả lời trong console (tùy chọn)
                $('input[name^="answers_"]').each(function() {
                    var answerId = $(this).attr('name').split('_')[1];
                    var answerText = $('input[name="answerText_' + answerId + '"]').val();
                    console.log('Answer ID: ' + answerId + ', Answer Text: ' + answerText);
                });

                // Điều chỉnh dữ liệu trước khi gửi lên server (nếu cần)
                // Ví dụ: thu thập dữ liệu, xử lý validate,...

                return true; // Cho phép submit form nếu đã kiểm tra xong
            });
        });
        </script>





<<<<<<< HEAD
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/front-end







        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    </body>


</html>