<%@page import="com.atmecs.pojo.TechTalk"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.sql.Connection,java.sql.DriverManager,java.sql.Statement,java.sql.ResultSet" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container">
  <h2>Request For TechTalk</h2>
  <form action="UserOprnController" method="get">
    
    <div class="form-group">
      <label for="Title">Title</label>
      <input type="hidden" name="op" value="2">
      <input type="text" class="form-control" id="Title" placeholder="Enter Title" name="Title">
    </div>
    
    <div class="form-group">
      <label for="Description">Description</label>
      <input type="text" class="form-control" id="Description" placeholder="Enter Description"  name="Description">
    </div>
    
    <div class="form-group">
      <label for="Speaker">Speaker</label>
      <input type="text" class="form-control" id="Speaker" placeholder="Enter Speaker" name="Speaker">
    </div>
    
    <div class="form-group">
      <label for="Date">Date</label>
      <input type="text" class="form-control" id="Date" placeholder="Enter Date" name="Date">
    </div>
    
    <div class="form-group">
      <label for="Time">Time</label>
       <input type="text" class="form-control" id="Time" placeholder="Enter Time"  name="Time">
    </div>
   
   
    <button type="submit" class="btn btn-default">Request</button>
  </form>

</div>
 
</body>
</html>