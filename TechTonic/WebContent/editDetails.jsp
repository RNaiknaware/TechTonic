<%@page import="com.atmecs.pojo.TechTalk"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.sql.Connection,java.sql.DriverManager,java.sql.Statement,java.sql.ResultSet" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Details</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container">
  <h2>Edit TechTalk Details</h2>
  <form action="AdminController" method="get">
    <div class="form-group">
      <label for="Tid">Tid :</label>
      <input type="hidden" name="op" value="3">
      <input type="text" class="form-control" id="Tid" value="${dataObj.tid}" name="Tid">
    </div>
    <div class="form-group">
      <label for="Title">Title</label>
      <input type="text" class="form-control" id="Title" value="${dataObj.title}" name="Title">
    </div>
    
    <div class="form-group">
      <label for="Description">Description</label>
      <input type="text" class="form-control" id="Description" value="${dataObj.description}" name="Description">
    </div>
    
    <div class="form-group">
      <label for="Speaker">Speaker</label>
      <input type="text" class="form-control" id="Speaker" value="${dataObj.speaker}" name="Speaker">
    </div>
    
    <div class="form-group">
      <label for="Date">Date</label>
      <input type="text" class="form-control" id="Date" value="${dataObj.date}" name="Date">
    </div>
    
    <div class="form-group">
      <label for="Time">Time</label>
       <input type="text" class="form-control" id="Time" value="${dataObj.time}" name="Time">
    </div>
   
   
    <button type="submit" class="btn btn-default">Save</button>
  </form>

</div>
 
</body>
</html>