<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>	
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true" %>


<html>
<head>
	<title>회원가입</title>
	<link rel="shortcut icon" href="./resources/img/favicon.png">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
		rel="stylesheet" 
		integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="./resources/css/all.min.css">	
	<link rel="stylesheet" href="./resources/css/basic.css">	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" 
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="./resources/js/config.js"></script>
	<script src="./resources/js/add-user.js"></script>
</head>
<body>

	<div class="container-body">
		<div class="flex v-center h-center" style="height:100%;flex-direction:column;">
			<img class="logo" src="./resources/img/logo.png"/>
			<div style="color:#000;font-size:15px;font-weight:700;margin-top:20px;">
				20대의 채팅에 오신걸 환영합니다!
			</div>
			<input id="id" class="user-inp" placeholder="아이디"/>
			<input id="pw" type="password" class="user-inp" placeholder="비밀번호"/>
			<input id="nick" class="user-inp" placeholder="닉네임"/>
			<input id="intro"class="user-inp" placeholder="간단소개"/>
			<button id="submit" class="black-btn" style="width:250px;padding:8px;margin-top:26px;">회원가입 하기</button>
		</div>
		
		
		
	</div>
</body>
</html>
