<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 디렉티브 page -->
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 선언부 -->
	<%!
		public int multiply(int x, int y){
			return x * y;
	}
	%>
<!-- 선언부 -->
<!-- 스크립트릿 : 기본 자바코드 블럭 -->
	<%
		Date today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = format.format(today);
		int result = multiply(2, 10);
	%>
</head>
<body>
<!-- 표현식 : 값을 화면에 출력 -->
	<h1> 오늘의 날짜는 : <%=dateStr %></h1>
	<h1> 2 * 10은 : <%=result %> 입니다.</h1>
</body>
</html>