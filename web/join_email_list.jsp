<%--
  Created by IntelliJ IDEA.
  User: ijaaztello
  Date: 1/19/19
  Time: 9:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Emailing List</title>
</head>
<body>

<h1>Join our email list!</h1>
<p>To join our emailing list enter your name and email address below</p>
<form action="addToEmailList" method="post">
    <table>
        <tr>
            <td>First Name: </td>
            <td><input type="text" name="firstName"></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastName"></td>
        </tr>
        <tr>
            <td>Email Address: </td>
            <td><input type="text" name="emailAddress"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>

</body>
</html>
