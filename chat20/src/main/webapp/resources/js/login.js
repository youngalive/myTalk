

$(document).ready(function(){
	
	
	
	$('#submit').on('click',function(){
		var id = $('#id').val();
		var pw = $('#pw').val();
		
		
		$.ajax({
			url:apiAdress+'/login',
			type:'get',
			data:{
				id:id,
				pw:pw,
			},
			success:function(data){
				if(data=='ok'){
					alert('로그인 되었습니다.');
					location.replace('./');
				}else{
					alert('올바른 정보를 입력하세요.');
				}
			},
			error:function(error){
				
			}
		})
		
		
	});
	
})