<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap-responsive.css">
      <link rel="stylesheet" href="home.css">
<title>Search Customer</title>
</head>
<body>
 <div class="row">
          
                <ul class="nav">
                 
               
                <li class="active"><a href="View_Customer.jsp">View Customers</a></li>
                <li class="active"><a href="Transfer Amount.jsp">Transfer Amount</a></li>
                <li class="active"><a href="Search.jsp">Search Customer</a></li>
                <li class="active"><a href="TransferDetails.jsp">Transfer Details</a></li>
                <hr style="border: 0.5px solid white" />
                </ul>
                
              </div>
        </header>
<form action="SearchController" method=post>
	<div class="container2">
	
		<p>Account No<span class="req">*</span></p>
            <input type="text" name="sacc_no" placeholder="Enter Account Number" >
             <input type="submit" name="" value="Search"  >
         </div>
         
      </form>   
</body>
</html>