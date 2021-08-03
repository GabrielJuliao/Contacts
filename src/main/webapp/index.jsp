<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="css/global.css">
    <link rel="stylesheet" href="css/form.css"/>
    <title>Contacts | Sign In</title>
</head>
<body>
<section id="form-box">
    <form action="${pageContext.request.contextPath}/SignIn" method="POST">
        <h1>Have an account?</h1>
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
        <label for="submit">
            <input
                    class="submit btn-primary"
                    type="submit"
                    id="submit"
                    value="SIGN IN"
            />
        </label>
    </form>

    <div id="form-extras">
        <!-- <label for="remember-me">
            <input type="checkbox" name="remember-me" id="remember-me"/>
            Remember Me
        </label> -->
        <!-- <a href="">Forgot Password</a> -->
    </div>
    <a href="signUp">Don't Have an Account? Sign Up.</a>
</section>
</body>
</html>
