<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>管理页面</title>
<meta http-equiv="X-UA-Compatible" content="IE=8"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">  
<script src="js/prototype.lite.js" type="text/javascript"></script>
	<!--超级轻量级的JavaScript的特效库，用来显示折叠菜单-->
<script src="js/moo.fx.js" type="text/javascript"></script>
<script src="js/moo.fx.pack.js" type="text/javascript"></script>

<style type="text/css">
.left{width:190px; height:280px; background-color:#EEF2FB}
table tr td{ font-size:12px; font-family:Arial, Helvetica, sans-serif;}
body {
	font:12px Arial, Helvetica, sans-serif;
	color: #000;
	background-color: #1D1D1D;
	margin: 0px;
}
#container {
	width: 190px;
}
H1 {
	font-size: 12px;
	margin: 0px;
	width: 190px;
	cursor: pointer;
	height: 30px;
	line-height: 20px;	
}
H1 a {
	display: block;
	width: 190px;
	color: white;
	height: 30px;
	text-decoration: none;
	moz-outline-style: none;
	background-image: url(images/menu_bgS2.gif);
	background-repeat: no-repeat;
	line-height: 30px;
	text-align: center;
	margin: 0px;
	padding: 0px;
}
.content{
	width: 190px;
	height: 26px;
	
}
.MM ul {
	list-style-type: none;
	margin: 0px;
	padding: 0px;
	display: block;
}
.MM li {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	list-style-type: none;
	display: block;
	text-decoration: none;
	height: 26px;
	width: 190px;
	padding-left: 0px;
}
.MM {
	width: 190px;
	margin: 0px;
	padding: 0px;
	left: 0px;
	top: 0px;
	right: 0px;
	bottom: 0px;
	clip: rect(0px,0px,0px,0px);
}
.MM a:link {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(images/menu_bg1.gif);
	background-repeat: no-repeat;
	height: 26px;
	width: 190px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}
.MM a:visited {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(images/menu_bg1.gif);
	background-repeat: no-repeat;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 190px;
	text-decoration: none;
}
.MM a:active {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(images/menu_bg1.gif);
	background-repeat: no-repeat;
	height: 26px;
	width: 190px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}
.MM a:hover {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	font-weight: bold;
	color: #006600;
	background-image: url(images/menu_bg2.gif);
	background-repeat: no-repeat;
	text-align: center;
	display: block;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 190px;
	text-decoration: none;
}
</style>
</head>

