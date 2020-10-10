<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">

<head>

<title>Add Employee</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="https://fonts.googleapis.com/css?family=Rubik:400,700"
	rel="stylesheet">
<link rel="stylesheet" href="fonts/icomoon/style.css">
<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css"
	rel="stylesheet">
<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://kit.fontawesome.com/7db8364a09.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/jquery-ui.css">

<link rel="stylesheet" href="css/aos.css">
<link rel="stylesheet" href="css/addItem.css">

<style>



</style>





<script>

<!--Error Script -->
<%String emsg = (String)request.getAttribute("ErrMsg"); %>

<% if (emsg != null) { %>
var emsg = "<%= emsg%>";
alert(emsg);
<% } %>


<!--Carousel Script -->
        $('.file-upload').file_upload();

        $(document).ready(function () {
            // Activate Carousel
            $("#carouselExampleIndicators").carousel();

            // Enable Carousel Indicators
            $(".item1").click(function () {
                $("#carouselExampleIndicators").carousel(0);
            });
            $(".item2").click(function () {
                $("#carouselExampleIndicators").carousel(1);
            });
            $(".item3").click(function () {
                $("#carouselExampleIndicators").carousel(2);
            });

            // Enable Carousel Controls
            $(".left").click(function () {
                $("#carouselExampleIndicators").carousel("prev");
            });
            $(".right").click(function () {
                $("#carouselExampleIndicators").carousel("next");
            });
        });
        
        function  ValidateForm(){

        	var ename=document.empform.name.value;
        	var letters=/^[a-zA-Z]+$/;
        	if (ename.value.match(letters)){

        	return true;
        	}else{
        	alert("Please Enter a valid Username");
        	ename.focus();
        	return false;
        	}

        	}
   
        function myFunction() {
        	  var x, text;

        	  // Get the value of the input field with id="numb"
        	  x = document.getElementById("numb").value;

        	  // If x is Not a Number or less than one or greater than 10
        	  if (isNaN(x) || x < 1 || x > 10) {
        	    text = "Input not valid";
        	  } else {
        	    
        	  }
        	  document.getElementById("demo").innerHTML = text;
        	}
        
    </script>

</head>

