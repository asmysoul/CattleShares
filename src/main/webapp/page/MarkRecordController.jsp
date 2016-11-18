<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/js/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/js/bootstrap/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/my.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/various-record.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/js/bootstrap/js/My97DatePickerBeta/My97DatePicker/skin/WdatePicker.css" />
		<title></title>
		<style type="text/css">
			.pager {
				height: 30px;
				line-height: 30px;
				font-size: 12px;
				margin: 25px 0px;
				text-align: center;
				color: #2E6AB1;
				overflow: hidden;
			}
			
			.pager a {
				border: 1px solid #9AAFE5;
				color: #2E6AB1;
				margin: 0px 5px;
				padding: 5px 8px;
				text-decoration: none;
			}
			
			.pager a.hover,
			.pager a.active {
				background-color: #2E6AB1;
				border-color: #000080;
				color: #FFF;
			}
			
			.pager a.disabled {
				color: #C8CDD2;
				cursor: auto;
			}
		</style>
	</head>

	<body>
		<div class="content-left">
			<div style="background-color: #f8f8f8;height: 50px;">
				<ul class="nav-top" role="tablist">
					<li id="widthdraw-record" role="presentation" class="tab-click click-style">
						<a href="#">积分记录</a>
					</li>
				</ul>
			</div>

			<div class="search-top">
				账号ID：<input class="usermessage" type="" name="" id="mrdUserid" value="" /> 昵称：
				<input class="usermessage" type="" name="" id="mrdUsername" value="" />
				收益状态：<select class="member-select select" id="mrdProfittype">
				<option value="0">邀请</option>
				<option value="1">充值</option>
				<option value="2">支出</option>
			</select>
				创建时间：
				<!--<input id="txtBeginDate" type="" name="" value="" readonly />—
			<input id="txtEndDate" type="" name="" value="" />-->
				<input class="Wdate" type="text" name="" id="startTime" value="" onclick="WdatePicker()" />&nbsp;-
				<input class="Wdate" type="text" name="" id="endTime" value="" onclick="WdatePicker()" />
				<button id="search" class="btn btn-color" onclick="getVipRecordByCommand()">
							<i class="small-icon small-search"></i>
							查询</button>
			</div>
			<div class="money-content">
				<table class="table border">
					<thead>
						<tr class="firstline">
							<th>账户ID</th>
							<th>账户昵称</th>
							<th>收支类型</th>
							<th>时间</th>
							<th>收入</th>
							<th>支出</th>
							<th>结余</th>
							<th>备注</th>
						</tr>
					</thead>
					<tbody id="MarkRecodeList">
						<tr>
							<td>123456</td>
							<td>rgrg</td>
							<td>12:12</td>
							<td>rgergre</td>
							<td>rgergre</td>
							<td>ergerg</td>
							<td>123456</td>
							<td>rgrg</td>
						</tr>
					</tbody>
					<tr>
						<td colspan="8">
							<div class="jqueryPage" id="jqueryPage" style="float: right;">

							</div>
						</td>
					</tr>
				</table>
			</div>

		</div>

		<script src="${pageContext.request.contextPath}/resource/js/bootstrap/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resource/js/jquery/jquery-3.0.0.min.js"></script>
		<script src="${pageContext.request.contextPath}/resource/js/bootstrap/jqueryPage.js"></script>
		<script src="${pageContext.request.contextPath}/resource/js/MarkRecordController.js"></script>
		<script src="${pageContext.request.contextPath}/resource/js/bootstrap/js/My97DatePickerBeta/My97DatePicker/WdatePicker.js"></script>
	</body>

</html>