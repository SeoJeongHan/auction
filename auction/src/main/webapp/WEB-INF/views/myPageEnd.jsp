<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta>
<title>${loginUser.name} 님의 지난 경매</title>
<link rel="stylesheet" type="text/css" href="/auction/styles/sticky.css"
	media="all" />
<link href='http://fonts.googleapis.com/css?family=The+Girl+Next+Door'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<%@ include file="header.jsp"%>

	<p align="center" style="font-weight: bold;">
		<font size="5" color="black">${loginUser.name} 님의 지난 경매 기록</font>
	</p>

	<div id='frame'>
		<div class="note sticky2">
			<p style="font-weight: bold;">
				<font color="black" size="5">+판매기록+</font>
			</p>
			<br>
			<hr>
			<div class="scrollbar2" id="style-2">
				<div class="force-overflow">
					<c:forEach var="orderSoldList" items="${orderSoldList}">

	낙찰번호 : ${orderSoldList.o_code }<br>
	구매자 : <a href="/auction/userInfo/${orderSoldList.o_b_uid}">${orderSoldList.o_b_uid}</a>
						<br>
	모델명 : ${orderSoldList.o_snumber}<br>
	낙찰가격 : ${orderSoldList.o_sell_price}<br>
	낙찰시간 : ${orderSoldList.o_date} <br>
						<hr>

					</c:forEach>
				</div>
			</div>
		</div>
		<div class="note sticky1">

			<p style="font-weight: bold;">
				<font color="black" size="5">+구매기록+</font>
			</p>
			<br>
			<hr>
			<div class="scrollbar1" id="style-1">
				<div class="force-overflow">
					<c:forEach var="orderBoughtList" items="${orderBoughtList}">

	낙찰번호 : ${orderBoughtList.o_code } <br>
	판매자 : <a href="/auction/userInfo/${orderBoughtList.o_s_uid}">${orderBoughtList.o_s_uid}</a>
						<br>
	모델명 : ${orderBoughtList.o_snumber} <br>
	낙찰가격 : ${orderBoughtList.o_sell_price} <br>
	낙찰시간 : ${orderBoughtList.o_date} <br>
						<hr>

					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>