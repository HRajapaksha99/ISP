<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Contact Us | Teen Fashion</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Mukta:300,400,700">
<link rel="stylesheet" href="fonts/icomoon/style.css">

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
<link rel="stylesheet" href="css/contact.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/aos.css">
<link rel="stylesheet" href="css/style.css">


</head>
<body>

	<div class="site-wrap">

		<jsp:include page="header.jsp"></jsp:include>

		<div class="site-blocks-cover inner-page"
			style="background-image: url('images/new/contactUs.jpg'); background-repeat: no-repeat; background-size: cover; height: 60px; background-position: center"
			data-aos="fade">
			<div class="container">
				<div class="row">
					<h1 class="text_header">Contact Us</h1>
				</div>
			</div>
		</div>

		<div class="custom-border-bottom py-3">
			<div class="container">
				<div class="row">
					<div class="col-md-12 mb-0">
						<a href="landPage.jsp">Home</a> <span class="mx-2 mb-0">/</span> <strong
							class="text-black">Contact Us</strong>
					</div>
				</div>
			</div>
		</div>


		<div class="site-section">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h2 class="h3 mb-8 text-black ">Contact our support center</h2>
					</div>
					<div class="col-md-7">

						<form class="contactusform" action="#" method="post" novalidate>

							<div class="p-3 p-lg-5 border">
								<div class="form-group row">
									<div class="col-md-6">
										<label for="c_fname" class="text-black">First Name <span
											class="text-danger">*</span></label> <input style="height: 35px"
											type="text" class="form-control" id="c_fname" name="c_fname"
											placeholder="First name" required>
										<div class="invalid-feedback">Please at least give us
											your first name</div>
									</div>
									<div class="col-md-6">
										<label for="c_lname" class="text-black">Last Name <span
											class="text-danger">*</span></label> <input style="height: 35px"
											type="text" class="form-control" id="c_lname" name="c_lname"
											placeholder="Last name">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-md-12">
										<label for="c_email" class="text-black">Email <span
											class="text-danger">*</span></label> <input style="height: 35px"
											type="email" class="form-control form-control-lg"
											id="c_email" name="c_email" aria-describedby="emailHelp"
											placeholder="Email" required> <small id="emailHelp"
											class="form-text text-muted">We'll never share your
											email with anyone else.</small>
										<div class="invalid-feedback">Please provide your email
										</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-md-12">
										<label for="c_subject" class="text-black">Subject </label> <input
											style="height: 35px" type="text" class="form-control "
											id="c_subject" name="c_subject" required>
										<div class="invalid-feedback">Please provide your
											subject</div>
									</div>
								</div>

								<div class="form-group row">
									<div class="col-md-12">
										<label for="c_message" class="text-black">Message </label>
										<textarea name="c_message" id="c_message" cols="30" rows="7"
											class="form-control" required></textarea>
										<div class="invalid-feedback">Please fill this</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-12">
										<input type="submit" class="btn btn-primary btn-lg btn-block"
											value="Send Message">
									</div>
								</div>
							</div>
						</form>
					</div>

					<div class="col-md-5 ml-auto">
						<div class="p-4 border mb-3">
							<span class="d-block text-primary h6 text-uppercase ">Kottawa</span>
							<p class="mb-0">No.13/3 Rahula mw, Kottawa,</p>
							<p class="mb-0">+94767833304 - Hansi</p>

						</div>
						<div class="p-4 border mb-3">
							<span class="d-block text-primary h6 text-uppercase">Galle</span>
							<p class="mb-0">no 04, Main rd, Galle</p>
							<p class="mb-0">+9475678956 - Dulasha</p>
						</div>
						<div class="p-4 border mb-3">
							<span class="d-block text-primary h6 text-uppercase">Kandy</span>
							<p class="mb-0">No 678,queens rd, Kandy</p>
							<p class="mb-0">+94716943624 - Javindu</p>
						</div>
						<div class="p-4 border mb-3">
							<span class="d-block text-primary h6 text-uppercase">Malabe</span>
							<p class="mb-0">Isurupura Rd</p>
							<p class="mb-0">+9471678328 - Shanilka</p>
						</div>


					</div>
				</div>
			</div>
		</div>


		<jsp:include page="footer.jsp"></jsp:include>
	</div>

	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/jquery-ui.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/aos.js"></script>

	<script src="js/main.js"></script>
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