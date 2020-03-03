$(function() {
	ajax();
});

$('input[type="file"]').change(function(e) {
	var fileName = e.target.files[0].name;
	alert("this file" + fileName + "has been select");
})

function ajax() {
	var stop=1;
	
	if(stop==1){
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
	}
	stop++;
	
	
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
}
