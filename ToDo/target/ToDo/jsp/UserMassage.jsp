<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>UserMassage</title>
<link rel="stylesheet" href="/ToDo/jsp/reveal.css">
<script src="http://www.jq22.com/jquery/jquery-1.6.2.js"></script>
<script type="text/javascript" src="/ToDo/jsp/jquery.reveal.js"></script>
<script type="text/javascript" src="/ToDo/jsp/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#button").click(function(){
		var age =$("#age").val();
		var phone=$("#phoneNumber").val();
		var comments=$("comments").val();
		if(isNaN(age)||age>200||age<0||(age==null)){
			 alert("年龄只能是0-200的数字");
			 return;	
			 }
		if(isNaN(phone)||((phone.length!=7)&&(phone.length!=11))||(phone==null)){
			alert("电话号码为7/11位");
			return;
		}
		$.ajax({
					type : "POST", //提交方式
					url : "/ToDo/userController/updateUserMassage",
					data : {
						"age" : age,
						"phoneNumber" : phone,
						"comments":comments
					},
					success : function(result) {
						if (result == 200) {
							alert("更新成功");
							window.location.reload();
						} else {
							alert("更新失败");
							return;
						}
					}
});
	
	});
	 $("#age").blur(function(){
		 var age =$("#age").val();
		 if(isNaN(age)){
		  $("#ageError").text("");
		  $("#ageError").append("年龄只能是0-200的数字");
		  $("#age").css("border-color","red");
		 return;
		 }
		 if(age>200||age<0){
			 $("#ageError").text("");
			  $("#ageError").append("年龄只能是0-200的数字");
			  $("#age").css("border-color","red");
			 return; 
			 } 
	 });
	 $("#phoneNumber").focus(function(){
		 $("#phoneNumber").css("border-color","blue");
		 $("#phoneNumberError").text(""); 
	 });
	 $("#age").focus(function(){
		 $("#age").css("border-color","blue");
		 $("#ageError").text(""); 
	 });
	 
	$("#phoneNumber").blur(function(){
		var phoneNumber =$("#phoneNumber").val();
		 if(isNaN(phoneNumber)){
		  $("#phoneNumberError").text("");
		  $("#phoneNumberError").append("电话号码只能是数字");
		  $("#phoneNumber").css("border-color","red");
		 return;
		 }
		 if((phoneNumber.length!=11)&&(phoneNumber.length!=7)){
			 $("#phoneNumberError").text("");
			  $("#phoneNumberError").append("电话号码是7/11位");
			  $("#phoneNumber").css("border-color","red");
			  $("#phoneNumber").css("border-color","red");
			 return; 
			 } 
	});
    
 });





</script>
<style type="text/css">
* {
	margin: 0;
	padding: 0px;
}

#box {
	width: 1300px;
	height: 600px;
	background: rgb(232, 232, 232);
	border: 1px solid blue;
	margin: 0 auto;
}

#left {
	width: 150px;
	height: 100%;
	background: rgb(207, 215, 235);
	border: 1px solid blue;
	float: left;
}

#left ul {
	margin-top: 80px;
}

#ageError {
	width: 200px;
	height: 30px;
	margin-left: 210px;
	margin-top: -30px;
	font-size: 15px;
	text-align: left;
	line-height: 30px;
	display: block;
}

#phoneNumberError {
	display: block;
	width: 200px;
	height: 30px;
	margin-left: 210px;
	margin-top: -30px;
	font-size: 15px;
	text-align: left;
	line-height: 30px;
}

#left ul li {
	display: block;
	color: black;
	font-size: 20px;
	float: none;
	margin-top: 30px;
	text-align: center;
	cursor: pointer;
}

#left ul li:hover {
	background: green;
	color: white;
}

#right {
	width: 1100px;
	height: 100%;
	background: rgb(207, 215, 235);
	border: 1px solid blue;
	float: right;
}

#top {
	width: 100%;
	height: 50px;
	background: rgb(225, 225, 225);
	border: 1px solid blue;
}

#welcome {
	display: block;
	font-size: 20px;
	line-height: 50px;
	color: red;
	float: right;
	margin-right: 100px;
}

#base {
	width: 900px;
	height: 268px;
	background: rgb(210, 225, 245);
	margin: 0 auto;
	border: 1px solid grey;
}

