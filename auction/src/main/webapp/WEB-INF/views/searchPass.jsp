<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 찾기</title>
<link href='styles/style.css' rel='stylesheet' type='text/css'>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="wrapper">
		<div id="box">
			<div id="top_header">
				<h6>비밀번호 찾기</h6>
				<h5>비밀번호 찾기(아이디 / 이름 / 전화번호)</h5>
				<h3>${pass}</h3>
			</div>
			<div id="inputs">
				<form id='searchPass' action='searchPassProc' method='post'
					style="margin-left: 6px;">
					<input type='hidden' name='submitted' id='submitted' value='1' />
					<div class='container'>
						<input type='text' name='id' id='id' required="required"
							maxlength="50" size="30" placeholder="아이디 " /><br />
					</div>
					<div class='container'>
						<input type='text' name='name' id='name' required="required"
							maxlength="50" size="30" placeholder="이름" /><br />
					</div>
					<div class='container'>
						<input type='text' name='phone' id='phone' required="required"
							maxlength="50" size="30" placeholder="전화번호 예)010-0000-0000 " /><br />
					</div>
					<div class='container'>
						<input type='submit' name='Submit' value='비밀번호 찾기' />
					</div>
				</form>

			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>