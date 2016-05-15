<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href='styles/style.css' rel='stylesheet' type='text/css'>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="wrapper">
		<div id="box">
			<div id="top_header">
				<h6>회원가입</h6>
			</div>
			<div id="inputs">

				<div class='container'>

					<form action="/auction/idCheck" method="post"
						style="margin-left: 6px;">


						<input type="text" name="id" required="required" maxlength="8"
							size="30" placeholder="아이디(8자)" value="${id}" style = "ime-mode:disabled;"/>
							<input type="submit" name="Submit" value="아이디 중복확인(필수)" /> <br>${regMsg}
					</form>
				</div>


				<form:form action="/auction/userReg" method="post" modelAttribute="user" style="margin-left:6px;">
				
	
						<form:hidden path="id" value="${id}"/>
					<div class='container'>

						<form:password path="password" required="required" maxlength="8"
							size="30" placeholder="비밀번호(8자)"/>
					</div>
					<div class="container">
						<form:password path="passwordChk" required="required"
							maxlength="8" size="30" placeholder="비밀번호 확인"/>
					</div>
					<div class='container'>
						<form:input type="text" path="name" required="required"
							maxlength="8" size="30" placeholder="이름"/>
					</div>
					<div class='container'>
						<form:input type="text" path="address" required="required"
							maxlength="50" size="30" placeholder="주소" />
					</div>
					<div class='container'>
						<form:input type="text" path="phone" required="required"
							maxlength="13" size="30" placeholder="전화번호"/>
					</div>
					<div class='container'>
						<form:input type="email" path="email" required="required"
							maxlength="50" size="30" placeholder="E-mail" />
					</div>
					<div>
						<div id="ck-button">
							<label> <form:radiobutton path="gender" id="ss2"
									value="남" checked="true"/><span>남</span>
							</label>
						</div>
						<div id="ck-button">
							<label> <form:radiobutton path="gender" id="ss2"
									value="여" /><span>여</span>
							</label>
						</div>
					</div>
					<div class='container'>
						<input type='submit' name='Submit' value='가입하기' />
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>