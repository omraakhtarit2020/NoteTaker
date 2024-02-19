package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

public class deleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public deleteservlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int noteId = Integer.parseInt(req.getParameter("note_id").trim());
			System.out.print(noteId);

			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			Note n = s.get(Note.class, noteId);
			s.delete(n);
			tx.commit();
			s.close();

			resp.sendRedirect("allNotes.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
