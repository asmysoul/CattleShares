var Config = {
	count: 1,
	page:1,
	isClick: false
}
$(document).ready(function() {
	getInviteList(1);
	$("#jqueryPage").pagination({
		count: Config.count, //总数
		size: 10, //每页数量
		index: 1, //当前页
		lrCount: 3, //当前页左右最多显示的数量
		lCount: 1, //最开始预留的数量
		rCount: 1, //最后预留的数量
		callback: function(options) {
			if(Config.isClick) {
				if(Config.page==1){
					select();
				}else{
					Config.page = options.index;
					select();
				}
			} else {
				getInviteList(options.index);
			}
		},
		beforeRender: function(jA) {}
	});
})

//获取列表
function getInviteList(page) {
	$.ajax({
		type: "get",
		url: "http://localhost:8080/CattleShares/inviteManager/getInviteList",
		async: false,
		data: {
			current: page
		},
		success: function(data) {
			if(data.success) {
				xunhuan(data);
			} else {
				window.alert("莫名错误~请联系技术人员");
			}

		},
		error: function() {
			window.alert("加载失败~请刷新页面！");
		}
	});
}

function xunhuan(data) {
	Config.count = data.obj.total;
	$('#invaiteList').html("");
	var str = "";
	for(var i = 0; i < data.obj.records.length; i++) {
		str += '<tr><td>' + data.obj.records[i].inviUsername + '</td><td>' + data.obj.records[i].inviAcceptuser + '</td><td>' + data.obj.records[i].inviAcceptmobile + '</td><td>' + data.obj.records[i].inviRegisttime + '</td>';
		if(data.obj.records[i].inviAcceptuserstate == 0) {
			var inviAcceptuserstate = "普通用户";
		} else if(data.obj.records[i].inviAcceptuserstate == 1) {
			var inviAcceptuserstate = "普通会员";
		} else {
			var inviAcceptuserstate = "合作用户";
		}
		str += '<td>' + inviAcceptuserstate + '</td><td>' + data.obj.records[i].inviRecharge + '</td><td>' + data.obj.records[i].inviGold + '</td><td>' + data.obj.records[i].inviMark + '</td></tr>';
	}
	$("#invaiteList").append(str);
}

function select(page) {
	
	var inviAcceptuser = $("#inviAcceptuser").val();
	var inviUsername = $("#inviUsername").val();
	var inviUserstate = $("#inviAcceptuserstate").val();
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	if(endTime == "") {
		if(inviAcceptuser == "" && inviUsername == "") {
			Config.isClick = true;
			$.ajax({
				type: "get",
				url: "http://localhost:8080/CattleShares/inviteManager/getInviteSatate",
				async: false,
				data: {
					current: Config.page,
					acceptuserstate: inviUserstate
				},
				success: function(data) {
					if(data.success) {
						xunhuan(data)
					} else {
						window.alert("莫名错误~请联系技术人员");
					}

				},
				error: function() {
					window.alert("查询失败~请耐心重试");
				}
			});
		} else {
			Config.isClick = true;
			$.ajax({
				type: "get",
				url: "http://localhost:8080/CattleShares/inviteManager/getInviteByCommand",
				async: false,
				data: {
					current: Config.page,
					inviAcceptuser: inviAcceptuser,
					inviUsername: inviUsername
				},
				success: function(data) {
					if(data.success) {
						xunhuan(data)
					} else {
						window.alert("莫名错误~请联系技术人员");
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
		Config.isClick = true;
		$.ajax({
			type: "get",
			url: "http://localhost:8080/CattleShares/inviteManager/getInviteByTime",
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
					window.alert("莫名错误~请联系技术人员");
				}

			},
			error: function() {
				window.alert("查询失败~请耐心重试");
			}
		});
	}
}