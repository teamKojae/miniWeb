

$('input[type="file"]').change(function(e){
	var fileName = e.target.files[0].name;
	alert("this file"+fileName+"has been select");
})


