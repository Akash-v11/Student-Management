package com.tap.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daofiles.Student;
import com.tap.daofiles.StudentDaoImpl;

 
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("id"));
		
		Student s = new Student(id,
								req.getParameter("name"),				
								req.getParameter("email"),
								req.getParameter("phone"),
								req.getParameter("city")
								);
 
		StudentDaoImpl sdaoi = new StudentDaoImpl();
		  int status  = sdaoi.update(s);
		  
		  if(status == 1)
		  {
 				resp.sendRedirect("FetchAll");	
 		  }
		  else
		  {
			  resp.sendRedirect("failure.jsp");
		  }
	}
}
