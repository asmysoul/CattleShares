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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/withdraw-manage.css" />
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
		<div class="manage-content">
			<div class="search-top">
				账号ID：<input class="usermessage" type="" name="" id="selectRrdUserid" value="" />
				昵称：<input class="usermessage" type="" name="" id="selectRrdUsername" value="" />
				记录状态：<select class="member-select select" id="selectRrdState">
					<option value="0">待处理</option>
					<option value="1">已处理</option>
				</select>
				创建时间：
				<!--<input id="txtBeginDate" type="" name="" value="" readonly />—
				<input id="txtEndDate" type="" name="" value="" />-->
				<input class="Wdate" type="text" name="" id="startTime" value="" onclick="WdatePicker()"/>&nbsp;-
				<input class="Wdate" type="text" name="" id="endTime" value="" onclick="WdatePicker()"/>
				<button id="search" class="btn btn-color btn-ml" onclick="selectReflectByCommand()">
					<i class="small-icon small-search"></i>
					查询</button>
				<button id="export" class="btn btn-color btn-ml">
					<i class="small-icon small-export"></i>
					导出</button>
				<button id="inport" class="btn btn-color btn-ml">
					<i class="small-icon small-inport"></i>
					导入</button>
			</div>
			<table class="table border">
				<thead>
				<tr class="firstline">
					<th>申请时间</th>
					<th>账号ID</th>
					<th>账号昵称</th>
					<th>申请金额</th>
					<th>账户类型</th>
					<th>账号</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody id="ReflectManagerList">
				
				</tbody>
				<tr>
					<td colspan="5">
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
				<input id="rrdId" type="hidden" value=""/>
				<input id="hiddenRrdPrice" type="hidden" value=""/>
				<input id="hiddenUserId" type="hidden" value=""/>
				<div>
					<p>姓名：</p>
					<span id="rrdUsername"></span>
				</div>
				<div>
					<p>账户类型：</p>
					<span id="accountType"></span>
				</div>
				<div>
					<p>提现账户：</p>
					<span id="reflectAccount"></span>
				</div>
				<div>
					<p>提现金额：</p>
					<input class="input-style" type="text" name="" id="rrdPrice" value="" />
				</div>
				<button class="btn btn-color btn-addconfirm" onclick="Update_UserInfo()">
					<i class="small-icon small-ok"></i>
				确定</button>
			</div>
		</div>
		<div class="back"></div>
		<script src="${pageContext.request.contextPath}/resource/js/bootstrap/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resource/js/jquery/jquery-3.0.0.min.js"></script>
		<script src="${pageContext.request.contextPath}/resource/js/bootstrap/js/My97DatePickerBeta/My97DatePicker/WdatePicker.js"></script>
		<script src="${pageContext.request.contextPath}/resource/js/withdraw-manage.js"></script>
		<script src="${pageContext.request.contextPath}/resource/js/bootstrap/jqueryPage.js"></script>
	</body>
</html>
		