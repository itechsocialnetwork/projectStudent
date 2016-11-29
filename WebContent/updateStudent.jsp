<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Student</title>
<script type="text/javascript">

function validateForm() {

	var x = document.forms["updateStudentForm"]["name"].value;
	/* if (isNaN(x)){  
    	alert("id  must be in number");
    	  return false;  
    } */

	if (x == "") {
        alert("Id must be filled out");
        return false;
    }
    
}


</script>

</head>
<body>
<form  name="updateStudentForm"     action="studentUpdate"   onsubmit="return validateForm()"  method="post">
Enter id of student for update<input type="text" name="id">
<input type="submit" value="get details">
</form>

</body>
</html>