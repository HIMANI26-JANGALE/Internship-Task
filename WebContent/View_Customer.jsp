<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
Connection con=null;
Statement statement = null;
ResultSet resultSet = null;
//String id = request.getParameter("account_no");

String database = "internship";
String userid = "System";
String password = "hrj13112001";
try {
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/internship","root","hrj13112001");
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap-responsive.css">
      <link rel="stylesheet" href="home.css">
<title>Display Customers</title>
</head>
<body>
<header>
            <div class="row">
          
                <ul class="nav">
                 
               
                <li class="active"><a href="View_Customer.jsp">View Customers</a></li>
                <li class="active"><a href="Transfer Amount.jsp">Transfer Amount</a></li>
                <li class="active"><a href="Search.jsp">Search Customer</a></li>
                <li class="active"><a href="TransferDetails.jsp">Transfer Details</a></li>
                <hr style="border: 0.5px solid white;" />
                </ul>
                
              </div>
        </header>
<h12><center>Customer's List</center></h12>
<table border="7" class="tabledesign">
<tr>
<td>Account Number</td>
<td>Name</td>
<td>Email</td>
<td>Current Balance</td>

	</tr>
<%
try{
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/internship","root","hrj13112001");
statement=con.createStatement();
String sql ="select * from customer";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("account_no") %></td>
<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("current_balance") %></td>
</tr>
<%
}
con.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>