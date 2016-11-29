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

import com.student.project.dao.LoginDao;
import com.student.project.dao.LoginDaoImpl;
import com.student.project.dao.StudentDao;
import com.student.project.dao.StudentDaoImpl;
import com.student.project.model.Student;

public class LoginServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;
    
    StudentDao studentDao = new StudentDaoImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        String n=request.getParameter("username");  
        String p=request.getParameter("userpass"); 
        
        HttpSession session = request.getSession(false);
        if(session!=null)
        session.setAttribute("name", n);

        LoginDao loginDao = new LoginDaoImpl();
        if(loginDao.validate(n, p)){  
        	List<Student> studentList = studentDao.getAllStudent();
        	request.setAttribute("students", studentList );
            RequestDispatcher rd=request.getRequestDispatcher("listStudent.jsp");  
            rd.forward(request,response);  
        }  
        else{  
            out.print("<p style=\"color:red\">Sorry username or password error</p>");  
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
            rd.include(request,response);  
        }  

        out.close();  
    }  
} 
