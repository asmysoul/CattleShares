<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/js/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/js/bootstrap/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/my.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/js/bootstrap/js/My97DatePickerBeta/My97DatePicker/skin/WdatePicker.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/invite-manage.css" />
		<title>邀请管理</title>
		<style>
.pager{height:30px;line-height:30px;font-size: 12px;margin: 25px 0px;text-align: center;color: #2E6AB1;overflow: hidden;}
.pager a{border:1px solid #9AAFE5;color:#2E6AB1;margin:0px 5px;padding:5px 8px;text-decoration: none;}
.pager a.hover,.pager a.active{background-color:#2E6AB1;border-color:#000080;color:#FFF;}
.pager a.disabled{color:#C8CDD2;cursor:auto;}
</style>
	</head>

	<body>
		<div class="manage-content">
			<div class="search-top">
				邀请人：<input class="usermessage" type="" name="" id="inviUsername" value="" /> 
				注册用户：<input class="usermessage" type="" name="" id="inviAcceptuser" value="" /> 
				<!--会员状态：<input class="usermessage" type="" name="" id="" value="" />--> 
				用户状态：
				<select class="member-select select" id="inviAcceptuserstate">
					<option value="0">未开通</option>
					<option value="1">已开通</option>
					<option value="2">已过期</option>
				</select>
				充值会员时间：
				<input class="Wdate" type="text" name="" id="startTime" value="" onclick="WdatePicker()" />&nbsp;-
				<input class="Wdate" type="text" name="" id="endTime" value="" onclick="WdatePicker()" />
				<button id="search" class="btn btn-color btn-ml" onclick="select()">
					<i class="small-icon small-search"></i>
					查询</button>
			</div>
			<table class="table border">
				<thead>
					<tr class="firstline">
						<th>邀请人</th>
						<th>注册用户</th>
						<th>注册手机</th>
						<th>注册时间</th>
						<th>用户状态</th>
						<th>充值时间</th>
						<th>奖励金币</th>
						<th>奖励积分</th>
					</tr>
				</thead>
				<tbody id="invaiteList">
					<tr>
						<td>123456</td>
						<td>rgrg</td>
						<td>12:12</td>
						<td>rgergre</td>
						<td>ergerg</td>
						<td>普通会员</td>
						<td class="state-color">待处理</td>
						<td>2224</td>
					</tr>
				</tbody>
				<tr>
					<td colspan="12">
						<div class="jqueryPage" id="jqueryPage" style="float: right;">
							
						</div>						
					</td>
				</tr>
			</table>
		</div>

		<script src="${pageContext.request.contextPath}/resource/js/bootstrap/js/bootstrap.min.js"></script>

		<script src="${pageContext.request.contextPath}/resource/js/jquery/jquery-3.0.0.min.js"></script>
		<script src="${pageContext.request.contextPath}/resource/js/invaite-manage.js"></script>
		
		<script src="${pageContext.request.contextPath}/resource/js/bootstrap/js/My97DatePickerBeta/My97DatePicker/WdatePicker.js"></script>
		<script src="${pageContext.request.contextPath}/resource/js/bootstrap/jqueryPage.js"></script>
	</body>

</html>