<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="">
<head>
<title>Hmmteresting!</title>


<!--[if lt IE 11]>
    	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    	<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->

<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/studentStyle.css">


</head>

<%if(request.getAttribute("result") == "false"){
	%>
<script type="text/javascript">
  alert("로그인 다시하세요.");
</script>
<%} %>

<body>
	<div class="auth-wrapper align-items-stretch bg-white">
		<div class="">
			<div class="auth-side-form">
				<div class="auth-content">
					<div class="text-center">
						<img src="${pageContext.request.contextPath}/resource/view/img/hmmteresting.png" alt="" class="img-fluid mb-5"
						style="height: 80px">
						<h1 class="f-w-400">성적조회 사이트에 오신걸 환영합니다</h1>
					</div>
					
					<!-- 로그인아이디비번 확인하는 서블릿 만들어서 연결 -->
					<form class="my-5" method="post" action="/Login">
						<div class="row">
						
							<div class="col-sm-6">
								<div class="form-group">
									<label>이름</label> <input type="text" name="name" class="form-control"
										placeholder="김말자">
								</div>
							</div>
							
							<div class="col-sm-6">
								<div class="form-group">
									<label>수험번호</label> <input type="text" name="studentNo" class="form-control"
										placeholder="102945EM93D03">
								</div>
							</div>
							
							<div class="col-sm-6">
								<div class="form-group">
									<label>주민번호</label> <input type="password" name="juminNo" class="form-control"
									placeholder="9506**-1*****">
								</div>
							</div>

						</div>
						<div class="form-group">
							<div class="row justify-content-between">
								<div class="col-auto">
									<p>
										<small><b>*절대 수험번호 및 주민등록번호를 알려주지 마세요</b></small>
									</p>
								</div>
								<div class="col-auto text-right">
									<button class="btn btn-primary btn-block mb-3"
									style="background-color: #336fd0; border-color: #1366eb;">조회하기</button>
								</div>
							</div>
						</div>
					</form>

				</div>
				<div class="footer-cont text-center">
					<h6 class="mb-0 text-muted">©2001–2019 All Rights Reserved.
						Hmmteresting®</h6>
				</div>
			</div>
		</div>
	</div>


	<script src="assets/js/plugins/bootstrap.min.js"></script>
	<script src="assets/js/pcoded.min.js"></script>
	<script src="assets/js/menu-setting.js"></script>


</body>
</html>