<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="description">
<meta content="" name="author">
<link href="../../docs-assets/ico/favicon.png" rel="shortcut icon">
<title>LISHIBOOK</title>
<link rel="stylesheet"
	href="/lishibook/bootstrap-3.1.1/css/bootstrap.min.css" />
<link rel="stylesheet" href="/lishibook/css/lishibook.css" />
</head>
<body>
	<div class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button class="navbar-toggle" data-target=".navbar-collapse"
					data-toggle="collapse" type="button">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand navbar-link" href="/lishibook/">LISHIBOOK</a>
			</div>
			<div class="navbar-collapse collapse navbar-right">
				<c:if test="${!empty user}">
					<a class="navbar-text navbar-link">${user.username }</a>
				</c:if>
				<c:if test="${empty user}">
					<a class="navbar-text navbar-link">注册 LISHIBOOK</a>
					<a class="navbar-text navbar-link" href="/lishibook/login">登录</a>
				</c:if>
			</div>
		</div>
	</div>
	<div class="container">
		<h2>
			<img src="${resource.iconurl }" class="lb-icon">
			${resource.name }
		</h2>
		<hr />
		<div class="row lb-screen-height">
			<div class="col-md-12">
				<ul class="nav nav-tabs">
					<li><a href="#">动态</a></li>
					<li><a href="/lishibook/resource/${resource.id }">基本资料</a></li>
					<li><a href="#">时间轴</a></li>
					<li class="active"><a href="/lishibook/resource/focus/${resource.id }">关注</a></li>
				</ul>
				<div class="lb-margin-top-20"></div>
				<div class="row">
					<div class="col-md-2">
						<ul class="nav bs-sidenav">
							<li class="active"><a href="/lishibook/resource/focus/${resource.id }">${resource.name } 的关注</a></li>
							<li><a href="#">分组</a></li>
						</ul>
					</div>
					<div class="col-md-7">
						<div class="row lb-focuses">
						</div>
					</div>
					<div class="col-md-3">
							<div class="form-group">
								<label for="search">搜索资源</label>
								<input type="text" class="form-control" id="searchkey" placeholder="资源名字">
							</div>
							<button id="searchbutton" type="submit" class="btn btn-default">查找</button>
					</div>
				</div>
			</div>
		</div>
		<footer>
			<hr>
			<p>© Company 2014</p>
		</footer>
	</div>
	<script src="/lishibook/js/jquery-2.1.0.js"></script>
	<script src="/lishibook/bootstrap-3.1.1/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function searchResource(name){
			$.get("/lishibook/ws/resource/search?key="+name, function(data){
				var root = $(".lb-focuses").html("");
				
				if(data[0]==null){
					root.append("找不到资源!");
				}
				for ( var i in data) {
					var node = data[i];
					root.append(newResourceElement(node));
				}
			});
		}
		function newResourceElement(node){
			var ele = $("<div>",{
					class:"col-md-4",
				});
				var thumbnail = $("<div>",{
					class:"thumbnail"
				});
				var image = $("<img>", {
					src:node.iconurl,
					alt:"...",
					class:"img-rounded"
				});
				var cap = $("<div>",{
					class:"caption"
				});
				var link1 = $("<a>",{
					href: "/lishibook/resource/"+node.id
				});
				link1.html(image);
				var head = $("<h3>").html(node.name);
				var desc = $("<p>").html(node.description);
				cap.append(head).append(desc);
				
				thumbnail.append(link1).append(cap);
				ele.append(thumbnail);
				
				return ele;
		}
		$(document).ready(function() {
			$("#searchbutton").click(function() {
				var key = $("#searchkey").val();
				$("#searchkey").val("");
				searchResource(key);
			});
			$.get("/lishibook/ws/resource/${resource.id }/focuses",function(data) {
			
				if(data[0]==null){
					$(".lb-focuses").append("尚未添加关注！");
				}
				for ( var i in data) {
					var node = data[i];
					
					$(".lb-focuses").append(newResourceElement(node));
				}
			});
		});
	</script>
</body>
</html>