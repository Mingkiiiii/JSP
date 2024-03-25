<%@page import="org.apache.jasper.tagplugins.jstl.core.Catch"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
	String dbUser = "java";
	String dbPass = "oracle";
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	try{
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
		stmt = conn.createStatement();
		
		String query = "SELECT * FROM member";
		rs= stmt.executeQuery(query);
		while(rs.next()){
			out.println(rs.getString("mem_name") + "<br>");
		}
	}catch(Exception e){
		out.println("Error");
	}finally{
		if(rs != null) try{ rs.close();}catch(SQLException e){}
		if(stmt != null) try{ rs.close();}catch(SQLException e){}
		if(conn != null) try{ rs.close();}catch(SQLException e){}
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