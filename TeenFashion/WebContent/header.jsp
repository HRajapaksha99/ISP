<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.oop.model.RegisterBean" %>
<%@page import="com.oop.service.IRegisterService" %>
<%@page import="com.oop.service.RegisterServiceImpl" %>
<%@page import="com.oop.service.UploadDPService" %>
<%@page import="com.oop.service.IUploadDP" %>
<%@page import="com.oop.service.LoginDea" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.oop.model.RegisterBean"%>
<%@page import="com.oop.model.Image"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="fonts/icons/style.css">
<link rel="stylesheet" href="css/style.css">

<style>
.sidenav {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color:black;
  opacity:0.8;
  background-size:cover;
  background-repeat:no-repeat;
  background-position:center;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
}

.sidenav a {

  text-decoration: none;
  font-size: 20px;
  color: #818181;
  font-family:Blooming sans elegent;
  display: block;
  text-align:center;
  transition: 0.3s;
  padding-top: 5px;
}

.sidenav a:hover {
  color: #f1f1f1;
  background-color:black;
}

.sidenav .closebtn {
  position: absolute;
  top: 0;
  right: 10px;
  font-size: 36px;


}

#main {
  transition: margin-left .5s;
  padding: 30px;
}
#side-head{
color:grey;
font-style: italic;
font-family:Blooming sans elegent;
font-size: 20px;
text-align:center;
transition: 0.3s;
}

#side-img{
display:block;
margin-left:auto;
margin-right:auto;
height:65px;
width:65px;
border-radius:50%
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}


.pauction{

  background-color: none;
  color: black;
  border: 2px solid #555555;
  border-radius:4px;
}

.pauction:hover {
  background-color: black;
  color: white;
  
}

.btnmen{

  background-color:black;
  color: black;
  border: 2px solid black;
  border-radius:4px;
}

.btnmen:hover {
  background-color: red;
  border: 2px solid red;
  color: white;
  
}


.rocket{
position: relative;

}

.overlay {
position: Absolute;
opacity: 0;
transition: .3s ease;

top: 0;
bottom: 0;
left: 87px;
right: 0;
height:65px;
width:66px;
border-radius:50%
}

.rocket:hover .overlay {
  opacity: 0.8;
  background-color: black;
}

.icon {
   
  color: white;
  font-size: 100px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  text-align: center;
  text-decoration:none;

}

/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: fixed;
  bottom: 0;
  right: 15px;
  border: 3px solid #f1f1f1;
  z-index: 100;
}



.image-form-container{
 
 position:fixed;
 display:none;
 z-index:100;
 width:1200px;
 height:500px;
 margin-left:275px;
 margin-top:100px;
 background:black;
 font-color:white;
 opacity:0.8;
 padding:30px;
 }
 
.image-form-close{
 
  position: absolute;
  top: -8px;
  left:1170px;
  font-size: 36px;
  color:white;
 
 }

 .image-form-upload{
 position:absolute;
 left:555px;
 top:420px;
 button-border:none;
 background-color:white;
 padding: 6px 20px;
  border: none;
  cursor: pointer;
  border-radius:4px; font-family:blooming sans elegent;
 
 }

 .image-form-upload:hover{
  background-color:green;
 
 }
 .file-input{

	width: 0.1px;
	height: 0.1px;
	opacity: 0;
	overflow: hidden;
	position: absolute;
	z-index: -1;
}

.file-input + label {
    font-size: 15px;
    font-weight: 700;
    color: black;
    background-color:white;
    display: inline-block;
    cursor: pointer;
    margin-left:510px;
    margin-top:10px;
    padding:10px;
    border-radius:4px;
    font-family:blooming sans elegent;
    
}

.file-input:focus + label,
.file-input + label:hover {
    background-color: red;
    z-index:100;
}
 
 
 #output_image
 {
  width:250px; height:250px; border:2px solid white; border-radius:50%; display:block; margin-left:auto; margin-right:auto; margin-top:25px}




</style>



</head>
<%



%>





