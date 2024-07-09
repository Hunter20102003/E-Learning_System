<%-- 
    Document   : edit-question
    Created on : Jul 8, 2024, 4:00:49 PM
    Author     : LEGION
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add/Edit Question</title>
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
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
        <style>
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

        <jsp:include page="header.jsp"></jsp:include>

            <!-- Navbar End -->
        <c:if test="${questionUpdateSuccess != null}">
            <script>alert('${questionUpdateSuccess}');</script>
        </c:if>
        <c:if test="${questionUpdateFailed != null}">
            <script>alert('${questionUpdateFailed}');</script>
        </c:if>
        <div class="container">
            <div class="card mt-5">
                <div class="card-header bg-primary" style="background-color: #ff6600;">
                    <h5 class="card-title">Edit Question</h5>
                </div>
                <div class="card-body">
                    <div class="modal-body">
                        <form action="QuizzesManagement" method="post" id="quiz-form">
                            <input type="text" name="quizId" value="${quizId}" hidden/>

                            <input type="text" name="questionId" value="${question.questionId}" hidden/>
                            <input type="text" name="action" value="questionEdit" hidden/>

                            <div class="form-group row">
                                <label for="questionTitle" class="col-form-label col-md-3">Title:</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" id="questionTitle" name="questionTitle" placeholder="Enter title of question" value="${question.questionText}">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="typeOfQuestion" class="col-form-label col-md-3">Type:</label>
                                <div class="col-md-4">
                                    <select class="custom-control custom-select form-control" id="typeOfQuestion" name="typeOfQuestion">
                                        <option value="checkbox" ${question.typeId == 2 ? 'selected' : ''}>Checkbox</option>
                                        <option value="radio" ${question.typeId == 1 ?'selected' : ''}>Radio</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-form-label col-md-3">Answers:</label>
                                <div class="col-md-9">
                                    <a href="#" class="btn btn-default" id="add-answer-btn">+ Add Answer</a>
                                </div>
                            </div>
                            <div id="answers-container" class="form-group row">
                                <c:set var="count" value="0" />

                                <c:choose>
                                    <c:when test="${question.typeId == 1}">
                                        <c:set var="count" value="0" />
                                        <c:forEach var="i" items="${question.answers_list}">
                                            <div class="col-md-12 mb-2 answer-item">
                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <input type="radio" id="${answerId}-radio" name="answers_" ${i.isCorrect == true? "checked":""} value="${count}" aria-label="Radio button for following text input">
                                                        </div>
                                                    </div>
                                                    <input type="text" id="${answerId}-text" name="answerText_${count}" class="form-control" aria-label="Text input with radio button" value="${i.answerText}" placeholder="Answer">
                                                    <button class="btn btn-danger delete-answer-btn"><i class="fa fa-trash"></i></button>
                                                </div>
                                            </div>
                                            <c:set var="count" value="${count+1}" />

                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach var="i" items="${question.answers_list}">
                                            <div class="col-md-12 mb-2 answer-item">
                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <input type="checkbox" id="${answerId}-checkbox" name="answers_" ${i.isCorrect == true? "checked":""} value="${count}" aria-label="Checkbox for following text input">
                                                        </div>
                                                    </div>
                                                    <input type="text" id="${answerId}-text" name="answerText_${count}" class="form-control"  value="${i.answerText}" aria-label="Text input with checkbox" placeholder="Answer">
                                                    <button class="btn btn-danger delete-answer-btn"><i class="fa fa-trash"></i></button>
                                                </div>
                                            </div>
                                            <c:set var="count" value="${count+1}" />

                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                            </div>

                            <div class="form-group row">
                                <div class="col-md-3 text-center">
                                    <button type="submit" class="btn btn-primary" id="save-question-btn">Save Question</button>
                                    <a href="#" class="btn btn-default" id="cancel-btn">Cancel</a>
                                </div>
                            </div>
                        </form>


                    </div>

                </div>
            </div>


            <!-- jQuery and Bootstrap scripts -->
            <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>

            <!-- Template Javascript -->
            <script src="js/main.js"></script>

            <script>
$(document).ready(function () {
    var answerCounter = ${count}; // Biến đếm số lượng câu trả lời
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
 
           
    </body>
</html>

