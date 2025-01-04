package com.tap.daofiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.db.MyConnection;
   
public class StudentDaoImpl implements StudentDaoInterface
{
	ArrayList<Student> studentArrayList = new ArrayList<Student>(); 

	private Connection con;
 	private Statement stmt;
 	private ResultSet resultSet;

	private PreparedStatement pstmt;

	private int status;
	private static final String FECTH_ALL="select * from `student`";
	private static final String ADDSTUDENT="INSERT INTO `student` (name, email, phone, city) VALUES(?,?,?,?);";
	private static final String FETCH_ID="select * from `student` where id=?";
	private static final String UPDATESTUDENT="UPDATE `student` SET name=?, phone=?, city=? where id=?";
	private static final String DELETESTUDENT="DELETE from `student` where id=?";
	
	
	public StudentDaoImpl()
	{
		try {
			con = MyConnection.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Student> getAllUser()
	{
		try 
		{
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(FECTH_ALL);
			
			return extractionStudentArrayList(resultSet);
		}
		catch (SQLException e) {
 			e.printStackTrace();
		}
 		return null;
	}
	
	public ArrayList<Student> extractionStudentArrayList(ResultSet resultSet)
	{
		try 
		{
			while(resultSet.next() == true)
			{
				studentArrayList.add(new Student(resultSet.getInt("id"),
												 resultSet.getString("name"),
												 resultSet.getString("email"),
												 resultSet.getString("phone"),
												 resultSet.getString("city")
												 ));
			}
		}
		catch (SQLException e) {
 			e.printStackTrace();
		}
 		return studentArrayList;		
	}

	@Override 
	public int insertStudent(Student s)
	{
		 try 
		 {
			pstmt = con.prepareStatement(ADDSTUDENT);
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getEmail());
			pstmt.setString(3, s.getPhone());
			pstmt.setString(4, s.getCity());
			 
			status = pstmt.executeUpdate();
			 
			
		 } 
		 catch (SQLException e)
		 {
			e.printStackTrace();
		 }
		 return status;
	}

	@Override
	public Student fetchId(int id)
	{
		try 
		{
			pstmt = con.prepareStatement(FETCH_ID);
 			pstmt.setInt(1, id);
 			resultSet = pstmt.executeQuery();
 			
 			studentArrayList = extractionStudentArrayList(resultSet);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return studentArrayList.get(0);
	
	}

	@Override
	public int update(Student s)
	{
		try 
		{
			pstmt = con.prepareStatement(UPDATESTUDENT);
 			pstmt.setString(1, s.getName());
 			pstmt.setString(2, s.getPhone());
 			pstmt.setString(3, s.getCity());
 			pstmt.setInt(4, s.getId());
 			status = pstmt.executeUpdate();
 			
 			 
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int delete(int id)
	{
		try 
		{
			pstmt = con.prepareStatement(DELETESTUDENT);
  			pstmt.setInt(1, id);
 			status = pstmt.executeUpdate();
 			
 			 
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return status;
	}
}
