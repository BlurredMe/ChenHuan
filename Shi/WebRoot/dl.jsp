<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dl.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function validate() {
		//当用户失去焦点时 没有输入用户名 则在span标签中显示"用户名不能为空"
		var uname = $("#uname").val();
		if (uname == null || uname == '') {
			$("#msg").html("<span style='color :red'>用户名不能为空!</span>");
		} else {
			//用户名不为空的情况下 必须要去验证重复
			//第一步 创建xmlHttpRequest对象
			/* xmlHttpRequest = new XMLHttpRequest();
			
			//第二步 设置xmlHttpRequest对象的回调函数
			xmlHttpRequest.onreadystatechange = callBack;
			
			//发送请求
			xmlHttpRequest.open("post", "target.jsp", true);
			
			//设置请求参数传递编码格式
			xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			
			//开始传参
			xmlHttpRequest.send("uname="+uname); */

			//用户名不能为ACCP 
			
			
			/* $.ajax({
				url : 'target.jsp',
				type : 'get',
				data : 'uname=' + uname,
				success : function(result) {
					if ($.trim(result) == "false") {
						$("#msg").html("<span style='color :red'>用户名已被占用!</span>");
					} else {
						$("#msg").html("<span style='color :green'>用户名可以使用!</span>");
					}
				}
			}); */
			
			
			$.post('ax','uname='+uname,function(result){
			
				if ($.trim(result) == "false") {
			
					$("#msg").html("<span style='color :red'>用户名不存在!</span>");
				} else {
				
					$("#msg").html("<span style='color :green'>用户名可以使用!</span>");
				}
			});
		}
	}
	//用来接收ajax返回值 进行回调处理的
	/* function callBack(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
		
			var result = xmlHttpRequest.responseText;
			
			if($.trim(result)=="false"){
				$("#msg").html("<span style='color :red'>用户名已被占用!</span>");
			}else{
				$("#msg").html("<span style='color :green'>用户名可以使用!</span>");
			}
		}
	} */
</script>
  </head>
  
  <body>
  
    <form action="deng" method="post">
		<!-- 用户名框 失去焦点的时候要调用 -->
		用户名：<input type="text" id="uname" name="uname" onblur="validate()" /> <span
			id="msg"></span> 
		密码<input type="text" name="pwd">	
			<input type="submit" value="登录" />
	</form>
  </body>
</html>
