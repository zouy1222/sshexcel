<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'intoExcel.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/> 
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.8.1.js"></script>

  </head>
  
  <body>
    <form action="export_ExcelInto" enctype="multipart/form-data" method="post">
      <table width="100%" border="0" align="center">
        <tr>
	      <td colspan="99" id="more">
	        <input type="file" name="uploadFile" id="uploadFile"/>
	        <input type="submit" value="上传"/>
	        <input type="reset" value="重置"/>
	      </td>
	    </tr>
      </table>
    </form>
  </body>
</html>
