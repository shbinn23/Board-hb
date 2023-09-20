<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #fafafa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .login-container {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            padding: 40px;
            text-align: center;
            max-width: 400px;
            width: 100%;
        }
        .login-logo {
            font-size: 2rem;
            margin-bottom: 20px;
            color: #333;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group input {
            border: none;
            border-bottom: 1px solid #ccc;
            padding: 10px;
            width: 100%;
        }
        .form-group input:focus {
            outline: none;
            border-bottom: 1px solid #333;
        }
        .login-button {
            background-color: #0095f6;
            border: none;
            border-radius: 4px;
            color: #fff;
            cursor: pointer;
            font-weight: bold;
            padding: 10px 20px;
            transition: background-color 0.2s;
        }
        .login-button:hover {
            background-color: #0077c0;
        }
        .signup-link {
            font-size: 14px;
            color: #333;
            margin-top: 10px; /* 여기서 간격 조정 */
        }
    </style>

    <script>
        function fn_btnSignupClick(){
            location.href ="${pageContext.request.contextPath}/user/signupForm";
        }
    </script>

</head>
<body>
<div class="login-container">
    <div class="login-logo"></div>
    <form action="/login/process" method="post">
        <div class="form-group">
            <input type="text" class="form-control" name="username" placeholder="Username" required>
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="Password" required>
        </div>
        <button type="submit" class="login-button">Log In</button>
    </form>
    <p class="signup-link">Don't have an account? <a href="/signup">Sign up</a></p>
</div>
</body>
</html>
