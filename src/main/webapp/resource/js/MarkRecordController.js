var Config = {
	count: 20,
	page: 1,
	isClick: false,

}

$(document).ready(function() {
			getmarkRecodeList(1);
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

function getmarkRecodeList(page) {
	$.ajax({
		type: "get",
		url: "http://localhost:8080/CattleShares/markRecord/getmarkRecodeList",
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
	$('#MarkRecodeList').html("");
	var str = "";
	for(var i = 0; i < data.obj.records.length; i++) {
		str +='<tr>'+
					'<td>'+data.obj.records[i].mrdUserid+'</td>'+
					'<td>'+data.obj.records[i].mrdUsername+'</td>';
		if(data.obj.records[i].mrdProfittype==0){
			var mrdProfittype = "邀请";
		}
		if(data.obj.records[i].mrdProfittype==1){
			var mrdProfittype = "充值";
		}
		if(data.obj.records[i].mrdProfittype==2){
			var mrdProfittype = "支出";
		}
				str	+='<td>'+mrdProfittype+'</td>'+
					'<td>'+data.obj.records[i].mrdTime+'</td>';
		if(data.obj.records[i].mrdIncome==null){
			var mrdIncome = "无";
		}else{
			var mrdIncome = data.obj.records[i].mrdIncome;
		}
		str +='<td>'+mrdIncome+'</td>';
		if(data.obj.records[i].mrdPay==null){
			var mrdPay = "无";
		}else{
			var mrdPay = data.obj.records[i].mrdPay;
		}
					str+='<td>'+mrdPay+'</td>'+
					'<td>'+data.obj.records[i].mrdShare+'</td>'+
					'<td>'+data.obj.records[i].mrdShare+'</td>'+
				'</tr>';
	}
	$("#MarkRecodeList").append(str);
}

function getVipRecordByCommand() {
	var mrdUserid = $("#mrdUserid").val();
	var mrdUsername = $("#mrdUsername").val();
	var mrdProfittype = $("#mrdProfittype").val();
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	if(endTime == "") {
		if(mrdUserid == "" && mrdUsername == "") {
			Config.isClick = true;
			$.ajax({
				type: "get",
				url: "http://localhost:8080/CattleShares/markRecord/getmarkRecodeProfittype",
				async: false,
				data: {
					Profittype: mrdProfittype,
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
				url: "http://localhost:8080/CattleShares/markRecord/getmarkRecodeByCommand",
				async: false,
				data: {
					mrdUserid: mrdUserid,
					mrdUsername: mrdUsername,
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
			url: "http://localhost:8080/CattleShares/markRecord/markRecodeByTime",
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