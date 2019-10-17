<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{background:url(317921.jpg) no-repeat top}
</style>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<!-- 	2、练习c:set标签的使用：
	(1)往request域中添加一个域属性为:str，值为:"Hello !"，并通过EL取出显示在JSP中
	(2)修改request域中str属性, 将值改为:"Hello JSTL !"，并通过EL取出显示在JSP中 -->
	<%-- <% String str="HelloKitty"; request.setAttribute("ss", str); %>
	${ ss } --%>
	<c:set scope="request" var="str" value="hello" />
	<h1>${ str }</h1>
	<c:set scope="request" var="str" value="HelloKitty" />
	<h1>${ str }</h1>
<!-- 	(1)将下列数组存入request域中，通过EL+cforEach标签取出数据遍历输出到浏览器上
		数组声明如下：
		String names = {"张三", "李四", "王五", "赵四", "刘能"}; -->
	<% String[] names={"露露","小法","狐狸","龙王"}; request.setAttribute("ll", names); %>
	<c:forEach items="${ ll }" var="name">${ name }</c:forEach>
	</br>
	<!-- 将下列Map集合存入request域中，通过EL+cforEach标签取出map集合遍历输出到浏览器上
		Map集合声明如下:
		Map map = new HashMap();
		map.put("name", "张三");
		map.put("age", "38");
		map.put("addr", "北京");
		map.put("job", "Java高级工程师"); -->
	<% Map map = new HashMap();map.put("name", "奥巴马");
	map.put("age", "33"); map.put("addr", "召唤师峡谷");map.put("位置", "adc"); 
	request.setAttribute("mm", map); %>
	<c:forEach items="${ mm }" var="mm1">${ mm1 }</c:forEach></br>
	<!-- (3)遍历0~300之间的偶数，将是7的倍数的数值输出到浏览器上	 -->
	<c:forEach begin="0" end="300" var="i" step="1">
	<c:if test="${ i%7==0 }">${ i }</c:if>
	</c:forEach>
	
</body>
</html>













