var Config = {
		count:10,
		page:1,
		isClick:false
}

$(function() {

	$("#txtBeginDate").calendar({
		controlId: "divDate", // 弹出的日期控件ID，默认: $(this).attr("id") + "Calendar"
		speed: 200, // 三种预定速度之一的字符串("slow", "normal", or "fast")或表示动画时长的毫秒数值(如：1000),默认：200
		complement: true, // 是否显示日期或年空白处的前后月的补充,默认：true
		readonly: true, // 目标对象是否设为只读，默认：true
		upperLimit: new Date(), // 日期上限，默认：NaN(不限制)
		lowerLimit: new Date("2011/01/01"), // 日期下限，默认：NaN(不限制)
		callback: function() { // 点击选择日期后的回调函数
		}
	});
	$("#txtEndDate").calendar();
});

	$(document).ready(function() {
		getVipRecordList(1);
		$("#jqueryPage").pagination({
			count: Config.count, //总数
			size: 10, //每页数量
			index: 1, //当前页
			lrCount: 3, //当前页左右最多显示的数量
			lCount: 1, //最开始预留的数量
			rCount: 1, //最后预留的数量
			callback: function(options) {
				if(Config.isClick) {
					Config.page=options.index;
					getVipRecordByCommand();
				} else {
					getVipRecordList(1);
				}

			},
			beforeRender: function(jA) {}
		});
	})

function getVipRecordList(page) {
	$.ajax({
		type: "get",
		url: "http://localhost:8080/CattleShares/vipRecord/getVipRecordList",
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
	
	$('#VipRecordList').html("");
	
	var str = "";
	for(var i = 0; i < data.obj.records.length; i++) {
		
		str += '<tr><td>' + data.obj.records[i].vrdUserid + '</td><td>' + data.obj.records[i].vrdUsername + '</td><td>' + data.obj.records[i].vrdRechargetime + '</td><td>' + data.obj.records[i].vrdRechargeprice + '</td><td>'+data.obj.records[i].vrdRemark+'</td></tr>';
	}
	$("#VipRecordList").append(str);
}

function getVipRecordByCommand() {
	var vrdUserid = $("#vrdUserid").val();
	var vrdUsername = $("#vrdUsername").val();
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	if(endTime == "") {
		alert("0");
		$.ajax({
			type: "get",
			url: "http://localhost:8080/CattleShares/vipRecord/getVipRecordByCommand",
			async: false,
			data:{
				vrdUserid:vrdUserid,
				vrdUsername:vrdUsername,
				current:Config.page
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
	} else if(endTime != "" && startTime != "") {
		alert("1");
		$.ajax({
			type: "get",
			url: "http://localhost:8080/CattleShares/vipRecord/getVipRecordByTime",
			async: false,
			data:{
				firstTime:startTime,
				lastTime:endTime,
				current:Config.page
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
	}else{
		alert("3");
		window.alert('输入条件有误，请重试~');
	}
}