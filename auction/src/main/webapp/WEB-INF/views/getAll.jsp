<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>세부 항목</title>
<link href='/auction/styles/ribbon.css' rel='stylesheet' type='text/css'>
<link href='/auction/styles/table.css' rel='stylesheet' type='text/css'>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class='ribbon orange'></div>
	<div class='ribbon navy'></div>
	&nbsp;&nbsp;&nbsp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
	&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
	&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
	&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp; &ensp;&ensp;
	<font size="10">전체 경매 물품</font>
	<hr>
	<br>
	<br>
	<br>
	<br>
	<br>
	<section class="container">
		<table class="order-table">
			<tr>
				<th width="5%">제목</th>
				<th width="5%">판매자</th>
				<th width="5%">모델명</th>
				<th width="5%">시작가격</th>
				<th width="5%">현재가격</th>
				<th width="5%">즉구가격</th>
				<th width="10%">경매종료시간</th>
			</tr>

		</table>
	</section>
	<div class="scrollbar3" id="style-9">
		<div class="force-overflow">
			<section class="container">
				<table class="order-table">

					<c:forEach var="product" items="${list}">
						<tr>
							<td width="5%"><a
								href="/auction/productDetail/${product.p_code}">${product.p_title}</a></td>
							<td width="5%">${product.p_s_uid}</td>
							<td width="5%">${product.p_snumber}</td>
							<td width="5%">${product.p_primary_price}</td>
							<td width="5%">${product.p_current_price}</td>
							<td width="5%">${product.p_instant_price}</td>
							<td width="10%">${product.p_date2}</td>
						</tr>
					</c:forEach>
				</table>
			</section>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<p align="center">
	<div class="button-collection">
		<button type="button" class="clean-gray"
			onclick="location='/auction/productReg'">물품 등록하기</button>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>