package com.tap.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyConnection 
{
	private static String url = "jdbc:mysql://localhost:3306/university";
	private static String user = "root";
	private static String password = "root";
	
	private static Connection con=null;;

	public static Connection connect()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public static void disConnect(Connection con , PreparedStatement pstmt)  
	{
		 
		if(pstmt != null)
		{
			try 
			{
				pstmt.close();
				System.out.println("Prepared Statement Closed");

			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		 
		if (con != null)
		{
			try 
			{
				con.close();
				System.out.println("Connection Closed");
				
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
		}
		   
	}
}

