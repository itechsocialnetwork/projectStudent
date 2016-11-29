package com.student.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student.project.dao.StudentDao;
import com.student.project.dao.StudentDaoImpl;
import com.student.project.model.Student;

public class StudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	StudentDao studentDao = new StudentDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
	        PrintWriter out = response.getWriter();  
	        int id=Integer.parseInt(request.getParameter("id")); 
	        String name=request.getParameter("name");  
	        String password=request.getParameter("password"); 
	        int age=Integer.parseInt(request.getParameter("age")); 
	        String rollNo=request.getParameter("rollNo"); 
	        
	        
	        Student student = new Student(id,name, rollNo, password, age);
	        studentDao.addStudent(student);
	        List<Student> studentList = studentDao.getAllStudent();
        	request.setAttribute("students", studentList );
            RequestDispatcher rd=request.getRequestDispatcher("listStudent.jsp");  
            rd.forward(request,response);  
	        HttpSession session = request.getSession(false);
	}
	
	
	

}