<body onload='document.empname.name.focus()'>

	<div class="site-wrap">

		<jsp:include page="header.jsp"></jsp:include>
		<br> <br>
		<br>
		<br>
		<br>
		<br>
		<div class="container">
			<div class="row col-12">
				<div class="col-4 col-sm-2 col-md-3 col-lg-4">
					<br>
					<br>
					<br>
					<h2 class="text-center" id="col-text"
						style="font-size: 40px; text-transform: uppercase; font-weight: 600; color: black;">Add
						Employees</h2>


						<div class="field col-md-9 col-md-offset-34">
						<a href="employeeview.jsp"><button class="btn btn-primary pull-right" >
							View Employees&nbsp; <i class="far fa-eye"></i>
						</button></a>
					</div>

				</div>

				<div class="col-8">
					<div id="carouselExampleIndicators" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							 <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    						 <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
   							 <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img src="images/new/s1.jpg" class="d-block  img-fluid">
							</div>
							<div class="carousel-item">
								<img src="images/new/s2.jpg" class="d-block  img-fluid">
							</div>
							<div class="carousel-item">
								<img src="images/new/s3.png" class="d-block img-fluid">
							</div>
						</div>

						<!-- Left and right controls -->
						<a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    					<span class="carousel-control-prev-icon-dark" aria-hidden="true"></span>
    					<span class="sr-only">Previous</span>
  						</a>
  						<a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
   						 <span class="carousel-control-next-icon-dark" aria-hidden="true"></span>
   						 <span class="sr-only">Next</span>
  						</a>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Add Employees</a></li>
		
				<li class="breadcrumb-item active">Form</li>
			</ol>
		</div>
		<br>

		<div class="container">
			<form name= "empform" action="AddEmployeeServlet" method="post">

				<h4 class="text-left text-primary">Employees Details</h4>
				<br>
			 
				<!-- ROW 01 -->
				<div class="row">
					<div class="col-sm-3 ">
						<h6>Employee Id<span class="text-danger">*</span></h6>
					</div>
				
					<div class="col-sm-6">
						<div class="form-group">
							<input name="eid" type="text"
								class="form-control form-control-lg" required="required">

						</div>
					</div>
					
					<div class="col-sm-3"></div>
				</div>
				<!-- ROW 03 -->
				<div class="row">
					<div class="col-sm-3 ">
						<h6>First Name<span class="text-danger">*</span></h6>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
							<input name="name" type="text"
								class="form-control form-control-lg" required="required">
                        </div>
						
					</div>
					<div class="col-sm-3"></div>
				</div>

				<!-- ROW 04 -->
				<div class="row">
					<div class="col-sm-3 ">
						<h6>Last Name<span class="text-danger">*</span></h6>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
							<input name="sname" type="text"
								class="form-control form-control-lg" required="required">

						</div>
					</div>
				</div>



				<div class="row">
					<div class="col-sm-3">
						<h6>Address<span class="text-danger">*</span></h6>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
							<textarea name="add" cols="20" rows="3"
								class="form-control form-control-lg"></textarea>
						</div>
					</div>
					<div class="col-sm-3"></div>
				</div>
				<!-- ROW 04 -->
				<div class="row">
					<div class="col-sm-3 ">
						<h6>City<span class="text-danger">*</span></h6>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
							<input name="city" type="text"
								class="form-control form-control-lg" required="required">

						</div>
					</div>
					<div class="col-sm-3"></div>
				</div>




				<!-- ROW 07 -->
				<div class="row">
					<div class="col-sm-3 ">
						<h6>Gender</h6>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
							<input type="radio" id="male" name="gender" value="male">
							<label for="male">Male</label><br>
							 <input type="radio"id="female" name="gender" value="female">
								 <label	for="female">Female</label>
						</div>
					</div>
					<div class="col-sm-3"></div>
				</div>





				<!-- ROW 08 -->

				<div class="row">
					<div class="col-sm-3">
						<h6>Phone No</h6>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
							<input name="phone" type="text" class="form-control" id="numb">
							<p id="demo"></p>
						</div>
					</div>
					<div class="col-sm-3"></div>
				</div>


				<!-- ROW 09 -->
				<div class="row">
					<div class="col-sm-3">
						<h6>Email</span></h6>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
							<input name="mail" type="email" class="form-control" pattern="[^@]+@[a-zA-Z]+\.[a-zA-Z]{2,6}" required>
						</div>
					</div>
					<div class="col-sm-3"></div>
				</div>

				<!-- ROW 10 -->
				<div class="row">
					<div class="col-sm-3">
						<h6>Salary<span class="text-danger">*</span></h6>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
							<input name="sal" type="text" class="form-control">
						</div>
					</div>
					<div class="col-sm-3"></div>
				</div>

				<!-- ROW 11 -->
				<div class="row">
					<div class="col-sm-3 ">
						<h6>Works on</h6>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
							<input type="checkbox" id="day1" name="day" value="Monday">
							<label for="day1"> Monday</label><br> <input type="checkbox"
								id="day2" name="day" value="Tuesday"> <label for="day2">
								Tuesday</label><br> <input type="checkbox" id="day3" name="day"
								value="Wednesday"> <label for="day3"> Wednesday</label><br>
							<input type="checkbox" id="day4" name="day" value="Thursday">
							<label for="day3"> Thursday</label><br> <input
								type="checkbox" id="day5" name="day" value="Friday"> <label
								for="day4"> Friday</label><br> <input type="checkbox"
								id="day6" name="day" value="Saturday"> <label for="day5">
								Saturday</label><br> <input type="checkbox" id="day7" name="day"
								value="Sunday"> <label for="day3"> Sunday</label><br>
								
						</div>
						<div class="col-sm-3"></div>
					</div>
				</div>
				
<br><br>
				<div class="row">
           <div class="col-sm-3"> </div>
					<div class="col-sm-3">
						<div class="input-group">
							<a href="index.jsp">
								<button type="submit" class="btn  btn-primary" value="Submit" onclick=" return ValidateForm()" onclick="myFunction()">Add</button>
							</a>
						</div>
					</div>

					<div class="col-sm-3">
						<div class="input-group">
							<button type="button" class="btn btn-danger" value="reset">Reset</button>
						</div>
					</div>
				</div>



			</form>
		</div>
		<br>
		<br>
		<br>
	</div>



	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/jquery-ui.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/aos.js"></script>

	<script src="js/main.js"></script>

	<jsp:include page="footer.jsp"></jsp:include>
<script>
// disabling form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    
    var forms = document.getElementsByClassName('contactusform');
    
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script>
</body>

</html>