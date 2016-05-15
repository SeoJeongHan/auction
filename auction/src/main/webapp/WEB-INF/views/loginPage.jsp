<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
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
				<h6>로그인</h6>
				<h5>아이디 / 비밀번호 입력 ${fail}</h5>
			</div>
			<div id="inputs">
				<form id='login' action='loginProc' method='post'
					accept-charset='UTF-8' style="margin-left: 6px;">
					<input type='hidden' name='submitted' id='submitted' value='1' />
					<div class='container'>
						<input type='text' name='id' id='id' required="required"
							maxlength="50" size="30" placeholder="아이디" /><br />
					</div>
					<div class='container'>
						<input type='password' name='password' required="required"
							id='password' maxlength="50" size="30" placeholder="비밀번호" /><br />
					</div>
					<div class='container'>
						<input type='submit' name='Submit' value='로그인' />
					</div>
				</form>
				<div id="bottom">
					<a class="search" href="/auction/searchPass">비밀번호 찾기</a><br>

				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>