$(document).ready(function() {
	getAllReference();
});

//获取所有内参
function getAllReference() {
	$.ajax({
		type: "get",
		url: "http://localhost:8080/CattleShares/reference/getAllReference",
		async: false,
		data: {
			current:1
		},
		success: function(data) {
			if(data.success) {
				$('#publishMessage').html("");
				var str = "";
				for(var i = 0; i<data.obj.records.length ; i++) {
					str += '<tr class="table-content"><td class="number">' + data.obj.records[i].rerId+ '</td>' +
						'<td class="text-left"><div class="company">'+data.obj.records[i].rerStockname+'</div><div>'+data.obj.records[i].rerSharecode+'</div></td>' +
						'<td class="text-left show-content">'+data.obj.records[i].rerRerinfo+'</td><td class="text-left"><div>'+data.obj.records[i].rerPubtime+'</div><div>12:12</div></td>' +
						'<td class="number"><i class="small-icon small-change" onclick="setdateReference(this)"></i><i class="small-icon small-deleteline" onclick="deleteReference(this)"></i></td></tr>';
				}
				$("#publishMessage").append(str);
			}
		},
		error: function() {
			window.alert('请求失败，请重试~');
		}
	});
}
$(".close").click(function() {
	$('.content-fade').slideUp();
	$('.back').fadeOut();
})

//修改时获取参数
function setdateReference(obj) {
	$(".change-umessage").slideDown();
	$(".back").fadeIn();
	$("#hiddenRerSharecode").val($(obj).parent().siblings()[0].innerText);
	$("#rerRerinfo").val($(obj).parent().siblings()[2].innerText);
}
//修改确定事件
function updateReference() {
	var rerSharecode = $("#hiddenRerSharecode").val();
	var rerRerinfo = $("#rerRerinfo").val();
	alert(rerSharecode);
	alert(rerRerinfo);
	$.ajax({
		type: "post",
		url: "http://localhost:8080/CattleShares/reference/updateReference",
		async: true,
		data: {
			rerRerinfo: rerRerinfo,
			rerId: rerSharecode
		},
		success: function(data) {
			if(data.success) {
				window.alert('恭喜，修改成功~');
				$('.content-fade').slideUp();
				$('.back').fadeOut();
				getAllReference();
			}
		},
		error: function() {
			window.alert('信息提交失败，请耐心重试~');
		}
	});
}

function deleteReference(obj) {
	var truthBeTold = window.confirm("单击“确定”继续。单击“取消”停止。");
	if(truthBeTold) {
		var rerSharecode = $(obj).parent().siblings()[0].innerText;
		$.ajax({
			type: "post",
			url: "http://localhost:8080/CattleShares/reference/deleteReference",
			async: false,
			data: {
				rerId: rerSharecode
			},
			success: function(data) {
				if(data.success) {
					alert('恭喜，删除成功~');
					$('.content-fade').slideUp();
					$('.back').fadeOut();
					getAllReference();
				}
			},
			error: function() {
				alert('信息提交失败，请耐心重试~');
			}
		});
	} else {
		window.alert("再见啦！");
	}
}

function pubReference() {
	var rerSharecode = $("#rerSharecode").val();
	var fbRerRerinfo = $("#fbRerRerinfo").val().trim();
	if(rerSharecode == "") {
		window.alert("请填写股票代码~");
		return;
	} else if(rerSharecode.length != 6) {
		window.alert("股票代码长度有误，请检查~");
		return;
	} else {;
	}
	if(fbRerRerinfo == "") {
		window.alert("请填写内参信息~");
		return;
	}
	$.ajax({
		type: "post",
		url: "http://localhost:8080/CattleShares/reference/pubReference",
		async: true,
		data: {
			rerSharecode: rerSharecode,
			rerRerinfo: fbRerRerinfo,
		},
		success: function(data) {
			if(data.success) {
				alert('恭喜，发布成功~');
				$("#rerSharecode").val("");
				$("#fbRerRerinfo").val("");
				getAllReference();
			}
			else{
				alert(data.msg);
			}
		},
		error: function() {
			alert("信息提交失败，请耐心重试~");
		}
	});
}