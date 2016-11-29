<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Student</title>
<script type="text/javascript">

function validateForm() {

	var x = document.forms["deleteStudentForm"]["name"].value;
	if (isNaN(x)){  
    	alert("id  must be in number");
    	  return false;  
    }

	if (x == "") {
        alert("Id must be filled out");
        return false;
    }
    
}


</script>


</head>
<body>
<form name="deleteStudentForm" action="studentDelete" onsubmit="return validateForm()" method="post">
Enter student id for delete <input type="text" name="id">
<input type = "submit" value="delete">
</form>
</body>
</html>