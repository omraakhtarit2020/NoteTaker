package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

public class editservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public editservlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int id = Integer.parseInt(request.getParameter("note_id"));

			Session s = FactoryProvider.getFactory().openSession();
			Transaction t = s.beginTransaction();
			Note note = s.get(Note.class, id);

			note.setTitle(title);
			note.setContent(content);
			note.setAddedOn(new Date());

			t.commit();

			s.close();

			response.sendRedirect("allNotes.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
