$(function() {
	ajax();
});

$('input[type="file"]').change(function(e) {
	var fileName = e.target.files[0].name;
	alert("this file" + fileName + "has been select");
})

function ajax() {
	
	$("#year").click(function(event){
		var str = $("#year").serialize();
		event.preventDefault();
		$.ajax({
			url : "/SelectExamRequest.do",
			type : 'POST',
			datatype : 'JSON',
			async:false,
			data : str,
		success: function(data){
			var stop=1;
			var results = JSON.parse(data);
			var yearSetting = '<option value="">년도선택</option>';
			$.each(results, function(key, value) {
				yearSetting +='<option value="'+value.examDate+'">'+value.examDate+'</option>' ;
			});
			$("#year").append(yearSetting);
		},
		error : function(data) {
			alert(error);
		}
		});
	});
	
	
	$("#year").click(function(event) {
		event.preventDefault();
		var str = $("#year").serialize();
		$.ajax({
			url : "/SelectExamRequest.do",
			type : 'POST',
			datatype : 'JSON',
			data : str,
//
			success : function(data) {
				var i = 1;
				var results = JSON.parse(data);
				var examCodeSetting='<option value=""회차선택</option>';
				$.each(results, function(key, value) {
					examCodeSetting='<option value="'+value.examCode+'">'+value.examDate+'</option>';
				});
				$("#examCode > option").remove();
				$("#examCode").append(examCodeSetting);
			},
			error : function(data) {
				alert(error);
			}
		});

	});
	
	$("#kt_search").click(function(event) {
		event.preventDefault();
		var str = $("#form123").serialize();
		$.ajax({
			url : "/SelectFilterRequest.do",
			type : 'POST',
			datatype : 'JSON',
			data : str,
		
			success : function(data) {
				var i=1;
				var results = JSON.parse(data);
				var tableSetting = '<TBODY><TR>';
	            $.each(results , function(key,value){
	            	tableSetting += '<TD>'+i+++'</TD><TD>' +value.studentNo+ '</TD><TD>' + value.StudentName + '</TD><TD>'+value.ExamDate+'</TD><TD>'+value.examNo+'</TD>' +
	            	'<TD>'+value.koreanScore + '</TD><TD>'+ value.englishScore + '</TD><TD>'+ value.mathScore + '</TD>'+
	                '<TD>'+ value.scienceScore + '</TD><TD>'+ value.historyScore + '</TD><TD>'+ value.totalScore + '</TD>' +
	                '<TD>'+ value.averageScore + '</TD>'
	                ;
	            	tableSetting += '</TR><TBODY>';
	           });
	            $("#kt_table_1 > TBODY").remove();
				$("#kt_table_1").append(tableSetting);
			},
			error : function(data) {
				alert(error);
				}
		});
		});
	
	
}
