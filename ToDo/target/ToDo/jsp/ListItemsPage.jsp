
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ListItemsPage</title>
<link rel="stylesheet" href="/ToDo/jsp/reveal.css">
<script src="http://www.jq22.com/jquery/jquery-1.6.2.js"></script>
<script type="text/javascript" src="/ToDo/jsp/jquery.reveal.js"></script>
<script type="text/javascript" src="/ToDo/jsp/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
 


$(document).ready(function(){
	// 删除
	$("#delete").click(function(){
		$.ajax({
			type:"POST",  //提交方式
			// TODO 
			url:"/ToDo/ItemsController/deleteItem",//路径
			data:{"toDoItemId" : "18"
			},
			success : function(result) {//返回数据根据结果进行相应的处理
				if ( result.success ) { 
					window.location.reload();
				} else {	 
				}
			}
	    });
		
		
	});
	
 $("#submit").click(function(){  
        var todoItemContenet = $(":text[id=todoItemContenet]").val();
		var toDoItemTitle = $(":text[id=toDoItemTitle]").val()
		var priority= $("#priority").val();
		var comments=$("#comments").val()
        if(todoItemContenet==""||todoItemContenet==null){  
            alert("内容不能为空！");  
		   return false;
        } 
		if(toDoItemTitle==""||toDoItemTitle==null){  
            alert("标题不能为空！");  
		     return false;
        }
		// 新增
		$.ajax({
			type :"POST",  //提交方式
			url :"/ToDo/ItemsController/addItem",//路径
			data : {"todoItemContenet" : todoItemContenet,
				"toDoItemTitle":toDoItemTitle,
				"priority":priority,
				"comments":comments
			},
			success:function(result) {//返回数据根据结果进行相应的处理
				if(result="SUCCESS"){
					alert("新增成功");
					window.location.reload();
				}else{
					alert("新增失败");
					window.location.reload();
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

#top ul {
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
}

#top ul li:hover {
	background: green;
	color: white;
}

#welcome {
	display: block;
	font-size: 20px;
	line-height: 50px;
	color: red;
	float: right;
	margin-right: 100px;
}

#left ul {
	margin-top: 80px;
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

a {
	text-decoration: none;
}

#left ul li:hover {
	background: green;
	color: white;
}

#text {
	display: block;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
	height: 40px;
	line-height: 40px;
}

#table {
	text-align: center;
	border: 1px solid blue;
}

#table span {
	display: block;
	float: left;
	margin-left: 10px;
	font-size: 18px;
	color: blue;
	cursor: pointer;
}

#table span:hover {
	background: green;
	color: white;
}

#page {
	width: 700px;
	height: 50px;
	margin-top: 20px;
	font-size: 20px;
	line-height: 50px;
	margin-left: 200px;
}

#page ul li {
	float: left;
	list-style-type: none;
	color: grey;
	margin-left: 50px;
}

#after {
	float: left;
	margin-left: 60px;
	display: block;
	color: green;
	cursor: pointer;
}

#after:hover {
	background: green;
	color: white;
}

#befor {
	float: left;
	margin-left: 100px;
	display: block;
	color: green;
	cursor: pointer;
}

#befor:hover {
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

#toDoItemTitle {
	width: 500px;
	height: 30px;
	float: none;
	border: 1px solid blue;
	font-size: 20px;
}

#todoItemContenet {
	width: 500px;
	height: 30px;
	float: none;
	border: 1px solid blue;
	font-size: 20px;
}

#comments {
	width: 500px;
	height: 30px;
	float: none;
	border: 1px solid blue;
	font-size: 20px;
}

#priority {
	width: 90px;
	height: 30px;
	float: none;
	border: 1px solid blue;
	font-size: 20px;
}

#submit {
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
				<li></li>
			</ul>
		</div>
		<div id="right">
			<div id="top">
				<ul>
					<a href="#" class="big-link" data-reveal-id="myModal"><li>新增</li></a>
				</ul>
				<span id="welcome">欢迎您${userDTO.userName}</span>
			</div>
			<table border="1px" width="1100px" id="table" cellspacing="0"
				cellpadding="0" bordercolor="blue" align="center">
				<tr align="center">
					<td width="200px">标题</td>
					<td>内容</td>
					<td width="60px">优先级</td>
					<td width="200px">创建时间</td>
					<td width="200px">修改时间</td>
					<td width="100px">操作</td>
				</tr>
				<c:forEach items="${listItems}" var="items">
					<tr align="center">
						<td>${items.toDoItemTitle }</td>
						<td width="367px" id="text" bordercolor="blue">${items.todoItemContenet }</td>
						<td>${items.priority }</td>
						<td>${items.creationDateString}</td>
						<td>${items.lastUpdateDateString}</td>
						<td><span>修改</span>
						<span  id="delete">删除 </span>
					</tr>
				</c:forEach>
			</table>
			<div id="page">
				<ul>
					<li>共${count }条记录每页10条
					<li>
					<li>第1页
					<li>
				</ul>
				<span id="befor"> 《上一页 </span> <span id="after">下一页》</span>
				<div></div>
			</div>
		</div>
		<div id="myModal" class="reveal-modal">
			<a class="close-reveal-modal">&#215;</a>
			<p>新增待办事项</p>
			<span  id="form" >
				<span id="toDoItemTitleId">标题:</span><input type="text"
					name="toDoItemTitle" id="toDoItemTitle"> <span
					id="priorityId">优先级:</span> <select name="priority" id="priority">
					<option value="低">---低---</option>
					<option value="中">---中---</option>
					<option value="高">---高---</option>
				</select> <span id="todoItemContenetId">内容:</span> <input type="text"
					name="todoItemContenet" id="todoItemContenet"> <span
					id="commentsId">备注:</span><input type="text" name="comments"
					id="comments"> <input type="button" value="添加" id="submit">
			</span>
			</div>
			
</body>
</html>