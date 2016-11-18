<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/js/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/js/bootstrap/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/fonts/font-awesome.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/my.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/chicang.css" />
		<title></title>

	</head>

	<body class="" style="">
		

		<div class="">
			<div class="content-left">
				<div class="con-table">
					<table class="table border">
						<thead>
							<tr>
								<td colspan="7" style="text-align: left;">当前持仓</td>
							</tr>
							<!--<caption style="color: #000000;">当前持仓</caption>-->

							<tr class="firstline">
								<!--								<th></th>
-->
								<th>股票代码</th>
								<th>股票名称</th>
								<th>推荐类型</th>
								<th>买入时间</th>
								<th>股票价格</th>
								<th>涨幅<img class="topdown" src="${pageContext.request.contextPath}/resource/img/topdown.png" /></th>
								<th>推荐老师</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="purchaseList">
							<!--<tr>
								<input type="hidden" value="" class="" />
								<td class=""><input class="code" type="text" name="" id="" value="121112" /></td>
								<td>rgrg</td>
								<td><img />12:12</td>
								<td>rgergre</td>
								<td>ergerg</td>
								<td>ergerg</td>
								<td>
									<input type="button" name="" id="" value="删除" onclick="deletePurchase(this)" />
								</td>
							</tr>-->
						</tbody>
						<!--<tr>
						<td>
							<label class="checkbox checkbox-inline" for="checkbox2" style="margin-top: 7px;">
                        		<input type="checkbox" value="" id="checkbox2" data-toggle="checkbox" checked="checked">
							</label>
						</td>
						<td class="all" style="padding-top: 14px;border-top: none;">全选</td>
						<td class="btn-focus" colspan="5" style="height: 45px;">
							
						</td>
						
					</tr>-->
					</table>
				</div>
			</div>
			<div class="content-right">

			</div>
		</div>
		
		
		<div id="dataLoad" style="z-index: 900;">
			<!--页面载入显示-->
			<table width=100% height=100% border=0 align=center valign=middle>
				<tr height=50%>
					<td align=center>&nbsp;</td>
				</tr>
				<tr>
					<td align=center>
				</tr>
				<tr>
					<td align=center>数据载入中，请稍后......</td>
				</tr>
				<tr height=50%>
					<td align=center>&nbsp;</td>
				</tr>
			</table>
		</div>
		

		<script src="${pageContext.request.contextPath}/resource/js/bootstrap/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resource/js/jquery/jquery-3.0.0.min.js"></script>
		<script src="${pageContext.request.contextPath}/resource/js/chicang.js"></script>
	</body>

</html>