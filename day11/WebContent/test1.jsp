<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<!-- 在test1.jsp中，通过Java代码往request域中添加两个属性，分别是：
		name：韩少云
		age：18 -->
	<% Map map=new HashMap(); map.put("name", "奥巴马");
	map.put("age", 99); request.setAttribute("mm", map); 
	request.getRequestDispatcher("/test2.jsp").forward(request, response);
	%>
	
</body>
</html>