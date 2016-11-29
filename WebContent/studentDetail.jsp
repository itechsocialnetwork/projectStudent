<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Detail</title>

<script>
function validateForm() {
    var x = document.forms["updateStudentForm"]["name"].value;
    var y = document.forms["updateStudentForm"]["password"].value;
    var z = document.forms["updateStudentForm"]["age"].value;
    var r = document.forms["updateStudentForm"]["rollNo"].value;
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
<form name="updateStudentForm"  action="studentUpdate"    onsubmit="return validateForm()"   method="get">
Student ID : <input type="text" readonly="readonly" name="id"
            value="${student.id}" />  <br /> <br><br>
         Name : <input
            type="text" name="name"
            value="${student.name}" /> <br /> <br><br>
        Roll No : <input
            type="text" name="rollNo"
            value="${student.rollNo}" />  <br />  <br><br>
        Age : <input
            type="text" name="age"
            value="${student.age}" />  <br />  <br><br>
        <br />
             <input
            type="submit" value="update" /> <br><br>

</form>
</body>
</html>