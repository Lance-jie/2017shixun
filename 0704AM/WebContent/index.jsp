<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btnLogin").click(function(){
			$.post("usersServlet",
					{
						txtName:$("#txtName").val(),
						txtPwd:$("#txtPwd").val()
					},
					function(res){
						var json = JSON.parse(res);
						
						if(json.state!="OK"){
							alert(json.msg);
						}else{
							location.href="main.jsp";
						}
					});
		});
		
		$("#btn").click(function(){
			
			var _word = $("#word").val();
			if(_word==null||_word==""){
				$("#label").html("词条不能为空");
				return -1;
			}else{
				alert(_word);
				$.post("usersServlet",
				{
					word:$("#word").val()
				},
				function(res){
					var json = JSON.parse(res);
					if(json.state!="OK"){
						$("#label").html(json.msg);
					}else{
						$("#label").html(json.msg);
					}
				});
			}
			
		});
	});

</script>
</head>
<body>
 	
<!--  	账号：<input type = "text" value="" id="txtName"/><br>
 	密码：<input type = "password" value="" id="txtPwd"/><br>
 	<button id="btnLogin">登录</button> --> 
 	<input type="text" value="" id="word"/>

 	<button id="btn">词典搜索</button>
 	<label id="label"></label>
 	<img alt="验证码" src="VCServlet">

</body>
</html>