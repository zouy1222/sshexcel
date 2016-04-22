<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/> 
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/css.css" type="text/css"></link>
	<script type="text/javascript" src="js/jquery-1.8.1.js"></script>
	<script type="text/javascript" src="js/js.js"></script>
	<script type="text/javascript" src="js/table.js"></script>
	<script type="text/javascript">
	var ids='';
	$(function(){
		$("#excel").click(function(){
			$("#tab input[type='checkbox']").each(function(){
				if($(this).is(":checked")){if($(this).val()!='on'){ids=ids+$(this).val()+',';}}
			});
			if(ids==''){
				alert("请选择要导出的数据！");
			}else{
				if(confirm("确认导出选中数据吗？")){
					document.forms[0].action="export_ExcelExport.action?ids="+ids;
					document.forms[0].submit();
					ids=''
				}else{
				//将复选框的状态更改为位选中，并清空所有的Id数值
					$.each($("#tab input[type='checkbox']"),function(i,v){if($(v).attr("checked")=="checked"){ v.checked=false;}});ids='';
				}
			}
		});
	});
	</script>
  </head>
  
  <body>
    <form action="" method="post">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td height="30" background="images/tab_05.gif">
	      <table width="100%" border="0" cellspacing="0" cellpadding="0">
	        <tr>
	          <td width="12" height="30"><img src="images/tab_03.gif" width="12" height="30" /></td>
	          <td>
	            <table width="100%" border="0" cellspacing="0" cellpadding="0">
		          <tr>
		            <td width="46%" valign="middle">&nbsp;</td>
		            <td width="54%">
		              <table border="0" height="30" align="right" cellpadding="0" cellspacing="0">
		                <tr>
			              <td width="35">
		                    <table width="90%" border="0" cellpadding="0" cellspacing="0">
			                  <tr>
			                    <td class="STYLE1"><div align="center"><span title="导出为Excel"><a href="javascript:" id="excel"><img border="0" src="images/emport/excel.png"/></a></span></div></td>
			                  </tr>
			                </table>
			              </td>
		                </tr>
		              </table>
		            </td>
		          </tr>
	        	</table>
	          </td>
	          <td width="16"><img src="images/tab_07.gif" width="16" height="30" /></td>
	        </tr>
	      </table>
	    </td>
	  </tr>
	  <tr>
	    <td>
	      <table width="100%" border="0" cellspacing="0" cellpadding="0">
	        <tr>
	          <td width="8" background="images/tab_12.gif">&nbsp;</td>
	          <td>
	            <table id="tab" width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
	              <tr align="center" class="STYLE1" bgcolor="#FFFFFF">
		            <td width="3%" height="22" background="images/bg.gif"><input type="checkbox" id="checkbox" onclick="xuanzhong()"/></td>
		            <td width="3%" height="22" background="images/bg.gif">序号</td>
		            <td width="12%" height="22" background="images/bg.gif">学生名称</td>
		            <td width="14%" height="22" background="images/bg.gif">年龄</td>
		            <td width="18%" background="images/bg.gif">性别</td>
		            <td width="23%" height="22" background="images/bg.gif">地址</td>
		          </tr>
		  		  <s:iterator value="#request.list" id="sList" status="s">
		 			<tr align="center" class="STYLE1" bgcolor="#FFFFFF">
		              <td height="20"><input type="checkbox" name="box" value="<s:property value="#sList.s_id"/>"/></td>
		              <td height="20"><s:property value="#sList.s_id"/></td>
		              <td height="20"><s:property value="#sList.s_name"/></td>
		              <td height="20"><s:property value="#sList.s_sex"/></td>
		              <td height="20"><s:property value="#sList.s_age"/></td>
		              <td height="20"><s:property value="#sList.s_address"/></td>
		            </tr>
		          </s:iterator>
		        </table>
		      </td>
	          <td width="8" background="images/tab_15.gif">&nbsp;</td>
	        </tr>
	      </table>
	    </td>
	  </tr>
	  <tr>
	    <td height="35" background="images/tab_19.gif">
	      <table width="100%" border="0" cellspacing="0" cellpadding="0">
	        <tr>
	          <td width="12" height="35"><img src="images/tab_18.gif" width="12" height="35" /></td>
	          <td>
	            <table width="100%" border="0" cellspacing="0" cellpadding="0">
		          <tr>
		            <td class="STYLE4"></td>
		            <td><table border="0" align="right" cellpadding="0" cellspacing="0"><tr><td width="40"></td></tr></table></td>
		          </tr>
		        </table>
		      </td>
	          <td width="16"><img src="images/tab_20.gif" width="16" height="35" /></td>
	        </tr>
	      </table>
	    </td>
	  </tr>
	</table>
	</form>
  </body>
</html>
