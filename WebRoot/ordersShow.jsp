<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售订单查询</title>
<link href="css/main.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
var tempClassName="";
function tr_mouseover(obj) 
{ 
	tempClassName=obj.className;
	obj.className="list_mouseover";
}
function tr_mouseout(obj)      
{ 
	obj.className=tempClassName;
}      
function CheckAll(obj) 
{
	var checks=document.getElementsByName("chkid");
    for (var i=0;i<checks.length;i++)
	{
	    var e = checks[i];
	    e.checked = obj.checked;
	}
    
}


function serch()
{
   document.info.action="Admin_listOrderss.action";
   document.info.submit();
}
function del()
{
	var checks=document.getElementsByName("chkid");
    var ids="";
	for (var i=0;i<checks.length;i++)
    {
        var e = checks[i];
		if(e.checked==true)
		{
		  if(ids=="")
		  {
		    ids=ids+e.value;
		  }
		  else
		  {
		    ids=ids+","+e.value;
		  }
		}
    }
    if(ids=="")
    {
       alert("请至少选择一个要删除的销售订单！");
       return false;
    }
    if(confirm('确认删除吗!?'))
    {
       document.info.action="Admin_delOrderss.action?paramsOrders.ids="+ids+"&paramsOrders.delType=3";
       document.info.submit();
    }
    
}
function GoPage()
{
  var pagenum=document.getElementById("goPage").value;
  var patten=/^\d+$/;
  if(!patten.exec(pagenum))
  {
    alert("页码必须为大于0的数字");
    return false;
  }
  document.getElementById("pageNo").value=pagenum;
  document.info.action="Admin_listOrderss.action";
  document.info.submit();
}
function ChangePage(pagenum)
{
  document.getElementById("pageNo").value=pagenum;
  document.info.action="Admin_listOrderss.action";
  document.info.submit();
}
</script>
</head>
<body>
<div class="pageTitle">
	&nbsp;&nbsp;<img src="images/right1.gif" valign="middle" /> &nbsp;<span id="MainTitle" style="">销售订单管理&gt;&gt;销售订单查询</span>
</div>
<form name="info" id="info" action="Admin_listOrderss.action" method="post">
<input type="hidden" name="pageNo" id="pageNo" value="${pageNo}"/>
<table width="95%" align="center" cellpadding="0" cellspacing="0">
  <tr><td colspan="2" height="10px">&nbsp;</td></tr>
  <tr>
    <td width=""></td>
    <td width="" align="right">
            订单编号：
      <input type="text" style="width:100px;" id="paramsOrders.orders_no" name="paramsOrders.orders_no" 
      		value="${paramsOrders.orders_no}" class="inputstyle" Style="width:100px"/>&nbsp;      
            订单日期：
      <s:textfield name="paramsOrders.apply_dateMin" id="paramsOrders.apply_dateMin" 
					 value="%{#attr.paramsOrders.apply_dateMin}"  cssStyle="width:70px"
					 onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>
	  &nbsp;-&nbsp;
	  <s:textfield name="paramsOrders.apply_dateMax" id="paramsOrders.apply_dateMax" 
					 value="%{#attr.paramsOrders.apply_dateMax}"  cssStyle="width:70px"
					 onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>&nbsp;
	   订单状态：
      <s:select list="#{'1':'待出库', '2':'待收货', '3':'已收货', '4':'待收款', '5':'已收款', '6':'待退货', '7':'已退货'}" 
      		name="paramsOrders.orders_flag" value="%{#attr.paramsOrders.orders_flag}"
      		listKey="key" listValue="value" headerKey="0" headerValue="请选择"
      		cssClass="inputstyle" cssStyle="width:100px">
      </s:select>&nbsp;
            商品编号：
      <input type="text" style="width:100px;" id="paramsOrders.goods_no" name="paramsOrders.goods_no" 
      		value="${paramsOrders.goods_no}" class="inputstyle" Style="width:100px"/>&nbsp;
            商品名称：
      <input type="text" style="width:100px;" id="paramsOrders.goods_name" name="paramsOrders.goods_name" 
      		value="${paramsOrders.goods_name}" class="inputstyle" Style="width:100px"/>&nbsp;
      <input type="button" value="搜索" onclick="serch();" class="btnstyle"/>&nbsp;
      <s:if test="#attr.admin.user_type==5">
      <input type="button" value="删除" onclick="del();" class="btnstyle"/>
      </s:if>
    </td>
  </tr>
  <tr><td colspan="2" height="2px"></td></tr>  