<body class="brain">

         
       <div class="site-navbar bg-dark py-2">
    
          <div class="search-wrap">
        <div class="container">
          <a href="#" class="search-close js-search-close"><span class="icon-close2"></span></a>
          <form action="#" method="post">
            <input type="text" class="form-control" placeholder="Search keyword and hit enter...">
          </form>  
        </div>
      </div>
    
          <div class="container">
            <div class="d-flex align-items-center justify-content-between">
              <div class="logo">
                <div class="site-logo">
                  <a href="landPageCusView.jsp" class="js-logo-clone"> <img src="images/new/black.png" id="mainLogo" style="width: 280px;height: 200px;"> </a>
                </div>
              </div>
              <div class="main-nav d-none  d-lg-block">
                <nav class="site-navigation text-right text-md-center" role="navigation">
                  <ul class="site-menu js-clone-nav d-none d-lg-block">
                    
                    <li class="has-children">
                      <a href="landPageCusView.jsp">Sample products</a>
                      <ul class="dropdown">

                          <li class="has-children">
                            <a href="#">Fashion</a>
                            <ul class="dropdown">
                              <li><a href="#">Gents</a></li>
                              <li><a href="#">Ladies</a></li>
                              <li><a href="#">Kids</a></li>
                             
                            </ul>
                            </ul>
                          </li>

                    <li>
                    
                    
                    <li><a href="topsellers.jsp">Top Designs</a></li>
                    <li><a href="about.jsp">About</a></li>
                    <li><a href="contact.jsp">Contact</a></li>
                    
                    
                   
                  </ul>
                </nav>
              </div>
              <div class="icons">
            <a href="#" class="icons-btn d-inline-block js-search-open"><span class="icon-search"></span></a>
           
         
          
<%
String username=(String)session.getAttribute("username");
if(username == null)
{
%>
  
  <a href="index.jsp">  <button class="btnmen"><i class="fas fa-bars" style ="color:white;"></i></button></a>
 <% } %>   
 
<%

if(username!= null){
	
	IRegisterService r1 = new RegisterServiceImpl();
	RegisterBean u1 =  r1.getUserByName(username);
	String Uname =u1.getuName();
	String Umail=u1.getuMail();
	String Upass=u1.getuPass();
	String Utype=u1.getU_type();
	
     if(Utype.equals("Seller")) {	 
%>
<a href="addItem.jsp" ><button class="pauction">+Add</button></a>
<button onclick= "openNav()" class="btnmen"><i class="fas fa-bars" style ="color:white;"></i></button> 


<div id="mySidenav" class="sidenav">

  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  
 <div class="rocket">
 
 
 <% 
    IUploadDP i1 = new UploadDPService();
    byte[] img = i1.getPhotos(username);
    
    if(img == null)
    { 
 
 %>
 
       <img id="side-img"  src="images/user.png">
  
 <% 
    }
    if(img != null){   
    		    
 %>
      <img id="side-img"  src="Display.jsp?username=<%=Uname%>">
      
 <% } %>
 
  <div class="overlay">
  <a href="javascript:openForm()" class="icon" title="Upload profile picture">
    <i class="fa fa-camera"></i> 
  </a>
  </div>
  </div>
  <h1 id="side-head"><%=Uname%></h1>
  <span style =" display:block;margin-left:100px; font-size:10px;" >Online<i class="far fa-dot-circle" style ="color:green;"></i></span>
  <a href="javascript:openSettingForm()">Account Settings</a>
  <a href="addItem.jsp">Post products</a>
  <a href="landPage.jsp">View products</a>
  <a href="logout.jsp">Log out</a>
</div>

<% } %>
<% } %>

