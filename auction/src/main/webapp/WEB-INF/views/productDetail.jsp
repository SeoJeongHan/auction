<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="auction.entity.ProductEntity"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세보기</title>
<link href='/auction/styles/ribbon.css' rel='stylesheet' type='text/css'>

</head>
<script>
	var data = "";
	window.onload = function() {
		var time = document.getElementById("time");

		window.setInterval(function() {
			time.innerHTML = new Date().toLocaleString();
			data = time.innerHTML;
		}, 1000);
	}
</script>
<script>
	function isNumberKey(evt) {
        var charCode = (evt.which) ? evt.which : event.keyCode;
        if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
            return false;
 
        // Textbox value       
        var _value = event.srcElement.value;       
 
        // 소수점(.)이 두번 이상 나오지 못하게
        var _pattern0 = /^\d*[.]\d*$/; // 현재 value값에 소수점(.) 이 있으면 . 입력불가
        if (_pattern0.test(_value)) {
            if (charCode == 46) {
                return false;
            }
        }
 
        // 1억 이하의 숫자만 입력가능
        var _pattern1 = /^\d{8}$/; // 현재 value값이 3자리 숫자이면 . 만 입력가능
        if (_pattern1.test(_value)) {
            if (charCode != 46) {
                alert("1억 이하의 금액만 입찰 가능합니다");
                return false;
            }
        }
 
        // 소수점 둘째자리까지만 입력가능
        var _pattern2 = /^\d*[.]\d{2}$/; // 현재 value값이 소수점 둘째짜리 숫자이면 더이상 입력 불가
        if (_pattern2.test(_value)) {
            alert("소수점 둘째자리까지만 입력가능합니다.");
            return false;
        }     
 
        return true;
    }
</script>
<body>
	<%@ include file="header.jsp"%>
	<div class='ribbon orange'></div>
	<div class='ribbon navy'></div>
	&nbsp;&nbsp;&nbsp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
	&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
	&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
	&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp; &ensp;&ensp;
	<font size="10">상품정보</font>
	<hr>
	<br>
	<br>
	<br>
	<c:if test="${ProductEntity ne null}">
		<form action="/auction/order" method="post">
			<table align="center">
				<tr>
					<td align="center" rowspan="12">
					<img src="/auction/images/${ProductEntity.p_code }.jpg" width=200 height=200></td>
				</tr>
				<tr>
					<th align="right">제목</th>
					<td>${ProductEntity.p_title }</td>
				</tr>
				<tr>
					<th align="right">내용</th>
					<td>${ProductEntity.p_content }</td>
				</tr>
				<tr>
					<th align="right">판매자</th>
					<td>${ProductEntity.p_s_uid }</td>
				<tr>
					<th align="right">현재입찰자</th>
					<td>${ProductEntity.p_b_uid }
					<td>
				</tr>
				<tr>
					<th align="right">모델명</th>
					<td>${ProductEntity.p_snumber }
				</tr>

				<tr>
					<th align="right">시작가격</th>
					<td>${ProductEntity.p_primary_price }원</td>
				</tr>
				<tr>
					<th align="right">즉구가격</th>
					<td>${ProductEntity.p_instant_price }원</td>
				</tr>
				<tr>
					<th align="right">등록시간</th>
					<td>${ProductEntity.p_date }</td>
				</tr>
				<tr>
					<th align="right">종료시간</th>
					<td>${ProductEntity.p_date2 }</td>
				</tr>
				<tr>
					<th align="right">현재시간</th>
					<td>
						<h4 id="time"></h4>
					</td>
				</tr>
			</table>

			<input type="hidden" name="pCode" value="${ProductEntity.p_code }">
			<input type="hidden" name="cPrice" value="${ProductEntity.p_current_price }">
			<input type="hidden" name="iPrice" value="${ProductEntity.p_instant_price }">
			<p align="center" ><font size="6" color="red">${orderFail}</font></p>
			<table align="center">
				<tr>
					<td rowspan="3" align="center"><img src="/auction/chart/${ProductEntity.p_snumber }.jpeg"><br>
						<font size="5">[과거 낙찰 가격 추이]</font></td>
					<td> * 현재가격 : ${ProductEntity.p_current_price }원 <c:if test="${ProductEntity.p_b_uid ne null}"><img src="/auction/images/arrow.gif" width=5 height=10></c:if></td>
				</tr>
				<tr>
					<td>
					<input type="text" name="cPrice_new" placeholder="${ProductEntity.p_current_price}" onkeypress="return isNumberKey(event)" >
					<input type="submit" value="입찰하기"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						    최대가격 : ${max}원 <br>
					<br> 최소가격 : ${min}원 <br>
					<br> 평균가격 : ${avg}원 <br>
					<br>
					</td>
				</tr>
			</table>
			<br>
		</form>
		
	</c:if>
	<c:if test="${ProductEntity eq null}">
		<p align="center"><font size="5" color="black"> 판매 완료! </font></p>
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
		
	</c:if>
	<%@ include file="footer.jsp"%>
</body>
</html>