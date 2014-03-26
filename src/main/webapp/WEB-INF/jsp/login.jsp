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
		<div class="row lb-screen-height">
			<div style="margin: 50px"></div>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<form class="form-signin" action="/lishibook/login" method="post">
						<h4>欢迎登录</h4>
						<div class="lb-margin-top-20"></div>
						<div class="form-group">
							<input id="email" name="email" class="form-control" type="text"
								autofocus="" required="" placeholder="邮箱账号">
						</div>
						<div class="form-group lb-margin-top-20">
							<input type="hidden" name="password" id="hiddenpassword" /> <input
								id="password" class="form-control" type="password" required=""
								placeholder="密码">
						</div>
						<span class="checkbox"><input type="checkbox"
							value="remember-me"><small>记住我 </small></span>
						<button id="submit" class="btn btn-primary btn-block"
							type="submit">登 录</button>
						<c:if test="${loginFail == true}">
							<div
								class="form-group lb-margin-top-20 alert alert-danger alert-dismissable">
								<button type="button" class="close" data-dismiss="alert"
									aria-hidden="true">&times;</button>
								<strong>登录失败！</strong>请检查您的用户名和密码！
							</div>
						</c:if>
					</form>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
		<footer>
			<hr>
			<p>© Company 2014</p>
		</footer>
	</div>
	<script src="/lishibook/js/jquery-2.1.0.js"></script>
	<script src="/lishibook/js/jquery.md5.js"></script>
	<script src="/lishibook/bootstrap-3.1.1/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$("form").submit(function() {
								var md5 = $.md5($("#password").val());
								$("#hiddenpassword").val(md5);
							});
						});
	</script>
</body>
</html>