<%
if(username != null)
{	
	IRegisterService r1 = new RegisterServiceImpl();
	RegisterBean u1 =  r1.getUserByName(username);
	String Uname =u1.getuName();
	String Umail=u1.getuMail();
	String Upass=u1.getuPass();
	String Utype=u1.getU_type();
	
	
if(Utype.equals("admin")){	 
%>
<a href="addItem.jsp" ><button class="pauction">+Add</button></a>
<button onclick= "openNav()" class="btnmen"><i class="fas fa-bars" style ="color:white;"></i></button> 

<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
 <div class="rocket">
 
 <% 
    IUploadDP i1 = new UploadDPService();
    byte[] img = i1.getPhotos(username);
    
    if(img == null)
    { 
 
 %>
 
       <img id="side-img"  src="images/user.png">
  
 <% 
    }
    if(img != null){   
    		    
 %>
      <img id="side-img"  src="Display.jsp?username=<%=Uname%>">
      
 <%} %>
  
  <div class="overlay">
  <a href="javascript:openForm()" class="icon" title="Upload profile picture">
    <i class="fa fa-camera"></i> 
  </a>
  </div>
  </div>
  
  <h1 id="side-head"><%=Uname%></h1>
   <span style =" display:block;margin-left:100px; font-size:10px;" >Online<i class="far fa-dot-circle" style ="color:green;"></i></span>
  <a href="javascript:openSettingForm()" >Account Settings</a>
  <a href="addemployee.jsp">Manage employees</a>
  <a href="addstock.jsp">Manage inventory</a>
  <a href="user.jsp">Manage Users</a>
  <a href="notifications.jsp">Notifications</a>
  <a href="logout.jsp">Log out</a>
  
</div>

<%} } %>
<%
if(username != null)
{	
	IRegisterService r1 = new RegisterServiceImpl();
	RegisterBean u1 =  r1.getUserByName(username);
	String Uname =u1.getuName();
	String Umail=u1.getuMail();
	String Upass=u1.getuPass();
	String Utype=u1.getU_type();
	
	
if(Utype.equals("Buyer"))
{%>
<button class="pauction" disabled>+ Add</button>
<button onclick= "openNav()" class="btnmen"><i class="fas fa-bars" style ="color:white;"></i></button> 
 
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <div class="rocket">
  
  
 
 <% 
    IUploadDP i1 = new UploadDPService();
    byte[] img = i1.getPhotos(username);
    
    if(img == null)
    { 
 
 %>
 
       <img id="side-img"  src="images/user.png">
  
 <% 
    }
    if(img != null){   
    		    
 %>
      <img id="side-img"  src="Display.jsp?username=<%=Uname%>">
      
 <%} %>
 
  <div class="overlay">
  <a href="javascript:openForm()" class="icon" title="Upload profile picture">
    <i class="fa fa-camera"></i> 
  </a>
  </div>
  </div>
  <h1 id="side-head"><%= Uname %></h1>
<span style =" display:block;margin-left:100px; font-size:10px;" >Online<i class="far fa-dot-circle" style ="color:green;"></i></span>
  <a href="javascript:openSettingForm()">Account Settings</a>
  <a href="paymentList.jsp">Payment History</a>
  <a href="viewawarded.jsp"></a>
  <a href="logout.jsp">Log out</a>
</div>
<%} } %>

      
          </div>
            </div>
          </div>
        </div>
        
<!-- Profile Picture updating form -->
<div class="image-form-container" id="ImageForm">
<a href="javascript:void(0)" class="image-form-close" onclick="closeForm()">&times;</a>
  <form method ="POST" action="UploadDP" enctype="multipart/form-data" class="form-container">


    <label ><b style ="display:block; margin-left:420px; margin-right:; font-Family:blooming sans elegent; font-size:30px;">Upload your image Here</b></label><br>
    <input class="file-input" type="file" placeholder="Profile.pic" id="image" accept="image/*" name="image" onchange="preview_image(event)" required>
    <label for="image">Choose a file</label>
    <br>
    <img id="output_image"/>
    
    <div >
        <input type="hidden" value="<%=(String)session.getAttribute("username") %>" name="username"/>
        </div>

    <button type="submit" class="image-form-upload">Upload</button>
  </form>
</div>        
 
 
 
<!-- Account Setting Form -->
 <jsp:include page="lol.jsp"></jsp:include>
 
  

 
 
<script>
//navigation handler
function openNav() {
  document.getElementById("mySidenav").style.width = "240px";
  document.getElementById("brain").style.marginLeft = "240px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("brain").style.marginLeft= "0";
}
</script>

<script>
//Form opener
function openForm() {
  document.getElementById("ImageForm").style.display = "block";
}

function closeForm() {
  document.getElementById("ImageForm").style.display = "none";
}
</script>


<script>
//Settings opener
function openSettingForm() {
  document.getElementById("SettingForm").style.display = "block";
}

function closeSettingForm() {
  document.getElementById("SettingForm").style.display = "none";
}
</script>

<script type='text/javascript'>
function preview_image(event) 
{
 var reader = new FileReader();
 reader.onload = function()
 {
  var output = document.getElementById('output_image');
  output.src = reader.result;
 }
 reader.readAsDataURL(event.target.files[0]);
}
</script>
</body>
</html>