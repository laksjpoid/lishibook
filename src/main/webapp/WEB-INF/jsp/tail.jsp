<footer>
	<hr>
	<p>© Company 2014</p>
</footer>
</div>
<script src="/lishibook/js/jquery-2.1.0.js"></script>
<script src="/lishibook/js/jquery.md5.js"></script>
<script src="/lishibook/bootstrap-3.1.1/js/bootstrap.min.js"></script>
<script src="/lishibook/tinymce/tinymce.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("form").submit(function() {
		var md5 = $.md5($("#password").val());
		$("#hiddenpassword").val(md5);
	});
	tinymce.init({
		selector: "textarea#content",
		theme: "modern",
		height: 300,
	   	menubar: "",
	   	toolbar: "undo redo bold italic alignleft aligncenter alignright alignjustify bullist numlist outdent indent link image forecolor backcolor", 
	   	statusbar: false,
	}); 
});
</script>
</body>
</html>