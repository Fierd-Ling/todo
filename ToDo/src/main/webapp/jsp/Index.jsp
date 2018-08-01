<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<script src="jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#submit")
								.click(
										function() {
											var userName = $(
													":text[id=userName]").val();
											var password = $(
													":text[id=password]").val()
													if(userName==""||userName==null){
														alert("用户名不能为空");
														return;
													}
											if(password==""||password==null){
												alert("密码不能为空");
												return;
											}	
											$.ajax({
														type : "POST", //提交方式
														// TODO 
														url : "/ToDo/userController/index",//路径
														data : {
															"userName" : userName,
															"password" : password
														},
														success : function(
																result) {//返回数据根据结果进行相应的处理
															if (result == "SUCCESS") {
																alert("登录通过，点击后跳转");
																window.location.href = "/ToDo//userController/goToListItemsPage";
															} else {
																alert("用户名或密码错误，请重新输入");
															}
														}
													});
										});
					});
</script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body {
	background: rgb(204, 232, 225);
}

#form {
	display: block;
	width: 400px;
	height: 350px;
	background: white;
	margin: 100px auto;
}

span {
	display: block;
	font-size: 30px;
	text-align: center;
	line-height: 100px;
	color: blue;
}

p {
	display: block;
	width: 100px;
	height: 50px;
	font-size: 25px;
	line-height: 50px;
	text-align: right;
	float: left;
	margin-left: 20px;
}

#userName {
	width: 200px;
	height: 50px;
	font-size: 25px;
	border: 1px solid green;
	float: left;
	margin-left: 10px;
}

#password {
	width: 200px;
	height: 50px;
	font-size: 25px;
	border: 1px solid green;
	float: left;
	margin-left: 10px;
	margin-top: 10px;
}

#submit {
	width: 100px;
	height: 50px;
	background: green;
	cursor: pointer;
	border: 1px solid red;
	font-size: 25px;
	color: white;
	margin-left: 70px;
	margin-top: 30px;
}
#form{
		display:block;
		width:400px;
		height:350px;
		background:white;
		margin:100px auto;
	}


</style>

<span id="form">
<span>登陆</span>
<p>用户名:</p>
<input type="text" name="userName" id="userName">
<p>密码:</p>
<input type="text" name="password" id="password">
<input type="button" value="登陆" id="submit">
</span>
</body>

</body>
</html>