<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:if test="#attr.custom!=null && #attr.custom.custom_id!=''">编辑</s:if><s:else>添加</s:else>客户信息信息</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript">
$(document).ready(function(){
	 
	 var email=/^[\w]+[@]\w+[.][\w]+$/;
     var Phone=/^\d{11}$/;
	 $("#addBtn").bind('click',function(){
		if($("#paramsCustom\\.custom_name").val()==''){
			alert('客户名称不能为空');
			return;
		}
		if($("#paramsCustom\\.custom_mail").val()!='' && !email.exec($("#paramsCustom\\.custom_mail").val())){
			alert('客户邮箱格式不正确');
			return;
		}
		if($("#paramsCustom\\.custom_phone").val()!='' && !Phone.exec($("#paramsCustom\\.custom_phone").val())){
			alert('联系电话格式不正确');
			return;
		}
		$("#paramsCustom\\.custom_id").val("");
		$("#info").attr('action','Admin_addCustom.action').submit();
		 
	 });
	 
	 $("#editBtn").bind('click',function(){
		if($("#paramsCustom\\.custom_name").val()==''){
			alert('客户名称不能为空');
			return;
		}
		if($("#paramsCustom\\.custom_mail").val()!='' && !email.exec($("#paramsCustom\\.custom_mail").val())){
			alert('客户邮箱格式不正确');
			return;
		}
		if($("#paramsCustom\\.custom_phone").val()!='' && !Phone.exec($("#paramsCustom\\.custom_phone").val())){
			alert('联系电话格式不正确');
			return;
		}
		$("#info").attr('action','Admin_saveCustom.action').submit();
			 
	});
	
});
</script>
<style type="text/css">
</style>
</head>
<body>
<div class="pageTitle">
	&nbsp;&nbsp;<img src="images/right1.gif" valign="middle" /> &nbsp;<span id="MainTitle" style="">客户信息管理&gt;&gt;<s:if test="#attr.custom!=null && #attr.custom.custom_id!=''">编辑</s:if><s:else>添加</s:else>客户信息</span>
</div>
<form id="info" name="info" action="Admin_addCustom.action" method="post">   
<s:hidden id="paramsCustom.custom_id" name="paramsCustom.custom_id" value="%{#attr.custom.custom_id}" /> 
<table width="800" align="center" cellpadding="0" cellspacing="0" style="margin-top:10px;margin-bottom:10px;">
  <tr> 
     <td height="24">
       <Table border="0" cellspacing="0" cellpadding="0" align="center" width="100%"> 
            <TR>
              <TD height="24" class="edittitleleft">&nbsp;</TD>
              <TD class="edittitle"><s:if test="#attr.custom!=null && #attr.custom.custom_id!=''">编辑</s:if><s:else>添加</s:else>客户信息</TD>
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
          <td width="35%" align="right" style="padding-right:5px"><font color="red">*</font> 客户名称：</td>
          <td width="65%">
          	<s:textfield name="paramsCustom.custom_name" id="paramsCustom.custom_name" value="%{#attr.custom.custom_name}"/>
          </td>
        </tr> 
        <tr>
          <td width="35%" align="right" style="padding-right:5px">客户邮箱：</td>
          <td width="65%">
          	<s:textfield name="paramsCustom.custom_mail" id="paramsCustom.custom_mail" value="%{#attr.custom.custom_mail}"/>
          </td>
        </tr> 
        <tr>
          <td width="35%" align="right" style="padding-right:5px">客户电话：</td>
          <td width="65%">
          	<s:textfield name="paramsCustom.custom_phone" id="paramsCustom.custom_phone" value="%{#attr.custom.custom_phone}"/>
          </td>
        </tr> 
        <tr>
          <td width="35%" align="right" style="padding-right:5px">客户地址：</td>
          <td width="65%">
          	<s:textfield name="paramsCustom.custom_address" id="paramsCustom.custom_address" value="%{#attr.custom.custom_address}" cssStyle="width:300px;"/>
          </td>
        </tr> 
        <tr>
          <td width="35%" align="right" style="padding-right:5px">备注：</td>
          <td width="65%">
          	<s:textarea name="paramsCustom.custom_note" id="paramsCustom.custom_note" value="%{#attr.custom.custom_note}" cssStyle="width:300px;height:60px;">
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
          	<s:if test="#attr.custom!=null && #attr.custom.custom_id!=''">
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