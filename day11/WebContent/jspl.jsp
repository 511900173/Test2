<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<h3>1.c:set标签</h3>
	<!-- (1)往指定的域中添加属性 -->
	<c:set scope="request" var="name" value="二狗"/>
	${ name }
	<!-- (2)修改域中的属性值 -->
	<c:set scope="request" var="name" value="大狗"/>
	${ name }
	<h3>2.c:if标签</h3>
	<!-- 实现简单的if..else语句 -->
	<c:set scope="request" var="score" value="78" />
	<c:if test="${ score>=80 }">游侠</c:if>
	<c:if test="${ score<80 and score>=60 }">贵族</c:if>
	<c:if test="${ score<60 }">狂野</c:if>
	<h3>4.c:forEach标签</h3>
	<h5>(1)遍历域中的数组或集合中的元素</h5>
	<% String[] names={"露露","龙王","狐狸","小法"}; request.setAttribute("ns", names); %>
	<c:forEach items="${ ns }" var="name"> ${ name } </c:forEach>
	<h5>(2)遍历域中的map集合中的元素</h5>
	<% Map map=new HashMap(); map.put("name", "奥巴马");map.put("age", 12);
	map.put("job", "贵族游侠"); request.setAttribute("ma", map); %>
	<c:forEach items="${ ma }" var="entry"> ${ entry.getKey() }:${ entry.getValue() } </c:forEach>
<%--<c:forEach items="${ ma }" var="entry"> ${ entry.key}:${ entry.value } </c:forEach> --%>
	<h5>(3)遍历0-100之间的整数,将是3的倍数的数值输出到浏览器中</h5>
	<c:forEach begin="0" end="100" var="num" step="1" varStatus="status"> 
	<c:if test="${ num%3==0 }">
	<c:if test="${ !status.first }">,</c:if>
	${ num }
	</c:if>
	</c:forEach>
	
	
	
</body>
</html>