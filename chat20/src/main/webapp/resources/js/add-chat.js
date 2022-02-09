

$(document).ready(function(){
	
	
	
	$('#submit').on('click',function(){
		var title = $('#title').val();
		var content = $('#content').val();
		
		
		var con = confirm('채팅방을 만드시겠습니까?');
		if(con==false){
			return;
		}
		
		$.ajax({
			url:apiAdress+'/addChat',
			type:'get',
			data:{
				title:title,
				content:content
			},
			success:function(data){
				if(data=='ok'){
					alert('채팅방이 생성 되었습니다.');
					location.replace('./');
				}
			},
			error:function(error){
				
			}
		})
		
		
	});
	
})