<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
					<input type="hidden" name="password" id="hiddenpassword" />
					<input id="password" class="form-control"
						type="password" required="" placeholder="密码">
				</div>
				<span class="checkbox"><input type="checkbox"
					value="remember-me"><small>记住我 </small></span>
				<button id="submit" class="btn btn-primary btn-block" type="submit">登 录</button>
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