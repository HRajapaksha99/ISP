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
<html>
<head>
    <title>Employees| Teen Fashion </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Rubik:400,700" rel="stylesheet">
    <link rel="stylesheet" href="fonts/icomoon/style.css">
    
    <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/7db8364a09.js"></script>


    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/jquery-ui.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">


    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/style.css">
  <script type="text/javascript">
  
  <!--Update Alert Script -->
   <% String umsg = (String)request.getAttribute("UpdateMsg");%>
    <% if (umsg != null) { %>
    var msg = "<%= umsg%>";
    alert(msg);
    <% }
    
    //Added Alert Script
   String amsg = (String)request.getAttribute("AddMsg"); %>
   
    <% if (amsg != null) { %>
    var amsg = "<%= amsg%>";
    alert(amsg);
    <% }
    
    //Error Alert Script
   String emsg = (String)request.getAttribute("ErrMsg"); %>
   
    <% if (emsg != null) { %>
    var emsg = "<%= emsg%>";
    alert(emsg);
    <% }
    
    //Delete Alert Script
   String dmsg = (String)request.getAttribute("DeleteMsg"); %>
   
    <% if (dmsg != null) { %>
    var dmsg = "<%= dmsg%>";
    alert(dmsg);
    <% }%>
    
    
</script>

</head>
<body>

 <jsp:include page="header.jsp"></jsp:include>
<br><br><br><br>
<br><br>
            <div class="container">
		        <!-- Bread crumbs-->
		        <ol class="breadcrumb">
		            <li class="breadcrumb-item"><a href="employeeview.jsp">Admin</a></li>
		            <li class="breadcrumb-item">Employee</li>
		        </ol>
		    </div> <br>
		     
<div class="container  " id ="content">
	
		
				<%
						IEmployeeService iEmployeeService = new EmployeeServiceImpl();
						ArrayList<Employee> arrayList = iEmployeeService.getEmployees();
						
						for(Employee employee : arrayList) {
            	%>
				

	  <div class="raw">						
 <div class="col-sm-12">
    <div class="card">
      <div class="card-body">
      <div id="element">
    
        <h5 class="p-2 mb-2 rounded bg-dark text-center text-white"><%=employee.getName() + " " + employee.getSurName()  %></h5>
        <div class="p-2 mb-1 row">
         <div class="col-sm-6">
         
        <p class="text-muted" ><strong>EID</strong> : <%=employee.getEID() %>  </p>
        <p class="text-muted">Name: <%=employee.getName() %>  <%=employee.getSurName() %>  </p>
        <p class="text-muted">Address : <%=employee.getAddress() %>  </p>
        <p class="text-muted">City : <%=employee.getCity() %>  </p>
        <p class="text-muted">Gender: <%=employee.getGender() %>  </p>
      
        </div> 
        <div class="col-sm-6">
         <p class="text-muted">Phone : <%=employee.getPNo() %>  </p>
        <p class="text-muted">Email: <%=employee.getEmail() %>  </p>
         <p class="text-muted">Salary: <%=employee.getSalary() %>  </p>
        <p class="text-muted">Working Days : <%=employee.getWorks() %>  </p>
     
        </div>
       
        </div>
       </div>
  <div class="row"> 
        <div class="col-sm-6">
	            	
				        <form action="GetEmployeeServlet" method="POST">
				        		<input type="hidden" name="EId" value="<%=employee.getEID()%>" />
				        		<button type="submit" class="btn btn-black btn-lg btn-block">Edit Employee &nbsp; &nbsp;<i class="fas fa-user-edit"></i></button>
				        </form>
			        </div>
            	
        
         <div class="col-sm-6">
		            
				        <form action="DeleteEmployeeServlet" onclick="return confirm('Are you sure you want to delete this item')" method="POST">
				        		<input type="hidden" name="eId" value="<%=employee.getEID()%>" />
				        		<button type="submit" class="btn btn-danger btn-lg btn-block">Delete Employee &nbsp; &nbsp;<i class="fas fa-user-slash"></i></button>
				        </form> 
				        <br>
				    
		<div class="col-sm-6">
		                
				         
				        		
				   
				    </div>   
				  </div>      
		        	
            	</div>
            	</div>
      </div>
    
    </div>
  </div>
  
 
	
            <%
							
							
						
						}
            %>
            
        </div>      
       
            <br>
            <div class="container">
            	<hr style="border: 2px solid black; ">
            </div>
            
            <input type="hidden" name="EId" >
				        		<button type="submit" id="print" class="btn btn-black btn-lg btn-block">Report &nbsp; &nbsp;<i class="fas fa-file-pdf"></i></button>
				    
				       <script>
				       
				       $('#print').click(function() {

				    	   var w = document.getElementById("content").offsetWidth;
				    	   var h = document.getElementById("content").offsetHeight;
				    	   html2canvas(document.getElementById("content"), {
				    	     dpi: 300, // Set to 300 DPI
				    	     scale: 3, // Adjusts your resolution
				    	     onrendered: function(canvas) {
				    	       var img = canvas.toDataURL("image/jpeg", 1);
				    	       var doc = new jsPDF('L', 'px', [w, h]);
				    	       doc.addImage(img, 'JPEG', 0, 0, w, h);
				    	       doc.save('sample-file.pdf');
				    	     }
				    	   });
				    	 });
				       </script>
          
        <jsp:include page="footer.jsp"></jsp:include>

<script src="assets/js/pdfconvert/jspdf.js"></script>
<script src="assets/js/pdfconvert/jspdf.plugin.from_html.js"></script>
<script src="assets/js/pdfconvert/jspdf.plugin.split_text_to_size.js"></script>
<script src="assets/js/pdfconvert/jspdf.plugin.standard_fonts_metrics.js">  </script>
<script src="assets/js/pdfconvert/jspdf.plugin.addhtml.js"></script>
<script src="assets/js/pdfconvert/filesaver.js"></script>
<script src="assets/js/pdfconvert/jspdf.plugin.cell.js"></script>
<script src="assets/js/pdfconvert/html2canvas.js"></script>
<script src="assets/js/pdfconvert/jspdf.plugin.addimage.js"></script>
</body>
</html>