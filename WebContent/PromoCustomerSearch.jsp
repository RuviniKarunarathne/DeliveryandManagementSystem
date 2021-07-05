<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel = "stylesheet" href = "Styles/PromoDisplayForm.css"/>
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
  				<li>Search Details</a></li>
			</ul> 
		</div>
		
		
<div class="table-wrapper">
	<table>
		<c:forEach var ="promocus" items ="${proCustomerSearch}">
		
			<c:set var ="cusID" value ="${promocus.cusID}"></c:set>
			<c:set var ="name" value ="${promocus.name}"></c:set>
			<c:set var ="NIC" value ="${promocus.NIC}"></c:set>
			<c:set var ="street" value ="${promocus.street}"></c:set>
			<c:set var ="city" value ="${promocus.city}"></c:set>
			<c:set var ="phoneNo" value ="${promocus.phoneNo}"></c:set>
			<c:set var ="companyName" value ="${promocus.companyName}"></c:set>
			<c:set var ="companyAddress" value ="${promocus.companyAddress}"></c:set>
			
			<tr>
				<td>
					Customer ID	
				</td>
				<td>
					${promocus.cusID}
				</td>
			</tr>
			<tr>
				<td>
					Full Name	
				</td>
				<td>
					${promocus.name}
				</td>
			</tr>
			<tr>
				<td>
					NIC	
				</td>
				<td>
					${promocus.NIC}
				</td>
			</tr>
			
			<tr>
				<td>
					Street
				</td>
				<td>
					${promocus.street}
				</td>
			</tr>
			<tr>
				<td>
					City	
				</td>
				<td>
					${promocus.city}
				</td>
			</tr>
			<tr>
				<td>
					Telephone
				</td>
				<td>
					${promocus.phoneNo}
				</td>
			</tr>
			<tr>
				<td>
					Company Name	
				</td>
				<td>
					${promocus.companyName}
				</td>
			</tr>
			<tr>
				<td>
					Company Address	
				</td>
				<td>
					${promocus.companyAddress}
				</td>
			</tr>
			
			
		</c:forEach>
	</table>

		
	<c:url value="PromoCustomerUpdate.jsp" var ="PromoCustomerUpdate">
		
		<c:param name="cusID" value = "${cusID}"></c:param>
		<c:param name="name" value = "${name}"></c:param>
		<c:param name="NIC" value = "${NIC}"></c:param>
		<c:param name="street" value = "${street}"></c:param>
		<c:param name="city" value = "${city}"></c:param>
		<c:param name="phoneNo" value = "${phoneNo}"></c:param>
		<c:param name="companyName" value = "${companyName}"></c:param>
		<c:param name="companyAddress" value = "${companyAddress}"></c:param>
		
		
	</c:url>

	<div class="searchbutton">
		
		<div class="buttone-lement">
			<a href ="${PromoCustomerUpdate}">
			
				<input type ="button" name="ProUpdate" value="Update Details">
			
			</a>
		</div>
		
		<c:url value = "PromoDeleteCustomer.jsp" var = "PromoDeleteCustomer">
		
			<c:param name="cusID" value ="${cusID}"></c:param>
			<c:param name="name" value = "${name}"></c:param>
			<c:param name="NIC" value = "${NIC}"></c:param>
			<c:param name="street" value = "${street}"></c:param>
			<c:param name="city" value = "${city}"></c:param>
			<c:param name="phoneNo" value = "${phoneNo}"></c:param>
			<c:param name="companyName" value = "${companyName}"></c:param>
			<c:param name="companyAddress" value = "${companyAddress}"></c:param>
		
		</c:url>
		
		<div class="buttone-lement btn-red">
			<a href ="${PromoDeleteCustomer}">
			
				<input type ="button" name = "deleteCustomer" value = "Delete">
			
			</a>
		</div>
		<div class="buttone-lement">
			<a href ="PromoMain.jsp">
			
				<input type ="button" name = "Confirm" value = "Confirm">
			
			</a>
		</div>
	</div>		
</div>	
	
	<div class = "footer clearfix">
			<p>Copyright�2021 KIAORA Enterprises</p>

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