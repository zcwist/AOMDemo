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
					 	htmlObj = $.ajax({url: 'http://localhost:8080/AOMDemo/index.jsp', async:false});
						console.log(htmlObj.responseText);
						$("#myDiv").html(htmlObj.responseText);
					});
					
			   });
		  </script>
		<title>Insert title here</title>
	</head>
	<body>
		<div class="container">
			<div class="btn-group">
				<button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown">
				Success <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="#">Action</a></li>
					<li><a href="#">Another action</a></li>
					<li><a href="#">Something else here</a></li>
					<li class="divider"></li>
					<li><a href="#">Separated link</a></li>
				</ul>
			</div>
			<button type="button" class="btn btn-success" id="b01">click</button>
			<div id="myDiv"><h2>Let AJAX change this text</h2></div>
		</div>


	</body>
</html>