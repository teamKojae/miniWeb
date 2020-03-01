<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
  $(function() {
    $("button").click(function() {
      var str = $("#form1").serialize();
      $.ajax({
    	url:"/E1",
    	type:'GET',
    	datatype:'JSON',
    	contentType: "application/x-www-form-urlencoded; charset=utf-8",
        data: str,
        
        success: function(data) {
        	console.log('안녕');
        	alert(aa);
        	var a = JSON.parse(data.result);
          		alert(a);
          		
        },	
        error: function(data){
        	alert(data.result);
        	console.log(data.result);
        }
      });
    });
  });
  </script>
<meta charset="UTF-8">
<title>예제</title>
</head>
<body>
안녕
<form id="form1" method="get">
안녕하십니까
<input type="text" name="id">
<input type="password" name="password" >
<button>하이요</button>>
</form>
</body>

</html>