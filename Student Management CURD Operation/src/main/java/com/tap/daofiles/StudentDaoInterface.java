package com.tap.daofiles;

import java.util.List;
 
public interface StudentDaoInterface 
{
	 List<Student> getAllUser();
	 int insertStudent(Student s);
	 Student fetchId(int id);
	 int update(Student s);
	 int delete(int id);
	 
	 
}
  