var Config = {
	count: 20,
	page: 1,
	isClick: false,

}

$(document).ready(function() {
			getReflectRecodeList(1);
	$("#jqueryPage").pagination({
		count: Config.count, //总数
		size: 10, //每页数量
		index: 1, //当前页
		lrCount: 3, //当前页左右最多显示的数量
		lCount: 1, //最开始预留的数量
		rCount: 1, //最后预留的数量
		callback: function(options) {
			if(Config.isClick) {
				if(Config.page == 1){
					getVipRecordByCommand();
				}else{
					Config.page == options.index;
					getVipRecordByCommand();
				}
				
			} else {
				getVipRecordList(options.index);
			}

		},
		beforeRender: function(jA) {}
	});
})

function getReflectRecodeList(page) {
	$.ajax({
		type: "get",
		url: "http://localhost:8080/CattleShares/ReflectRecode/getReflectRecodeList",
		async: false,
		data: {
			current: page
		},
		success: function(data) {
			if(data.success) {
				xunhuan(data);
			} else {
				window.alert('莫名失败~请联系技术人员');
			}
		},
		error: function() {
			window.alert('信息加载失败~');
		}
	});
}

function xunhuan(data) {
	Config.count = data.obj.total;
	$('#ReflectRecode').html("");
	var str = "";
	for(var i = 0; i < data.obj.records.length; i++) {
		str += '<tr><td>' + data.obj.records[i].rrdUserid + '</td><td>' + data.obj.records[i].rrdUsername + '</td>' +
			'<td>' + data.obj.records[i].rrdSerialnum + '</td><td>' + data.obj.records[i].rrdPrice + '</td>' +
			'<td>' + data.obj.records[i].rrdApplytime + '</td><td>' + data.obj.records[i].rrdManagetime + '</td>';
		if(data.obj.records[i].rrdState == 0) {
			var rrdState = "待处理";
		}
		if(data.obj.records[i].rrdState == 1) {
			var rrdState = "已处理";
		}
		str += '<td>' + rrdState + '</td></tr>';
	}
	$("#ReflectRecode").append(str);
}

function getVipRecordByCommand() {
	var rrdUserid = $("#rrdUserid").val();
	var rrdUsername = $("#rrdUsername").val();
	var rrdState = $("#rrdState").val();
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	if(endTime == "") {
		if(rrdUserid == "" && rrdUsername == "") {
			Config.isClick = true;
			$.ajax({
				type: "get",
				url: "http://localhost:8080/CattleShares/ReflectRecode/getReflectRecodeProfittype",
				async: false,
				data: {
					Profittype: rrdState,
					current: Config.page
				},
				success: function(data) {
					if(data.success) {
						xunhuan(data);
					} else {
						window.alert('莫名失败~请联系技术人员');
					}
				},
				error: function() {
					window.alert('信息加载失败~');
				}
			});
		} else {
			Config.isClick = true;
			$.ajax({
				type: "get",
				url: "http://localhost:8080/CattleShares/ReflectRecode/getReflectRecodeByCommand",
				async: false,
				data: {
					rrdUserid: rrdUserid,
					rrdUsername: rrdUsername,
					current: Config.page
				},
				success: function(data) {
					if(data.success) {
						xunhuan(data);
					} else {
						window.alert('莫名失败~请联系技术人员');
					}
				},
				error: function() {
					window.alert('信息加载失败~');
				}
			});
		}
	}
	if(endTime != "" && startTime != "") {
		Config.isClick = true;
		$.ajax({
			type: "get",
			url: "http://localhost:8080/CattleShares/ReflectRecode/ReflectRecodeByTime",
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
					window.alert('莫名失败~请联系技术人员');
				}
			},
			error: function() {
				window.alert('信息加载失败~');
			}
		});
	}
}