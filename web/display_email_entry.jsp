<%--
  Created by IntelliJ IDEA.
  User: ijaaztello
  Date: 1/19/19
  Time: 9:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="business.User" %>
<% User user = (User) request.getAttribute("user"); %>
<html>
<head>
    <title>My Mailing List</title>
</head>
<body>

    <table>
        <tr>
            <td>First Name</td>
            <td><%= user.getFirstName() %></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <th><%= user.getLastName() %></th>
        </tr>
        <tr>
            <td>Email Address</td>
            <th><%= user.getEmailAddress() %></th>
        </tr>
    </table>

    <p>To enter another email address, click on the back button in your browser or the <b>return</b> button shown below.</p>

    <form action="join_email_list.jsp" method="post">
        <input type="submit" value="Return">
    </form>

</body>
</html>
