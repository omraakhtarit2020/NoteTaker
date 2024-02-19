<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.helper.*,org.hibernate.*,com.entities.*" %>
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
      <h3 class="text-center">Update your Note</h3>
      <%
        int noteId = Integer.parseInt(request.getParameter("note_id").trim());
		Session s = FactoryProvider.getFactory().openSession();
		Note note = s.get(Note.class, noteId);
      %>
      
      <form action="./editservlet" method="post">
           <input type="hidden" name="note_id" value="<%=note.getId()%>">
		  <div class="mb-3">
		    <label for="title" class="form-label">TITLE</label>
		    <input type="text" class="form-control" name="title" value="<%=note.getTitle() %>" required>
		  </div>
		  <div class="mb-3">
		    <label for="content" class="form-label">ADD CONTENT</label>
		    <textarea type="text" class="form-control" name="content" style="min-height:300px;" required><%=note.getContent() %></textarea>
		  </div>
		  <button type="submit" class="btn btn-warning">UPDATE</button>
		</form>
		      
</body>
</html>