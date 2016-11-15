<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/js/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/js/bootstrap/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/fonts/font-awesome.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/my.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/js/bootstrap/js/My97DatePickerBeta/My97DatePicker/skin/WdatePicker.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/member-account.css" />
		<title>会员账户</title>
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
				账号ID：<input class="usermessage" type="" name="" id="selectUserId" value="" /> 姓名：
				<input class="usermessage" type="" name="" id="selectUserName" value="" /> 账户类型：
				<select class="member-select select" id="selectAccountType">
					<option value="0">财付通</option>
					<option value="1">支付宝</option>
					<option value="2">银行卡</option>
				</select>
				创建时间：
				<!--<input id="txtBeginDate" type="" name="" value="" readonly />—
				<input id="txtEndDate" type="" name="" value="" />-->
				<input class="Wdate" type="text" name="" id="startTime" value="" onclick="WdatePicker()" />&nbsp;-
				<input class="Wdate" type="text" name="" id="endTime" value="" onclick="WdatePicker()" />
				<button id="search" class="btn btn-color" onclick="getSelectUserByType()">
								<i class="small-icon small-search" ></i>
								查询</button>
			</div>
			<table class="table border">
				<thead>
					<tr class="firstline">
						<th>账号ID</th>
						<th>账户姓名</th>
						<th>账户类型</th>
						<th>提现账户</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="accountList">
					<!--<tr>

						<td>4</td>

						<td>gy</td>

						<td>其他类型</td>

						<td>123456789</td>

						<td>

							<i class="small-icon small-change" onclick="Set_VIPUserInfo(this)"></i>

						</td>

					</tr>-->
				</tbody>
				<tr>
					<td colspan="12">
						<div class="jqueryPage" id="jqueryPage" style="float: right;">
						</div>						
					</td>
				</tr>
			</table>
		</div>
		<div class="content-fade change-umessage">
			<div class="fade-top">
				<p>修改信息</p>
				<i class="small-icon small-close close"></i>
			</div>
			<div class="fade-content">
				<input type="hidden" id="hiddenUserId" value=""/>
				<div>
					<p>姓名：</p>
					<span id="userName">sldf</span>
				</div>
				<div>
					<p>账户类型：</p>
					<select class="account-type select" id="upDataAccountType">
						<option value="3">--请选择--</option>
						<option value="0">支付宝</option>
						<option value="1">财付通</option>
						<option value="2">银行卡</option>
					</select>
				</div>
				<div>
					<p>提现账户：</p>
					<input class="input-style" type="text" name="" id="reflectAccount" value="" />
				</div>
				<div class="bank">
					<div>
						<p>银行：</p>
						<select class="select">
							<option>工商</option>
							<option>招商</option>
							<option>邮政储蓄</option>
						</select>
					</div>
					<div>
						<p>银行卡号：</p>
						<input class="input-style" type="text" name="" id="" value="" />
					</div>
				</div>
				<button class="btn btn-color btn-addconfirm" onclick="Update_VIPUserInfo()">
					<i class="small-icon small-ok"></i>
				确定</button>
			</div>
		</div>
		<div class="back"></div>
		<script src="${pageContext.request.contextPath}/resource/js/bootstrap/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resource/js/jquery/jquery-3.0.0.min.js"></script>
		<script src="${pageContext.request.contextPath}/resource/js/bootstrap/js/My97DatePickerBeta/My97DatePicker/WdatePicker.js"></script>
		<script src="${pageContext.request.contextPath}/resource/js/member-account.js"></script>
		<script src="${pageContext.request.contextPath}/resource/js/bootstrap/jqueryPage.js"></script>
	</body>

</html>