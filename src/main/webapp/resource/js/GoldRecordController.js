var Config = {
	count: 20,
	page: 1,
	isClick: false,

}

$(document).ready(function() {
			getgoldRecordList(1);
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
				getgoldRecordList(options.index);
			}

		},
		beforeRender: function(jA) {}
	});
})

function getgoldRecordList(page) {
	$.ajax({
		type: "get",
		url: "http://localhost:8080/CattleShares/goldRecord/getgoldRecordList",
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
	$('#GoldRecordList').html("");
	var str = "";
	for(var i = 0; i < data.obj.records.length; i++) {
		str +='<tr>'+
					'<td>'+data.obj.records[i].grdUserid+'</td>'+
					'<td>'+data.obj.records[i].grdUsername+'</td>';
		if(data.obj.records[i].grdProfittype==0){
			var grdProfittype = "邀请";
		}
		if(data.obj.records[i].grdProfittype==1){
			var grdProfittype = "充值";
		}
		if(data.obj.records[i].grdProfittype==2){
			var grdProfittype = "支出";
		}
				str	+='<td>'+grdProfittype+'</td>'+
					'<td>'+data.obj.records[i].grdTime+'</td>';
		if(data.obj.records[i].grdIncome==null){
			var grdIncome = "无";
		}else{
			var grdIncome = data.obj.records[i].grdIncome;
		}
		str +='<td>'+grdIncome+'</td>';
		if(data.obj.records[i].grdPay==null){
			var grdPay = "无";
		}else{
			var grdPay = data.obj.records[i].grdPay;
		}
					str+='<td>'+grdPay+'</td>'+
					'<td>'+data.obj.records[i].grdSpare+'</td>'+
					'<td>'+data.obj.records[i].grdRemark+'</td>'+
				'</tr>';
	}
	$("#GoldRecordList").append(str);
}

function getVipRecordByCommand() {
	var grdUserid = $("#grdUserid").val();
	var grdUsername = $("#grdUsername").val();
	var grdProfittype = $("#grdProfittype").val();
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	if(endTime == "") {
		if(grdUserid == "" && grdUsername == "") {
			Config.isClick = true;
			$.ajax({
				type: "get",
				url: "http://localhost:8080/CattleShares/goldRecord/getGoldRecordProfittype",
				async: false,
				data: {
					Profittype: grdProfittype,
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
				url: "http://localhost:8080/CattleShares/goldRecord/getGoldRecordByCommand",
				async: false,
				data: {
					grdUserid: grdUserid,
					grdUsername: grdUsername,
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
			url: "http://localhost:8080/CattleShares/goldRecord/goldRecordByTime",
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