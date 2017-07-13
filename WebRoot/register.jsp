<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script type="text/javascript">
	function regcheck() {
		
		reg=/^[a-zA-Z0-9_\u0391-\uFFE5]{3,10}$/; 
		
		if(form_reg.regname.value.trim()==""){
			alert("请输入用于名");
			form1.username.focus();
			return false;
		}
		
		if(form_reg.regpass1.value.trim() != form_reg.regpass2.value.trim()) {
			alert("两次密码不一致,请确认");
			form_reg.regname.focus();
			return false;
		}
		
	}
	
	</script>

  </head>
  
  <body>
    <img alt="" src="zt.jpg" width="300" height="200" style="text-align: center"> <br/>
	美好，从注册相识开始... <br/>
	请注册：<br/>
	<form id="form_reg" method="post" action="regmessage" >
		用户名：<br/>
		<input type="text" name="regname" /> <br/>
		密码:   <br/>
		<input type="password" name="regpass1" /> <br/>
		确认密码：<br/>
		<input type="password" name="regpass2" />
		<input type="hidden" name="method" value="register" />
		<input type="submit" value="开启美好" name="subf" onclick="return regcheck()" />
	
	</form>
	
  </body>
</html>
