<%@include file="header.jsp"%>
<%@ page import="business.User" %>
<% String message = (request.getAttribute("message") == null) ? "": (String) request.getAttribute("message");
    User user = (User)request.getAttribute("user");
    if(user == null) {
        user = new User();
    }
%>
<script language="JavaScript">
    function validate(form) {
        if(form.firstName.value == "") {
            alert("Please enter in your first name.");
            form.firstName.focus();
        } else if(form.lastName.value =="") {
            alert("please enter in your last name.");
            form.lastName.focus();
        } else if (form.emailAddress.value == "") {
            alert("Please enter in your email address.");
            form.emailAddress.focus();
        } else {
            form.submit();
        }
    }
</script>
<h1>Join our email list!</h1>
<p>To join our emailing list enter your name and email address below</p>

<p><i><%= message %></i></p>

<form action="addToEmailList" method="post">
    <div class="form-label-group">
        <input type="text" class="form-control" name="firstName" id="firstName" placeholder="First name"  value="<%=user.getFirstName()%>" required autofocus>
        <label for="firstName">First name</label>
    </div>

    <div class="form-label-group">
        <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last name" value="<%=user.getLastName()%>">
        <label for="lastName">Last name</label>
    </div>

    <div class="form-label-group">
        <input id="emailAddress" type="email" class="form-control" name="emailAddress" value="<%=user.getEmailAddress()%>" placeholder="Email address">
        <label for="emailAddress">Email address</label>
    </div>

    <button type="submit" class="btn btn-primary btn-block" onclick="validate(this.form)">Submit</button>
</form>
<%@include file="footer.jsp"%>
