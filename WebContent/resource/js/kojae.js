  $(function() {
	  ajax();
  });

$('input[type="file"]').change(function(e) {
	var fileName = e.target.files[0].name;
	alert("this file" + fileName + "has been select");
})

function ajax(){ 
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
