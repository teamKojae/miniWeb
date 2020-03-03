$(function() {
	ajax();
	excelRead();
	getFilterAjax();
});

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
						$('#studentData').empty();
						$.each(jQuery.parseJSON(data), function(key, value) {

							$('#studentData').append(
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
					}
				});

			});
}

$(function() {
	/*$('.kt-input[name=kojae]').trigger('change',getFilterAjax());	*/
	
	
	$('#locationName').bind('change',function(event){
			getFilterAjax(event) });
});


function getFilterAjax(event){
	$('.kt-input[name=kojae]').on('click',
			function(event) {
				/* console.log($('.kt-input option:selected').val()); --> 선택한 애 */
				event.preventDefault();
				var target = $(event.target);
				
				
				
				// console.log($('.kt-input[option=selected]').length);
				var a = $('.kt-input option:selected');

				$(this).attr('option', 'selected');

				var selectFilter = $('.kt-input[option=selected]');

				//
				// console.log(selectFilter.length);
				// console.log(selectFilter[0].name);
				//						
				// console.log($(this).attr('id'));

				var filterNameArray = [];
				var filterValueArray = [];

				for (var i = 0; i < selectFilter.length; i++) {
					filterNameArray.push(selectFilter[i].id);
					filterValueArray.push(selectFilter[i].value);
				}

				var dataArray = {
					"paramName" : filterNameArray,
					"paramValue" : filterValueArray
				}

				console.log(dataArray);
				console.log(target.attr('id'));

				// || $('.kt-input').change()
				$.ajax({
					url : "/FilterGetExam.do",
					type : 'post',
					dataType : 'json',
					data : dataArray,
					success : function(data) {
						$(event.target).empty();
						console.log(data);
						$.each(data, function(key, value) {

							var contents = target.attr('id');
							console.log(value.locationName);
							if (contents == ('locationName')) {
								$(event.target).append(
										"<option value=" + value.locationName
												+ "> " + value.locationName
												+ "</option>");
							} else if (contents == ('schoolName')) {
								$(event.target).append(
										"<option value=" + value.schoolName
												+ "> " + value.schoolName
												+ "</option>");
								
							}
							$(this).off(event);
						})
						
					}
				});
			});
}

