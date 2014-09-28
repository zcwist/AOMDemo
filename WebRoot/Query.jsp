<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			   $(document).ready(function() {
					$("#b01").click(function() {
						var data = {}
						// $.getJSON('http://localhost:8080/AOMDemo/servlet/ForAjax', function(json, textStatus) {
						// 		$("#myDiv").html(json);

						// 		console.log(json2formGroup(json));
						// 		$("#myDiv").html(json2formGroup(json))
						// });
						$.post('http://localhost:8080/AOMDemo/servlet/ForAjax', {Command: 'getQueryType'}, function(data, textStatus, xhr) {
						/*optional stuff to do after success */
							console.log(data);
							if (textStatus == 'success'){
								$("#myDiv").html(json2formGroup(data));


							}
						});
					});
					
					function json2formGroup(json){
						s = '<form role="form">';
						$.each(json.value, function(index, val) {
							s += '<div class="form-group">';
							s += '<label for="' + val +'">' + val + '</label>';
							s += '<input type="text" class="form-control" + id="' + val + '" placeholder="">';
							s += "</div>";
							});
						s += '<button type="submit" class="btn btn-default">Submit</button>';
						s += '</form>';
						console.log(s);
						return s;
					}

					function json2QueryTypeList(json){
						$.each(json.value, function(index, val) {
							 s = ""
						});
					}
					
			   });
		  </script>
		<title>Insert title here</title>
	</head>
	<body>
		<div class="container">
			<div class="btn-group">
				<button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown">
				查询类型 <span class="caret"></span>
				</button>
				<ul class="dropdown-menu" id="queryType">
<!-- 					<li><a href="#">Action</a></li>
					<li><a href="#">Another action</a></li>
					<li><a href="#">Something else here</a></li>
					<li class="divider"></li>
					<li><a href="#">Separated link</a></li> -->
				</ul>
			</div>
			<button type="button" class="btn btn-success" id="b01">click</button>
			<div id="myDiv"><h2>Let AJAX change this text</h2></div>
		</div>


	</body>
</html>