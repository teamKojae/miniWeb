<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정요청</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/css/adminStyle.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/css/adminStyleCustom.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/css/plugins.css">
<script
	src="${pageContext.request.contextPath}/resource/js/jquery-3.4.1.min.js"></script>
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
						onclick="javascript:document.location.href='studentMain';"
						class="kt-menu__link ">HOME</label></li>
					<li class="kt-menu__item fas fa-tools"><label
						onclick="javascript:document.location.href='studentGradeModify';"
						class="kt-menu__link ">수정요청</label></li>
					<li class="kt-menu__item fas fa-tools"><label
						onclick="javascript:document.location.href='/SelectModify';"
						class="kt-menu__link ">요청내역</label></li>
					<li class="kt-menu__item fas fa-tools"><label
						onclick="javascript:document.location.href='/Logout';"
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
						<h3 class="kt-portlet__head-title">성적 수정 요청</h3>
					</div>
				</div>
				<div class="kt-portlet__body">
					<!--begin: Search Form -->
					<div class="kt-form kt-form--fit kt-margin-b-20">
						<div class="row kt-margin-b-20">
							<div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
								<label style="font-weight: bold;">이름: </label>
								${student.studentName}
							</div>
							<div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
								<label style="font-weight: bold;">수험번호: </label>
								${student.studentNo}
							</div>
						</div>

						<div class="row kt-margin-b-20">
							<div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
								<label style="font-weight: bold;">학교: </label>
								${student.schoolName}
							</div>
							<div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
								<label style="font-weight: bold;">지역: </label>${student.locationName}
							</div>

						</div>

						<h5>수정 가능한 시험</h5>


						<div id="kt_table_1_wrapper"
							class="dataTables_wrapper dt-bootstrap4">
							<div class="row">
								<div class="col-sm-12">
									<table
										class="table table-striped- table-bordered table-hover table-checkable dataTable dtr-inline"
										id="kt_table_1" role="grid" aria-describedby="kt_table_1_info"
										style="width: 1533px;">
										<thead>
											<tr role="row">
												<th class="sorting_asc" tabindex="0"
													aria-controls="kt_table_1" rowspan="1" colspan="1"
													style="width: 150px;" aria-sort="ascending"
													aria-label="Record ID: activate to sort column descending">학생번호</th>
												<th class="sorting" tabindex="0" aria-controls="kt_table_1"
													rowspan="1" colspan="1" style="width: 100px;"
													aria-label="Order ID: activate to sort column ascending">이름</th>
												<th class="sorting" tabindex="0" aria-controls="kt_table_1"
													rowspan="1" colspan="1" style="width: 150px;"
													aria-label="Country: activate to sort column ascending">일시</th>
												<th class="sorting" tabindex="0" aria-controls="kt_table_1"
													rowspan="1" colspan="1" style="width: 80px;"
													aria-label="Ship City: activate to sort column ascending">회차</th>
												<th class="sorting" tabindex="0" aria-controls="kt_table_1"
													rowspan="1" colspan="1" style="width: 95px;"
													aria-label="Company Agent: activate to sort column ascending">국어</th>
												<th class="sorting" tabindex="0" aria-controls="kt_table_1"
													rowspan="1" colspan="1" style="width: 95px;"
													aria-label="Ship Date: activate to sort column ascending">영어</th>
												<th class="sorting" tabindex="0" aria-controls="kt_table_1"
													rowspan="1" colspan="1" style="width: 95px;"
													aria-label="Status: activate to sort column ascending">수학</th>
												<th class="sorting" tabindex="0" aria-controls="kt_table_1"
													rowspan="1" colspan="1" style="width: 95px;"
													aria-label="Type: activate to sort column ascending">과학</th>
												<th class="sorting" tabindex="0" aria-controls="kt_table_1"
													rowspan="1" colspan="1" style="width: 95px;"
													aria-label="Type: activate to sort column ascending">한국사</th>
												<th class="sorting" tabindex="0" aria-controls="kt_table_1"
													rowspan="1" colspan="1" style="width: 120px;"
													aria-label="Type: activate to sort column ascending">총점</th>
												<th class="sorting" tabindex="0" aria-controls="kt_table_1"
													rowspan="1" colspan="1" style="width: 120px;"
													aria-label="Type: activate to sort column ascending">평균</th>
											</tr>
										</thead>
										<tbody>


											<tr role="row" class="odd">
												<td class="sorting_1" tabindex="0">${studentGrades[0].studentNo}</td>
												<td>${studentGrades[0].studentName}</td>
												<td>${studentGrades[0].examDate}</td>
												<td>${studentGrades[0].examCode}</td>
												<td>${studentGrades[0].koreanScore}</td>
												<td>${studentGrades[0].englishScore}</td>
												<td>${studentGrades[0].mathScore}</td>
												<td>${studentGrades[0].scienceScore}</td>
												<td>${studentGrades[0].historyScore}</td>
												<td>${studentGrades[0].totalScore}</td>
												<td>${studentGrades[0].averageScore}</td>
											</tr>


										</tbody>
									</table>
									<div id="kt_table_1_processing"
										class="dataTables_processing card" style="display: none;">Processing...</div>
								</div>
							</div>

						</div>





					</div>
					<!--begin: Datatable -->

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
						<div class="row kt-margin-b-20"
							style="border-left-width: 10px; padding: 10px;">
							<textarea name="modifyContent" rows="5" cols="200"
								placeholder="수정할 내용을 입력하세요."></textarea>

						</div>
						<div align="right">
							<button onclick="alert('전송되었습니다.')" type="submit">전송</button>
						</div>
					</form>


				</div>
			</div>
		</div>
		</div>
</body>
<script src="https://kit.fontawesome.com/8fe653c8f8.js"
	crossorigin="anonymous"></script>
</html>
