package com.student.project.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.project.dao.StudentDao;
import com.student.project.dao.StudentDaoImpl;
import com.student.project.model.Student;

public class StudentUpdateServlet  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	StudentDao studentDao = new StudentDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id =Integer.parseInt(req.getParameter("id")) ;
		String name = req.getParameter("name");
		int age =Integer.parseInt(req.getParameter("age")) ;
		String rollNo = req.getParameter("rollNo");
		
		studentDao.updateStudent(id,name,age,rollNo);
		
		List<Student> studentList = studentDao.getAllStudent();
    	req.setAttribute("students", studentList );
        RequestDispatcher rd=req.getRequestDispatcher("listStudent.jsp");  
        rd.forward(req,resp);  
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		Student student = studentDao.getStudentById(id);
		request.setAttribute("student", student );
        RequestDispatcher rd=request.getRequestDispatcher("studentDetail.jsp"); 
        rd.forward(request,response);  
	}
	
	

}
