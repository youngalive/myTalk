<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>	
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true" %>


<html>
<head>
	<title>채팅방 | My Talk</title>
	<link rel="shortcut icon" href="./resources/img/favicon.png">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
		rel="stylesheet" 
		integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="./resources/css/all.min.css">	
	<link rel="stylesheet" href="./resources/css/basic.css">	
	<link rel="stylesheet" href="./resources/css/chat-room.css">	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" 
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="https://cdn.socket.io/4.4.1/socket.io.min.js" integrity="sha384-fKnu0iswBIqkjxrhQCTZ7qlLHOFEgNkRmK2vaO/LbTZSXdJfAu6ewRBdwHPhBo/H" crossorigin="anonymous"></script>
	<script>
		var session={
				member_idx:'<c:out value="${sessionScope.user.member_idx}"/>',
				nick:'<c:out value="${sessionScope.user.nick}"/>'
		}
	</script>
	<script src="./resources/js/config.js"></script>
	<script src="./resources/js/chat-room.js?ver=123123"></script>
</head>
<body>
	
	
	<div class="container-body" style="width:400px;height:100%;background:#fff;border:1px solid #dedede;">
		<div id="title" style="color:var(--main-color);font-size:15px;font-weight:700;height:20px;padding-left:12px;">로딩중...</div>
		<div id="msg-list" class="msg-list">
			
		</div>		
		<div class="msg-inp-container">
			<textarea id="msg-text"></textarea>
			<button id="send-btn" class="black-btn send-btn">전송</button>
			
		</div>
		
	</div>
</body>
</html>
