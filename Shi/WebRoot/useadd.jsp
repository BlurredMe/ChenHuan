<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'useadd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="uadd" method="post">
    	用户编码<input type="text" name="bm"><br/>
    	用户名称<input type="text" name="mc"><br/>
    	用户密码<input type="text" name="mm"><br/>
    	确认密码<input type="text" name="qmm"><br/>
    	用户性别<select name="six">
    		<option value="1">女</option>
    		<option value="2">男</option>
    	</select><br/>
    	出生日期<input type="text" name="data"><br/>
    	用户电话<input type="text" name="dh"><br/>
    	用户地址<input type="text" name="dz"><br/>
    	用户角色<select name="js">
    		<option value="1">系统管理员</option>
    		<option value="2">经理</option>
    		<option value="3">普通员工</option>
    	</select><br/>
    	<input type="submit" value="确定">
    </form>
  </body>
</html>
