<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Accounts List</title>
</head>
<body>
    <h1>Accounts List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Username</th>
                <th>Password</th>
                <th>Email</th>
                <th>First Name</th>
                <th>Last Name</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="account" items="${accounts}">
                <tr>
                    <td>${account.name}</td>
                    <td>${account.password}</td>
                    <td>${account.email}</td>
                    <td>${account.first_name}</td>
                    <td>${account.last_name}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h2>Add or Update Account</h2>
    <form method="POST" action="all_manager_accounts">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username"><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br>
        <label for="email">Email:</label>
        <input type="text" id="email" name="email"><br>
        <label for="first_name">First Name:</label>
        <input type="text" id="first_name" name="first_name"><br>
        <label for="last_name">Last Name:</label>
        <input type="text" id="last_name" name="last_name"><br>
        <label for="status">Status:</label>
        <input type="text" id="status" name="status"><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
