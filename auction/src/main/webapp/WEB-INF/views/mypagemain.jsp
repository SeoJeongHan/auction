<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Card</title>
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.1.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Raleway:400">
<link href='styles/mypage.css' rel='stylesheet' type='text/css'>

</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="profile-card">

		<img src="/auction/images/image.png" alt=""> 


		<h1>${loginUser.id}님</h1>
		<h2>My page</h2>
		<div class="btn">
			<a href="/auction/userEdit">[회원정보수정]</a> <a
				href="/auction/myPageIng/${loginUser.id}">[진행 중인 경매 보기]</a> <a
				href="/auction/myPageEnd/${loginUser.id}">[완료 된 경매 보기]</a>
		</div>

	</div>
	<!-- end profile-card -->
</body>
</html>