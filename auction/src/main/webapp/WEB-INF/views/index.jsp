<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project!!</title>
<link href='styles/main.css' rel='stylesheet' type='text/css'>
</head>
<body>
	<p align="center"><a href="/auction/index"><img src="images/logo.png" width="468" height="164" ></a></p>
	<%@ include file="header.jsp"%>
	<nav>
		<ul>
			<li><a href="category/C001">CASIO</a></li>
			<li><a href="category/C002">TIME</a></li>
			<li><a href="category/C003">TISSOT</a></li>
			<li><a href="category/C004">D&G</a></li>
			<li><a href="category/C005">DKNY</a></li>
			<li><a href="category/C006">ROLEX</a></li>
			<li><a href="category/C007">OMEGA</a></li>
			<li><a href="category/C008">ALBA</a></li>
			<li><a href="category/C009">기타</a></li>
		</ul>
	</nav>
	<br>

	<div class="container">
		<div class="button-collection">
			<button type="button" class="blue-pill" onclick="location='getAll'">전체상품보기</button>
		</div>
	</div>
	<click>
	<ul>
		<c:forEach var="product" items="${productList}">
			<li><p1> <a style="font-family: '바탕'; text-decoration: none" href="productDetail/${product.p_code}">${product.p_title}</a></p1> <p2>
				<br>
				【 판 매 자 】 : ${product.p_s_uid}<br>
				【 시작가격 】: ${product.p_primary_price}원<br>
				【 현재가격 】: ${product.p_current_price}원<br>
				【 즉구가격 】: ${product.p_instant_price}원<br>
				<br>
				【 종료시간 】: ${product.p_date2} </p2></li>
		</c:forEach>

	</ul>
	</click>


	<br>
	<br>

	<form action="searchProc" id="search" class="form-wrapper">

		<input type="text" placeholder="search.." name="searchText"
			id="searchText" required="required" /> <input type="submit"
			value="검색" id="search_button" />

	</form>
	<br>
	<br>

		<table>

			<tr>
				<th align="center" colspan="2">브랜드순위<br>
				<br></th>
			</tr>
			<%
				int count = 1;
			%>
			<c:forEach var="category" items="${categoryList}">
				<tr>
					<%-- <td align="center"><span><%=count++%></span></td> --%>
					<td align="center"><a href="category/${category.ccode}"
						class="rank"><span><%=count++%></span>${category.cname}</a></td>
				</tr>
			</c:forEach>
		</table>

	<%-- 	<table>
	<thead>
		<tr>
			<th>브랜드순위</th>
		</tr>
		<%
			int count = 1;
		%>
		<c:forEach var="category" items="${categoryList}">
			<tr>
				<td><%=count++%>.<a href="category/${category.ccode}">${category.cname}</a></td>
			</tr>
		</c:forEach>
	</table> --%>
	<br>
	<br>

	<%@ include file="footer.jsp"%>
</body>
</html>