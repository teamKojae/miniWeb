<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/rootui.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/bootstrap-custom.css" >

<script type="text/javascript">
 
if( '${name}'== "fail" ){
	alert('로그인 정보를 다시 확인해주세요');
}

</script>
</head>
<body>

	<div class="rui-main">
		<div class="rui-sign align-items-center justify-content-center">
			<div class="bg-image">
				<div class="bg-grey-1"></div>
			</div>
			<div class="form rui-sign-form rui-sign-form-cloud">
				<div class="row vertical-gap sm-gap justify-content-center">
					<div class="col-12">
						<h1 class="display-4 mb-10 text-center">Admin Login</h1>
					</div>
					<form action="/adminlogin" method="post">
					<div class="col-12">
						<input type="text" class="form-control" name="managerId" id="managerId" placeholder="ID"><br>
					</div>
					<div class="col-12">
						<input type="password" class="form-control" name="managerPassword" id="managerPassword" placeholder="Password"><br>
						<input type="submit" class="btn btn-brand btn-block text-center" value="로그인">
					</div>
					</form>				
				</div>
			</div>
		</div>
	</div>


</body>
</html>