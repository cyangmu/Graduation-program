<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加采购申请</title>
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
		if(!num.exec($("#paramsPurchase\\.goods_count").val())){
			alert('采购数量必须为数字');
			return;
		}
		if(Number($("#paramsPurchase\\.goods_count").val()) > Number($("#max_countV").val())){
			alert('采购数量不能大于最大采购数量');
			return;
		}
		if(!num2.exec($("#paramsPurchase\\.goods_price").val())){
			alert('采购单价必须为数字');
			return;
		}
		if($("#supplier_id").val()==''){
			alert('供应商名称不能为空');
			return;
		}
		$("#paramsPurchase\\.purchase_id").val("");
		$("#info").attr('action','Admin_addPurchase.action').submit();
		 
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
	 	goodss[goods_id].max_count = decodeEntities("<s:property value='#goods.max_count'/>");
	 	goodss[goods_id].purchase_count = Math.max(Number(goodss[goods_id].max_count) - Number(goodss[goods_id].goods_count),0);
	 </s:iterator>
	 </s:if>
	 
	 $("#goods_id").change(function(){
		 var goods_idV = $(this).val();
		 if(goods_idV!=""){
			 $("#goods_no").val(goodss[goods_idV].goods_no);
			 $("#goods_name").val(goodss[goods_idV].goods_name);
			 $("#max_countV").val(goodss[goods_idV].purchase_count);
			 $("#max_count").html(goodss[goods_idV].purchase_count);
		 }
	 });
	 
	 $("#supplier_id").change(function(){
		 var supplier_idV = $(this).val();
		 if(supplier_idV!=""){
			 $("#supplier_name").val($(this).find("option:selected").text());
		 }
	 });
	 
});
</script>
<style type="text/css">
</style>
</head>
<body>
<div class="pageTitle">
	&nbsp;&nbsp;<img src="images/right1.gif" valign="middle" /> &nbsp;<span id="MainTitle" style="">采购申请管理&gt;&gt;添加采购申请</span>
</div>
<form id="info" name="info" action="Admin_addPurchase.action" method="post">   
<s:hidden id="paramsPurchase.purchase_id" name="paramsPurchase.purchase_id" value="%{#attr.purchase.purchase_id}" /> 
<s:hidden id="paramsPurchase.apply_id" name="paramsPurchase.apply_id" value="%{#attr.admin.user_id}" /> 
<s:hidden id="paramsPurchase.apply_name" name="paramsPurchase.apply_name" value="%{#attr.admin.real_name}" /> 
<s:hidden id="supplier_name" name="paramsPurchase.supplier_name" value="" /> 
<s:hidden id="max_countV" value="0" /> 
<s:hidden id="goods_no" name="paramsPurchase.goods_no" value="%{#attr.purchase.goods_no}" /> 
<s:hidden id="goods_name" name="paramsPurchase.goods_name" value="%{#attr.purchase.goods_name}" /> 
<table width="800" align="center" cellpadding="0" cellspacing="0" style="margin-top:10px;margin-bottom:10px;">
  <tr> 
     <td height="24">
       <Table border="0" cellspacing="0" cellpadding="0" align="center" width="100%"> 
            <TR>
              <TD height="24" class="edittitleleft">&nbsp;</TD>
              <TD class="edittitle">添加采购申请</TD>
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
          	  <s:select list="#attr.goodss" id="goods_id" name="paramsPurchase.goods_id" value="%{#attr.purchase.goods_id}"
		      		listKey="goods_id" listValue="goods_name" headerKey="" headerValue="请选择"
		      		cssClass="inputstyle" cssStyle="width:155px">
		      </s:select>
          </td>
       </tr> 
       <tr>
          <td align="right" style="padding-right:5px"><font color="red">*</font> 最大采购数量：</td>
          <td id="max_count"></td>
       </tr>
       <tr>
          <td align="right" style="padding-right:5px"><font color="red">*</font> 采购数量：</td>
          <td>
          	<s:textfield name="paramsPurchase.goods_count" id="paramsPurchase.goods_count" value="%{#attr.purchase.goods_count}" />
          </td>
       </tr> 
       <tr>
          <td align="right" style="padding-right:5px"><font color="red">*</font> 采购单价：</td>
          <td>
          	<s:textfield name="paramsPurchase.goods_price" id="paramsPurchase.goods_price" value="%{#attr.purchase.goods_price}" />
          </td>
       </tr> 
       <tr>
          <td align="right" style="padding-right:5px"><font color="red">*</font> 供应商：</td>
          <td>
          	  <s:select list="#attr.suppliers" id="supplier_id" name="paramsPurchase.supplier_id" value="%{#attr.purchase.supplier_id}"
		      		listKey="supplier_id" listValue="supplier_name" headerKey="" headerValue="请选择"
		      		cssClass="inputstyle" cssStyle="width:155px">
		      </s:select>
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