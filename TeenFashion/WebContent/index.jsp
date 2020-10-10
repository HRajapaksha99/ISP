
				
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.oop.servlet.LoginServlet" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Log In | Teen Fashion</title>


<!-- Font Icon -->
<link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://kit.fontawesome.com/7db8364a09.js"></script>

<style>

.signup-image-link:hover{
background-color: url("images.png");
}

</style>
<!-- Main css -->
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="main">
        <!-- Login -->
        
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="images/new/logoo.png" alt="sing up image" height="50px"></figure>
                        <a style ="color:White; text-decoration:none" href="signup.jsp?user_type=Customer" class="signup-image-link">Sign in</a>
               
                    </div>

                    <div class="signin-form">
                        <h2  style="color:white"class="form-title">Log In</h2>
                        <form method="POST" class="register-form" action="LoginServlet" id="login-form">
                            <div class="form-group">
                                <label for="your_name"><i class="zmdi zmdi-account material-icons-name "></i></label>
                                <input type="text" name="user_name" id="your_name" placeholder="Your Name"  required="required"/>
                            </div>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="user_pass" id="your_pass" placeholder="Password"  required="required"/>
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
                                <label style ="color:white" for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>
                            </div>
                            
                               
                            <div class="form-group" style="color: red">
                               <%=(request.getAttribute("errMessage") == null) ? "": request.getAttribute("errMessage")%>
                            </div>
                            
                            <div class="form-group form-button">
                                <input type="submit" name="signin" id="signin" class="form-submit" value="Log in" />
                            </div>
                         
                            
                        </form>
                        <div style ="color:white" class="social-login">
                            <span class="social-label">Or login with</span>
                            <ul class="socials">
                                <li><a href="#"><i class="display-flex-center zmdi zmdi-facebook"></i></a></li>
                                <li><a href="#"><i class="display-flex-center zmdi zmdi-twitter"></i></a></li>
                                <li><a href="#"><i class="display-flex-center zmdi zmdi-google"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    </div>
</body>
</html>