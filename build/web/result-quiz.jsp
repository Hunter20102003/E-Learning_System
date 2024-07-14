<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Quiz Results</title>
        <!-- Meta tags for SEO -->
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="${pageContext.request.contextPath}/img/favicon.ico" rel="icon">

        <!-- Google Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="${pageContext.request.contextPath}/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

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

            .results-container {
                background-color: #fff;
                padding: 25px;
                border-radius: 10px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }

            .results-container h1 {
                text-align: center;
                color: #333;
                margin-bottom: 20px;
            }

            .score {
                text-align: center;
                font-size: 24px;
                margin-bottom: 20px;
            }

            .questions {
                margin-bottom: 20px;
            }

            .question {
                margin-bottom: 20px;
                border: 1px solid #ccc;
                padding: 15px;
                border-radius: 5px;
                background-color: #fff;
            }

            .question h3 {
                margin: 0 0 10px;
                font-size: 1.2em;
            }

            .options {
                list-style-type: none;
                padding: 0;
            }

            .options li {
                margin-bottom: 10px;
            }

            input[type="radio"],
            input[type="checkbox"] {
                display: none;
            }

            input[type="radio"]+label,
            input[type="checkbox"]+label {
                position: relative;
                padding-left: 30px;
                cursor: pointer;
                display: inline-block;
                line-height: 20px;
            }

            input[type="radio"]+label:before,
            input[type="checkbox"]+label:before {
                content: '';
                position: absolute;
                left: 0;
                top: 0;
                width: 20px;
                height: 20px;
                border: 2px solid #000;
                border-radius: 50%;
                background: #fff;
            }

            input[type="checkbox"]+label:before {
                border-radius: 3px;
            }

            input[type="radio"]:checked+label:before,
            input[type="checkbox"]:checked+label:before {
                background: #000;
                border-color: #000;
            }

            input[type="radio"]+label:hover:before,
            input[type="checkbox"]+label:hover:before {
                border-color: #555;
            }

            .back-button {
                text-align: center;
                margin-top: 20px;
            }

            .back-button button {
                background-color: #007BFF;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            .back-button button:hover {
                background-color: #0056b3;
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

            .timer {
                font-size: 24px;
                font-weight: bold;
                margin-bottom: 20px;
                text-align: center;
                line-height: 1.5;
            }

            .timer span {
                background-color: #ff6600;
                color: white;
                padding: 5px;
                border-radius: 3px;
                margin: 0 2px;
            }
            .back-button button {
                background-color: #ff6600; /* Orange background color */
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            .back-button button:hover {
                background-color: #cc5500; /* Darker shade of orange on hover */
            }
            .back-quiz a {
                background-color: #ff6600; /* Orange background color */
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                text-decoration: none; /* Remove underline */
                display: inline-block; /* To apply padding */
                text-align: center; /* Center align the text */
            }
            .back-quiz {
                display: flex;
                justify-content: space-evenly; /* Center horizontally */
            }
            .percentage {
                color: blue;
            }
        </style>
    </head>


    <script>
         // Cài ??t l?ch s?
        const currentState = {url: location.href};
        history.pushState(currentState, null, location.href);

        // Ng?n ch?n Alt + Left Arrow và Alt + Right Arrow
        document.addEventListener("keydown", function (event) {
            if (event.altKey && (event.key === "ArrowLeft" || event.key === "ArrowRight")) {
                event.preventDefault();
            }
        });

        // Ng?n ch?n vi?c quay l?i trang tr??c
        window.onpopstate = function () {
            history.pushState(currentState, null, location.href);
        };
    </script>


    <body>
        <!-- Navbar Start -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Navbar End -->

            <div class="container">
                <div class="results-container">
                    <h1>Quiz Results</h1>
                <c:set var="m" value="${menteeScore}" />
                <div class="score">
                    Your Score: ${m.score}/${listQuestions.size()}
                </div>

                <div class="questions">
                    <c:forEach var="question" items="${listQuestions}">
                        <div class="question">
                            <h3>${question.questionText}</h3>
                            <ul class="options">
                                <c:forEach var="answer" items="${question.answers_list}">
                                    <li>
                                        <c:choose>
                                            <c:when test="${question.typeId != 1}">
                                                <input type="checkbox" id="q${question.questionId}${answer.answerId}" name="q${question.questionId}" value="${answer.answerId}" disabled
                                                       <c:if test="${userAnswers[question.questionId].contains(answer.answerId)}">checked</c:if>>
                                            </c:when>
                                            <c:otherwise>
                                                <input type="radio" id="q${question.questionId}${answer.answerId}" name="q${question.questionId}" value="${answer.answerId}" disabled
                                                       <c:if test="${userAnswers[question.questionId].contains(answer.answerId)}">checked</c:if>>
                                            </c:otherwise>
                                        </c:choose>
                                        <label for="q${question.questionId}${answer.answerId}">${answer.answerText}</label>
                                    </li>
                                </c:forEach>
                            </ul>

                            <!-- Feedback for each question -->
                            <c:set var="userSelectedAnswers" value="${userAnswers[question.questionId]}" />
                            <c:set var="correctAnswers" value="${question.correctAnswerIds}" />

                            <c:if test="${userSelectedAnswers == null || !userSelectedAnswers.toString().equals(correctAnswers.toString())}">
                                <p style="color: red;">Answer Is Not Correct</p>
                            </c:if>
                            <c:if test="${userSelectedAnswers != null && userSelectedAnswers.toString().equals(correctAnswers.toString())}">
                                <p style="color: green;">Correct answer</p>
                            </c:if>
                        </div>
                    </c:forEach>
                </div>


                <div class="back-quiz">
                    <c:if test="${m.score < passingScore}">
                        <a href="/E-Learning_System/course/learning?b=quiz&quiz_id=${quiz_id}&course_id=${courseId}" id="backToQuiz">
                            Back to Quiz
                        </a>
                    </c:if>
                    <c:if test="${m.score >= passingScore }">
                        <a href="/E-Learning_System/course/learning/quiz?action=next&quiz_id=${quiz_id}&course_id=${courseId}">
                            Next Lesson
                        </a>

                    </c:if>
                </div>

            </div>

            <div class="sidebar">
                <div class="section video-list">
                    <h3>Video List</h3>
                    <ul>
                        <c:forEach var="l" items="${listLesson}">
                            <li>
                                <div class="video-item">
                                    <label class="video-item-title" onclick="toggleContent(this)">${l.title}</label>
                                    <div class="video-item-content">
                                        <ul>
                                            <c:forEach var="sl" items="${l.sub_lesson_list}">
                                                <span>${youtobeDuration.convertToMinutesAndSeconds(sl.video_duration)}</span>
                                                <li>
                                                    <a href="/E-Learning_System/course/learning?a=sub&course_id=${courseId}&sub_lesson_id=${sl.id}">${sl.title}</a>
                                                </li>
                                            </c:forEach>
                                            <c:forEach var="q" items="${l.quiz_lesson_list}"> 
                                                <li>
                                                    <a href="/E-Learning_System/course/learning?a=quiz&course_id=${courseId}&quiz_id=${q.quizId}">${q.quizName}</a> 
                                                </li> 
                                            </c:forEach>
                                        </ul>

                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="section video-list">
                    <h3>Progress</h3>
                    <div class="progress-content">
                        <c:choose>
                            <c:when test="${userProgress != null}">
                                <c:set var="progress" value="${userProgress.progress}" />
                            </c:when>
                            <c:otherwise>
                                <c:set var="progress" value="0" />
                            </c:otherwise>
                        </c:choose>
                        <ul>
                            <li><span>${course.name}</span>
                                <span class="percentage">${progress}%</span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>



        <script>
            document.addEventListener('DOMContentLoaded', () => {
                let backToQuizLink = document.getElementById('backToQuiz');

                function clearQuizSession(event) {
                    event.preventDefault(); // Prevent the default link action
                    sessionStorage.removeItem('timeLeft'); // Xóa thông tin th?i gian còn l?i
                    window.location.href = event.target.href; // Redirect ??n trang t??ng ?ng
                }

                if (backToQuizLink) {
                    backToQuizLink.addEventListener('click', clearQuizSession);
                }
            });


        </script>


        <!-- JavaScript for toggling content -->
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

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="${pageContext.request.contextPath}/lib/easing/easing.min.js"></script>
        <script src="${pageContext.request.contextPath}/lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="${pageContext.request.contextPath}/mail/jqBootstrapValidation.min.js"></script>
        <script src="${pageContext.request.contextPath}/mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="${pageContext.request.contextPath}/js/main.js"></script>
    </body>
</html>