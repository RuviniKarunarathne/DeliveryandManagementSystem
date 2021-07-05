<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Promotional Order Management</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel = "stylesheet" href = "Styles/PromoFormStyle.css"/>
</head>
<body>
<div class = "wrapper">
	<div class = "header">
				<center>
					<img alt="logo" src="images/kiaora_logo.png" width="30%" height="30%" >
				</center>
			</div>
			
			<div class  = "navigation">
				<ul class="breadcrumb">
	  				<li><a href="#">Home</a></li>
	  				<li><a href="#">Employee Portal</a></li>
  				<li><a href="adminAccount.jsp">Admin Account</a></li>
  				<li><a href="PromoMain.jsp">Promotion</a></li>
  				<li><a href="PromoCustomerInsert.jsp">Add Customer</a></li>
  				<li><a href="PromoOrderInsert.jsp">Add Order</a></li>
  				<li><a href="PromoDetailsSearch.jsp">Search Details</a></li>
				</ul> 
			</div>
		<div class="field-wrapper">
			<fieldset>
				<div class="topic">
					<h1>Promotional Order Management</h1>	
				</div>	
	
			<center>
				<div name = "credential_error" id ="credential_error" class="credential_error"> ${credential_error}</div>
			</center>
				
				<div class="button-shape">
					<a href ="PromoCustomerInsert.jsp">
						<input type = "button" name ="PromoAddCustomer" value ="Add Promotional Customer">
					</a>
					
					<a href ="PromoOrderInsert.jsp">
						<input type = "button" name ="PromoAddOrder" value ="Add Promotional Order">
					</a>
					
					<a href ="PromoDetailsSearch.jsp">
						<input type = "button" name ="PromoSearch" value ="Search Details">
					</a>
				</div>	
			
			</fieldset>		
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
</div><!-- wrapper -->

</body>
</html>