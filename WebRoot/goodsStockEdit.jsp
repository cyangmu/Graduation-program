<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:if test="#attr.goods!=null && #attr.goods.goods_id!=''">编辑</s:if><s:else>添加</s:else>商品库存信息</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript">
$(document).ready(function(){
	 var num = /^\d+?$/;
	 $("#addBtn").bind('click',function(){
		if(!num.exec($("#paramsGoods\\.goods_count").val())){
			alert('库存数量必须为数字');
			return;
		}
		if(!num.exec($("#paramsGoods\\.max_count").val())){
			alert('最大库存必须为数字');
			return;
		}
		if(!num.exec($("#paramsGoods\\.alarm_count").val())){
			alert('预警库存必须为数字');
			return;
		}
		//$("#paramsGoods\\.goods_id").val(0);
		$("#info").attr('action','Admin_addGoods.action').submit();
		 
	 });
	 
	 $("#editBtn").bind('click',function(){
		if(!num.exec($("#paramsGoods\\.goods_count").val())){
			alert('库存数量必须为数字');
			return;
		}
		if(!num.exec($("#paramsGoods\\.max_count").val())){
			alert('最大库存必须为数字');
			return;
		}
		if(!num.exec($("#paramsGoods\\.alarm_count").val())){
			alert('预警库存必须为数字');
			return;
		}
		$("#info").attr('action','Admin_saveGoodsStock.action').submit();
			 
	});
	
});
</script>
<style type="text/css">
</style>
</head>
<body>
<div class="pageTitle">
	&nbsp;&nbsp;<img src="images/right1.gif" valign="middle" /> &nbsp;<span id="MainTitle" style="">商品库存管理&gt;&gt;<s:if test="#attr.goods!=null && #attr.goods.goods_id!=''">编辑</s:if><s:else>添加</s:else>商品库存</span>
</div>
<form id="info" name="info" action="Admin_addGoods.action" method="post">   
<s:hidden id="paramsGoods.goods_id" name="paramsGoods.goods_id" value="%{#attr.goods.goods_id}" /> 
<table width="800" align="center" cellpadding="0" cellspacing="0" style="margin-top:10px;margin-bottom:10px;">
  <tr> 
     <td height="24">
       <Table border="0" cellspacing="0" cellpadding="0" align="center" width="100%"> 
            <TR>
              <TD height="24" class="edittitleleft">&nbsp;</TD>
              <TD class="edittitle"><s:if test="#attr.goods!=null && #attr.goods.goods_id!=''">编辑</s:if><s:else>添加</s:else>商品库存</TD>
              <TD class="edittitleright">&nbsp;</TD>
            </TR>
        </TABLE>
     </td>
   </tr>
   <tr>
     <td height="1" bgcolor="#8f8f8f"></td>
   </tr>
   <tr>
     <td >
     <table width="100%" align="center" cellpadding="1" cellspacing="1" class="editbody">
      	<tr>
          <td width="35%" align="right" style="padding-right:5px"><font color="red">*</font> 商品编号：</td>
          <td width="65%">
          	<s:property value="#attr.goods.goods_no"/>
          </td>
        </tr> 
        <tr>
          <td width="35%" align="right" style="padding-right:5px"><font color="red">*</font> 商品名称：</td>
          <td width="65%">
          	<s:property value="#attr.goods.goods_name"/>
          </td>
        </tr> 
        <tr>
          <td align="right" style="padding-right:5px"><font color="red">*</font> 商品类型：</td>
          <td>
          	<s:property value="#attr.goods.kind.kind_name"/>
          </td>
        </tr>
        <tr>
          <td align="right" style="padding-right:5px"><font color="red">*</font> 库存数量：</td>
          <td>
          	<s:textfield name="paramsGoods.goods_count" id="paramsGoods.goods_count" value="%{#attr.goods.goods_count}"/>
          </td>
        </tr>
        <tr>
          <td align="right" style="padding-right:5px"><font color="red">*</font> 最大库存：</td>
          <td>
          	<s:textfield name="paramsGoods.max_count" id="paramsGoods.max_count" value="%{#attr.goods.max_count}"/>
          </td>
        </tr> 
        <tr>
          <td align="right" style="padding-right:5px"><font color="red">*</font> 预警库存：</td>
          <td>
          	<s:textfield name="paramsGoods.alarm_count" id="paramsGoods.alarm_count" value="%{#attr.goods.alarm_count}"/>
          </td>
        </tr>  
     </table>
     </td>
   </tr>  
   <tr>
     <td>
       <table width="100%" align="center" cellpadding="0" cellspacing="0" class="editbody">
        <tr class="editbody">
          <td align="center" height="30">
          	<s:if test="#attr.goods!=null && #attr.goods.goods_id!=''">
          	<input type="button" id="editBtn" Class="btnstyle" value="编 辑"/> 
          	</s:if>
          	<s:else>
          	<input type="button" id="addBtn" Class="btnstyle" value="添 加" />
          	</s:else>
            &nbsp;<label style="color:red">${tip}</label>
          </td>
        </tr>
      </table>
     </td>
   </tr>
</table>
</form>
</body>
</html>