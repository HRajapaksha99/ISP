<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.oop.model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.CategoryServiceImpl"%>
<%@page import="com.oop.service.ICategoryService"%>   
    
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
        <link href="https://fonts.googleapis.com/css?family=Rubik:400,700" rel="stylesheet">
        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <!-- <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet"> -->
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
    
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://kit.fontawesome.com/7db8364a09.js"></script>
    
    
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <!-- Page level plugin CSS-->
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
    
        <link rel="stylesheet" href="css/aos.css">
    
        <link rel="stylesheet" href="css/style.css">



</head>
<body>


<button class="tablink" onclick="openPage('Add', this, 'red')">+Category</button>
<button class="tablink" onclick="openPage('Update', this, 'green')">Update</button>
<button class="tablink" onclick="openPage('View', this, 'blue')"id="defaultOpen">View All</button>

<div class="tabcontent" id="Add">
      <form action="AddCategoryServlet" method="post">
              <h4 class="text-left text-primary">Category Details</h4>
              <br>
				<!-- ROW 01 -->
              
				
              <!-- ROW 02 -->
              <div class="row">
                <div class="col-sm-3 ">
                  <h5>Category Name</h5>
                </div>
                <div class="col-sm-6">
                  <div class="form-group">
                    <input type="text" class="form-control form-control-lg" name="catName"  required="required">
                  </div>
                </div>
                <div class="col-sm-3"></div>
              </div>

              <!-- ROW 03 -->
              <div class="row">
                <div class="col-sm-3 ">
                  <h5>Sub Category Name</h5>
                </div>
                <div class="col-sm-6">
                  <div class="form-group">
                    <input type="text" class="form-control form-control-lg" name="subName" required="required">
                  </div>
                </div>
                <div class="col-sm-3"></div>
              </div>

              <!-- ROW 03 -->
              <div class="row">
                <div class="col-sm-3 ">
              
                </div>
                <div class="col-sm-6">
                  <div class="row">
                    <div class="col-sm-6">
                      <div class="input-group">
                        <input type="submit" class="btn btn-primary" value="Submit">
                      </div>
                    </div>
                  
                    <div class="col-sm-6">
                      <div class="input-group">
                        <input type="reset" class="btn btn-primary" value="Reset">
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-sm-3"></div>
              </div>
            </form>
</div>


<div class="tabcontent" id="View">
<%
    ICategoryService iCategoryService = new CategoryServiceImpl();
     ArrayList<Category> arrayList = iCategoryService.getCategory();
    for(Category category : arrayList){
%>
        
        <div class="row">
          
          <div class="col-lg-8">
            <div class="row">
              <div class="col-sm-6">
                <h6>Category No</h6>
              </div>
              <div class="col-sm-6">
                <h6><%=category.getCatNo() %></h6>
              </div>
            </div>
            <br>
            
            <div class="row">
              <div class="col-sm-6">
                <h6>Category Name</h6>
              </div>
              <div class="col-sm-6">
                <h6><%=category.getCatName() %></h6>
              </div>
            </div>
            <br>
            <div class="row">
              <div class="col-sm-6">
                <h6>Sub Category Name</h6>
              </div>
              <div class="col-sm-6">
                <h6><%=category.getSubName() %></h6>
              </div>
            </div>
            <br>
            
            <div class="row">
              <div class="col-sm-3">
                <form method="POST" action="GetCategoryServlet">
                  <input type="hidden" name="itemNo" value="<%=category.getCatNo()%>" />
                  <input type="submit" value="Select Category "   class="btn btn-primary" />
                </form>
              </div>
              
              <div class="col-sm-3">
                
              </div>
              
              <div class="col-sm-3">
                
              </div>
            </div>

          </div>
          
        

      <hr style="border: 2px solid #0f9fe6; ">   

    </div> 
    
    <%	
			   }
            %>  
    </div>


        
 <div class="tablecontent" id="Update">
<%
Category c = (Category) request.getAttribute("category");
String cu=c.getCatNo();
System.out.println(cu);
%> 
 
 <form action="UpdateCategoryServlet" class="post">
                <h4 class="text-left text-primary">Category Details</h4>
                <br>

                <!-- ROW 01 -->
                <div class="row">
                    <div class="col-sm-3 ">
                        <h5>Category ID</h5>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <input type="text" name="catNo" class="form-control form-control-lg" disabled="disabled" value="<%c.getCatNo();%>">
                        </div>
                    </div>
                    <div class="col-sm-3"></div>
                </div>


                <!-- ROW 02 -->
                <div class="row">
                    <div class="col-sm-3 ">
                        <h5>Category Name</h5>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <input type="text" name="catName" class="form-control form-control-lg" value="<%c.getCatName();%>">
                        </div>
                    </div>
                    <div class="col-sm-3"></div>
                </div>

                <!-- ROW 03 -->
                <div class="row">
                    <div class="col-sm-3 ">
                        <h5>Sub Category Name</h5>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <input type="text" name="subName" class="form-control form-control-lg" value="<%c.getSubName(); %>">
                        </div>
                    </div>
                    <div class="col-sm-3"></div>
                </div>

                <!-- ROW 03 -->
                <div class="row">
                    <div class="col-sm-3 ">

                    </div>
                    <div class="col-sm-6">
                        <div class="row">
                            <div class="col-sm-6">
                                    <input type="hidden" name="catNo" value="<%c.getCatNo();%>" />
                                    <input type="submit" value="Update " class="btn btn-primary" />
                            </div>

                            <div class="col-sm-6">
                               
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3"></div>
                </div>
            </form> <br> 
            
                        <div class="row">
                            <div class="col-sm-3">
                                   
                            </div> <br>

                            <div class="col-sm-6">
                               <form method="POST" action="DeleteCategoryServlet">
                                    <input type="hidden" name="catNo" value="" />
                                    <input type="submit" value="Delete  " class="btn btn-danger fas fa-trash-alt" />
                                </form>
                            </div>
                            <div class="col-sm-3"></div>
                        </div>
                        
                        
                     
        </div> 
        




























<script type="text/javascript">


function openPage(pageName, elmnt, color) {
	  // Hide all elements with class="tabcontent" by default */
	  var i, tabcontent, tablinks;
	  tabcontent = document.getElementsByClassName("tabcontent");
	  for (i = 0; i < tabcontent.length; i++) {
	    tabcontent[i].style.display = "none";
	  }

	  // Remove the background color of all tablinks/buttons
	  tablinks = document.getElementsByClassName("tablink");
	  for (i = 0; i < tablinks.length; i++) {
	    tablinks[i].style.backgroundColor = "";
	  }

	  // Show the specific tab content
	  document.getElementById(pageName).style.display = "block";

	  // Add the specific color to the button used to open the tab content
	  elmnt.style.backgroundColor = color;
	}

	// Get the element with id="defaultOpen" and click on it
	document.getElementById("defaultOpen").click(); 


</script>





</body>
</html>