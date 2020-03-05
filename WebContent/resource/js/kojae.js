$(function() {
	excelRead();
	getLocationAjax();
	getSchoolNames();
	
});

document.write("<script type='text/javascript' src='/resource/js/soobin.js'><"+"/script>");  
function excelRead() {
	$('#fileUpload').change(
			function(event) {
				// Get form
				event.preventDefault();
				var form = $('#AdminExcelUpload')[0];
				var data = new FormData(form);
				$.ajax({
					enctype : 'multipart/form-data',
					url : "/AdminExcelRead.do",
					type : 'POST',
					processData : false,
					contentType : false,
					data : data,
					success : function(data) {
						// alert(data);
						$('#kt_table_1').empty();
						$('#kt_table_1').append("<tbody>");
						$.each(jQuery.parseJSON(data), function(key, value) {
							console.log(key);
							$('#kt_table_1').append(
									'<tr role="row" class="odd">' + '<td>'
											+ (key + 1) + '</td>' + '<td>'
											+ value[0] + '</td>' + '<td>'
											+ value[1] + '</td>' + '<td>'
											+ value[2] + '</td>' + '<td>'
											+ value[3] + '회차</td>' + '<td>'
											+ value[4] + '</td>' + '<td>'
											+ value[5] + '</td>' + '<td>'
											+ value[6] + '</td>' + '<td>'
											+ value[7] + '</td>' + '<td>'
											+ value[8] + '</td>' + '<td>'
											+ value[9] + '</td>' + '<td>'
											+ value[10] + '</td>' + +'</tr>'
							);
						})
						$('#kt_table_1').append("</tbody>");
						page();
					}
				});

			});
}

function getLocationAjax() {
	$('#locationName').on(
			'click',
			function(event) {
				event.preventDefault();
				// var str = $("#examDate").serialize();
				$.ajax({
					url : "/FilterGetExam.do",
					type : 'POST',
					dataType : 'JSON',
					success : function(data) {
						$('#locationName').empty();
						$(this).attr('option', 'selected');
						$(event.target).append("<option value=''>구 선택</td>");
						$.each(data, function(key, value) {
							$(event.target).append(
									"<option value=" + value.locationName
											+ "> " + value.locationName
											+ "</option>");
						});
						$(this).off(event);
					}
				});

			});
}

function getSchoolNames() {
	$('#locationName').bind(
			'change',
			function(event) {
				event.preventDefault();
				$.ajax({
					url : "/FilterGetExam.do",
					type : 'POST',
					dataType : 'JSON',
					data : "locationName=" + $('#locationName').val(),
					success : function(data) {
						$('#schoolName').empty();
						$('#schoolName').append("<option value=''>학교선택</td>");

						$.each(data, function(key, value) {
							$('#schoolName').append(
									"<option value=" + value.schoolName + "> "
											+ value.schoolName + "</option>");

						})
					}
				})
			})
}
