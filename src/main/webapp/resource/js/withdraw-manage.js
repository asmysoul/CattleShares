var Config = {
	count: 20,
	page: 1,
	isClick: false,

}
//$('#widthdraw-edit').click(function() {
//	$(".change-umessage").slideDown();
//	$('.back').fadeIn();
//})
$('.close').click(function() {
	$(".change-umessage").slideUp();
	$('.back').fadeOut();
})

$(document).ready(function() {
	getReflectManagerList(1);
	$("#jqueryPage").pagination({
		count: Config.count, //总数
		size: 10, //每页数量
		index: 1, //当前页
		lrCount: 3, //当前页左右最多显示的数量
		lCount: 1, //最开始预留的数量
		rCount: 1, //最后预留的数量
		callback: function(options) {
			if(Config.isClick) {
				if(Config.page == 1) {
					selectReflectByCommand();
				} else {
					Config.page == options.index;
					selectReflectByCommand();
				}

			} else {
				getReflectManagerList(options.index);
			}

		},
		beforeRender: function(jA) {}
	});
});

function getReflectManagerList(page) {
	$.ajax({
		type: "get",
		url: "http://localhost:8080/CattleShares/ReflectManager/getReflectManagerList",
		data: {
			current: page
		},
		async: false,
		success: function(data) {
			if(data.success) {
				xunhuan(data);
			} else {
				window.alert(data.msg);
			}
		},
		error: function() {

		}
	});
}

function xunhuan(data) {
	Config.count = data.obj.total;
	$("#ReflectManagerList").html("");
	var str = "";
	for(var i = 0; i < data.obj.records.length; i++) {
		str += '<tr><input type="hidden" value="' + data.obj.records[i].rrdId + '"/>' +
			'<td>' + data.obj.records[i].rrdApplytime + '</td>' +
			'<td>' + data.obj.records[i].rrdUserid + '</td>' +
			'<td>' + data.obj.records[i].rrdUsername + '</td>' +
			'<td>' + data.obj.records[i].rrdPrice + '</td>';
		if(data.obj.records[i].accountType == 0) {
			var accountType = "财付通";
		}
		if(data.obj.records[i].accountType == 1) {
			var accountType = "支付宝";
		}
		if(data.obj.records[i].accountType == 2) {
			var accountType = "银行卡";
		}
		
		str += '<td>' + accountType + '</td>' +
			'<td>' + data.obj.records[i].reflectAccount + '</td>';
		if(data.obj.records[i].rrdState == 0) {
			var rrdState = "未处理";
			str += '<td class="state-color">' + rrdState + '</td>' +
			'<td>' +
			'<i class="small-icon small-waitdeal" id="widthdraw-edit" onclick="setUserInfo(this)"></i>' +
			'<i class="small-icon small-deleteline" onclick="deleteReflectRecord(this)"></i>' +
			'</td>' +
			'</tr>';
		}
		if(data.obj.records[i].rrdState == 1) {
			var rrdState = "已处理";
			str += '<td class="state-color">' + rrdState + '</td>' +
			'<td><i class="small-icon small-dealed" onclick="resetrrdState(this)"></i></td></tr>';
		}
		
	}
	$("#ReflectManagerList").append(str);
}

function deleteReflectRecord(obj) {
	var truthBeTold = window.confirm("单击“确定”继续。单击“取消”停止。");
	if(truthBeTold) {
		var rrdId = $(obj).parent().siblings()[0].value;
		$.ajax({
			type: "post",
			url: "http://localhost:8080/CattleShares/ReflectManager/deleteReflectRecord",
			async: false,
			data: {
				rrdId: rrdId
				
			},
			success: function(data) {
				if(data.success) {
					window.alert("删除成功~");
					getReflectManagerList(1);
				} else {
					window.alert(data.msg);
				}
			},
			error: function() {
				window.alert("请求失败~");
			}
		});
	} else {
		window.alert("再见啦！");
	}

}

