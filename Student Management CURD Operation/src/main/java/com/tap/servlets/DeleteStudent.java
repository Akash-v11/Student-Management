package com.tap.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daofiles.Student;
import com.tap.daofiles.StudentDaoImpl;

 
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		int id = Integer.parseInt(req.getParameter("studentId"));
	 
		StudentDaoImpl sdaoi = new StudentDaoImpl();
		  int status  = sdaoi.delete(id);
		  
		  if(status != 0)
		  {
 				resp.sendRedirect("FetchAll");	
 		  }
		  else
		  {
			  resp.sendRedirect("failure.jsp");
		  }
	}
}
