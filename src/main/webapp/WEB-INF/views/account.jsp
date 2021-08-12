<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" scope="session" type="com.gabrieljuliao.Contacts.model.User"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css"/>
    <title>Contacts | Account</title>
</head>
<body>
<section id="form-box">
    <form action="Account" method="POST">
        <h1>Account</h1>
        <label for="firstName">
            <input
                    type="text"
                    id="firstName"
                    name="firstName"
                    placeholder="First Name"
                    value="${user.firstName}"
                    required
            />
        </label>

        <label for="lastName">
            <input
                    type="text"
                    id="lastName"
                    name="lastName"
                    placeholder="Last Name"
                    value="${user.lastName}"
                    required
            />
        </label>

        <label for="email">
            <input
                    type="text"
                    id="email"
                    name="email"
                    placeholder="Email"
                    value="${user.email}"
                    required
            />
        </label>
        <label for="submit">
            <input
                    class="submit btn-primary"
                    type="submit"
                    id="submit"
                    value="SAVE"
            />
        </label>
    </form>
    <form action="DeleteAccount" method="post">
        <label for="delete">
            <input class="submit btn-danger" type="submit" id="delete" name="delete" value="DELETE ACCOUNT">
        </label>
    </form>
<%--    <a href="ChangePassword">Change Password</a>--%>
</section>
</body>
</html>

