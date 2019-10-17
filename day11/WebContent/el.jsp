<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{background: url(317921.jpg) repeat top}
</style>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h3>(1)获取表达式,常量或变量的值(变量必须得先存入域中)</h3>
		常量:${"HelloKitty"} <br/>
		表达式:${123+100 }<br/>
		变量:
		<% String name="张无忌"; request.setAttribute("name2",name);%>
		${ name2 }
	<h3>(2)获取域中数组或集合中的元素</h3>
		<% String[] names = {"刘德华","猪八戒","张学友","范冰冰"}; request.setAttribute("ns",names); %>
		${ ns[3] }
		${ ns[2] }
		${ ns[1] }
	<h3>(3)获取域中map集合的元素</h3>
		<% Map map = new HashMap(); 
		map.put("name","买买提"); 
		map.put("age","200");
		map.put("nickname","小小提");
		request.setAttribute("map1", map); %>
		${ map1 }
		${ map1.name }
		${ map1.age }
		${ map1.nickname }
</body>
</html>










