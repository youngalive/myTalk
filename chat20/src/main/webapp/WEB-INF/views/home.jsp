<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>	
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true" %>


<html>
<head>
	<title>My Talk</title>
	<link rel="shortcut icon" href="./resources/img/favicon.png">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
		rel="stylesheet" 
		integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="./resources/css/all.min.css">	
	<link rel="stylesheet" href="./resources/css/basic.css">	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" 
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		var session={
				member_idx:'<c:out value="${sessionScope.user.member_idx}"/>'
		}
	</script>
	<script src="./resources/js/config.js"></script>
	<script src="./resources/js/home.js?ver=123123"></script>
</head>
<body>

	<div class="container-body">
		<div class="top-header flex v-center space-between">
			<div>
				<img class="logo" src="./resources/img/logo.png"/>
			</div>
			
			<div>
				<c:if test="${empty sessionScope.user}">
					<button id="go-login-btn">로그인</button>
					<button id="go-add-btn">회원가입</button>
				</c:if>
				
				<c:if test="${!empty sessionScope.user}">
					<span style="color:var(--main-color);font-weight:700;font-size:15px;">${sessionScope.user.nick}</span>
					<span style="color:#999;font-weight:700;margin-right:10px;">님</span>
					<button id="go-my-btn">마이페이지</button>
					<button id="go-add-chat-btn">채팅만들기</button>
					<button id="logout-btn">로그아웃</button>
				</c:if>
				
				
			</div>
		</div>
		<div style="height:100px;"></div>
		<div class="side-by-side-div">
			<section class="one-section">
				<div class="sec-title">회원목록</div>
				<div id="member-list">
					<!-- <div class="member-object">
						<span class="nick">닉네임</span>
						<div>
							<span class="intro">안녕하세요!</span>
							<button class="main-cr-btn">+ 친구추가</button>
						</div>
					</div> -->
					
					
					
				</div>
			</section>
			
			<section class="one-section">
				<div class="sec-title">진행중 채팅방</div>
				<div id="chat-list">
					<!-- <div class="chat-object">
						<span class="nick">서울 친목도모</span>
						<div>
							<span class="intro">[닉네임]안녕하세요!</span>
							<button class="black-btn">참가하기</button>
						</div>
					</div> -->
				</div>
			</section>
			
		</div>
		
		
		
	</div>
</body>
</html>
