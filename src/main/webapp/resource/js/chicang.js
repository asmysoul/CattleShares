$(document).ready(function() {
	getLastPurchase();
});

function getLastPurchase(){
	 $("#dataLoad").css("display","block");
	$.ajax({
		type:"get",
		url:"http://120.76.53.251/CattleShares/purchase/getLastPurchase?current=1",
		async:false,
		success: function(data) {
			if(data.success) {
				$("#purchaseList").html("");
				var str = "";
				for (var i = 0;i<data.obj.records.length;i++) {
					str += '<tr>'+
								'<input type="hidden" value="'+data.obj.records[i].purId+'" class=""/>'+
								'<td class=""><input class="code" type="text" name="" id="" value="'+data.obj.records[i].purStockcode+'" /></td>'+
								'<td>'+data.obj.records[i].purStockname+'</td>';
					if(data.obj.records[i].purType==0){
						var purType = "普通用户";
					}
					if(data.obj.records[i].purType==1){
						var purType = "会员用户";
					}
					str +=
								'<td>'+purType+'</td>'+
								'<td><img />'+data.obj.records[i].purPurchasetime+'</td>'+
								'<td>'+data.obj.records[i].purStockprice+'</td>'+
								'<td>'+data.obj.records[i].profit+'</td>'+
								'<td>'+data.obj.records[i].purTechnick+'</td>'+
								'<td>'+
									'<input type="button" name="" id="" value="删除" onclick="deletePurchase(this)" />'+
								'</td>'+
							'</tr>';
				}
				$("#dataLoad").css("display","none");
				$("#purchaseList").append(str);
				
			}
			else{
				$("#dataLoad").css("display","none");
				window.alert('获取失败，请刷新~');
			}
			
		},
		error: function() {
			window.alert('信息提交失败，请耐心重试~');
		}
	});
}


function deletePurchase(obj){
	var truthBeTold = window.confirm("单击“确定”继续。单击“取消”停止。");
	if(truthBeTold) {
		var purId = $(obj).parent().siblings()[0].value;
		$.ajax({
			type: "post",
			url: "http://120.76.53.251/CattleShares/purchase/deletePurchase",
			async: false,
			data: {
				purId:purId
			},
			success: function(data) {
				if(data.success) {
					window.alert('恭喜，删除成功~');
					getLastPurchase();
				}else{
					window.alert('莫名错误，请联系技术人员~');
				}
			},
			error: function() {
				window.alert('信息提交失败，请耐心重试~');
			}
		});
	} else {
		window.alert("再见啦！");
	}
}
