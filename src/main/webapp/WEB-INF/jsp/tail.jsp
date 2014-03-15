
<footer>
	<hr>
	<p>© Company 2014</p>
</footer>
</div>
<script src="js/jquery-2.1.0.js"></script>
<script src="js/jquery.md5.js"></script>
<script src="bootstrap-3.1.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("form").submit(function() {
		var md5 = $.md5($("#password").val());
		$("#hiddenpassword").val(md5);
	});
});
</script>
</body>
</html>