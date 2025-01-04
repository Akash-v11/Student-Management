package com.tap.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daofiles.Student;
import com.tap.daofiles.StudentDaoImpl;



@WebServlet("/FecthOne")
public class FecthOne extends HttpServlet
{ 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int id = Integer.parseInt(req.getParameter("sid"));
		
		StudentDaoImpl sdaoi = new StudentDaoImpl();
		Student student = sdaoi.fetchId(id);
		
		req.getSession().setAttribute("student", student);
		resp.sendRedirect("editStudent.jsp");
		
		
	}
}
