<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <ul>
    	<li>订单管理</li>
    	<li>供应商管理</li>
    	<li>用户管理管理</li>
    	<li>密码修改</li>
    </ul>
    <a href="useadd.jsp">新增用户信息</a>
    <table border="1">
    	<tr>
    			<td>用户编码</td>
    			<td>用户名称</td>
    			<td>性别</td>
    			<td>年龄</td>
    			<td>电话</td>
    			<td>用户角色</td>
    		</tr>
    	<c:forEach var="list" items="${list }">
    		<tr>
    			<td>${list.userCode }</td>
    			<td>${list.userName }</td>
    			<td>
    				<c:if test="${list.gender==1 }">
    					女
    				</c:if>
    				<c:if test="${list.gender==2 }">
    					男
    				</c:if>
    			</td>
    			<td>${list.birthday }</td>
    			<td>${list.phone }</td>
    			<td>${list.role.roleName }</td>
    			<td><a href="user?id=${list.id }">修改</a></td>
    			<td><a href="udelete?id=${list.id }">删除</a></td>
    		</tr>
    	</c:forEach>
    </table>
    <a href="getAll?fan=shou">首页</a ><a href="getAll?fan=wei">尾页</a>
  </body>
  
</html>
