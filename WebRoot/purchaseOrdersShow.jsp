<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>采购订单查询</title>
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
   document.info.action="Admin_listPurchaseOrderss.action";
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
       alert("请至少选择一个要删除的采购订单！");
       return false;
    }
    if(confirm('确认删除吗!?'))
    {
       document.info.action="Admin_delPurchaseOrderss.action?paramsPurchase.ids="+ids;
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
  document.info.action="Admin_listPurchaseOrderss.action";
  document.info.submit();
}
function ChangePage(pagenum)
{
  document.getElementById("pageNo").value=pagenum;
  document.info.action="Admin_listPurchaseOrderss.action";
  document.info.submit();
}
</script>
</head>
<body>
<div class="pageTitle">
	&nbsp;&nbsp;<img src="images/right1.gif" valign="middle" /> &nbsp;<span id="MainTitle" style="">采购订单管理&gt;&gt;采购订单查询</span>
</div>
<form name="info" id="info" action="Admin_listPurchases.action" method="post">
<input type="hidden" name="pageNo" id="pageNo" value="${pageNo}"/>
<table width="95%" align="center" cellpadding="0" cellspacing="0">
  <tr><td colspan="2" height="10px">&nbsp;</td></tr>
  <tr>
    <td width=""></td>
    <td width="" align="right">
            订单编号：
      <input type="text" style="width:100px;" id="paramsPurchase.purchase_no" name="paramsPurchase.purchase_no" 
      		value="${paramsPurchase.purchase_no}" class="inputstyle" Style="width:100px"/>&nbsp;      
            订单日期：
      <s:textfield name="paramsPurchase.orders_dateMin" id="paramsPurchase.orders_dateMin" 
					 value="%{#attr.paramsPurchase.orders_dateMin}"  cssStyle="width:70px"
					 onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>
	  &nbsp;-&nbsp;
	  <s:textfield name="paramsPurchase.orders_dateMax" id="paramsPurchase.orders_dateMax" 
					 value="%{#attr.paramsPurchase.orders_dateMax}"  cssStyle="width:70px"
					 onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/>&nbsp;
	   订单状态：
      <s:select list="#{'1':'待确认', '2':'采购中', '3':'已收货', '4':'待入库', '5':'已入库', '6':'待退货', '7':'已退货' }" 
      		name="paramsPurchase.purchase_flag" value="%{#attr.paramsPurchase.purchase_flag}"
      		listKey="key" listValue="value" headerKey="0" headerValue="请选择"
      		cssClass="inputstyle" cssStyle="width:100px">
      </s:select>&nbsp;
            商品编号：
      <input type="text" style="width:100px;" id="paramsPurchase.goods_no" name="paramsPurchase.goods_no" 
      		value="${paramsPurchase.goods_no}" class="inputstyle" Style="width:100px"/>&nbsp;
            商品名称：
      <input type="text" style="width:100px;" id="paramsPurchase.goods_name" name="paramsPurchase.goods_name" 
      		value="${paramsPurchase.goods_name}" class="inputstyle" Style="width:100px"/>&nbsp;
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
     <td width="" align="center">采购单价</td>
     <td width="" align="center">采购数量</td>
     <td width="" align="center">采购金额</td>
     <td width="200" align="center">供应商</td>
     <td width="" align="center">订单状态</td>
     <td width="" align="center">检验状态</td>
     <td width="85" align="center">操作</td>
   </tr>
   <s:if test="#attr.purchases!=null && #attr.purchases.size()>0">
   <s:iterator value="#attr.purchases" id="purchase" status="status">
   <tr class="<s:if test='(#status.index + 1)%2==0'>list1</s:if><s:else>list0</s:else>" onmouseover="tr_mouseover(this)" onmouseout="tr_mouseout(this)"> 
     <s:if test="#attr.admin.user_type==5">
     <td width="" align="center"><s:checkbox name="chkid" fieldValue="%{#purchase.purchase_id}" cssStyle="vertical-align:text-bottom;"/></td>
     </s:if>
     <td width="" align="center"><s:property value="#status.index+#attr.paramsPurchase.start+1"/></td>
     <td width="" align="center"><s:property value="#purchase.purchase_no"/></td>
     <td width="" align="center"><s:property value="#purchase.orders_dateDesc"/></td>
     <td width="" align="center"><s:property value="#purchase.goods_no"/></td>
     <td width="" align="center"><s:property value="#purchase.goods_name"/></td>
     <td width="" align="center"><s:property value="#purchase.goods_price"/></td>
     <td width="" align="center"><s:property value="#purchase.goods_count"/></td>
     <td width="" align="center"><s:property value="#purchase.purchase_money"/></td>
     <td width="" align="center"><s:property value="#purchase.supplier_name"/></td>
     <td width="" align="center"><s:property value="#purchase.purchase_flagDesc"/></td>
     <td width="" align="center"><s:property value="#purchase.check_flagDesc"/></td>  
     <td width="" align="center">
     	<s:if test="#purchase.purchase_flag!=1">
     		<s:a href="Admin_listLogisticss.action?paramsLogistics.orders_no=%{#purchase.purchase_no}">物流信息<br/></s:a>
     	</s:if>
     	<s:if test="#attr.admin.user_type==4 && #purchase.purchase_flag==1">
     		<s:a href="Admin_updatePurchaseOrders.action?paramsPurchase.purchase_id=%{#purchase.purchase_id}&paramsPurchase.purchase_flag=2">财务确认</s:a>
     	</s:if>
     	<s:elseif test="#attr.admin.user_type==2 && #purchase.purchase_flag==2">
     		<s:a href="Admin_updatePurchaseOrders.action?paramsPurchase.purchase_id=%{#purchase.purchase_id}&paramsPurchase.purchase_flag=3">确认收货</s:a>
     	</s:elseif>
     	<s:elseif test="#attr.admin.user_type==2 && #purchase.purchase_flag==3">
     		<s:a href="Admin_updatePurchaseOrders.action?paramsPurchase.purchase_id=%{#purchase.purchase_id}&paramsPurchase.purchase_flag=4" title="准备入库">检验合格</s:a><br/>
     		<s:a href="Admin_updatePurchaseOrders.action?paramsPurchase.purchase_id=%{#purchase.purchase_id}&paramsPurchase.purchase_flag=6" title="准备退货">检验不合格</s:a>
     	</s:elseif>
     	<s:elseif test="#attr.admin.user_type==1 && #purchase.purchase_flag==4">
     		<s:a href="Admin_updatePurchaseOrders.action?paramsPurchase.purchase_id=%{#purchase.purchase_id}&paramsPurchase.purchase_flag=5">确认入库</s:a>
     	</s:elseif>
     	<s:elseif test="#attr.admin.user_type==2 && #purchase.purchase_flag==6">
     		<s:a href="Admin_updatePurchaseOrders.action?paramsPurchase.purchase_id=%{#purchase.purchase_id}&paramsPurchase.purchase_flag=7">确认退货</s:a>
     	</s:elseif>
     	<s:else>&nbsp;</s:else>
     </td>  
   </tr> 
   </s:iterator>
   </s:if>
   <s:else>
   <tr>
     <td height="60" colspan="15" align="center"><b>&lt;不存在采购订单信息&gt;</b></td>
   </tr>
   </s:else>
   
</table>
<jsp:include page="page.jsp"></jsp:include>
</form> 
</body>
</html>