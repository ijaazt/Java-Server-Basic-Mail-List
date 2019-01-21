<%@include file="header.jsp"%>
<%@ page import="business.User" %>
<%
    User user = (User)request.getAttribute("user");
%>
    <table class="table">
        <tr>
            <td>First Name</td>
            <th><%= user.getFirstName() %></th>
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
        <button class="btn" type="submit">Return</button>
    </form>

<%@include file="footer.jsp"%>
