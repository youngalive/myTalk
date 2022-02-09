

$(document).ready(function(){
	
	//load data
	//나의 친구 목록
	$.ajax({
		url:apiAdress+'/getFollowByMember',
		type:'get',
		data:{},
		success:function(list){
			
			
			
			$.each(list,function(index,item){
				
				
				
				$('#my-member-list').append(
					'<div class="member-object">'+
						'<span class="nick">'+item.nick+'</span>'+
						'<div>'+
							'<span class="intro">'+item.nick+'</span>'+
							'<button class="black-btn del-follow-btn" data-member-idx="'+item.member_idx+'">- 친구삭제</button>'+
						'</div>'+
					'</div>'
				);
			});
			
		},
		error:function(error){
			
		}
	});
	
	
	//나의 채팅 목록
	$.ajax({
		url:apiAdress+'/getChatByMember',
		type:'get',
		data:{},
		success:function(list){
			
			$.each(list,function(index,item){
				$('#my-chat-list').append(
					'<div class="chat-object">'+
						'<span class="nick">'+item.title+'</span>'+
						'<div>'+
							'<span class="intro">'+item.content+'</span>'+
							'<button class="black-btn del-chat-btn" data-chat-idx="'+item.chat_idx+'">- 삭제하기</button>'+
						'</div>'+
					'</div>'
				);
			});
			
		},
		error:function(error){
			
		}
	});
	
	
	//메인 페이지로 이동
	$('#go-main-btn').on('click',function(){
		location.href='./';
	});
	
	//친구 삭제
	$(document).on('click','.del-follow-btn',function(){
		var con = confirm('친구를 삭제 하시겠습니까?');
		if(!con){
			return;
		}
		
		$.ajax({
			url:apiAdress+'/delFollow',
			type:'get',
			data:{
				star_idx:$(this).data('member-idx')
			},
			success:function(data){
				if(data=='ok'){
					alert('회원 삭제 완료!');
					location.reload();
				}
			},
			error:function(error){
				
			}
		})
	});
	
	
	//채팅 삭제
	$(document).on('click','.del-chat-btn',function(){
		var con = confirm('채팅방을 삭제 하시겠습니까?');
		if(!con){
			return;
		}
		
		$.ajax({
			url:apiAdress+'/delChat',
			type:'get',
			data:{
				chat_idx:$(this).data('chat-idx')
			},
			success:function(data){
				if(data=='ok'){
					alert('채팅방 삭제 완료!');
					location.reload();
				}
			},
			error:function(error){
				
			}
		})
	})
	
	
	
})