<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{background:url(a.jpg) repeat left top;}
h2{border:2px solid red ;background pink;}
</style>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>index.jsp</h1>
	<h2><%= request.getAttribute("name") %></h2>
	<h2><%= request.getAttribute("addr") %></h2>
</body>
</html>