#orther {
	width: 900px;
	height: 268px;
	background: rgb(210, 225, 245);
	margin: 10px auto;
	border: 1px solid grey;
}

#right p {
	display: block;
	margin-left: 100px;
	color: rgb(129, 53, 7);
	font-size: 30px;
	margin-top: 10px;
}

#right ul {
	margin-left: 30px;
}

#right ul li {
	display: block;
	width: 200px;
	height: 50px;
	float: left;
	margin-left: 10px;
	margin-top: 20px;
	color: black;
	line-height: 50px;
	font-size: 20px;
}

#key {
	text-align: right;
}

#value {
	text-align: left;
}

#textId {
	display: block;
	width: 100px;
	height: 30px;
	float: none;
	margin-left: 40px;
	margin-top: 80px;
	color: black;
	font-size: 20px;
	text-align: right;
	line-height: 30px;
}

#textBox {
	display: block;
	width: 700px;
	height: 100px;
	margin-top: -30px;
	margin-left: 150px;
	color: black;
	font-size: 20px;
}

a {
	text-decoration: none;
}

#top ul {
	display: block;
	width: 100px;
	margin-top: -20px;
	margin-left: 300px;
}

#top ul li {
	display: block;
	color: black;
	font-size: 20px;
	float: left;
	margin-left: 80px;
	line-height: 50px;
	cursor: pointer;
	text-align: center;
}

#top ul li:hover {
	background: green;
	color: white;
}

#myModal p {
	display: block;
	text-align: center;
	font-size: 20px;
	color: blue;
}

#myModal span {
	display: block;
	font-size: 20px;
	color: green;
	height: 30px;
}

#phoneNumber {
	width: 200px;
	height: 30px;
	float: none;
	border: 1px solid blue;
	font-size: 20px;
}

#age {
	width: 200px;
	height: 30px;
	float: none;
	border: 1px solid blue;
	font-size: 20px;
}

#comments {
	width: 400px;
	height: 30px;
	float: none;
	border: 1px solid blue;
	font-size: 20px;
}

#button {
	width: 100px;
	border: 1px solid red;
	background: green;
	height: 50px;
	font-size: 30px;
	margin: 30px 200px;
	cursor: pointer;
}
</style>
</head>
<body>
	<div id="box">
		<div id="left">
			<ul>
				<a href="/ToDo/userController/goToListItemsPage"><li>待办事项列表</li></a>
				<a href="/ToDo/userController/findUserMassgeByUserId"><li>个人信息维护</li></a>
			</ul>
		</div>

		<div id="right">
			<div id="top">
				<ul>
					<a href="#" class="big-link" data-reveal-id="myModal"><li>修改个人信息</li></a>
				</ul>
				<span id="welcome">欢迎您${userDTO.userName}</span>
			</div>
			<div id="base">
				<p>基本信息</p>
				<ul>
					<li id="key">用户名:</li>
					<li id="value">${userDTO.userName}</li>
					<li id="key">性别:</li>
					<li id="value">${userDTO.sex}</li>
					<li id="key">年龄:</li>
					<li id="value">${userDTO.age}</li>
					<li id="key">电话号码:</li>
					<li id="value">${userDTO.phoneNumber}</li>
				</ul>
			</div>
			<div id="orther">
				<p>其他信息</p>
				<ul>
					<li id="key">创建时间:</li>
					<li id="value">${userDTO.creationDateString}</li>
					<li id="key">修改时间:</li>
					<li id="value">${userDTO.lastUpdateDateString}</li>
				</ul>
				<span id="textId">备注:</span> <span id="textBox">${userDTO.comments}</span>
			</div>
		</div>
	</div>


	<div id="myModal" class="reveal-modal">
		<a class="close-reveal-modal">&#215;</a>
		<p>个人信息修改（只可修改部分）</p>

		<span id="phoneNumberId">电话号码（7或11位）:</span> <input type="text"
			name="phoneNumber" id="phoneNumber" value="${userDTO.phoneNumber}">
		<p id="phoneNumberError"></p>
		<span id="ageId">年龄（0-200）</span> <input type="text" name="age"
			id="age" value="${ userDTO.age}">
		<p id="ageError"></p>
		<span id="commentsId">备注:</span> <input type="text" name="comments"
			id="comments" value="${ userDTO.comments}"> <input
			type="button" value="修改" id="button">

	</div>
</body>