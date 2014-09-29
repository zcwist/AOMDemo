
$(document).ready(function() {
	var data = {};
	function generateQueryTypeList(){
		$.post('http://localhost:8080/AOMDemo/servlet/ForAjax', {Command: 'getQueryType'}, function(data, textStatus, xhr){
			if (textStatus == 'success'){
				console.log(data);
				$("#queryType").html(json2QueryTypeList(data));
				$("#queryType li a").bind('click', function() {
					/* Act on the event */
					console.log($(this).html());

					queryType = $(this).html();
					$("#queryTypeName").html(queryType);
					var propertyListData = {};
					$.post('http://localhost:8080/AOMDemo/servlet/ForAjax', {Command: 'getPropertyList', QueryType: queryType}, function(propertyListData, textStatus, xhr) {
					/*optional stuff to do after success */
						console.log(propertyListData);
						if (textStatus == 'success'){
							$("#inputPropertyList").html(json2formGroup(propertyListData));
						}
					});


				});
			}
		});
	}
	generateQueryTypeList();
	$("#update").click(function() {
		var data = {};
		$.post('http://localhost:8080/AOMDemo/servlet/ForAjax', {Command: 'update'}, function(data, textStatus, xhr) {
			/*optional stuff to do after success */
			console.log('Updating');
			if (textStatus == 'success'){
				generateQueryTypeList();
				alert('配置文件升级成功');
			}
		});
	});
	// $("#b01").click(function() {
	// 	var data = {}
	// 	// $.getJSON('http://localhost:8080/AOMDemo/servlet/ForAjax', function(json, textStatus) {
	// 	// 		$("#myDiv").html(json);

	// 	// 		console.log(json2formGroup(json));
	// 	// 		$("#myDiv").html(json2formGroup(json))
	// 	// });
	// 	$.post('http://localhost:8080/AOMDemo/servlet/ForAjax', {Command: 'getPropertyList'}, function(data, textStatus, xhr) {
	// 	/*optional stuff to do after success */
	// 		console.log(data);
	// 		if (textStatus == 'success'){
	// 			$("#myDiv").html(json2formGroup(data));
	// 		}
	// 	});
	// });
	
	function json2formGroup(json){
		s = '<form role="form">';
		$.each(json.value, function(index, val) {
			s += '<div class="form-group">';
			s += '<label for="' + val +'">' + val + '</label>';
			s += '<input type="text" class="form-control" + id="' + val + '" placeholder="">';
			s += "</div>";
			});
		s += '<button type="submit" class="btn btn-default">查询</button>';
		s += '</form>';
		console.log(s);
		return s;
	}

	function json2QueryTypeList(json){
		s = '';
		$.each(json.value, function(index, val) {
			 s += '<li><a>' + val + '</a></li>';

		});
		return s;
	}
	function test(){
		console.log("hehe");
	}
	
});