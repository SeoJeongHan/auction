<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
     <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
  
<!DOCTYPE html>
<html>
<head>
<meta>
<title>회원가입이 완료되었습니다.</title>
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Gafata|Nobile:400,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Roboto:400,300' rel='stylesheet' type='text/css'>
<link href='styles/style.css' rel='stylesheet' type='text/css'>
</head>
<body>
<%@ include file="header.jsp" %>
	<div id="top_header">
		<h6> 환영합니다!
	 	${userEntity.name}님 </h6>
	 	<h5>회원가입이 완료되었습니다.</h5>
	 </div>

<%@ include file="footer.jsp" %>
</body>
</html>