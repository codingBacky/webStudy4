<%@page import="webStudy09.MemberDAO"%>
<%@page import="java.lang.reflect.Member"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>db연동</h3>
<%
MemberDAO memDao = MemberDAO.getInstance();
Connection con = memDao.getConnection();
System.out.println("con :" + con);
%>
</body>
</html>