
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
							$("#submit").click(function(event) {
								queryData = JSON.stringify(makeQueryData(propertyListData));
								console.log(queryData);
								$.post('http://localhost:8080/AOMDemo/servlet/ForAjax', {Command: 'getQueryResult', QueryType: queryType, QueryData: queryData}, function(data, textStatus, xhr) {
									/*optional stuff to do after success */
									//render the table
									$("#resultTable").html(renderTable(data));

								});

							});
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

	
	function json2formGroup(json){
		s = '<form role="form">';
		$.each(json.value, function(index, val) {
			s += '<div class="form-group">';
			s += '<label for="' + val +'">' + val + '</label>';
			s += '<input type="text" class="form-control" + id="' + val + '" placeholder="">';
			s += "</div>";
			});
		s += '<button type="button" class="btn btn-default" id="submit">查询</button>';
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

	function makeQueryData(json){
		s = {}; //query key and value
		$.each(json.value, function(index, val) {
			 /* iterate through array or object */
			s[val] = $("#"+val).val();
			console.log($("#"+val).val());
		});
		return s;
	}

	function renderTable(json){
		s = '<table class="table">';
		// table head
		s += '<tr>';
		$.each(json.input, function(index, val) {
			 /* iterate through array or object */
			 s += '<th>' + index + '</th>';
		});
		$.each(json.output[0], function(index, val) {
			 /* iterate through array or object */
			 s += '<th>' + index + '</th>';
		});
		s += '</tr>';

		//table content
		$.each(json.output, function(index, val) {
			s += '<tr>';
			 /* iterate through array or object */
			 $.each(json.input, function(index, val) {
			 	 /* iterate through array or object */
			 	 s += '<td>' + val + '</td'>

			 });
			 $.each(val, function(index, val) {
			 	 /* iterate through array or object */
			 	 s += '<td>' + val + '</td'>
			 });
			 s += '</tr>';
		});

		s += '</table>';
		return s;

		
	}
	
});