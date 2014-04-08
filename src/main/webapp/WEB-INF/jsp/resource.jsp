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
		<h2><img src="${resource.iconurl }" class="lb-icon"> ${resource.name }</h2>
		<hr />
		<div class="row lb-screen-height">
			<div class="col-md-8">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#">基本资料</a></li>
					<li><a href="#">时间轴</a></li>
				</ul>
				<div>${resource.content }</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">${resource.name } 的关注</div>
					<div class="panel-body">
						<ul class="media-list">
							<li class="media lb-focus"><a class="pull-left" href="#"> <img
									class="media-object lb-focus-icon" src="${resource.iconurl }"
									alt="...">
							</a>
								<div class="media-body">
									<h4 class="media-heading">${resource.name }</h4>
									章泽天章泽天章泽天章泽天章泽天章泽天章泽天章泽天章泽天章泽天章泽天章泽天章泽天章泽天章泽天章泽天章泽天章泽天章泽天章泽天章泽天章泽天章泽天章泽天
								</div></li>
							<li class="media lb-focus"><a class="pull-left" href="#"> <img
									class="media-object lb-focus-icon" src="${resource.iconurl }"
									alt="...">
							</a>
								<div class="media-body focus">
									<h4 class="media-heading">${resource.name }</h4>
									章泽天
								</div></li>
						</ul>
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
		$(document).ready(function() {
			$("form").submit(function() {
				var md5 = $.md5($("#password").val());
				$("#hiddenpassword").val(md5);
			});
			$("li.lb-focus").hover(function(){
				$(this).toggleClass("lb-focus-hover");
			});
		});
	</script>
</body>
</html>