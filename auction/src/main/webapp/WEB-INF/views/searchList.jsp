<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>{searchText} 검색 결과</title>
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
	<font size="10">${searchText} 검색 결과</font>
	<hr>
	<br>
	<br>
	<br>
	<br>
	<br>
	<section class="container">
		<table class="order-table">
			<tr>
				<th width="2%">No</th>
				<th width="7%">제목</th>
				<th width="5%">판매자</th>
				<th width="5%">모델명</th>
				<th width="5%">경매 시작가</th>
				<th width="5%">경매 즉구가</th>
			</tr>
		</table>
	</section>

<% int count = 1; %>
	<div class="scrollbar3" id="style-9">
		<div class="force-overflow">
			<section class="container">
				<table class="order-table">

					<c:forEach var="product" items="${searchList}">
						<tr>
							<td width="5%"><%=count++ %></td>
							<td width="5%">
								<a href="/auction/productDetail/${product.p_code}" style="text-decoration:none">
								<font size="4">${product.p_title}</font></a>
							</td>						
							<td width="5%">${product.p_s_uid}</td>
							<td width="5%">${product.p_snumber}</td>
							<td width="5%">${product.p_primary_price}원</td>
							<td width="5%">${product.p_instant_price}원</td>
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