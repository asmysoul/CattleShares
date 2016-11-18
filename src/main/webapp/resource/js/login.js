$(document).ready(function(){
	console.log($('.login-form').serialize());
})

function check_login()
{
 var name=$("#adminUsername").val().trim();
 var pass=$("#adminPassword").val().trim();
$("#adminUsername").focus(function(){
	$(".prompt-username").css("display","none");
})
$("#adminPassword").focus(function(){
	$(".prompt-psw").css("display","none");
})
 if(name==""||pass==""){
 	if(name==""&&pass==""){
 		$(".prompt").css("display","inline-block");
 		return false;
 	}else if(pass==""){
 		$(".prompt-psw").css("display","inline-block");
 		return false;
 	}else{
 		$(".prompt-username").css("display","inline-block");
 		return false;
 	}
 	$(".form").css("text-align","left");
 	$("#login_form").removeClass('shake_effect');  
  	setTimeout(function(){
   		$("#login_form").addClass('shake_effect')
  	},1);  
 }else{
 	$.ajax({
 		type:"post",
 		url:"http://localhost:8080/CattleShares/login/chenck_login",
 		async:true,
 		data:$('.login-form').serialize(),
 		success:function(data){
            if (data.success) {
                window.location.href="http://localhost:8080/CattleShares/index";
            } else {
            	alert(data.msg);
            }
 		},
 		error:function(){alert('用户名验证失败');}
 	});
 }
 
 
}

$(function(){
	$("#login").click(function(){
		
		check_login();
		$("input").val("");
		return false;
	})
})