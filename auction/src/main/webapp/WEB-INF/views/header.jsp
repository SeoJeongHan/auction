<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta>
<link href='/auction/styles/header.css' rel='stylesheet' type='text/css'>
</head>
<body>
		<%
			if (session.getAttribute("loginUser") == null) {
		%>
		
   		<table align="right">
      <tr>

         <td><a href="/auction/userAgree" style="text-decoration: none">회원가입</a>|
            <a href="/auction/loginPage" style="text-decoration: none">로그인</a>|
            <a href="/auction/index" style="text-decoration: none">메인화면</a></td>
      </tr>
   </table>
		<%
			} else {
		%>
		   <table align="right">
		   <tr>
		   <td>
				${loginUser.name}님|<a href="/auction/logout" style="text-decoration: none">로그아웃</a>|<a
            href="/auction/productReg" style="text-decoration: none">물품등록</a>|
         <a href="/auction/mypagemain" style="text-decoration: none">마이페이지</a>|<a
            href="/auction/index" style="text-decoration: none">메인화면</a>
			</td>
			</tr>
			</table>
		<%
			}
		%>
		<br>
		<br>
		<br>
		<br>
</body>
</html>