<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>

<%
	String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
	String dbUser = "java";
	String dbPass = "oracle";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String userId = request.getParameter("userId");  // "userId"로 수정
	System.out.println(userId);
	try{
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
		String query = "SELECT * FROM member WHERE mem_id=?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, userId);
		rs = pstmt.executeQuery();

		while(rs.next()){
			out.println(rs.getString("mem_name") + "<br>");
			out.println(rs.getString("mem_mail") + "<br>");
		}
	}catch(Exception e){
		out.println("Error");
	}finally{
		if(rs != null) try{ rs.close();}catch(SQLException e){}
		if(pstmt != null) try{ pstmt.close();}catch(SQLException e){}
		if(conn != null) try{ conn.close();}catch(SQLException e){}
	}
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
