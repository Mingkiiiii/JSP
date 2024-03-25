<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="jdbc.userVO"%>
<%@page import="jdbc.UserService" %>
<% request.setCharacterEncoding("UTF-8"); %>

<% 
	userVO vo = new userVO();
	vo.setUserId(request.getParameter("userId"));
	vo.setUserNm(request.getParameter("userNm"));
	
	UserService service = UserService.getInstance();
	service.updateUser(vo);
	
	out.println("<script>");
	out.println("alert('수정되었습니다.'); location.href='mypage.jsp'; ");
	out.println("</script>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>