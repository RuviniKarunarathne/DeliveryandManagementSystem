 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Personal Order Registration</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel = "stylesheet" href = "Styles/PersonalCustomerAndOrder.css"/>

</head>
<body>

	

	<div class = "wrapper">
	
			<div class = "header">
				<center>
					<img alt="logo" src="images/kiaora_logo.png" width="30%" height="30%" >
				</center>
			</div>
			
		<div class="btn-group">
		  <button style="background-color:#04406c; border : none;" type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Customer
		  </button>
		  <div class="dropdown-menu">
		    <a class="dropdown-item" href="PersonalCustomerRegister.jsp">Customer Registration</a>
		    <a class="dropdown-item" href="SPsearchCustomer.jsp">Customer Account</a>
		   
		    
			  </div>
		</div>
		<div class="btn-group">
		  <button style="background-color:#04406c; border : none;  " type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Order
		  </button>
		  <div class="dropdown-menu">
		    <a class="dropdown-item" href="personalOrderRegister.jsp">New Order</a>
		    <a class="dropdown-item" href="SPsearchCustomer.jsp">Search Order</a>
		    <a class="dropdown-item" href="#"></a>
			    
		  </div>
		</div>
		
		<div class="btn-group">
		  <button style="background-color:#04406c; border : none;"  type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Payment
		  </button>
		  <div class="dropdown-menu">
		    <a class="dropdown-item" href="PersonalCustomerPayment.jsp">Get Remaining</a>
		  
		  </div>
		</div>
		<br>
		
		<div class="display">
		  <c:forEach var = "display" items= "${cusId}">
			  	
				<h4 style="background-color; lightgrey; text-align: center;  	color: red;  padding-bottom : 10px; padding-top : 20px; " >CUSTOMER ID</h4>
			  	<h5 style="text-align: center; font-size: 30px;  padding-top : 10px; ">${display.cusId}</h5>
			
			</c:forEach>
		</div>	
		
	<h4 style="color:black; text-align : center; padding-bottom : 30px;  padding-top : 10px; " id = "updatecus"><strong>PERSONAL ORDER REGISTRAION</strong></h4>
	<div class = "wrapper2">	
		<div class="main">
		
	<form action="orderRegister" method="post">
		<div class="form-group">
		    <label for="exampleInputEmail1"><strong>Customer ID</strong></label>
		    <input style="border-color:  #fcb45c;  width: 350px; " type="text" name = "id" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Customer ID"  required>
		    
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1"><strong>Unit Price</strong></label>
		    <input style="border-color:  #fcb45c;  width: 350px; " type="number" name = "price" class="form-control" id="exampleInputPassword1" placeholder="1200.00" required>

		</div>

		   <div class="form-group">
		    <label for="exampleFormControlSelect1"><strong>Item Code</strong></label>
		    <select style="border-color:  #fcb45c;  width: 350px; " class="form-control" name = "code" id="exampleFormControlSelect1" required>
		      <option>Dimo-flW100</option>
		      <option>Dimo-flW40</option>
		      <option>Innovex-wm7</option>
		      <option>PanaS-ledW15</option>
		      <option>PanaS-ledW18</option>	
		      <option>RichS-gcRS547</option>
		      <option>Singer-rc2L</option>
		      <option>Singer-rc5L</option>
		    </select>
	   </div>
	    <div class="form-group">
		    <label for="exampleInputPassword1"><strong>Initial Payment</strong></label>
		    <input style="border-color:  #fcb45c;  width: 350px; " type="number" name = "initpay" class="form-control" id="exampleInputPassword1" placeholder="500.00" required>

		</div>


		<div class="form-group">
		    <label for="exampleInputPassword1"><strong>Purchased Date</strong></label>
		    <input style="border-color:  #fcb45c;  width: 350px; " type="date" name = "pday" class="form-control" id="exampleInputPassword1" required>

		</div>

		<div class="form-group">
		    <label for="exampleInputPassword1"><strong>Due Date</strong></label>
		    <input style="border-color:  #fcb45c;  width: 350px; " type="date" name = "dday" class="form-control" id="exampleInputPassword1" required>

		</div>

		<div class="form-check">

		  <input class="form-check-input" type="radio" name="status" id="exampleRadios1" value="paid" checked>
		  <label class="form-check-label" for="exampleRadios1">
		   Fully Paid
		  </label>
		</div>

		<div class="form-check">
		  <input class="form-check-input" type="radio" name="status" id="exampleRadios2" value="NotPaid">
		  <label class="form-check-label" for="exampleRadios2">
		    Remained
		  </label>
		</div>
		
	

	 	 <button style="margin-top : 20px; margin-left : 120px; background-color:#04406c; margin-bottom : 20px" type="submit" class="btn btn-primary">Add Order</button>
	 </form>
	  
	 </div>
		
	</div>
				
	
	<div class = "footer clearfix"> 
				<p>Copyright©2021 KIAORA Enterprises</p>
	
				<ul>
					<li><a href = "#">Facebook</a></li>
					<li><a href = "#">Twitter</a></li>
					<li><a href = "#">Instagram</a></li>
					<li><a href = "#">RSS feed</a></li>
				</ul>
			</div> <!-- footer -->
			
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
			

	
</body>
</html>