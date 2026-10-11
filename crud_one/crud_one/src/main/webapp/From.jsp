<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/student" method="post">
<h1>Student form</h1>
<label>Enter ur EC number:</label>
<br>
<input type="number" name="ec_no">
<br>
<label>Enter ur Name:</label>
<br>
<input type="text" name="s_name">
<br>
<label>Enter ur Feedback:</label>
<br>
<input type="text" name="feedback" >
<br>
<Button type="submit">Submit</Button>
</form>
</body>
</html>