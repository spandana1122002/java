<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> All events</h1>
<table border ="5" cellpadding="10" cellspacing="10" style="border-collapse: collapse; margine:auto">
      <tr>
      <th>Id</th>
      <th>Title</th>
      <th>Location</th>
      <th>Date</th>
      <th>Chief Guest</th>
      <th colspan ="2">  Action</th>
       </tr>
       
       
       <%
          ResultSet rs= (ResultSet) request.getAttribute("rs");
          while(rs.next()){
       
       %>
       
       <tr>
         <td><%= rs.getInt(1)%></td>
         <td><%= rs.getString(2)%></td>
         <td><%= rs.getString(3)%></td>
         <td><%= rs.getString(4)%></td>
         <td><%= rs.getString(5)%></td>
         <td><a href ="delete?id=<%= rs.getInt(1)%>"> <button>Delete</button></a></td>
         <td><a href="updatepage?id=<%=rs.getInt(1)%>"><button>Update</button></a></td>
         
       </tr>
       
       <%
          }
       %>
</table>

</body>
</html>