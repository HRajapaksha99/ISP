<%@page import="com.oop.model.RegisterBean"%>
<%@page import="com.oop.service.EmployeeServiceImpl"%>
<%@page import="com.oop.service.IEmployeeService"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.oop.model.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Update Employee |  Teen Fashion</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/7db8364a09.js"></script>
    
    <link href="https://fonts.googleapis.com/css?family=Rubik:400,700" rel="stylesheet">
    <link rel="stylesheet" href="fonts/icomoon/style.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/7db8364a09.js"></script>


    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/jquery-ui.css">
  
    <link rel="stylesheet" href="css/owl.theme.default.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/empup.css">
 
    
    <script> 
 <!--
		function validate() { 
			
			 var Name = document.getElementById("name1");
			 var Surname = document.getElementById("sname");
			 var Address = document.getElementById("add1");
			 var City= getElementById("city1");
			 var Gender = document.getElementById("gen1");
			 var Phone = document.getElementById("phone1");
			 var Email = document.getElementById("mail1");
			 var Salary = document.getElementById("sal1");
			 var Email = document.getElementById("works1");
			 
			 
			 if (name==null || name=="") { 
				 alert("Name can't be blank"); 
				 return false; 
			 }
			 else if (email==null || email=="") { 
				 alert("Email can't be blank"); 
				 return false; 
			 }
			 else if(pass.length<6) { 
				 alert("Password must be at least 6 characters long."); 
				 return false; 
			 } 
			 else if (pass!=re_pass) { 
				 alert("Confirm Password should match with the Password"); 
				 return false; 
			 } 
		 } 
 -->
 <%String emsg = (String)request.getAttribute("ErrMsg"); %>
 
  <% if (emsg != null) { %>
  var emsg = "<%= emsg%>";
  alert(emsg);
  <% } %>
 
 </script> 
 
</head>
<body>

    <div class="main">

        <!-- Sign up form -->
        <section class="signup">
            <div class="container">
                <a class="backHome" href="landPage.jsp"> <i class="fas fa-arrow-circle-left"> </i> Back to HOME page</a><br><br>
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Update Info</h2>
                         <%
                         		Employee employee = (Employee)request.getAttribute("employee");
                                 
                         
			            %>
                        
                        <form action="UpdateEmpServlet" method="POST" class="register-form" id="register-form"  onclick="return validate()">
                            <div class="form-group">
                                <h6><b><i class="fas fa-user">  Employee Id</i></b></h6>
                                <input type="text" name="EId" id="empid" placeholder="Employee ID"  value="<%= employee.getEID() %>"/>
                            </div>
                            <div class="form-group">
                                <h6><b><i class="far fa-address-card">  First name</i></b></h6>
                                <input type="text" name="name" id="name1" placeholder="Emplopyee Name" value="<%= employee.getName() %>"/>
                            </div>
                            <div class="form-group">
                                <h6><b><i class="fas fa-address-card">  Last name</i></b></h6>
                                <input type="text" name="sname" id="sname" placeholder="Your Email" value="<%= employee.getSurName()%>"/>
                            </div>
                            <div class="form-group">
                                <h6><b><i class="fas fa-map-marker-alt">  Address</i></b></h6>
                                <input type="text" name="add" id="add1" placeholder="Address" value="<%= employee.getAddress()%>" />
                            </div>
                            <div class="form-group">
                                <h6><b><i class="fas fa-location-arrow">  City</i></b></h6>
                                <input type="text" name="city" id="city1" placeholder="City" value="<%= employee.getCity()%>"/>
                            </div>
                            
                             <div class="question-answer">
                            
							<input type="radio" id="male" name="gender" value="male">
							<label for="male">Male</label><br>
							 <input type="radio"id="female" name="gender" value="female">
								 <label	for="female">Female</label>
						        </div>
                            
                            
                            <div class="form-group" >
                             <label for="Phone"><i class="fas fa-phone-alt">  Phone No</i></label>
                               <input type="text" name="phone" id="phone1" value="<%= employee.getPNo()%>"/>
                           
                            </div>
                            
                             <div class="form-group" >
                             <h6><b><i class="zmdi zmdi-email">  Email</i></b></h6>
                               <input type="text" name="mail" id="mail1" value="<%= employee.getEmail()%>"/>
                           
                            </div>
                            
                             <div class="form-group">
                                <h6><b><i class="fas fa-file-invoice-dollar">  Salary</i></b></h6>
                                <input type="text" name="sal" id="sal1" placeholder="Salary" value="<%= employee.getSalary()%>"/>
                            </div>
                            
                             <div class="form-group">
                                <h6><b>Works on</b></h6>
                                <input type="checkbox" id="day1" name="day" value="Monday">
							<label for="day1"> Monday</label><br> 
							<input type="checkbox" id="day2" name="day" value="Tuesday"> 
							<label for="day2">Tuesday</label><br> 
							<input type="checkbox" id="day3" name="day" value="Wednesday"> 
							<label for="day3"> Wednesday</label><br>
							<input type="checkbox" id="day4" name="day" value="Thursday">
							<label for="day3"> Thursday</label><br> 
							<input type="checkbox" id="day5" name="day" value="Friday">
							<label for="day4"> Friday</label><br>
							 <input type="checkbox" id="day6" name="day" value="Saturday"> 
							 <label for="day5">Saturday</label><br> 
							 <input type="checkbox" id="day7" name="day" value="Sunday"> <label for="day3"> Sunday</label><br>
						       </div>
                            
                            <div class="form-group">
                                <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                                <label for="agree-term" class="label-agree-term" ><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                            </div>
                            <div class="row" >
                                <div class="col-sm-4">
                                  
                                        <input type="submit" name="updatesave" id="up" class="form-submit" value="Update & Save"/>
                                    </div>
                                
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <input type="reset" class="form-submit" value="Reset"/>
                                    </div>                                    
                                </div>
                            </div>
                        </form>
                        
                         <div class="row">
                        	<div class="col-sm-12">
                               <form method="POST" onclick="return confirm('Are you sure you want to delete this item')" action="DeleteEmployeeServlet">
                                    <input type="hidden" name="id" value="<%=employee.getEID()%>" />
                                    <button type="submit" class="btn btn-danger btn-lg btn-block">Delete User &nbsp; &nbsp;<i class="fas fa-user-slash"></i></button>
                                </form>
                            </div>
                           </div>
                    </div>
                   
                   
                </div>
            </div>
        </section>

        
    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
</body>
</html>