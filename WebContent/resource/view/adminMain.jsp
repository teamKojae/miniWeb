<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%  request.setCharacterEncoding("UTF-8");  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head >
<meta charset="UTF-8">


<title>Insert title here</title>
<!-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminStyle.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminStyleCustom.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/plugins.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script> -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/adminStyle.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/adminStyleCustom.css"  >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/plugins.css"  >

<script src="${pageContext.request.contextPath}/resource/js/kojae.js"></script>
 <script src="${pageContext.request.contextPath}/resource/js/soobin.js"></script>
 <script src="https://kit.fontawesome.com/8fe653c8f8.js" crossorigin="anonymous"></script>

 

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
					<li class="kt-menu__item fas fa-home "><label
						class="kt-menu__link ">HOME</label></li>

					<li class="kt-menu__item fas fa-tools"><label
						class="kt-menu__link ">수정요청</label><span>5</span></li>


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
						<h3 class="kt-portlet__head-title">This Page Hmmteresting
							Adamin</h3>
					</div>
					<div class="kt-portlet__head-toolbar">
						<div class="kt-portlet__head-wrapper">
							<div class="kt-portlet__head-actions">
								<div class="dropdown dropdown-inline">

									<div class="dropdown-menu dropdown-menu-right">
										<ul class="kt-nav">
											<li class="kt-nav__section kt-nav__section--first"><span
												class="kt-nav__section-text">Choose an option</span></li>
											<li class="kt-nav__item"><a href="#"
												class="kt-nav__link"> <i
													class="kt-nav__link-icon la la-print"></i> <span
													class="kt-nav__link-text">Print</span>
											</a></li>
											<li class="kt-nav__item"><a href="#"
												class="kt-nav__link"> <i
													class="kt-nav__link-icon la la-copy"></i> <span
													class="kt-nav__link-text">Copy</span>
											</a></li>
											<li class="kt-nav__item"><a href="#"
												class="kt-nav__link"> <i
													class="kt-nav__link-icon la la-file-excel-o"></i> <span
													class="kt-nav__link-text">Excel</span>
											</a></li>
											<li class="kt-nav__item"><a href="#"
												class="kt-nav__link"> <i
													class="kt-nav__link-icon la la-file-text-o"></i> <span
													class="kt-nav__link-text">CSV</span>
											</a></li>
											<li class="kt-nav__item"><a href="#"
												class="kt-nav__link"> <i
													class="kt-nav__link-icon la la-file-pdf-o"></i> <span
													class="kt-nav__link-text">PDF</span>
											</a></li>
										</ul>
									</div>
								</div>
								<form action="/AdminStudentUpload.do" method="post"  enctype="multipart/form-data">
										<div class="filebox">
										<i class="fas fa-file-upload"></i>
										<label id="labelExcel"> 엑셀 업로드</label>
								&nbsp; <input name="file" type="file"  id="fileUpload" style="width:200px">
										<label id="checkExcel"> 확인하기</label>
										<button type="submit" class="btn btn-brand btn-elevate btn-icon-sm">보내기</button>
									</div>
									</form>
									
								<!-- 	<script type="text/javascript">
									$('input[type="file"]').change(function(e){
										var fileValue = $("#fileUpload").val();
										var fileName = e.target.files[0].name;
										var fileaa = e.target.files[0].path;
										console.log(fileValue);
										console.log(fileName);
										console.log(aa);
									});
									</script> -->
							</div>
						</div>
					</div>
				</div>
			

				<div class="kt-portlet__body">
					<!--begin: Search Form -->

					<form id="form123" method="post" class="kt-form kt-form--fit kt-margin-b-20">
						<div class="row kt-margin-b-20">
							<div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
								<label>이름<c:out value="${list.get(0).getExamNo() }"></c:out></label> <input type="text" name="studentName"
									class="form-control kt-input" placeholder="" data-col-index="0">
							</div>
							<div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
								<label>수험번호</label> <input type="text"	name="studentNo"
									class="form-control kt-input" placeholder="" data-col-index="1">
							</div>
							<div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
								<label>지역</label> <select class="form-control kt-input" name="locationName"
									data-col-index="7">
									
								</select>
							</div>
							<div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
								<label>학교</label> <select class="form-control kt-input" name="schoolName"
									data-col-index="2">
									
								</select>
							</div>

						</div>

						<div class="row kt-margin-b-20">
							<div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
								<label>년도</label> <select class="form-control kt-input" name="examDate" id="year"
									data-col-index="2">
									
								</select>
							</div>

							<div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
								<label>회차선택</label> <select class="form-control kt-input" name="examCode" id="examCode"
									data-col-index="6">
								
								</select>
							</div>
							

						</div>

						<div class="kt-separator kt-separator--md kt-separator--dashed"></div>

						<div class="row">
							<div class="col-lg-3">
								<button class="btn btn-primary btn-brand--icon" id="kt_search">
									<span> <i class="fas fa-search"></i> <span>검색하기&nbsp;&nbsp;</span>
									</span>
								</button>
								&nbsp;&nbsp;

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
												style="width: 40px;" aria-sort="ascending"
												aria-label="Record ID: activate to sort column descending">번호</th>
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
									<tr role="row" class="odd" id="#kt_table_TR">
											<td>1</td>
											<td class="sorting_1" tabindex="0">389203S930D</td>
											<td>고재현</td>
											<td>2020-02-28</td>
											<td>1회차</td>
											<td>90</td>
											<td>80</td>
											<td>100</td>
											<td>100</td>
											<td>100</td>
											<td>270</td>
											<td>90</td>
										</tr>
			
								</table>
								<div id="kt_table_1_processing"
									class="dataTables_processing card" style="display: none;">Processing...</div>
							</div>
						</div>
						<div class="row">
							
							<div class="col-sm-12 col-md-7 dataTables_pager">
								<div class="dataTables_length" id="kt_table_1_length">
									
								<div class="dataTables_paginate paging_simple_numbers"
									id="kt_table_1_paginate">
									<ul class="pagination">
										<li class=" paginate_button page-item previous disabled"
											id="kt_table_1_previous"><a href="#"
											aria-controls="kt_table_1" data-dt-idx="0" tabindex="0"
											class="page-link"><i class="fas fa-arrow-left"></i></a></li>
										<li class="paginate_button page-item active"><a href="#"
											aria-controls="kt_table_1" data-dt-idx="1" tabindex="0"
											class="page-link">1</a></li>
										<li class="paginate_button page-item "><a href="#"
											aria-controls="kt_table_1" data-dt-idx="2" tabindex="0"
											class="page-link">2</a></li>
										<li class="paginate_button page-item "><a href="#"
											aria-controls="kt_table_1" data-dt-idx="3" tabindex="0"
											class="page-link">3</a></li>
										<li class="paginate_button page-item "><a href="#"
											aria-controls="kt_table_1" data-dt-idx="4" tabindex="0"
											class="page-link">4</a></li>
										<li class="paginate_button page-item next"
											id="kt_table_1_next"><a href="#"
											aria-controls="kt_table_1" data-dt-idx="5" tabindex="0"
											class="page-link"><i class="fas fa-arrow-right"></i></a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<!--end: Datatable -->
				</div>
			</div>
		</div>
	</div>

</body>
</html>
