<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="row lb-screen-height">
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
		<h3>新增資源</h3>
		<div>
			<form action="${resource.id }" method=post>
				<div class="form-group">
					<label for="name" class="">资源名字</label>
					<input type="text"
						class="form-control" id="name" name="name" value="${resource.name }">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">描述</label> <textarea type="text"
						class="form-control size-fixed" id="description" name="description" rows=2 resize=none>${resource.description }</textarea>
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