package com.student.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.project.model.Student;
import com.student.project.util.DButil;

public class StudentDaoImpl implements StudentDao {

	private Connection connection;
	 ResultSet rs = null;
	 PreparedStatement  pst = null;
	 
	 
	 
	
	public StudentDaoImpl() {
		super();
		
		connection = DButil.getConnection();
	}

	@Override
	public int addStudent(Student student) {
		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into student(name,password,rollNo,age,id) values (?, ?, ?, ?,? )");
            // Parameters start with 1
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getPassword());
            preparedStatement.setString(3, student.getRollNo());
            preparedStatement.setInt(4, student.getAge());
            preparedStatement.setInt(5, student.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}

	@Override
	public int deleteStudent(int id) {
		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from  student where id = ?");
            // Parameters start with 1
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}

	

	@Override
	public List<Student> getAllStudent() {
		List<Student> studentList = new ArrayList<>();
		Statement statement;
		try {
			statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("select * from student");
	        while (rs.next()) {
	            Student student = new Student();
	            student.setId(rs.getInt("id"));
	            student.setName(rs.getString("name"));
	            student.setPassword(rs.getString("password"));
	            student.setAge(rs.getInt("age"));
	            studentList.add(student);
	            
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return studentList;
	}

	@Override
	public Student getStudentById(int id) {
		Student student = new Student();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from student where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	student.setId(rs.getInt("id"));
            	student.setName(rs.getString("name"));
            	student.setRollNo(rs.getString("rollNo"));
            	student.setAge(rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
	}

	@Override
	public void updateStudent(int id, String name, int age, String rollNo) {
		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update student  set name = ?,age=?,rollNo=? where id = ?");
            // Parameters start with 1
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, rollNo);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
	}

}
