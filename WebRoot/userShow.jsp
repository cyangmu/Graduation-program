<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="#attr.user_typeDesc" />信息</title>
<link href="css/main.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
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
   document.info.action="Admin_listUserss.action";
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
       alert("请至少选择一个要删除的用户！");
       return false;
    }
    if(confirm('确认删除吗!?'))
    {
       document.info.action="Admin_delUserss.action?paramsUsers.ids="+ids;
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
  document.info.action="Admin_listUserss.action";
  document.info.submit();
}
function ChangePage(pagenum)
{
  document.getElementById("pageNo").value=pagenum;
  document.info.action="Admin_listUserss.action";
  document.info.submit();
}
</script>
</head>
<body>
<div class="pageTitle">
	&nbsp;&nbsp;<img src="images/right1.gif" valign="middle" /> &nbsp;<span id="MainTitle" style=""><s:property value="#attr.user_typeDesc"/>管理&gt;&gt;<s:property value="#attr.user_typeDesc"/>查询</span>
</div>
<form name="info" id="info" action="Admin_listUsers.action" method="post">
<input type="hidden" name="pageNo" id="pageNo" value="${pageNo}"/>
<s:hidden name="paramsUsers.user_type" value="%{#attr.user_type}"/>
<table width="95%" align="center" cellpadding="0" cellspacing="0">
  <tr><td colspan="2" height="10px">&nbsp;</td></tr>
  <tr>
    <td width=""><s:property value="#attr.user_typeDesc"/>列表</td>
    <td width="" align="right">
            用户名：
      <input type="text" id="paramsUsers.user_name" name="paramsUsers.user_name" value="${paramsUsers.user_name}" class="inputstyle"/>&nbsp;
            姓名：
      <input type="text" id="paramsUsers.real_name" name="paramsUsers.real_name" value="${paramsUsers.real_name}" class="inputstyle"/>&nbsp;&nbsp;
      <input type="button" value="搜索" onclick="serch();" class="btnstyle"/>&nbsp;
      <input type="button" value="删除" onclick="del();" class="btnstyle"/>
    </td>
  </tr>
  <tr><td colspan="2" height="2px"></td></tr>  
</table>
<table width="95%" align="center" class="table_list" cellpadding="0" cellspacing="0">
   <tr class="listtitle">
     <td width="40" align="center"><input type="checkbox" onclick="CheckAll(this);" style="vertical-align:text-bottom;" title="全选/取消全选"/></td>
     <td width="40" align="center">序号</td>
     <td width="" align="center">用户名</td>
     <td width="" align="center">姓名</td>
     <td width="" align="center">性别</td>
     <td width="" align="center">邮箱</td>
     <td width="" align="center">电话</td>
     <td width="" align="center">添加时间</td>
     <td width="" align="center">操作</td>
   </tr>
   <s:if test="#attr.userss!=null && #attr.userss.size()>0">
   <s:iterator value="#attr.userss" id="user" status="status">
   <tr class="<s:if test='(#status.index + 1)%2==0'>list1</s:if><s:else>list0</s:else>" onmouseover="tr_mouseover(this)" onmouseout="tr_mouseout(this)"> 
     <td width="" align="center"><s:checkbox name="chkid" fieldValue="%{#user.user_id}" cssStyle="vertical-align:text-bottom;"/></td>
     <td width="" align="center"><s:property value="#status.index+#attr.paramsUsers.start+1"/></td>
     <td width="" align="center"><s:property value="#user.user_name"/></td>
     <td width="" align="center"><s:property value="#user.real_name"/></td>
     <td width="" align="center"><s:property value="#user.user_sexDesc"/></td>
     <td width="" align="center"><s:property value="#user.user_mail"/>&nbsp;</td>
     <td width="" align="center"><s:property value="#user.user_phone"/></td>
     <td width="" align="center"><s:property value="#user.reg_dateDesc"/></td>  
     <td width="" align="center">
       <img src="images/edit.png"/>&nbsp;<s:a href="Admin_editUsers.action?paramsUsers.user_id=%{#user.user_id}&paramsUsers.user_type=%{#user.user_type}">编辑</s:a>
     </td>
   </tr> 
   </s:iterator>
   </s:if>
   <s:else>
   <tr>
     <td height="60" colspan="11" align="center"><b>&lt;不存在用户信息&gt;</b></td>
   </tr>
   </s:else>
   
</table>
<jsp:include page="page.jsp"></jsp:include>
</form> 
</body>
</html>