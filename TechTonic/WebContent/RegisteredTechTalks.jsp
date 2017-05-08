<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.sql.Connection" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ page import="java.sql.DriverManager,java.sql.Statement,java.sql.ResultSet" %>
   
<!DOCTYPE html>
<html>
<title>User Info</title>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
</head>
<body>
<h3>Welcome ${username} </h3>



<table border="2">

<tr>

<td>Tid</td>
<td>Email</td>

</tr>
<tr>
<c:forEach items="${sessionScope.EList}" var="item">

<td>${item.tid}</td>
<td>${item.email}</td>


</c:forEach>
</tr>
</table>

<a href="Admin_Info.jsp" ><button>Back</button> </a>

</body>
</html>