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
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<h3>编辑資源</h3>
					<div>
						<form action="${resource.id }" method=post>
							<div class="form-group">
								<label for="name" class="">资源名字</label> <input type="text"
									class="form-control" id="name" name="name"
									value="${resource.name }">
								<div>
									<input id="fileupload" type="file" name="fileupload" />
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">描述</label>
								<textarea type="text" class="form-control size-fixed"
									id="description" name="description" rows=2 resize=none>${resource.description }</textarea>
							</div>
							<div class="form-group">
								<label>内容</label>
								<textarea id="content" name="content" class="">${resource.content }</textarea>
							</div>

							<button type="submit" class="btn btn-default">提交修改</button>
						</form>
					</div>
				</div>
				<div class="col-md-2"></div>

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
	<script src="/lishibook/tinymce/tinymce.min.js"></script>
	<script src="/lishibook/upload/js/vendor/jquery.ui.widget.js"></script>
	<script src="/lishibook/upload/js/jquery.iframe-transport.js"></script>
	<script src="/lishibook/upload/js/jquery.fileupload.js"></script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							tinymce
									.init({
										selector : "textarea#content",
										theme : "modern",
										height : 300,
										menubar : "",
										toolbar : "undo redo bold italic alignleft aligncenter alignright alignjustify bullist numlist outdent indent link image forecolor backcolor",
										statusbar : false,
									});
							$('#fileupload').fileupload({
						        url: '/lishibook/ws/upload',
						        type:'POST',
						        dataType: 'json',
						        limitMultiFileUploads: 1,
						        limitMultiFileUploadSize: 1000000,
						        imageCrop: true,
						        done: function (e, data) {
						            $.each(data.result.files, function (index, file) {
						                $('<p/>').text(file.name).appendTo(document.body);
						            });
						        }
						    });
						});
	</script>
</body>
</html>