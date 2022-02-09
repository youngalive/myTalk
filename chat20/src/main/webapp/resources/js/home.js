

$(document).ready(function(){
	
	
	
	
	//load data
	//회원 목록
	$.ajax({
		url:apiAdress+'/getAllMember',
		type:'get',
		data:{},
		success:function(list){
			
			
			
			$.each(list,function(index,item){
				
				var btn='';
				if(item.member_idx!=session.member_idx){
					btn='<button class="main-cr-btn follow-member-btn" data-member-idx="'+item.member_idx+'">+ 친구추가</button>';
				}
				
				$('#member-list').append(
					'<div class="member-object">'+
						'<span class="nick">'+item.nick+'</span>'+
						'<div>'+
							'<span class="intro">'+item.nick+'</span>'+
							btn+
						'</div>'+
					'</div>'
				);
			});
			
		},
		error:function(error){
			
		}
	})
	
	//채팅 목록 불러오기
	$.ajax({
		url:apiAdress+'/getAllChat',
		type:'get',
		data:{},
		success:function(list){
			
			$.each(list,function(index,item){
				$('#chat-list').append(
					'<div class="chat-object" data-chat-idx="'+item.chat_idx+'">'+
						'<span class="nick">'+item.title+'</span>'+
						'<div>'+
							'<span class="intro">'+item.content+'</span>'+
							'<button class="black-btn enter-chat-btn" data-title="'+item.title+'" data-chat-idx="'+item.chat_idx+'">참가하기</button>'+
						'</div>'+
					'</div>'
				);
			});
		},
		error:function(error){
			
		}
	})
	
	
	
	$('#go-login-btn').on('click',function(){
		location.href='./login';
	});
	
	$('#go-add-chat-btn').on('click',function(){
		location.href='./addChat';
	});
	
	
	$('#go-add-btn').on('click',function(){
		location.href='./addUser';
	});
	
	$('#go-my-btn').on('click',function(){
		location.href='./my';
	});
	
	//로그아웃
	$('#logout-btn').on('click',function(){
		
		var con = confirm('정말 로그아웃 하시겠습니까?');
		if(con==false){
			return
		}
		
		$.ajax({
			url:apiAdress+'/logout',
			type:'get',
			data:{},
			success:function(){
				location.replace('./');
			},
			error:function(){
				
			}
		})
	});
	
	//채팅방 입장 클릭
	
	$(document).on('click','.enter-chat-btn',function(){
		var chat_idx = $(this).data('chat-idx');
		var title = $(this).data('title');
		location.href='./chatroom?chat_idx='+chat_idx+'&title='+title;
	})
	
	//팔로우 버튼 클릭 이벤트
	$(document).on('click','.follow-member-btn',function(){
		var con = confirm('친구추가 하시겠습니까?');
		if(!con){
			return;
		}
		
		$.ajax({
			url:apiAdress+'/addFollow',
			type:'get',
			data:{
				star_idx:$(this).data('member-idx')
			},
			success:function(data){
				if(data=='ok'){
					alert('친구추가 완료');
					location.replace('./');
				}else if(data=='ex'){
					alert('이미 추가된 친구 입니다.');
				}
			},
			error:function(error){
				
			}
		})
	});
	
	
	
})