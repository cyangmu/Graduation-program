<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:if test="#attr.goods!=null && #attr.goods.goods_id!=''">编辑</s:if><s:else>添加</s:else>商品信息</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript">
$(document).ready(function(){
	 var num = /^\d+?$/;
	 $("#addBtn").bind('click',function(){
		if($("#paramsGoods\\.goods_no").val()==''){
			alert('商品编号不能为空');
			return;
		}
		if($("#paramsGoods\\.goods_name").val()==''){
			alert('商品名称不能为空');
			return;
		}
		if($("#paramsGoods\\.kind\\.kind_id").val()==''){
			alert('商品类型不能为空');
			return;
		}
		if($("#paramsGoods\\.goods_pic").val()==''){
			alert('商品图片不能为空');
			return;
		}
		//$("#paramsGoods\\.goods_id").val(0);
		$("#info").attr('action','Admin_addGoods.action').submit();
		 
	 });
	 
	 $("#editBtn").bind('click',function(){
		if($("#paramsGoods\\.goods_name").val()==''){
			alert('商品名称不能为空');
			return;
		}
		if($("#paramsGoods\\.kind\\.kind_id").val()==''){
			alert('商品类型不能为空');
			return;
		}
		if($("#paramsGoods\\.goods_pic").val()==''){
			alert('商品图片不能为空');
			return;
		}
		$("#info").attr('action','Admin_saveGoods.action').submit();
			 
	});
	
});
</script>
<style type="text/css">
</style>
</head>
<body>
<div class="pageTitle">
	&nbsp;&nbsp;<img src="images/right1.gif" valign="middle" /> &nbsp;<span id="MainTitle" style="">商品管理&gt;&gt;<s:if test="#attr.goods!=null && #attr.goods.goods_id!=''">编辑</s:if><s:else>添加</s:else>商品</span>
</div>
<form id="info" name="info" action="Admin_addGoods.action" method="post">   
<s:hidden id="paramsGoods.goods_id" name="paramsGoods.goods_id" value="%{#attr.goods.goods_id}" /> 
<s:hidden id="paramsGoods.goods_pic" name="paramsGoods.goods_pic" value="%{#attr.goods.goods_pic}" /> 
<table width="800" align="center" cellpadding="0" cellspacing="0" style="margin-top:10px;margin-bottom:10px;">
  <tr> 
     <td height="24">
       <Table border="0" cellspacing="0" cellpadding="0" align="center" width="100%"> 
            <TR>
              <TD height="24" class="edittitleleft">&nbsp;</TD>
              <TD class="edittitle"><s:if test="#attr.goods!=null && #attr.goods.goods_id!=''">编辑</s:if><s:else>添加</s:else>商品</TD>
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
          	<s:if test="#attr.goods!=null && #attr.goods.goods_id!=''">
          	<s:property value="#attr.goods.goods_no"/>
          	</s:if>
          	<s:else>
          	<s:textfield name="paramsGoods.goods_no" id="paramsGoods.goods_no" value="%{#attr.goods.goods_no}"/>
          	</s:else>
          	
          </td>
        </tr> 
        <tr>
          <td align="right" style="padding-right:5px"><font color="red">*</font> 商品名称：</td>
          <td >
          	<s:textfield name="paramsGoods.goods_name" id="paramsGoods.goods_name" value="%{#attr.goods.goods_name}"/>
          </td>
        </tr> 
        <tr>
          <td align="right" style="padding-right:5px"><font color="red">*</font> 商品类型：</td>
          <td>
          	<s:select list="#attr.kinds" id="paramsGoods.kind.kind_id" name="paramsGoods.kind.kind_id" value="%{#attr.goods.kind.kind_id}"
		      		listKey="kind_id" listValue="kind_name" headerKey="" headerValue="请选择"
		      		cssClass="inputstyle" cssStyle="width:155px">
		      </s:select>
          </td>
        </tr>
        <tr>
		  <td align="right" style="padding-right:5px"><font color="red">*</font> 商品图片：</td>
		  <td align="left" height="80">
		    <img id="userPic" src='images/goodss/<s:property value="#attr.goods.goods_pic"/>' height='80'/>
      		&nbsp;<span id="op" style="display:none"><img src="images/loading001.gif" /></span>
	      </td>
	    </tr>
	    <tr>
		  <td align="right" style="padding-right:5px"><font color="red">*</font> 上传图片：</td>
	      <td align="left"> 
	          <iframe name="uploadPage" src="uploadImg2.jsp" width="100%" height="50" marginheight="0" marginwidth="0" scrolling="no" frameborder="0"></iframe>            
	       </td>
	    </tr>
        <tr>
          <td align="right" style="padding-right:5px">商品品牌：</td>
          <td >
          	<s:textfield name="paramsGoods.goods_brand" id="paramsGoods.goods_brand" value="%{#attr.goods.goods_brand}"/>
          </td>
        </tr> 
        <tr>
          <td align="right" style="padding-right:5px">商品材质：</td>
          <td >
          	<s:textfield name="paramsGoods.goods_mate" id="paramsGoods.goods_mate" value="%{#attr.goods.goods_mate}"/>
          </td>
        </tr> 
        <tr>
          <td align="right" style="padding-right:5px">保质期限：</td>
          <td >
          	<s:textfield name="paramsGoods.goods_year" id="paramsGoods.goods_year" value="%{#attr.goods.goods_year}"/>
          </td>
        </tr> 
        <tr>
          <td align="right" style="padding-right:5px">商品说明：</td>
          <td>
          	<s:textarea name="paramsGoods.goods_desc" id="paramsGoods.goods_desc" value="%{#attr.goods.goods_desc}" cssStyle="width:300px;height:60px;">
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