$(function() {
	ajax();
	ajax2();
});

$('input[type="file"]').change(function(e) {
	var fileName = e.target.files[0].name;
	alert("this file" + fileName + "has been select");
})

function ajax() {
	
	$("#examDate").on("click",function(event){
		var str = $("#examDate").serialize();
		console.log(str);
		event.preventDefault();
		$.ajax({
			url : "/SelectExamRequest.do",
			type : 'POST',
			datatype : 'JSON',
			data : str,
		success: function(data){
			var stop=1;
			var results = JSON.parse(data);
			var yearSetting = '<option value="">년도선택</option>';
			var examCodeSetting='<option value=""회차선택</option>';
			$.each(results, function(key, value) {
				yearSetting +='<option value="'+value.examDate+'">'+value.examDate+'</option>' ;
				examCodeSetting+='<option value="'+value.examCode+'">'+value.examCode+'</option>';
				
			});
			$("#examDate > option").remove();
			$("#examCode > option").remove();
			$("#examDate").append(yearSetting);
			$("#examCode").append(examCodeSetting);
			$(this).off(event);
			
		},
		error : function(data) {
			alert(error);
		}
		});
	});
}
function ajax1(){
	$("#examDate > option").click(function(event) {
		event.preventDefault();
		var str = $("#examDate > option").serialize();
		console.log(str);
	
		$.ajax({
			url : "/SelectExamRequest.do",
			type : 'POST',
			datatype : 'JSON',
			data : str,
			success : function(data) {
				var results = JSON.parse(data);
				var examCodeSetting='<option value=""회차선택</option>';
				$.each(results, function(key, value) {
					examCodeSetting='<option value="'+value.examCode+'">'+value.examCode+'</option>';
				});
				$("#examCode > option").remove();
				$("#examCode").append(examCodeSetting);
			},
			error : function(data) {
				alert(error);
			}
		});

	});
}
function ajax2(){
	$("#kt_search").bind('click',function(event) {
		event.preventDefault();
		
		var str = $("#form123").serialize();
		console.log(str);
		$.ajax({
			url : "/SelectFilterRequest.do",
			type : 'POST',
			contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
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
	            	tableSetting += '</TR></TBODY>';
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
	

