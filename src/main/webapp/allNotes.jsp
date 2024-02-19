<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.hibernate.Session" %>
<%@page import="org.hibernate.Query" %>
<%@page import="com.entities.Note" %>
<%@page import="com.helper.FactoryProvider" %>
<%@page import="java.util.*" %>
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
      <h3 class="text-center">All NOTES</h3>
      <% 
      Session s=FactoryProvider.getFactory().openSession();
      Query q=s.createQuery("from Note");
      List<Note> list=q.list();
      if(list.size()==0){
       %>
        <a href="addNote.jsp" class="text-center">Add notes</a>
      <%}
      else{
      for(Note note:list){
      %>
      <div class="d-flex justify-content-center align-items-center">
      <div class="card w-50 mt-5">
		  <div class="card-header text-center">
		     <b><%=note.getTitle()%></b>
		  </div>
		  <div class="card-body">
		    <p class="card-text"><%=note.getContent() %></p>
		  </div>
		  <div class="card-footer text-body-secondary">
		   <cite><%=note.getAddedOn().toLocaleString() %></cite>
		   <a href="deleteservlet?note_id=<%=note.getId() %>" style="color:red;margin-left:50%;"><i class="bi bi-trash3-fill fs-5"></i></a>
		   <a href="edit.jsp?note_id=<%=note.getId() %>" ><i class="bi bi-pencil-fill fs-5"></i></a>
		  </div>
	</div>
      </div>
      <%
      }
      }
      s.close();
      %>

</body>
</html>