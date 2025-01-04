 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tap.daofiles.Student"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Management</title>
<style>
    /* General Reset */
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    body {
        font-family: 'Arial', sans-serif;
        background-color: #f9f9f9;
        color: #333;
    }

    /* Header */
    header {
        background-color: #007bff;
        padding: 15px 30px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        color: white;
    }
 

    header .logo {
        font-size: 24px;
        font-weight: bold;
    }

    header nav a {
        color: white;
        text-decoration: none;
        margin: 0 15px;
        font-size: 16px;
    }

    header nav a:hover {
        text-decoration: underline;
    }

    /* Hero Section */
    .hero {
        background-color: #ffe8d6;
        padding: 50px 30px;
        text-align: center;
    }

    .hero h1 {
        font-size: 36px;
        color: #fc8019;
    }

    .hero p {
        font-size: 18px;
        color: #333;
        margin: 15px 0;
    }

    .hero .cta-button {
        background-color: #007bff;
        color: white;
        padding: 12px 20px;
        text-decoration: none;
        border-radius: 5px;
        font-size: 16px;
        display: inline-block;
        margin-top: 20px;
    }

    .hero .cta-button:hover {
        background-color: #e56c00;
    }

    /* Grid Section */
    .container {
        max-width: 1200px;
        margin: 20px auto;
        padding: 0 20px;
    }

    .grid {
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
        justify-content: center;
    }

    .card {
        background: white;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 300px;
        text-align: center;
        padding: 20px;
        transition: transform 0.3s, box-shadow 0.3s;
    }

    .card:hover {
        transform: translateY(-5px);
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
    }

    .card h3 {
        margin: 10px 0;
        font-size: 22px;
    }

    .card p {
        color: #666;
        font-size: 14px;
        margin: 5px 0;
    }

   
		.card .actions button {
		    background-color: #007bff; /* Default blue color */
		    color: white;
		    border: none;
		    padding: 10px 18px;
		    border-radius: 4px;
		    font-size: 16px;
		    cursor: pointer;
		    transition: all 0.3s ease;
		    margin: 5px;
		    text-align: center; /* Ensure the text is centered */
		    display: inline-block; /* Prevent issues with block-level behavior */
		    line-height: 1.2; /* Prevents vertical alignment issues */
		}
		
		/* Hover effect for buttons */
		.card .actions button:hover {
		    background-color: #ff5722; /* Orange color on hover */
		    box-shadow: 0 4px 8px rgba(255, 87, 34, 0.2); /* Subtle shadow for hover effect */
		}


    /* Footer */
    footer {
        background-color: #333;
        color: white;
        text-align: center;
        padding: 20px 0;
        margin-top: 20px;
    }

    footer p {
        font-size: 14px;
        margin: 0;
    }
</style>
</head>
<body>

<header>
    <div class="logo">Student Manager</div>
    <nav>
        <a href="home.jsp">Home</a>
        <a href="addstudent.jsp">Add Student</a>
        <a href="about.jsp">About</a>
    </nav>
</header>

<section class="hero">
    <h1>Welcome to Student Management</h1>
    <p>Effortlessly manage student information and keep track of updates with ease.</p>
    <a href="addstudent.jsp" class="cta-button">Add New Student</a>
</section>

<div class="container">
    <div class="grid">
        <% 
        ArrayList<Student> sList = (ArrayList<Student>) session.getAttribute("studentList");
        for (Student stud : sList) { 
        %>
            <div class="card">
                <h3><%= stud.getName() %></h3>
                <p><strong>ID:</strong> <%= stud.getId() %></p>
                <p><strong>Email:</strong> <%= stud.getEmail() %></p>
                <p><strong>Phone:</strong> <%= stud.getPhone() %></p>
                <p><strong>City:</strong> <%= stud.getCity() %></p>
                
	                <div class="actions">
					    <a href="FecthOne?sid=<%= stud.getId() %>"> <button>Edit</button></a> 
					    <a href="DeleteStudent?studentId=<%= stud.getId() %>"> <button>Delete</button></a>
					</div>
            </div>
        <% 
        } 
        %>
    </div>
</div>

<footer>
    <p>&copy; 2024 Student Manager. Designed with ❤️ for students.</p>
</footer>

</body>
</html>
 