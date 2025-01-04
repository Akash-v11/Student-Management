package com.tap.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.tap.daofiles.Student;
import com.tap.daofiles.StudentDaoImpl;
 
public class FetchAll extends HttpServlet 
{
	private List<Student> studentList;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		StudentDaoImpl sdaoi = new StudentDaoImpl();
		
		 studentList = sdaoi.getAllUser();
		 
		 req.getSession().setAttribute("studentList", studentList);
		 
		 resp.sendRedirect("home.jsp");
	}
} 
 