function setUserInfo(obj) {
	$(".change-umessage").slideDown();
	$('.back').fadeIn();
	var rrdId = $(obj).parent().siblings()[0].value;
	var rrdPrice = $(obj).parent().siblings()[4].innerText;
	var rrdUsername = $(obj).parent().siblings()[3].innerText;
	var accountType = $(obj).parent().siblings()[5].innerText;
	var reflectAccount = $(obj).parent().siblings()[6].innerText;
	var hiddenUserId = $(obj).parent().siblings()[2].innerText;
	$("#rrdId").val(rrdId);
	$("#hiddenRrdPrice").val(rrdPrice);
	$("#rrdUsername").text(rrdUsername);
	$("#accountType").text(accountType);
	$("#reflectAccount").text(reflectAccount);
	$("#hiddenUserId").val(hiddenUserId);
}

function Update_UserInfo() {
	var rrdId = $("#rrdId").val();
	var rrdPrice = $("#rrdPrice").val();
	var hiddenRrdPrice = $("#hiddenRrdPrice").val();
	var hiddenUserId = $("#hiddenUserId").val();
	if(rrdPrice != hiddenRrdPrice) {
		window.alert("输入金额与申请金额不符~");
		return;
	} else {
		$.ajax({
			type: "post",
			url: "http://localhost:8080/CattleShares/ReflectManager/update_UserInfo",
			async: false,
			data: {
				rrdId: rrdId,
				rrdPrice: rrdPrice,
				rrdUserid:hiddenUserId
			},
			success: function(data) {
				if(data.success) {
					window.alert("修改成功~");
					getReflectManagerList(1);
					$(".change-umessage").slideUp();
					$('.back').fadeOut();
				} else {
					window.alert(data.msg);
				}
			},
			error: function() {
				window.alert("请求失败~");
			}
		});
	}
}

function selectReflectByCommand() {
	var selectRrdUserid = $("#selectRrdUserid").val();
	var selectRrdUsername = $("#selectRrdUsername").val();
	var selectRrdState = $("#selectRrdState").val();
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	if(endTime == "") {
		//根据会员状态查询
		if(selectRrdUserid == "" && selectRrdUsername == "") {
			Config.isClick = true;
			
			$.ajax({
				type: "get",
				url: "http://localhost:8080/CattleShares/ReflectManager/getSelectSatate",
				async: false,
				data: {
					userState: selectRrdState,
					current: Config.page
				},
				success: function(data) {
					if(data.success) {
						xunhuan(data);
					} else {
						alert("数据显示失败~请刷新");
						return;
					}
				},
				error: function() {
					alert("请求失败,请耐心重试~");
					return;
				}
			});
		} else {
			Config.isClick = true;
			alert("0");
			$.ajax({
				type: "get",
				url: "http://localhost:8080/CattleShares/ReflectManager/selectReflectByCommand",
				async: false,
				data: {
					rrdUserid: selectRrdUserid,
					rrdUsername: selectRrdUsername,
					current: 1
				},
				success: function(data) {
					if(data.success) {
						xunhuan(data);
					} else {
						alert("数据显示失败~请刷新");
						return;
					}
				},
				error: function() {
					alert("删除失败,请耐心重试~");
					return;
				}
			});
		}
	}
	if(startTime != "" && endTime != "") {
		Config.isClick = true;
		$.ajax({
			type: "get",
			url: "http://localhost:8080/CattleShares/ReflectManager/getSelectTime",
			async: false,
			data: {
				firstTime: startTime,
				lastTime: endTime,
				current: Config.page
			},
			success: function(data) {
				if(data.success) {
					xunhuan(data);
				} else {
					alert("数据显示失败~请刷新");
					return;
				}
			},
			error: function() {
				alert("请求失败,请耐心重试~");
				return;
			}
		});
	}
}


function resetrrdState(obj){
	var truthBeTold = window.confirm("单击“确定”继续。单击“取消”停止。");
	if(truthBeTold) {
		var rrdId = $(obj).parent().siblings()[0].value;
		var rrdPrice = $(obj).parent().siblings()[4].innerText;
		alert(rrdPrice);
		var rrdUserid = $(obj).parent().siblings()[2].innerText;
		$.ajax({
			type: "post",
			url: "http://localhost:8080/CattleShares/ReflectManager/resetrrdState",
			async: false,
			data: {
				rrdId: rrdId,
				rrdPrice:rrdPrice,
				rrdUserid:rrdUserid
			},
			success: function(data) {
				if(data.success) {
					window.alert("重置成功~");
					getReflectManagerList(1);
				} else {
					window.alert(data.msg);
				}
			},
			error: function() {
				window.alert("请求失败~");
			}
		});
	} else {
		window.alert("再见啦！");
	}
}
