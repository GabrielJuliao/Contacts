<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css" />
    <script src="${pageContext.request.contextPath}/js/validatePasswd.js"></script>
    <title>Contacts | Sign Up</title>
</head>
<body>
<section id="form-box">
    <form action="signUp" method="POST">
        <h1>Create an account</h1>
        <label for="firstName">
            <input
                    type="text"
                    id="firstName"
                    name="firstName"
                    placeholder="First Name"
                    required
            />
        </label>

        <label for="lastName">
            <input
                    type="text"
                    id="lastName"
                    name="lastName"
                    placeholder="Last Name"
                    required
            />
        </label>

        <label for="email">
            <input
                    type="text"
                    id="email"
                    name="email"
                    placeholder="Email"
                    required
            />
        </label>
        <label for="password">
            <input
                    type="password"
                    id="password"
                    name="password"
                    placeholder="Password"
                    required
            />
        </label>
        <label for="password-confirm">
            <input
                    type="password"
                    id="password-confirm"
                    name="password-confirm"
                    placeholder="Confirm Password"
                    required
            />
        </label>
        <label for="submit">
            <input
                    class="submit btn-primary"
                    type="submit"
                    id="submit"
                    value="SIGN UP"
            />
        </label>
    </form>
    <a href="${pageContext.request.contextPath}/">Already Have an Account? Sign In.</a>
</section>
</body>
</html>