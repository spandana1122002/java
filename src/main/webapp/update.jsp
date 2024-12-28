<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update page</title>
</head>
<body>
 <h1> Update page</h1>
 
     <%
          ResultSet rs= (ResultSet) request.getAttribute("rs");
          
       
       %>
 <form action ="update">
 Name: <input type ="number" name ="id" value ="<%=rs.getInt(1)  %>" readonly="readonly" placeholder ="Enter Event id"> <br><br>
    Title: <input type ="text" name ="title" value = "<%= rs.getString(2)%>" placeholder ="Enter Event title"><br><br>
    Location: <input type ="text" name ="loc" value ="<%=rs.getString(3) %>" placeholder ="Enter Event Location"><br><br>
     Date:<input type ="text" name ="date" value ="<%=rs.getString(4) %>" placeholder ="Enter Event Date"><br><br>
      Guest:<input type ="text" name ="guest" value ="<%=rs.getString(5) %>" placeholder ="Enter Event Chief Guest"><br><br>

      <button type="submit"> Submit</button>
</form>
</body>
</html>