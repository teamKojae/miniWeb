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
		
			var a = jQuery.parseJSON(data);
				alert(a); 
		},
		error : function(data) {
			alert(data.result);
			console.log(data.result);
		}
	});
	
});
}
