package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

public class noteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public noteservlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int id = new Random().nextInt(1000);
			Note note = new Note(id, title, content, new Date());

			Session s = FactoryProvider.getFactory().openSession();
			Transaction t = s.beginTransaction();

			s.save(note);
			t.commit();

			s.close();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h1 style='text-center'>Note Added successfully</h1>");
			out.println("<a style='text-center' href='allNotes.jsp'>View all notes</a>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
