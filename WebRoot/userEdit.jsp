<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:if test="#attr.user!=null && #attr.user.user_id!=''">编辑</s:if><s:else>添加</s:else><s:property value="#attr.user_typeDesc"/>信息</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript">
$(document).ready(function(){
	 var user_sex = "<s:property value='#attr.user.user_sex' />";
	 if(user_sex!=''){
		 $("#sex"+user_sex).attr('checked','checked');
	 }else{
		 $("#sex1").attr('checked','checked');
	 }
	 
	 var num = /^\d+$/;
	 var email=/^[\w]+[@]\w+[.][\w]+$/;
     var Phone=/^\d{11}$/;
	 $("#addBtn").bind('click',function(){
		if($("#paramsUsers\\.user_name").val()==''){
			alert('用户名为空');
			return;
		}
		if($("#paramsUsers\\.user_pass").val()==''){
			alert('密码不能为空');
			return;
		}
		if($("#paramsUsers\\.real_name").val()==''){
			alert('姓名不能为空');
			return;
		}
		if($("#paramsUsers\\.user_mail").val()!='' && !email.exec($("#paramsUsers\\.user_mail").val())){
			alert('邮箱格式不正确');
			return;
		}
		if($("#paramsUsers\\.user_phone").val()!='' && !Phone.exec($("#paramsUsers\\.user_phone").val())){
			alert('电话格式不正确');
			return;
		}
		//$("#paramsUsers\\.user_id").val(0);
		$("#info").attr('action','Admin_addUsers.action').submit();
		 
	 });
	 
	 $("#editBtn").bind('click',function(){
		if($("#paramsUsers\\.user_name").val()==''){
			alert('用户名为空');
			return;
		}
		if($("#paramsUsers\\.real_name").val()==''){
			alert('姓名不能为空');
			return;
		}
		if($("#paramsUsers\\.user_mail").val()!='' && !email.exec($("#paramsUsers\\. ").val())){
			alert('邮箱格式不正确');
			return;
		}
		if($("#paramsUsers\\.user_phone").val()!='' && !Phone.exec($("#paramsUsers\\.user_phone").val())){
			alert('电话格式不正确');
			return;
		}
		$("#info").attr('action','Admin_saveUsers.action').submit();
			 
	});
	
});
</script>
<style type="text/css">
</style>
</head>
<body>
<div class="pageTitle">
	&nbsp;&nbsp;<img src="images/right1.gif" valign="middle" /> &nbsp;<span id="MainTitle" style=""><s:property value="#attr.user_typeDesc"/>管理&gt;&gt;<s:if test="#attr.user!=null && #attr.user.user_id!=''">编辑</s:if><s:else>添加</s:else><s:property value="#attr.user_typeDesc"/></span>
</div>
<form id="info" name="info" action="Admin_addUsers.action" method="post">   
<s:hidden id="paramsUsers.user_id" name="paramsUsers.user_id" value="%{#attr.user.user_id}" /> 
<s:hidden name="paramsUsers.user_type" value="%{#attr.user_type}"/>
<table width="800" align="center" cellpadding="0" cellspacing="0" style="margin-top:10px;margin-bottom:10px;">
  <tr> 
     <td height="24">
       <Table border="0" cellspacing="0" cellpadding="0" align="center" width="100%"> 
            <TR>
              <TD height="24" class="edittitleleft">&nbsp;</TD>
              <TD class="edittitle"><s:if test="#attr.user!=null && #attr.user.user_id!=''">编辑</s:if><s:else>添加</s:else><s:property value="#attr.user_typeDesc"/></TD>
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
          <td width="15%" align="right" style="padding-right:5px"><font color="red">*</font> 用户名：</td>
          <td width="35%" >
          	<s:if test="#attr.user!=null && #attr.user.user_id!=''"><s:property value="#attr.user.user_name" /></s:if>
          	<s:else><s:textfield name="paramsUsers.user_name" id="paramsUsers.user_name" value="%{#attr.user.user_name}"/> </s:else>
          </td>
          <td align="right" style="padding-right:5px"><font color="red">*</font> 密码：</td>
          <td>
            <s:if test="#attr.user!=null && #attr.user.user_id!=''">
          	<s:password name="paramsUsers.user_pass" id="paramsUsers.user_pass" value=""  showPassword="true"/>
          	</s:if>
          	<s:else>
          	<s:password name="paramsUsers.user_pass" id="paramsUsers.user_pass" value="111111"  showPassword="true"/>
          	<span id="passTip" style="color:red;">初始密码：111111</span>
          	</s:else>
          </td>
        </tr> 
        <tr>
          <td align="right" style="padding-right:5px"><font color="red">*</font> 姓名：</td>
          <td>
            <s:textfield name="paramsUsers.real_name" id="paramsUsers.real_name" value="%{#attr.user.real_name}"/>
          </td>
          <td align="right" style="padding-right:5px"><font color="red">*</font> 性别：</td>
          <td>
            <input type="radio" id="sex1" name="paramsUsers.user_sex" value="1"/>男&nbsp;&nbsp;
            <input type="radio" id="sex2" name="paramsUsers.user_sex" value="2"/>女
          </td>
        </tr>   
        <tr>
          <td align="right" style="padding-right:5px">邮箱：</td>
          <td>
            <s:textfield name="paramsUsers.user_mail" id="paramsUsers.user_mail" value="%{#attr.user.user_mail}"/>
          </td> 
          <td align="right" style="padding-right:5px">电话：</td>
          <td>
          	<s:textfield name="paramsUsers.user_phone" id="paramsUsers.user_phone" value="%{#attr.user.user_phone}"/>
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
          	<s:if test="#attr.user!=null && #attr.user.user_id!=''">
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