<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:if test="#attr.supplier!=null && #attr.supplier.supplier_id!=''">编辑</s:if><s:else>添加</s:else>供应商信息信息</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript">
$(document).ready(function(){
	 var email=/^[\w]+[@]\w+[.][\w]+$/;
     var Phone=/^\d{11}$/;
	 $("#addBtn").bind('click',function(){
		if($("#paramsSupplier\\.supplier_name").val()==''){
			alert('供应商名称不能为空');
			return;
		}
		if($("#paramsSupplier\\.supplier_mail").val()!='' && !email.exec($("#paramsSupplier\\.supplier_mail").val())){
			alert('供应商邮箱格式不正确');
			return;
		}
		if($("#paramsSupplier\\.supplier_phone").val()!='' && !Phone.exec($("#paramsSupplier\\.supplier_phone").val())){
			alert('供应商电话格式不正确');
			return;
		}
		$("#paramsSupplier\\.supplier_id").val("");
		$("#info").attr('action','Admin_addSupplier.action').submit();
		 
	 });
	 
	 $("#editBtn").bind('click',function(){
		if($("#paramsSupplier\\.supplier_name").val()==''){
			alert('供应商名称不能为空');
			return;
		}
		if($("#paramsSupplier\\.supplier_mail").val()!='' && !email.exec($("#paramsSupplier\\.supplier_mail").val())){
			alert('供应商邮箱格式不正确');
			return;
		}
		if($("#paramsSupplier\\.supplier_phone").val()!='' && !Phone.exec($("#paramsSupplier\\.supplier_phone").val())){
			alert('供应商电话格式不正确');
			return;
		}
		$("#info").attr('action','Admin_saveSupplier.action').submit();
			 
	});
	
});
</script>
<style type="text/css">
</style>
</head>
<body>
<div class="pageTitle">
	&nbsp;&nbsp;<img src="images/right1.gif" valign="middle" /> &nbsp;<span id="MainTitle" style="">供应商信息管理&gt;&gt;<s:if test="#attr.supplier!=null && #attr.supplier.supplier_id!=''">编辑</s:if><s:else>添加</s:else>供应商信息</span>
</div>
<form id="info" name="info" action="Admin_addSupplier.action" method="post">   
<s:hidden id="paramsSupplier.supplier_id" name="paramsSupplier.supplier_id" value="%{#attr.supplier.supplier_id}" /> 
<table width="800" align="center" cellpadding="0" cellspacing="0" style="margin-top:10px;margin-bottom:10px;">
  <tr> 
     <td height="24">
       <Table border="0" cellspacing="0" cellpadding="0" align="center" width="100%"> 
            <TR>
              <TD height="24" class="edittitleleft">&nbsp;</TD>
              <TD class="edittitle"><s:if test="#attr.supplier!=null && #attr.supplier.supplier_id!=''">编辑</s:if><s:else>添加</s:else>供应商信息</TD>
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
          <td width="35%" align="right" style="padding-right:5px"><font color="red">*</font> 供应商名称：</td>
          <td width="65%">
          	<s:textfield name="paramsSupplier.supplier_name" id="paramsSupplier.supplier_name" value="%{#attr.supplier.supplier_name}"/>
          </td>
        </tr> 
        <tr>
          <td width="35%" align="right" style="padding-right:5px">供应商邮箱：</td>
          <td width="65%">
          	<s:textfield name="paramsSupplier.supplier_mail" id="paramsSupplier.supplier_mail" value="%{#attr.supplier.supplier_mail}"/>
          </td>
        </tr> 
        <tr>
          <td width="35%" align="right" style="padding-right:5px">供应商电话：</td>
          <td width="65%">
          	<s:textfield name="paramsSupplier.supplier_phone" id="paramsSupplier.supplier_phone" value="%{#attr.supplier.supplier_phone}"/>
          </td>
        </tr> 
        <tr>
          <td width="35%" align="right" style="padding-right:5px">供应商地址：</td>
          <td width="65%">
          	<s:textfield name="paramsSupplier.supplier_address" id="paramsSupplier.supplier_address" value="%{#attr.supplier.supplier_address}" cssStyle="width:300px;"/>
          </td>
        </tr> 
        <tr>
          <td width="35%" align="right" style="padding-right:5px">备注：</td>
          <td width="65%">
          	<s:textarea name="paramsSupplier.supplier_note" id="paramsSupplier.supplier_note" value="%{#attr.supplier.supplier_note}" cssStyle="width:300px;height:60px;">
          	</s:textarea>
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
          	<s:if test="#attr.supplier!=null && #attr.supplier.supplier_id!=''">
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