<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%--jsp注释内容 --%>
	<h1>
		二狗子<%=new Date()%></h1>
	<hr />
	诡术妖姬
	<%="诡术妖猪"%>
	<%
		int n = 100;
	%>
	<%=n%>
	<%=123 + 321%>
	<hr />

	<%
		for (int i = 0; i < 5; i++) {
			out.write("hello..<br/>");
		}
	%>
	<hr />
	<%
		for (int i = 0; i < 5; i++) {
	%>
	{诡术妖猪}
	<%
		}
	%>
	<hr />

	<%
		Map map = new HashMap();
	%>

	<hr />


	
	</body>
</html>