$(document).ready(function(){
	
	
	var globalValue={
			chat_idx:getParam('chat_idx'),
			title:getParam('title'),
			member_idx:session.member_idx,
			nick:session.nick
	}
	var roomcode = 'c'+globalValue.chat_idx;
	
	
	
	$.ajax({
		url:apiAdress+'/getChat',
		type:'get',
		data:{
			chat_idx:globalValue.chat_idx,
		},
		success:function(data){
			$('#title').html(data.title);
		},
		error:function(error){
			
		}
	})
	
	
	console.log(globalValue);
	console.log('현재 채팅 idx : '+globalValue.chat_idx);
	var socket = io.connect(chatSocketAddress,{
		query:'roomcode=c'+globalValue.chat_idx
	});
	
	socket.on('connect',function(){
		socket.on('room_join_ok',function(data){
			if(data.msg=='ok'){
				console.log('소켓 서버에서 채팅 준비 완료.');
			}
		});
		
		
		
		socket.on('receive',function(data){
			console.log(data.nick);
			var cl;
			var nickhtml='';
			if(data.member_idx==globalValue.member_idx){
				cl = 'me';
			}else{
				cl = 'other';
				nickhtml='<div>'+data.nick+'</div>'
			}
			
			$('#msg-list').append(
				'<div class="msg-div '+cl+'">'+
					'<div class="msg-bubble '+cl+'">'+
						nickhtml+
						data.msg+
					'</div>'+
				'</div>'
			);
			
			$('#msg-list').scrollTop($('#msg-list').height(),200);
		});
		
		
		//채팅 대화 에서 엔터키 이벤트
		$('#msg-text').on('keyup',function(e){
			if (window.event.keyCode == 13) {
				$('#send-btn').trigger('click');
		    }
		});
		
		
		//전송 버튼 클릭 시 보내기
		$('#send-btn').on('click',function(){
			var text = $('#msg-text').val();
			socket.emit('send',{
				roomcode:roomcode,
				msg:text,
				member_idx:globalValue.member_idx,
				nick:globalValue.nick
			});
			$('#msg-text').val('')
		})
		
		
		
		
	});
	
	
	
	
	
	
	
});



//url 에서 parameter 추출
function getParam(sname) {
    var params = location.search.substr(location.search.indexOf("?") + 1);
    var sval = "";
    params = params.split("&");
    for (var i = 0; i < params.length; i++) {
        temp = params[i].split("=");
        if ([temp[0]] == sname) { sval = temp[1]; }
    }
    return sval;
}