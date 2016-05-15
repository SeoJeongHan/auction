<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>경매물품 등록하기</title>
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Gafata|Nobile:400,700'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Roboto:400,300'
	rel='stylesheet' type='text/css'>
<link href='styles/style.css' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="./js/jquery-1.10.2.js"/></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#range').on("change", function(val) {
			$('.output').html(this.value + "시간");
		}).trigger("change");
	});
</script>
<script type="text/javascript">
	function fileCheck(obj){   // 파일 확장자 체크하기
		var obj = document.getElementById('fileID');
		var lastIndex = -1; 
		var filePath = "";
		filePath = obj.value;
		lastIndex  = filePath.lastIndexOf('.'); 
		extension = filePath.substring( lastIndex+1, filePath.len ); // 확장자 짤라내
		if((extension.toLowerCase() != "jpg") && (extension.toLowerCase() != "jpeg") && (extension.toLowerCase() != "gif") && (extension.toLowerCase() != "png")) {           
			alert('이미지 파일만 첨부가능 합니다.(jpg, jpeg, gif, png)');
			mainForm.pt_upfile.select();  //pt_upfile 를 선택
			document.execCommand('Delete');
			document.mainForm.pt_upfile.focus();
			return false;
		}
		return true;
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
                alert("1억 이하의 금액만 설정 가능합니다");
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
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="top_header">
		<h6>경매 물품 등록</h6>
	</div>
	<div id="inputs">
		<form:form action="productRegResult" method="post" modelAttribute="productSellForm" enctype="multipart/form-data">
			<fieldset>
				<label> 제목 </label>
				<br>
				<form:input path="p_title" required="required"/>
				<br> <label> 브랜드 이름 </label>
				<div>
				
					<div id="ck-button">
						<label> <form:radiobutton value="C001" path="p_category" /><span>
								CASIO</span></label>
					</div>
					<div id="ck-button">
						<label> <form:radiobutton value="C002" path="p_category" /><span>
								TIME</span></label>
					</div>
					<div id="ck-button">
						<label> <form:radiobutton value="C003" path="p_category" /><span>
								TISSOT</span></label>
					</div>

					<div id="ck-button">
						<label> <form:radiobutton value="C004" path="p_category" /><span>
								D&G</span></label>
					</div>

					<div id="ck-button">
						<label> <form:radiobutton value="C005" path="p_category" /><span>
								DKNY</span></label>
					</div>

					<div id="ck-button">
						<label> <form:radiobutton value="C006" path="p_category" /><span>
								ROLEX</span></label>
					</div>

					<div id="ck-button">
						<label> <form:radiobutton value="C007" path="p_category" /><span>
								OMEGA</span></label>
					</div>

					<div id="ck-button">
						<label> <form:radiobutton value="C008" path="p_category" /><span>
								ALBA</span></label>
					</div>

					<div id="ck-button">
						<label> <form:radiobutton value="C009" path="p_category" checked="checked"/><span>
								기 타</span></label>
					</div>
				</div>
				<br>
				<br>
				<br>
				<br> <label>모델명</label>
				<form:input path="p_snumber" style = "ime-mode:disabled;"/>
				<br> <label> 즉시 구매가 </label>
				<form:input path="p_instant_price" onkeypress="return isNumberKey(event)" />
				<br> <label> 경매 시작가 </label>
				<form:input path="p_primary_price" onkeypress="return isNumberKey(event)"/>
				<br> <label> 경매 시간설정</label><br>
				<label for="range"> <input type="range" name="time" id="range" min="1" max="24" step="1" value="3" />
				</label><br><br><br><br>
				<div class="output"></div>
				<br> <br> <br> <br> <label> 상품 설명 </label><br>
				<form:textarea path="p_content" required="required"/>
				<br><br> <label> 상품 이미지 등록 </label><br> 
				<input type="file" accept=".gif, .jpeg, .jpg,.png" id="fileID" name="file" required="required" onchange="fileCheck()" /><br><br><br>
				<button type="submit">경매 등록</button>
				<button type="reset">다시 작성</button>
			</fieldset>
		</form:form>
	</div>
	<%@ include file="footer.jsp"%>
		
</body>
</html>