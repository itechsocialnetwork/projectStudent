   <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Students</title>

<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>

</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Student ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Course</th>
                <th>Year</th>
           <!--      <th colspan="2">Action</th> -->
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td><c:out value="${student.id}" /></td>
                    <td><c:out value="${student.name}" /></td>
                    <td><c:out value="${student.rollNo}" /></td>
                    <td><c:out value="${student.password}" /></td>
                    <td><c:out value="${student.age}" /></td>
                   <%--  <td><a
                        href="StudentController.do?action=edit&studentId=<c:out value="${student.studentId }"/>">Update</a></td>
                    <td><a
                        href="StudentController.do?action=delete&studentId=<c:out value="${student.studentId }"/>">Delete</a></td> --%>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br><br>
        <a href="addStudent.jsp">Add Student</a><br><br>
   
        <a href="updateStudent.jsp">Update Student</a><br><br>
    
        <a href="deleteStudent.jsp">Delete Student</a>
</body>
</html>