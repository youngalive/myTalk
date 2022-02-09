

$(document).ready(function(){
	
	
	
	$('#submit').on('click',function(){
		var id = $('#id').val();
		var pw = $('#pw').val();
		var nick = $('#nick').val();
		var intro = $('#intro').val();
		
		
		$.ajax({
			url:apiAdress+'/addUser',
			type:'get',
			data:{
				id:id,
				pw:pw,
				nick:nick,
				intro:intro,
			},
			success:function(data){
				if(data=='ok'){
					alert('회원가입이 완료 되었습니다.');
					location.replace('./');
				}
			},
			error:function(error){
				
			}
		})
	});
	
})