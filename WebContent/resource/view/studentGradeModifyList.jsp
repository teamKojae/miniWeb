<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정요청목록</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/adminStyle.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/adminStyleCustom.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/plugins.css">
<script src="${pageContext.request.contextPath}/resource/js/jquery-3.4.1.min.js"></script>
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
						onclick="javascript:document.location.href='${pageContext.request.contextPath}/resource/view/studentMain.jsp';"
						class="kt-menu__link ">HOME</label></li>
					<li class="kt-menu__item fas fa-tools"><label
						onclick="javascript:document.location.href='${pageContext.request.contextPath}/resource/view/studentGradeModify.jsp';"
						class="kt-menu__link ">수정요청</label></li>
					<li class="kt-menu__item fas fa-tools"><label
						onclick="javascript:document.location.href='${pageContext.request.contextPath}/resource/view/studentGradeModifyList.jsp';"
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
						<h3 class="kt-portlet__head-title">수정요청 처리 현황</h3>
					</div>
				</div>


				<div class="kt-portlet__body">
					<!--begin: Search Form -->
					<form class="kt-form kt-form--fit kt-margin-b-20">
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

					</form>
					<!--begin: Datatable -->
					<div
						class="kt-separator kt-separator--border-dashed kt-separator--space-md"></div>

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
												style="width: 30px;" 
												>요청번호</th>

											<th class="sorting" tabindex="0" 
												aria-controls="kt_table_1" rowspan="1" colspan="1" 
												style="width: 80px;" 
												>학생번호</th>
											
											<th class="sorting_asc" tabindex="0"
												aria-controls="kt_table_1" rowspan="1" colspan="1"
												style="width: 200px;" 
												>내용</th>
											<th class="sorting" tabindex="0" 
											    aria-controls="kt_table_1" rowspan="1" colspan="1" style="width: 50px;"
												>상태</th>
					
										</tr>
									</thead>
									<tbody>
									
									<!-- studentNo에 해당하는 수정요청내역 불러오기  -->
										<tr role="row" class="odd">
											<td>1</td>
											<td class="sorting_1" tabindex="0">389203S930D</td>
											<td>빨리 수정해주세요.</td>
											<td style="font-weight: bold;">미처리</td>
										</tr>

									</tbody>
								</table>
								<div id="kt_table_1_processing"
									class="dataTables_processing card" style="display: none;">Processing...</div>
							</div>
						</div>

					</div>

					<div
						class="kt-separator kt-separator--border-dashed kt-separator--space-md"></div>

					

				</div>
			</div>
		</div>
</body>
<script src="https://kit.fontawesome.com/8fe653c8f8.js" crossorigin="anonymous"></script>
</html>
