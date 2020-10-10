<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">

<head>

<title>Add Product</title>
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
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">

<link rel="stylesheet" href="css/aos.css">

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/addItem.css">

<style>
.custom-select {
	font-size: 15px;
}

.bkg {
	background-color: black;
	opacity: 0.3;
}
</style>

<script>
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
    </script>

</head>

<body>



		<jsp:include page="header.jsp"></jsp:include>

		<br> <br>
		<br>
<br><br><br>

		<div class="container">
			<div class="row">
				<div class="col-4 col-sm-2 col-md-3 col-lg-4">
					<br>
					<br>
					<br>
					<h2 class="text-center" id="col-text"
						style="font-size: 40px; text-transform: uppercase; font-weight: 600; color: black;">Add
						Sample Product</h2>


					<div class="field col-md-9 col-md-offset-34">
						<button class="btn btn-primary pull-right" data-toggle="">
							Add Product&nbsp; <i class="far fa-arrow-alt-circle-down"></i>
						</button>
					</div>

				</div>

				<div class="col-8">
					<div id="carouselExampleIndicators" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li class=" item1 active"></li>
							<li class="item2"></li>
							<li class="item3"></li>
						</ol>
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img src="images/new/item1.jpg" class="d-block w-100">
							</div>
							<div class="carousel-item">
								<img src="images/new/item.jpg" class="d-block w-100">
							</div>
							<div class="carousel-item">
								<img src="images/new/item5.jpg" class="d-block w-100">
							</div>
						</div>

						<!-- Left and right controls -->
						<a class="left carousel-control-prev"
							href="#carouselExampleIndicators" role="button"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="right carousel-control-next"
							href="#carouselExampleIndicators" role="button"> <span
							class="carousel-control-next-icon" aria-hidden="true"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">View  Product</a></li>
				<li class="breadcrumb-item active">Form</li>
			</ol>
		</div>
		<br>

		<div class="container">
			<form action="AddItemServlet" enctype="multipart/form-data"  method="POST">

				<h4 class="text-left text-primary">Sample Product Details</h4>
				<br>
	
							
				<!-- ROW 01 -->
				<div class="row">
					<div class="col-sm-3 ">
						<h6>Product Id<span class="text-danger">*</span></h6>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
							<input name="itemNo" type="text"
								class="form-control form-control-lg" required="required">
						
						</div>
					</div>
					<div class="col-sm-3"></div>
				</div>
				<!-- ROW 03 -->
				<div class="row">
					<div class="col-sm-3 ">
						<h6>Product Name<span class="text-danger">*</span></h6>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
							<input name="name" type="text"
								class="form-control form-control-lg" required="required">
							
						</div>
					</div>
					<div class="col-sm-3"></div>
				</div>

			


		<!-- ROW 05 -->
		<div class="row">
			<div class="col-sm-3">
				<h6>Category</h6>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<select name="category" class="custom-select mr-sm-2"
						id="inlineFormCustomSelect" required="required">
						<option selected>--</option>
						<option value="Gents">Gents</option>
						<option value="Ladies">Ladies</option>
						<option value="Kids">Kids</option>

					</select>
				</div>
			</div>
			<div class="col-sm-3"></div>
		</div>
		<!-- ROW 04 -->
		<div class="row">
			<div class="col-sm-3 ">
				<h6>Item Specific</h6>
			</div>
			<div class="form-group">
				<label for=""> Available Sizes</label><br>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<input type="checkbox" id="day1" name="size" value="S"> <label
						for="item1">S</label><br>
						 <input type="checkbox" id="day2"
						name="size" value="M"> <label for="item2">M</label><br>
					<input type="checkbox" id="day3" name="size" value="L"> <label
						for="item3">L</label><br>
						 <input type="checkbox" id="day4"
						name="size" value="XL"> <label for="size">XL</label><br>
				</div>
			</div>
			<div class="col-sm-3"></div>
		</div>




		<!-- ROW 07 -->
		<div class="row">
			<div class="col-sm-3 ">
				<h6>Prize</h6>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<input name="prize" type="text" class="form-control form-control-lg"
						required="required">
			</div>
			<div class="col-sm-3"></div>
		</div>
</div>




		<!-- ROW 08 -->

		<div class="row">
			<div class="col-sm-3">
				<h6>Item Description</h6>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<textarea name="desc_" cols="60" rows="10"
						class="form-control form-control-lg"></textarea>
				</div>
			</div>
			<div class="col-sm-3"></div>
		</div>
			
		<!-- ROW 05 -->
					<div class="row">
						<div class="col-sm-3 ">
							<h6>Upload Photos</h6>
						</div>
						<div class="col-sm-6">
							<!-- ROW 05 => 01 -->
							<div class="row" id="album">
								<div class="col-sm-4">
									<div class="inner-div">
										<input name="photo1" type="file">
									</div>
								</div>
								<div class="col-sm-4">
									<div class="inner-div">
										<input name="photo2" type="file">
									</div>
								</div>
								<div class="col-sm-4">
									<div class="inner-div">
										<input name="photo3" type="file">
									</div>
								</div>
							</div>
							
							<br>

		
		<br>
		<br>
	

				<div class="row">
           <div class="col-sm-3"> </div>
					<div class="col-sm-3">
						<div class="input-group">
							<a href="index.jsp">
								<button type="submit" class="btn  btn-primary" value="Submit">Add</button>
							</a>
						</div>
					</div>

					<div class="col-sm-3">
						<div class="input-group">
							<button type="button" class="btn btn-danger" value="reset">Reset</button>
						</div>
					</div>
				</div>



			</div>
		
		
		</div>
		</form>
	
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

</body>

</html>