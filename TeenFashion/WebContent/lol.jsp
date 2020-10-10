<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.oop.model.RegisterBean" %>
<%@page import="com.oop.service.IRegisterService" %>
<%@page import="com.oop.service.RegisterServiceImpl" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.settings-form-container{
 position:fixed;
 display:none;
 z-index:100;
 width:1200px;
 height:auto;
 margin-left:275px;
 margin-top:100px;
 background:black;
 font-color:white;
 opacity:0.8;
 padding:30px;
 }

.settings-form-close{
 
  position: absolute;
  top: -8px;
  left:1170px;
  font-size: 36px;
  color:white;
 
 }

.form-group-settings input{
 width:100%;
 height:40px;

}

.form-group-settings label{
font-size:15px;

}

.settings-up-btn{
 width:100%;
 button-border:none;
 background-color:white;
 margin-top:20px;
 padding: 6px 20px;
 border: none;
 cursor: pointer;
 

}
.settings-up-btn:hover{
 background-color:#006600;
  color:white;
}
.settings-del-btn{
 width:100%;
 button-border:none;
 background-color:white;
 padding: 6px 20px;
 margin-top:10px;
 border: none;
 cursor: pointer;

}

.settings-del-btn:hover{
 background-color:#b30000;
 color:white;
}
</style>

</head>
</body>
<%
   String username=(String)session.getAttribute("username");
    if(username != null){		
	IRegisterService r1 = new RegisterServiceImpl();
	RegisterBean u1 =  r1.getUserByName(username);
	String Uname =u1.getuName();
		
	String Umail=u1.getuMail();
		
	String Upass=u1.getuPass();
		
	String Utype=u1.getU_type();
	
	String Uid=u1.getuId();
		
	{
%>

<div class="settings-form-container" id="SettingForm">
<a href="javascript:void(0)" class="settings-form-close" onclick="closeSettingForm()">&times;</a>
<form method="POST" action="UpdateUserServlet" class="form-container">
<label ><b style ="display:block; margin-left:440px; margin-right:; font-Family:blooming sans elegent; font-size:25px;">Account Settings</b></label><br>


<input class="settings-input" type="hidden" name="uId" value ="<%=Uid%>">
<input class="settings-input" type="hidden" name="type" value ="<%=Utype%>"> 
 <div class = "form-group-settings">
<label>User name</label>
 <input class="settings-input" type="text" name="name" value ="<%=Uname%>">
</div>

 <div class = "form-group-settings">
<label>Email</label>
 <input class="settings-input" type="text" name="email" value ="<%=Umail%>">
 </div>
 
 <div class = "form-group-settings">
<label>Password</label>
 <input class="settings-input" type="text" name="pass" value="<%=Upass%>" required>
 </div>
 
<div class = "form-group-settings">
<label>Re Password</label>
<input class="settings-input" type="text" name="re_pass" required>
</div>
 <button type="submit" class="settings-up-btn">Update</button>
 </form>
<form method="POST" action="DeleteUserServlet">
<input class="settings-input" type="hidden" name="uId" value ="<%=Uid%>">
 <button type="submit" class="settings-del-btn">Delete Account</button>
</form>

</div>  
      
<% } } %>


<body>
</body>
</html>



