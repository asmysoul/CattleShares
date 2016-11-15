<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/js/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/js/bootstrap/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/my.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/publishMessage.css" />
		<title>发布消息</title>
		<script>
			var change = function(o) {
				//限制只数字
				o.value = o.value.replace(/\D/g, '').substring(0, 6); //长度限制，7是长度
			};
		</script>
	</head>

	<body>
		<div>
			<div class="content-left">
				<div class="send border">
					<h5>发布内参消息</h5>
					<div class="send-content">
						<div>
							股票代码:<input class="send-text border" oninput="change(this)" onpropertychange="change(this)" type="text" name="" id="rerSharecode" value="" placeholder="请输入股票代码" />
						</div>
						<div class="send-message">
							内参消息:<textarea class="send-textarea border" rows="5" cols="45" type="text" name="" id="fbRerRerinfo" value="" placeholder="请输入消息内容..."></textarea>
						</div>
						<input class="btn btn-color publish"  type="button" value="发布" onclick="pubReference()" />
					</div>
				</div>
				<div class="con-table">
					<table class="table table-hover border">
						<thead>
							<tr class="firstline table-content">
								<th>序号</th>
								<th class="float-l">股票</th>
								<th class="float-l text-content">内参内容</th>
								<th class="float-l">发布时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="publishMessage">
							<!-- <tr class="table-content">
								<td class="number">1</td>
								<td class="text-left">
									<div class="company">奇通公司</div>
									<div class="aaa">123456</div>
								</td>
								<td class="text-left show-content">111111111</td>
								<td class="text-left">
									<div>2016-10-10</div>
									<div>12:12</div>
								</td>
								<td class="number">
									<i class="small-icon small-change" onclick="setdateReference(this)"></i>
									<i class="small-icon small-deleteline" onclick="deleteReference(this)"></i>
								</td>
							</tr> -->
						</tbody>
					</table>
				</div>
			</div>
			<div class="content-right"></div>
		</div>
		<div class="content-fade change-umessage">
			<div class="fade-top">
				<p>修改信息</p>
				<i class="small-icon small-close close"></i>
			</div>
			<input type="hidden" id="hiddenRerSharecode" value="" />
			<div class="fade-content">
				<div>
					<p>内参消息：</p>
					<textarea class="change-neican" cols="30" rows="3" id="rerRerinfo"></textarea>
				</div>
			</div>
			<button class="btn btn-color btn-addconfirm" onclick="updateReference()">
					<i class="small-icon small-ok"></i>
				确定</button>
		</div>
		</div>
		<div class="back"></div>
		<script src="${pageContext.request.contextPath}/resource/js/bootstrap/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resource/js/jquery/jquery-3.0.0.min.js"></script>
		<script src="${pageContext.request.contextPath}/resource/js/publishMessage.js"></script>
	</body>

</html>