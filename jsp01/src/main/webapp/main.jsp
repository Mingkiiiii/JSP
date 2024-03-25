<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		int userNum = 0;
		String num = request.getParameter("num");
		if(num != null && !num.equals("")){
			userNum = Integer.parseInt(num);
		}
	%>
	<% if(userNum %2 !=0){ %>
			<h1>홀수 입니다.</h1>
	<% }else{ %>
			<h1>짝수 입니다.</h1>
	<%  } %>
</body>
</html>