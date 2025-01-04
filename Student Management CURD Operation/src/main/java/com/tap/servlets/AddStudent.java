package com.tap.servlets;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daofiles.Student;
import com.tap.daofiles.StudentDaoImpl;
import com.tap.db.Security;

 
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
  		Student s = new Student(req.getParameter("name"),
  			/*Security.encrypt*/req.getParameter("email") ,
								req.getParameter("phone"),
								req.getParameter("city")) ;
		
		StudentDaoImpl sdaoi = new StudentDaoImpl();
		int status = sdaoi.insertStudent(s);
		
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


