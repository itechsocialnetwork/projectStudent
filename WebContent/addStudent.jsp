<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<title>Add New Student</title>

<script>
function validateForm() {
    var x = document.forms["addStudentForm"]["name"].value;
    var y = document.forms["addStudentForm"]["password"].value;
    var z = document.forms["addStudentForm"]["age"].value;
    var r = document.forms["addStudentForm"]["rollNo"].value;
    if (x == "") {
        alert("Name must be filled out");
        return false;
    }

    if (y == "") {
        alert("password must be filled out");
        return false;
    }

    if (z == "") {
        alert("Age must be filled out");
        return false;
    }

    if (r == "") {
        alert("rollNo must be filled out");
        return false;
    }

    if (isNaN(z)){  
    	alert("Age  must be in number");
    	  return false;  
    }
}
</script>

</head>
<body>
    <form name="addStudentForm" action="studentServlet" onsubmit="return validateForm()" method="post">
    Student Id &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="id"><br><br>
       Student Name <input type="text" name="name"><br><br>
       Password &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="password" name="password"><br><br><br>
       Roll No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<input type="text" name="rollNo"><br><br><br>
       Age &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;  <input type="text" name="age"><br><br><br>
       <input type="submit" value="add" >
       
    </form>
</body>
</html>