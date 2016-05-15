<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='/auction/styles/ribbon.css' rel='stylesheet' type='text/css'>
<link href='/auction/styles/table.css' rel='stylesheet' type='text/css'>
<title>구매자/판매자 정보조회</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class='ribbon orange'></div>
	<div class='ribbon navy'></div>
	&nbsp;&nbsp;&nbsp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
	&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
	&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
	&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp; &ensp;&ensp;
	<font size="10">구매자 / 판매자 조회</font>
	<hr>
	<br>
	<br>
	<br>
	<section class="container">
		<table class="order-table">
			<caption><font size="5">${user.id} 님 정보 조회</font></caption>
			
			<tr>
				<th>ID</th>
				<th>이름</th>
				<th>주소</th>
				<th>전화번호</th>
				<th>E-mail</th>
			</tr>
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.address}</td>
				<td>${user.phone}</td>
				<td>${user.email}</td>
			</tr>
		</table>
	</section>
	<%@ include file="footer.jsp"%>
</body>
</html>