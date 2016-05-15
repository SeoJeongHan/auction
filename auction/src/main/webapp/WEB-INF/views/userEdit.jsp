<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta>
<title>회원정보수정</title>
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Gafata|Nobile:400,700'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Roboto:400,300'
	rel='stylesheet' type='text/css'>
<link href='styles/style.css' rel='stylesheet' type='text/css'>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="wrapper">
		<div id="box">
			<div id="top_header">
				<h6>회원정보수정</h6>
				<h5>보유포인트 : ${loginUser.point}</h5>
				<h5>${updateMsg}</h5>
			</div>
			<div id="inputs">
				<form:form action="userEditProc" method="post" modelAttribute="user">
					<form:input path="id" readonly="true" />
					<br>
					<form:password path="password" required="required" />
					<br>
					<form:input path="name" readonly="true" />
					<br>
					<form:input path="gender" readonly="true" />
					<br>
					<fieldset>
						<legend>수정 목록</legend>
						<br>
						<form:input path="address" required="required" />
						<br>
						<form:input path="phone" required="required"
							placeholder="010-0000-0000" />
						<br>
						<form:input path="email" required="required"
							placeholder="example@ex.com" />
						<br>
					</fieldset>
					<button type="submit">정보수정</button>
				</form:form>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>