</table>
<table width="95%" align="center" class="table_list" cellpadding="0" cellspacing="0">
   <tr class="listtitle">
   	 <s:if test="#attr.admin.user_type==5">
     <td width="40" align="center"><input type="checkbox" onclick="CheckAll(this);" style="vertical-align:text-bottom;" title="全选/取消全选"/></td>
     </s:if>
     <td width="40" align="center">序号</td>
     <td width="" align="center">订单编号</td>
     <td width="" align="center">订单日期</td>
     <td width="" align="center">商品编号</td>
     <td width="120" align="center">商品名称</td>
     <td width="" align="center">销售单价</td>
     <td width="" align="center">销售数量</td>
     <td width="" align="center">金额</td>
     <td width="120" align="center">客户名称</td>
     <td width="" align="center">付款方式</td>
     <td width="" align="center">订单状态</td>
     <td width="85" align="center">操作</td>
   </tr>
   <s:if test="#attr.orderss!=null && #attr.orderss.size()>0">
   <s:iterator value="#attr.orderss" id="orders" status="status">
   <tr class="<s:if test='(#status.index + 1)%2==0'>list1</s:if><s:else>list0</s:else>" onmouseover="tr_mouseover(this)" onmouseout="tr_mouseout(this)"> 
     <s:if test="#attr.admin.user_type==5">
     <td width="" align="center"><s:checkbox name="chkid" fieldValue="%{#orders.orders_id}" cssStyle="vertical-align:text-bottom;"/></td>
     </s:if>
     <td width="" align="center"><s:property value="#status.index+#attr.paramsOrders.start+1"/></td>
     <td width="" align="center"><s:property value="#orders.orders_no"/></td>
     <td width="" align="center"><s:property value="#orders.apply_dateDesc"/></td>
     <td width="" align="center"><s:property value="#orders.goods_no"/></td>
     <td width="" align="center"><s:property value="#orders.goods_name"/></td>
     <td width="" align="center"><s:property value="#orders.goods_price"/></td>
     <td width="" align="center"><s:property value="#orders.goods_count"/></td>
     <td width="" align="center"><s:property value="#orders.orders_money"/></td>
     <td width="" align="center"><s:property value="#orders.custom_name"/></td>  
     <td width="" align="center"><s:property value="#orders.pay_typeDesc"/></td>  
     <td width="" align="center"><s:property value="#orders.orders_flagDesc"/></td>
     <td width="" align="center">
     	<s:if test="#orders.orders_flag!=1">
     		<s:a href="Admin_listLogisticss.action?paramsLogistics.orders_no=%{#orders.orders_no}">物流信息<br/></s:a>
     	</s:if>
     	<s:if test="#orders.contract_file!=null && #orders.contract_file!=''">
     		<s:a href="DownLoad.jsp?fileName=%{#orders.contract_file}" title="下载合同附件">合同附件</s:a><br/>
     	</s:if>
     	
     	<s:if test="#attr.admin.user_type==1 && #orders.orders_flag==1">
     		<s:a href="Admin_confirmOrderss.action?paramsOrders.orders_id=%{#orders.orders_id}&paramsOrders.orders_flag=2">确认出库</s:a>
     	</s:if>
     	<s:elseif test="#attr.admin.user_type==3 && #orders.orders_flag==2">
     		<s:a href="Admin_updateOrdersFlag.action?paramsOrders.orders_id=%{#orders.orders_id}&paramsOrders.orders_flag=3">确认收货</s:a>
     	</s:elseif>
     	<s:elseif test="#attr.admin.user_type==3 && #orders.orders_flag==3">
     		<s:a href="Admin_updateOrdersFlag.action?paramsOrders.orders_id=%{#orders.orders_id}&paramsOrders.orders_flag=4">客户付款</s:a><br/>
     		<s:a href="Admin_updateOrdersFlag.action?paramsOrders.orders_id=%{#orders.orders_id}&paramsOrders.orders_flag=6">客户退货</s:a>
     	</s:elseif>
     	<s:elseif test="#attr.admin.user_type==4 && #orders.orders_flag==4">
     		<s:a href="Admin_updateOrdersFlag.action?paramsOrders.orders_id=%{#orders.orders_id}&paramsOrders.orders_flag=5">确认收款</s:a>
     	</s:elseif>
     	<s:elseif test="#attr.admin.user_type==1 && #orders.orders_flag==6">
     		<s:a href="Admin_updateOrdersFlag.action?paramsOrders.orders_id=%{#orders.orders_id}&paramsOrders.orders_flag=7">确认退货</s:a>
     	</s:elseif>
     	<s:else>&nbsp;</s:else>
     </td>
   </tr> 
   </s:iterator>
   </s:if>
   <s:else>
   <tr>
     <td height="60" colspan="14" align="center"><b>&lt;不存在销售订单信息&gt;</b></td>
   </tr>
   </s:else>
   
</table>
<jsp:include page="page.jsp"></jsp:include>
</form> 
</body>
</html>