package com.student.project.dao;

import java.util.List;

import com.student.project.model.Student;

public interface StudentDao {

	
	int addStudent(Student student);
	
	int deleteStudent(int id);
	
	void updateStudent(int id,String name,int age,String rollNo);
	
	List<Student> getAllStudent();
	
	Student getStudentById(int id);
}
