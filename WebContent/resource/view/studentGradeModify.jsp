<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정요청</title>
<link rel="stylesheet" href="../css/adminStyle.css">
<link rel="stylesheet" href="../css/adminStyleCustom.css">
<link rel="stylesheet" href="../css/plugins.css">
<script src="../js/jquery-3.4.1.min.js"></script>
</head>
<body
	class="kt-quick-panel--right kt-demo-panel--right kt-offcanvas-panel--right kt-header--fixed 
	kt-header-mobile--fixed kt-subheader--enabled kt-subheader--transparent kt-aside--enabled 
	kt-aside--fixed kt-aside--minimize">

	<div id="kt_header"
		class="kt-header kt-grid kt-grid--ver  kt-header--fixed ">
		<!-- begin: Header Menu -->
		<button class="kt-header-menu-wrapper-close"
			id="kt_header_menu_mobile_close_btn">
			<i class="la la-close"></i>
		</button>
		<div class="kt-header-menu-wrapper kt-grid__item kt-grid__item--fluid"
			id="kt_header_menu_wrapper">
			<div id="kt_header_menu"
				class="kt-header-menu kt-header-menu-mobile  kt-header-menu--layout- ">
				<div class="col-md-1"></div>
				<ul class="kt-menu__nav ">
					<li class="kt-menu__item fas fa-home"><label
						onclick="javascript:document.location.href='studentMain.jsp';"
						class="kt-menu__link ">HOME</label></li>
					<li class="kt-menu__item fas fa-tools"><label
						onclick="javascript:document.location.href='studentGradeModify.jsp';"
						class="kt-menu__link ">수정요청</label></li>
					<li class="kt-menu__item fas fa-tools"><label
						onclick="javascript:document.location.href='/SelectModify';"
						class="kt-menu__link ">요청내역</label></li>
					<li class="kt-menu__item fas fa-tools"><label
						class="kt-menu__link ">로그아웃</label></li>
				</ul>
			</div>
		</div>
		<!-- end: Header Menu -->
		<!-- begin:: Header Topbar -->

		<!-- end:: Header Topbar -->
	</div>

	<div class="adminPaddingTop">
		<div
			class="kt-content  kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor"
			id="kt_content">
			<div class="kt-portlet kt-portlet--mobile">
				<div class="kt-portlet__head kt-portlet__head--lg">
					<div class="kt-portlet__head-label">
						<span class="kt-portlet__head-icon"> <i
							class="fas fa-user-tie"></i>
						</span>
						<h3 class="kt-portlet__head-title">수정 요청 내역 기입하는 화면, 아직 로그인 후 학생데이터를 받아오지 않았으므로 임의로 </h3>
					</div>
				</div>
				<div class="kt-portlet__body">
					<!--begin: Search Form -->
					<div class="kt-form kt-form--fit kt-margin-b-20">
						<div class="row kt-margin-b-20">
							<div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
								<label style="font-weight: bold;">이름: </label> 강남구5
							</div>
							<div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
								<label style="font-weight: bold;">수험번호: </label> 111D526S3314
							</div>
						</div>
						<div class="row kt-margin-b-20">
							<div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
								<label style="font-weight: bold;">학교: </label> 개표고등학교
							</div>
							<div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
								<label style="font-weight: bold;">지역: </label>강남구
							</div>
						</div>

						<h5>수정하려는 해당 시험 정보</h5>
						111D526S3314 수험번호의 학생의 가장 최근 시험 정보만 select 해와서 여기 보여주기

					</div>
					<!--begin: Datatable -->
					<div
						class="kt-separator kt-separator--border-dashed kt-separator--space-md"></div>

					<div id="kt_table_1_wrapper"
						class="dataTables_wrapper dt-bootstrap4">
						<div class="row">
							<div class="col-sm-12">
								<div id="kt_table_1_processing"
									class="dataTables_processing card" style="display: none;">Processing...</div>
							</div>
						</div>

					</div>
					<!-- form 태그로 서블릿 controller로 보내서  
					수정요청정보 DTO 생성하여 DB에 insert하기  /resource/view/studentGradeModifyList.jsp-->
					<form class="kt-form kt-form--fit kt-margin-b-20"
						action="/InsertModify" method="post">
						<div class="row kt-margin-b-20">
						
							<input type="hidden" name="studentNo" value="111D526S3314">
							<textarea name="modifyContent" rows="5" cols="190" placeholder="수정할 내용을 입력하세요."></textarea>
						
						</div>
						<div align="right">
							<button onclick="alert('전송되었습니다.')" type="submit">전송</button>
						</div>
					</form>


				</div>
			</div>
		</div>
</body>
<script src="https://kit.fontawesome.com/8fe653c8f8.js" crossorigin="anonymous"></script>
</html>
