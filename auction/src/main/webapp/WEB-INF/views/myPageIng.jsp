<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta>
<title>${loginUser.name} 님의 진행중인 경매</title>
<link rel="stylesheet" type="text/css" href="/auction/styles/sticky.css"
	media="all" />
<link href='http://fonts.googleapis.com/css?family=The+Girl+Next+Door'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<%@ include file="header.jsp"%>
	<p align="center" style="font-weight: bold;">
		<font size="5" color="black">${loginUser.name} 님의 진행중인 경매</font>
	</p>

	<div id='frame'>
		<div class="note sticky1">
			<p style="font-weight: bold;">
				<font color="black" size="5">+등록한 물품+</font>
			</p>
			<br>
			<hr>
			<div class="scrollbar1" id="style-1">
				<div class="force-overflow">
					<c:forEach var="productSellList" items="${productSellList}">
			
			<a href="/auction/productDetail/${productSellList.p_code}" style="text-decoration:none">
			<font size="4">[${productSellList.p_title}]</font></a>
						<br>
			현재입찰자 : ${productSellList.p_b_uid} <br>
			브랜드코드 : ${productSellList.p_category} <br>
			제품번호 : ${productSellList.p_snumber} <br>
			현재가격 : ${productSellList.p_current_price}원 <br>
			등록시간 : ${productSellList.p_date} <br>
			종료시간 : ${productSellList.p_date2} <br>
						<hr>
					</c:forEach>
				</div>
			</div>
		</div>

		<div class="note sticky2">
			<p style="font-weight: bold;">
				<font color="black" size="5">+입찰한 물품+</font>
			</p>
			<br>
			<hr>
			<div class="scrollbar2" id="style-2">
				<div class="force-overflow">
					<c:forEach var="productBuyList" items="${productBuyList}">
			
			<a href="/auction/productDetail/${productBuyList.p_code}" style="text-decoration:none">
			<font size="4">[${productBuyList.p_title}]</font></a>
						<br>
			판매자 : ${productBuyList.p_s_uid} <br>
			브랜드코드 : ${productBuyList.p_category} <br>
			제품번호 : ${productBuyList.p_snumber} <br>
			현재가격 : ${productBuyList.p_current_price}원<br>
			등록시간 : ${productBuyList.p_date} <br>
			종료시간 : ${productBuyList.p_date2} <br>
						<hr>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>