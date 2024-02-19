<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_css_js.jsp" %>
</head>
<body>

<div class="container">
    
      <%@include file="nav.jsp" %>
    <h3 class="text-center">Add your note!</h3>
  <form action="./noteservlet" method="post">
  <div class="mb-3">
    <label for="title" class="form-label">TITLE</label>
    <input type="text" class="form-control" name="title" required>
  </div>
  <div class="mb-3">
    <label for="content" class="form-label">ADD CONTENT</label>
    <textarea type="text" class="form-control" name="content" style="min-height:300px;" required></textarea>
  </div>
  <button type="submit" class="btn btn-primary">ADD</button>
</form>
      
    
    </div>
    

</body>
</html>