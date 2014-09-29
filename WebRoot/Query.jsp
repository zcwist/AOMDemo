<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		<script src="script.js"></script>
		<title>Insert title here</title>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="btn-group col-md-2">
					<button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown">
					查询类型 <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" id="queryType">
						<!-- list query type here -->
					</ul>
				</div>
				<div class="col-md-2" id="queryTypeName"></div>
				<div class="col-md-2 col-md-offset-6">
					<button type="button" class="btn btn-success" id="update">更新配置</button>
				</div>
				
			</div>
			<div class="row">
				<div class="col-md-6 col-md-offset-3" id="inputPropertyList">
					<!-- Input Property List here -->
				</div>
			</div>
		</div>


	</body>
</html>