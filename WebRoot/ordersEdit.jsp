<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加销售订单</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript">
$(document).ready(function(){
	
	var num = /^\d+$/;
	var num2 = /^\d+(\.\d+)?$/;
	$("#addBtn").bind('click',function(){
		if($("#goods_id").val()==''){
			alert('商品名称不能为空');
			return;
		}
		if(!num.exec($("#paramsOrders\\.goods_count").val())){
			alert('销售数量必须为数字');
			return;
		}
		if(Number($("#paramsOrders\\.goods_count").val()) > Number($("#goods_countV").val())){
			alert('销售数量不能大于库存数量');
			return;
		}
		if(!num2.exec($("#paramsOrders\\.goods_price").val())){
			alert('销售单价必须为数字');
			return;
		}
		if($("#custom_id").val()==''){
			alert('客户名称不能为空');
			return;
		}
		$("#paramsOrders\\.orders_id").val("");
		$("#info").attr('action','Admin_addOrders.action').submit();
		 
	 });
	
	 var goodss = {};
	 function decodeEntities(s){ 
		    var str, temp= document.createElement('p'); 
		    temp.innerHTML= s; 
		    str= temp.textContent || temp.innerText; 
		    temp=null; 
		    return str; 
	 }
	 <s:if test="#attr.goodss!=null&&#attr.goodss.size()>0">
	 <s:iterator value="#attr.goodss" id="goods">
	 	var goods_id = "<s:property value='#goods.goods_id'/>";
	 	goodss[goods_id] = {};
	 	goodss[goods_id].goods_no = decodeEntities("<s:property value='#goods.goods_no'/>");
	 	goodss[goods_id].goods_name = decodeEntities("<s:property value='#goods.goods_name'/>");
	 	goodss[goods_id].goods_count = decodeEntities("<s:property value='#goods.goods_count'/>");
	 </s:iterator>
	 </s:if>
	 
	 $("#goods_id").change(function(){
		 var goods_idV = $(this).val();
		 if(goods_idV!=""){
			 $("#goods_no").val(goodss[goods_idV].goods_no);
			 $("#goods_name").val(goodss[goods_idV].goods_name);
			 $("#goods_countV").val(goodss[goods_idV].goods_count);
			 $("#goods_count").html(goodss[goods_idV].goods_count);
		 }
	 });
	 
	 $("#custom_id").change(function(){
		 var custom_idV = $(this).val();
		 if(custom_idV!=""){
			 $("#custom_name").val($(this).find("option:selected").text());
		 }
	 });
	 
});
</script>
<style type="text/css">
</style>
</head>
<body>
<div class="pageTitle">
	&nbsp;&nbsp;<img src="images/right1.gif" valign="middle" /> &nbsp;<span id="MainTitle" style="">销售订单管理&gt;&gt;添加销售订单</span>
</div>
<form id="info" name="info" action="Admin_addOrders.action" method="post">   
<s:hidden id="paramsOrders.orders_id" name="paramsOrders.orders_id" value="%{#attr.orders.orders_id}" />
<s:hidden id="paramsOrders.contract_file" name="paramsOrders.contract_file" value="%{#attr.orders.contract_file}" />  
<s:hidden id="paramsOrders.apply_id" name="paramsOrders.apply_id" value="%{#attr.admin.user_id}" /> 
<s:hidden id="paramsOrders.apply_name" name="paramsOrders.apply_name" value="%{#attr.admin.real_name}" /> 
<s:hidden id="custom_name" name="paramsOrders.custom_name" value="" /> 
<s:hidden id="goods_countV" value="0" /> 
<s:hidden id="goods_no" name="paramsOrders.goods_no" value="%{#attr.orders.goods_no}" /> 
<s:hidden id="goods_name" name="paramsOrders.goods_name" value="%{#attr.orders.goods_name}" /> 
<table width="800" align="center" cellpadding="0" cellspacing="0" style="margin-top:10px;margin-bottom:10px;">
  <tr> 
     <td height="24">
       <Table border="0" cellspacing="0" cellpadding="0" align="center" width="100%"> 
            <TR>
              <TD height="24" class="edittitleleft">&nbsp;</TD>
              <TD class="edittitle">添加销售订单</TD>
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
          <td width="200" align="right" style="padding-right:5px"><font color="red">*</font> 商品名称：</td>
          <td>
          	  <s:select list="#attr.goodss" id="goods_id" name="paramsOrders.goods_id" value="%{#attr.orders.goods_id}"
		      		listKey="goods_id" listValue="goods_name" headerKey="" headerValue="请选择"
		      		cssClass="inputstyle" cssStyle="width:155px">
		      </s:select>
          </td>
       </tr> 
       <tr>
          <td align="right" style="padding-right:5px"><font color="red">*</font> 库存数量：</td>
          <td id="goods_count"></td>
       </tr>
       <tr>
          <td align="right" style="padding-right:5px"><font color="red">*</font> 销售数量：</td>
          <td>
          	<s:textfield name="paramsOrders.goods_count" id="paramsOrders.goods_count" value="%{#attr.orders.goods_count}" />
          </td>
       </tr> 
       <tr>
          <td align="right" style="padding-right:5px"><font color="red">*</font> 销售单价：</td>
          <td>
          	<s:textfield name="paramsOrders.goods_price" id="paramsOrders.goods_price" value="%{#attr.orders.goods_price}" />
          </td>
       </tr> 
       <tr>
          <td align="right" style="padding-right:5px"><font color="red">*</font> 客户名称：</td>
          <td>
          	  <s:select list="#attr.customs" id="custom_id" name="paramsOrders.custom_id" value="%{#attr.orders.custom_id}"
		      		listKey="custom_id" listValue="custom_name" headerKey="" headerValue="请选择"
		      		cssClass="inputstyle" cssStyle="width:155px">
		      </s:select>
          </td>
       </tr> 
       <tr>
          <td align="right" style="padding-right:5px"><font color="red">*</font> 付款方式：</td>
          <td>
          	  <s:select list="#{'1':'信用付款', '2':'延期付款', '3':'分期付款', '4':'现金付款'}" 
          	  		id="pay_type" name="paramsOrders.pay_type" value="%{#attr.orders.pay_type}"
		      		listKey="key" listValue="value" emptyOption="false"
		      		cssClass="inputstyle" cssStyle="width:155px">
		      </s:select>
          </td>
       </tr> 
       <tr>
          <td align="right" style="padding-right:5px">合同附件：</td>
          <td>
          	 <span id="userImg"></span>
		     <span id="op" style="display:none"><img src="images/loading001.gif" /></span>
          </td>
       </tr> 
       <tr>
		  <td align="right" style="padding-right:5px">上传文件：</td>
	      <td> 
	          <iframe name="uploadPage" src="uploadImg.jsp" width="100%" height="50" marginheight="0" marginwidth="0" scrolling="no" frameborder="0"></iframe>            
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
          	<input type="button" id="addBtn" Class="btnstyle" value="添 加" />
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