<body>
<table width="190" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr>
  	<td height="30" style="text-align:center; line-height:30px; color:#BEDFF1; background:url(images/left_title.gif) no-repeat left bottom;font-weight:bold">
  		<img src="images/flag.png" valign="middle" /> &nbsp;功能模块管理
  	</td>
  </tr>
  <tr>
    <td width="190" valign="top" style="background:#fff;">
    	<div class="left">
			 <table width="100%" height="280" border="0" cellpadding="0" cellspacing="0" bgcolor="#1D1D1D">
			  <tr>
				<td width="190" valign="top">
				<div id="container">
				  <h1 class="type"><a href="javascript:void(0)">个人信息中心</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="modifyInfo.jsp" target="MainFrame">个人信息</a></li>
					  <li><a href="modifyPwd.jsp" target="MainFrame">修改密码</a></li>
					</ul>
				  </div>
				  
				  <c:if test="${admin.user_type==5}">
				  <h1 class="type"><a href="javascript:void(0)">用户信息管理</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listUserss.action?paramsUsers.user_type=1" target="MainFrame">库存用户查询</a></li>
					  <li><a href="Admin_addUsersShow.action?paramsUsers.user_type=1" target="MainFrame">新增库存用户</a></li>
					  <li><a href="Admin_listUserss.action?paramsUsers.user_type=2" target="MainFrame">采购用户查询</a></li>
					  <li><a href="Admin_addUsersShow.action?paramsUsers.user_type=2" target="MainFrame">新增采购用户</a></li>
					  <li><a href="Admin_listUserss.action?paramsUsers.user_type=3" target="MainFrame">销售用户查询</a></li>
					  <li><a href="Admin_addUsersShow.action?paramsUsers.user_type=3" target="MainFrame">新增销售用户</a></li>
					  <li><a href="Admin_listUserss.action?paramsUsers.user_type=4" target="MainFrame">财务用户查询</a></li>
					  <li><a href="Admin_addUsersShow.action?paramsUsers.user_type=4" target="MainFrame">新增财务用户</a></li>
					</ul>
				  </div>
				  <h1 class="type"><a href="javascript:void(0)">商品类型管理</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listKinds.action" target="MainFrame">商品类型查询</a></li>
					  <li><a href="Admin_addKindShow.action" target="MainFrame">新增商品类型</a></li>
					</ul>
				  </div>
				  <h1 class="type"><a href="javascript:void(0)">商品信息管理</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listGoodss.action" target="MainFrame">商品信息查询</a></li>
					  <li><a href="Admin_addGoodsShow.action" target="MainFrame">新增商品信息</a></li>
					</ul>
				  </div>
				  <h1 class="type"><a href="javascript:void(0)">客户信息管理</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listCustoms.action" target="MainFrame">客户信息查询</a></li>
					  <li><a href="Admin_addCustomShow.action" target="MainFrame">新增客户信息</a></li>
					</ul>
				  </div>
				  <h1 class="type"><a href="javascript:void(0)">供应商户管理</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listSuppliers.action" target="MainFrame">供应商查询</a></li>
					  <li><a href="Admin_addSupplierShow.action" target="MainFrame">新增供应商</a></li>
					</ul>
				  </div>
				  <h1 class="type"><a href="javascript:void(0)">库存信息管理</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listGoodsStocks.action" target="MainFrame">库存信息查询</a></li>
					</ul>
				  </div>
				  <h1 class="type"><a href="javascript:void(0)">采购申请管理</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listPurchases.action" target="MainFrame">采购申请查询</a></li>
					  <li><a href="Admin_addPurchaseShow.action" target="MainFrame">新增采购申请</a></li>
					</ul>
				  </div>
				  <h1 class="type"><a href="javascript:void(0)">采购订单管理</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listPurchaseOrderss.action" target="MainFrame">采购订单查询</a></li>
					</ul>
				  </div>
				  <h1 class="type"><a href="javascript:void(0)">销售订单管理</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listOrderss.action" target="MainFrame">销售订单查询</a></li>
					  <li><a href="Admin_addOrdersShow.action" target="MainFrame">新增销售订单</a></li>
					</ul>
				  </div>
				  </c:if>
				  
				  <c:if test="${admin.user_type==1}">
				  <h1 class="type"><a href="javascript:void(0)">库存信息管理</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listGoodsStocks.action" target="MainFrame">库存信息查询</a></li>
					</ul>
				  </div>
				  <h1 class="type"><a href="javascript:void(0)">采购申请管理</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listPurchases.action" target="MainFrame">采购申请查询</a></li>
					  <li><a href="Admin_addPurchaseShow.action" target="MainFrame">新增采购申请</a></li>
					</ul>
				  </div>
				  <h1 class="type"><a href="javascript:void(0)">入库信息管理</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listPurchaseOrderss.action" target="MainFrame">采购订单查询</a></li>
					  <li><a href="Admin_listPurchasesSum.action" target="MainFrame">入库商品统计</a></li>
					</ul>
				  </div>
				  <h1 class="type"><a href="javascript:void(0)">销售订单管理</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listOrderss.action" target="MainFrame">销售订单查询</a></li>
					  <li><a href="Admin_listOrderssSum.action" target="MainFrame">销售商品统计</a></li>
					</ul>
				  </div>
				  </c:if>
				  
				  <c:if test="${admin.user_type==2}">
				  <h1 class="type"><a href="javascript:void(0)">供应商户管理</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listSuppliers.action" target="MainFrame">供应商查询</a></li>
					  <li><a href="Admin_addSupplierShow.action" target="MainFrame">新增供应商</a></li>
					</ul>
				  </div>
				  <h1 class="type"><a href="javascript:void(0)">采购申请管理</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listPurchases.action" target="MainFrame">采购申请查询</a></li>
					</ul>
				  </div>
				  <h1 class="type"><a href="javascript:void(0)">采购订单管理</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listPurchaseOrderss.action" target="MainFrame">采购订单查询</a></li>
					</ul>
				  </div>
				  </c:if>
				  
				  <c:if test="${admin.user_type==3}">
				  <h1 class="type"><a href="javascript:void(0)">客户信息管理</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listCustoms.action" target="MainFrame">客户信息查询</a></li>
					  <li><a href="Admin_addCustomShow.action" target="MainFrame">新增客户信息</a></li>
					</ul>
				  </div>
				  <h1 class="type"><a href="javascript:void(0)">库存信息管理</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listGoodsStocks.action" target="MainFrame">库存信息查询</a></li>
					</ul>
				  </div>
				  <h1 class="type"><a href="javascript:void(0)">销售订单管理</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listOrderss.action" target="MainFrame">销售订单查询</a></li>
					  <li><a href="Admin_addOrdersShow.action" target="MainFrame">新增销售订单</a></li>
					</ul>
				  </div>
				  </c:if>
				  
				  <c:if test="${admin.user_type==4}">
				  <h1 class="type"><a href="javascript:void(0)">采购订单管理</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listPurchaseOrderss.action" target="MainFrame">采购订单查询</a></li>
					</ul>
				  </div>
				  <h1 class="type"><a href="javascript:void(0)">销售订单管理</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listOrderss.action" target="MainFrame">销售订单查询</a></li>
					</ul>
				  </div>
				  <h1 class="type"><a href="javascript:void(0)">账目信息统计</a></h1>
				  <div class="content">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><img src="images/menu_topline.gif" width="190" height="5" /></td>
					  </tr>
					</table>
					<ul class="MM">
					  <li><a href="Admin_listPurchasesSum.action" target="MainFrame">采购金额统计</a></li>
					  <li><a href="Admin_listOrderssSum.action" target="MainFrame">销售金额统计</a></li>
					</ul>
				  </div>
				  </c:if>
				  
				  
					<script type="text/javascript">
						var contents = document.getElementsByClassName('content');
						var toggles = document.getElementsByClassName('type');
					
						var myAccordion = new fx.Accordion(
							toggles, contents, {opacity: true, duration: 400}
						);
						myAccordion.showThisHideOpen(contents[0]);
					</script>
				</div>
				</td>
			  </tr>
			</table>       	
        </div>
    </td>
  </tr>
</table>
</body>
</html>
