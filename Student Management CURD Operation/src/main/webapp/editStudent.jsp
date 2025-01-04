<%@page import="com.tap.daofiles.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Student</title>
    <style>
        body {
            font-family: 'Roboto', Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 30px;
            width: 100%;
            max-width: 450px;
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333333;
            font-weight: 600;
        }

        .form-container label {
            display: block;
            margin-bottom: 8px;
            font-size: 14px;
            color: #555555;
            font-weight: bold;
        }

        .form-container input {
            width: 100%;
            padding: 10px 15px;
            margin-bottom: 20px;
            border: 1px solid #cccccc;
            border-radius: 5px;
            font-size: 14px;
            color: #333333;
        }

        .form-container input:focus {
            outline: none;
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
        }

        .form-container input[readonly] {
            background-color: #f1f1f1;
            color: #999999;
            cursor: not-allowed;
        }

        .form-container input[type="submit"] {
            background-color: #007bff;
            color: #ffffff;
            border: none;
            cursor: pointer;
            font-size: 16px;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        .form-container input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .form-container input[type="submit"]:active {
            background-color: #004494;
        }

        .form-container .form-footer {
            text-align: center;
            font-size: 12px;
            color: #666666;
            margin-top: 15px;
        }

        .form-container .form-footer a {
            color: #007bff;
            text-decoration: none;
        }

        .form-container .form-footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <% Student student = (Student) session.getAttribute("student"); %>

    <div class="form-container">
        <h2>Edit Student Details</h2>
        <form action="UpdateStudent" method="POST"> 
            <label for="id">Student ID:</label>
            <input type="text" name="id" id="id" value="<%= student.getId() %>" readonly>

            <label for="name">Full Name:</label>
            <input type="text" name="name" id="name" value="<%= student.getName() %>" required placeholder="Enter full name">

            <label for="phone">Phone Number:</label>
            <input type="tel" name="phone" id="phone" maxlength="10" pattern="\d{10}" 
                   title="Enter a valid 10-digit phone number" value="<%= student.getPhone() %>" required>

            <label for="email">Email Address:</label>
            <input type="email" name="email" id="email" value="<%= student.getEmail() %>" disabled>

            <label for="city">City:</label>
            <input type="text" name="city" id="city" value="<%= student.getCity() %>" required placeholder="Enter city name">

            <input type="submit" value="Update Student">
        </form>
        <div class="form-footer">
            Need help? <a href="contactSupport.jsp">Contact Support</a>
        </div>
    </div>
</body>
</html>
