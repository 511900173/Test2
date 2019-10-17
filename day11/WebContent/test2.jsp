<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1><%= request.getAttribute("name") %></h1>
	<h1><%= request.getAttribute("age") %></h1>
	<h1>${ mm.name }</h1>
	<h1>${ mm.age }</h1>
</body>
</html>