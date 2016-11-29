<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Application</title>

<script>
function validateForm() {
    var x = document.forms["loginform"]["username"].value;
    var y = document.forms["loginform"]["userpass"].value;
    if (x == "") {
        alert("Name must be filled out");
        return false;
    }

    if (y == "") {
        alert("password must be filled out");
        return false;
    }
}
</script>
</head>
<body>
    <form name="loginform" action="loginServlet"
onsubmit="return validateForm()" method="post">
        <fieldset style="width: 300px">
            <legend> Login to Student portal </legend>
            <table>
                <tr>
                    <td>User ID</td>
                    <td><input type="text" name="username" required="required" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="userpass" required="required" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login" /></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>