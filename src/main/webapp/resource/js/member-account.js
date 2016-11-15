var Config = {
	page: 1,
	size:1,
	count: 1,
	isClick: false
}

$('.account-type').blur(function() {
	var bank = $('#bank').is(':selected');
	if(bank == true) {
		$('.bank').css('display', 'block');
	} else {
		$('.bank').css('display', 'none');
	}
})
$('.small-change').click(function() {

})
$('.close').click(function() {
	$('.change-umessage').slideUp();
	$('.back').fadeOut();
})

$(document).ready(function() {
	getUserList(1);
	
	$("#jqueryPage").pagination({
		count: Config.count, //总数
		size: Config.size, //每页数量
		index: 1, //当前页
		lrCount: 3, //当前页左右最多显示的数量
		lCount: 1, //最开始预留的数量
		rCount: 1, //最后预留的数量
		callback: function(options) {
			if(Config.isClick) {
				if(Config.page==1){
					getSelectUserByType(Config.page);
				}else{
					Config.page = options.index;
					getSelectUserByType(Config.page);
				}
			} else {
				alert(Config.isClick+" "+options.index);
				getUserList(options.index);
			}
		},
		beforeRender: function(jA) {}
	});
})

function getUserList(page) {
	$.ajax({
		type: "get",
		url: "http://localhost:8080/CattleShares/user/getUserList",
		data: {
			current: page
		},
		async: false,
		success: function(data) {
			if(data.success) {
				xunhuan(data);
			}

		},
		error: function() {
			window.alert("加载失败~请耐心重试");
		}
	});
}

function getSelectUserByType(page) {
	var userId = $("#selectUserId").val();
	var userName = $("#selectUserName").val();
	var accountType = $("#selectAccountType").val();
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	alert(startTime+","+endTime);
	if(endTime == "") {
		if(userId == "" && userName == "") {
			alert("1");
			isClick = true;
			$.ajax({
				type: "get",
				url: "http://localhost:8080/CattleShares/user/getSelectUserByType",
				async: false,
				data: {
					current: 1,
					accountType: accountType
				},
				success: function(data) {
					if(data.success) {
						xunhuan(data)
					} else {
						window.alert("莫名错误~请耐心重试");
					}

				},
				error: function() {
					window.alert("查询失败~请耐心重试");
				}
			});
		} else {
			isClick = true;
			alert(page);
			$.ajax({
				type: "get",
				url: "http://localhost:8080/CattleShares/user/selectByCommandUser",
				async: false,
				data: {
					userId: userId,
					userName: userName,
					current: 1

				},
				success: function(data) {
					if(data.success) {
						xunhuan(data)
					} else {
						window.alert("莫名错误~请耐心重试");
					}

				},
				error: function() {
					window.alert("查询失败~请耐心重试");
				}
			});
		}

	}
	//根据时间间隔查询用户

	if(startTime != "" && endTime != "") {
		isClick = true;
		alert('shijian');
		$.ajax({
			type: "get",
			url: "http://localhost:8080/CattleShares/user/getSelectTime",
			async: false,
			data: {
				firstTime: startTime,
				lastTime: endTime,
				current: 1
			},
			success: function(data) {
				if(data.success) {
					xunhuan(data);
				} else {
					window.alert("莫名错误~请耐心重试");
				}

			},
			error: function() {
				window.alert("查询失败~请耐心重试");
			}
		});
	}

}

function xunhuan(data) {
	Config.count = data.obj.total;
	Config.size = data.obj.records.length;
	$('#accountList').html("");
	var str = "";
	for(var i = 0; i < data.obj.records.length; i++) {
		str += '<tr><td>' + data.obj.records[i].userId + '</td><td>' + data.obj.records[i].userName + '</td>';
		if(data.obj.records[i].accountType == 0) {
			var accountType = "财付通";
		} else if(data.obj.records[i].accountType == 1) {
			var accountType = "支付宝";
		} else if(data.obj.records[i].accountType == 2) {
			var accountType = "银行卡";
		} else {
			var accountType = "其他类型";
		}
		str += '<td>' + accountType + '</td><td>' + data.obj.records[i].reflectAccount + '</td><td><i class="small-icon small-change" onclick="Set_VIPUserInfo(this)"></i></td></tr>';
	}
	$("#accountList").append(str);
}

function Set_VIPUserInfo(obj) {
	var userId = $(obj).parent().siblings()[0].innerText;
	var accountType = $(obj).parent().siblings()[2].innerText;
	var userName = $(obj).parent().siblings()[1].innerText;
	if(accountType == "财付通") {
		var accountType = 0;
	}
	if(accountType == "支付宝") {
		var accountType = 1;
	}
	if(accountType == "银行卡") {
		var accountType = 2;
	}
	if(accountType == "其他类型") {
		var accountType = 3;
	}
	document.getElementById("upDataAccountType").value = accountType;
	$("#userName").text(userName);
	$("#hiddenUserId").val(userId);
	$('.change-umessage').slideDown();
	$('.back').fadeIn();
}

function Update_VIPUserInfo() {
	var userId = $("#hiddenUserId").val();
	var userName = $("#userName").text();
	var accountType = $("#upDataAccountType").val();
	var reflectAccount = $("#reflectAccount").val();
	if(accountType == 3) {
		window.alert("请选择账户类型~");
		return;
	}
	if(reflectAccount == "") {
		window.alert("请填入提现账户~");
		return;
	}
	alert(userId + "  " + userName + "  " + accountType + " " + reflectAccount);
	$.ajax({
		type: "post",
		url: "http://localhost:8080/CattleShares/user/Update_VIPUserInfo",
		async: false,
		data: {
			userId: userId,
			userName: userName,
			accountType: accountType,
			reflectAccount: reflectAccount
		},
		success: function(data) {
			if(data.success) {
				window.alert("修改成功！");
				getUserList(1);
			} else {
				window.alert("莫名错误~请耐心重试");
			}
		},
		error: function() {
			window.alert("修改失败~请耐心重试");
		}
	});
}