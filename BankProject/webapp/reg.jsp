<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body><center>
<fieldset>
   <form action="hi" method="post">
    <label>Name:<input type="text" name="uname"></label>
    <label>Phone No:<input type="tel" name="phne"></label>
    <label>Account Type:<input type="text" name="accType">(Savings/Salary)</label>
    <button type="reset">Reset</button>
    <button type="submit">Submit</button>
   </form>
</fieldset>
</body>
</html>
<style>
fieldset{
display:flex;
align-items: center;
}
</style>