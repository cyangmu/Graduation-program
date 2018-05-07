<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看商品信息</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>


</head>
<body>
<div class="pageTitle">
	&nbsp;&nbsp;<img src="images/right1.gif" valign="middle" /> &nbsp;<span id="MainTitle" style="">商品管理&gt;&gt;查看商品</span>
</div>
<form id="info" name="info" action="Admin_addGoods.action" method="post">   
<s:hidden id="paramsGoods.goods_id" name="paramsGoods.goods_id" value="#attr.goods.goods_id" /> 
<s:hidden id="paramsGoods.goods_pic" name="paramsGoods.goods_pic" value="#attr.goods.goods_pic" /> 
<table width="800" align="center" cellpadding="0" cellspacing="0" style="margin-top:10px;margin-bottom:10px;">
  <tr> 
     <td height="24">
       <Table border="0" cellspacing="0" cellpadding="0" align="center" width="100%"> 
            <TR>
              <TD height="24" class="edittitleleft">&nbsp;</TD>
              <TD class="edittitle">查看商品</TD>
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
          <td align="right" style="padding-right:5px"><font color="red">*</font> 商品名称：</td>
          <td >
          	<s:property  value="#attr.goods.goods_name"/>
          </td>
        </tr> 
        <tr>
          <td align="right" style="padding-right:5px"><font color="red">*</font> 商品类型：</td>
          <td>
          	<s:property  value="#attr.goods.kind.kind_name"/>
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
          <td align="right" style="padding-right:5px">商品品牌：</td>
          <td >
          	<s:property  value="#attr.goods.goods_brand"/>
          </td>
        </tr> 
        <tr>
          <td align="right" style="padding-right:5px">商品材质：</td>
          <td >
          	<s:property  value="#attr.goods.goods_mate"/>
          </td>
        </tr> 
        <tr>
          <td align="right" style="padding-right:5px">保质期限：</td>
          <td >
          	<s:property  value="#attr.goods.goods_year"/>
          </td>
        </tr> 
        <tr>
          <td align="right" style="padding-right:5px">商品说明：</td>
          <td>
          	<s:property  value="#attr.goods.goods_desc" />
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
          	<input type="button" onclick="window.history.back();" Class="btnstyle" value="返 回"/> 
          </td>
        </tr>
      </table>
     </td>
   </tr>
</table>
</form>
</body>
</html>