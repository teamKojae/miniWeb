<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div
	class="kt-container  kt-container--fluid  kt-grid__item kt-grid__item--fluid">
	<div class="alert alert-light alert-elevate" role="alert">
		<div class="alert-icon">
			<i class="flaticon-warning kt-font-brand"></i>
		</div>
		<div class="alert-text">
			This example is almost identical to text based individual column
			example and provides the same functionality. With server-side
			processing enabled, all paging, searching, ordering actions that
			DataTables performs are handed off to a server where an SQL engine
			(or similar) can perform these actions on the large data set. See
			official documentation <a class="kt-link kt-font-bold"
				href="https://datatables.net/examples/api/multi_filter_select.html"
				target="_blank">here</a>.
		</div>
	</div>

	<div class="kt-portlet kt-portlet--mobile">
		<div class="kt-portlet__head kt-portlet__head--lg">
			<div class="kt-portlet__head-label">
				<span class="kt-portlet__head-icon"> <i
					class="kt-font-brand flaticon2-line-chart"></i>
				</span>
				<h3 class="kt-portlet__head-title">Hmmteresting Adamin</h3>
			</div>
			<div class="kt-portlet__head-toolbar">
				<div class="kt-portlet__head-wrapper">
					<div class="kt-portlet__head-actions">
						<div class="dropdown dropdown-inline">

							<div class="dropdown-menu dropdown-menu-right">
								<ul class="kt-nav">
									<li class="kt-nav__section kt-nav__section--first"><span
										class="kt-nav__section-text">Choose an option</span></li>
									<li class="kt-nav__item"><a href="#" class="kt-nav__link">
											<i class="kt-nav__link-icon la la-print"></i> <span
											class="kt-nav__link-text">Print</span>
									</a></li>
									<li class="kt-nav__item"><a href="#" class="kt-nav__link">
											<i class="kt-nav__link-icon la la-copy"></i> <span
											class="kt-nav__link-text">Copy</span>
									</a></li>
									<li class="kt-nav__item"><a href="#" class="kt-nav__link">
											<i class="kt-nav__link-icon la la-file-excel-o"></i> <span
											class="kt-nav__link-text">Excel</span>
									</a></li>
									<li class="kt-nav__item"><a href="#" class="kt-nav__link">
											<i class="kt-nav__link-icon la la-file-text-o"></i> <span
											class="kt-nav__link-text">CSV</span>
									</a></li>
									<li class="kt-nav__item"><a href="#" class="kt-nav__link">
											<i class="kt-nav__link-icon la la-file-pdf-o"></i> <span
											class="kt-nav__link-text">PDF</span>
									</a></li>
								</ul>
							</div>
						</div>
						&nbsp; <a href="#" class="btn btn-brand btn-elevate btn-icon-sm">
							<i class="la la-plus"></i> New Record
						</a>
					</div>
				</div>
			</div>
		</div>

		<div class="kt-portlet__body">
			<!--begin: Search Form -->
			<form class="kt-form kt-form--fit kt-margin-b-20">
				<div class="row kt-margin-b-20">
					<div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
						<label>이름</label> <input type="text" class="form-control kt-input"
							placeholder="" data-col-index="0">
					</div>
					<div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
						<label>수험번호</label> <input type="text"
							class="form-control kt-input" placeholder="" data-col-index="1">
					</div>
					<div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
						<label>학교</label> <select class="form-control kt-input"
							data-col-index="2">
							<option value="">학교선택</option>
							<option value="Argentina">Argentina</option>
							<option value="Austria">Austria</option>
							<option value="China">China</option>
							<option value="Colombia">Colombia</option>
							<option value="Croatia">Croatia</option>
							<option value="Indonesia">Indonesia</option>
							<option value="Thailand">Thailand</option>
						</select>
					</div>

				</div>

				<div class="row kt-margin-b-20">
					<div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
						<label>년도</label> <select class="form-control kt-input"
							data-col-index="2">
							<option value="">년도선택</option>
							<option value="Argentina">Argentina</option>
							<option value="Austria">Austria</option>
							<option value="China">China</option>
							<option value="Colombia">Colombia</option>
							<option value="Croatia">Croatia</option>
							<option value="Indonesia">Indonesia</option>
							<option value="Thailand">Thailand</option>
						</select>
					</div>

					<div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
						<label>회차선택</label> <select class="form-control kt-input"
							data-col-index="6">
							<option value="">회차 선택</option>
							<option value="1">Pending</option>
							<option value="2">Delivered</option>
							<option value="3">Canceled</option>
							<option value="5">Info</option>
							<option value="6">Danger</option>
						</select>
					</div>
					<div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
						<label>지역</label> <select class="form-control kt-input"
							data-col-index="7">
							<option value="">구 선택</option>
							<option value="1">Online</option>
							<option value="2">Retail</option>
							<option value="3">Direct</option>
						</select>
					</div>
				</div>

				<div class="kt-separator kt-separator--md kt-separator--dashed"></div>

				<div class="row">
					<div class="col-lg-12">
						<button class="btn btn-primary btn-brand--icon" id="kt_search">
							<span> <i class="la la-search"></i> <span>Search</span>
							</span>
						</button>
						&nbsp;&nbsp;
						<button class="btn btn-secondary btn-secondary--icon"
							id="kt_reset">
							<span> <i class="la la-close"></i> <span>Reset</span>
							</span>
						</button>
					</div>
				</div>
			</form>
			<!--begin: Datatable -->

			<div
				class="kt-separator kt-separator--border-dashed kt-separator--space-md"></div>

			<div id="kt_table_1_wrapper" class="dataTables_wrapper dt-bootstrap4">
				<div class="row">
					<div class="col-sm-12">
						<table
							class="table table-striped- table-bordered table-hover table-checkable dataTable dtr-inline"
							id="kt_table_1" role="grid" aria-describedby="kt_table_1_info"
							style="width: 1533px;">
							<thead>
								<tr role="row">
									<th class="sorting_asc" tabindex="0" aria-controls="kt_table_1"
										rowspan="1" colspan="1" style="width: 128.256px;"
										aria-sort="ascending"
										aria-label="Record ID: activate to sort column descending">Record
										ID</th>
									<th class="sorting" tabindex="0" aria-controls="kt_table_1"
										rowspan="1" colspan="1" style="width: 117.256px;"
										aria-label="Order ID: activate to sort column ascending">Order
										ID</th>
									<th class="sorting" tabindex="0" aria-controls="kt_table_1"
										rowspan="1" colspan="1" style="width: 112.256px;"
										aria-label="Country: activate to sort column ascending">Country</th>
									<th class="sorting" tabindex="0" aria-controls="kt_table_1"
										rowspan="1" colspan="1" style="width: 186.256px;"
										aria-label="Ship City: activate to sort column ascending">Ship
										City</th>
									<th class="sorting" tabindex="0" aria-controls="kt_table_1"
										rowspan="1" colspan="1" style="width: 204.256px;"
										aria-label="Company Agent: activate to sort column ascending">Company
										Agent</th>
									<th class="sorting" tabindex="0" aria-controls="kt_table_1"
										rowspan="1" colspan="1" style="width: 129.256px;"
										aria-label="Ship Date: activate to sort column ascending">Ship
										Date</th>
									<th class="sorting" tabindex="0" aria-controls="kt_table_1"
										rowspan="1" colspan="1" style="width: 104.256px;"
										aria-label="Status: activate to sort column ascending">Status</th>
									<th class="sorting" tabindex="0" aria-controls="kt_table_1"
										rowspan="1" colspan="1" style="width: 79.2557px;"
										aria-label="Type: activate to sort column ascending">Type</th>
									<th class="sorting_disabled" rowspan="1" colspan="1"
										style="width: 126.5px;" aria-label="Actions">Actions</th>
								</tr>
							</thead>


							<tfoot>
								<tr>
									<th rowspan="1" colspan="1">Record ID</th>
									<th rowspan="1" colspan="1">Order ID</th>
									<th rowspan="1" colspan="1">Country</th>
									<th rowspan="1" colspan="1">Ship City</th>
									<th rowspan="1" colspan="1">Company Agent</th>
									<th rowspan="1" colspan="1">Ship Date</th>
									<th rowspan="1" colspan="1">Status</th>
									<th rowspan="1" colspan="1">Type</th>
									<th rowspan="1" colspan="1">Actions</th>
								</tr>
							</tfoot>
							<tbody>
								<tr role="row" class="odd">
									<td class="sorting_1" tabindex="0">1</td>
									<td>61715-075</td>
									<td>China</td>
									<td>Tieba</td>
									<td>Nixie Sailor</td>
									<td>2/12/2018</td>
									<td><span
										class="kt-badge  kt-badge--primary kt-badge--inline kt-badge--pill">Canceled</span></td>
									<td><span class="kt-badge kt-badge--primary kt-badge--dot"></span>&nbsp;<span
										class="kt-font-bold kt-font-primary">Retail</span></td>
									<td><span class="dropdown"> <a href="#"
											class="btn btn-sm btn-clean btn-icon btn-icon-md"
											data-toggle="dropdown" aria-expanded="true"> <i
												class="la la-ellipsis-h"></i>
										</a>
											<div class="dropdown-menu dropdown-menu-right">
												<a class="dropdown-item" href="#"><i class="la la-edit"></i>
													Edit Details</a> <a class="dropdown-item" href="#"><i
													class="la la-leaf"></i> Update Status</a> <a
													class="dropdown-item" href="#"><i class="la la-print"></i>
													Generate Report</a>
											</div>
									</span> <a href="#" class="btn btn-sm btn-clean btn-icon btn-icon-md"
										title="View"> <i class="la la-edit"></i>
									</a></td>
								</tr>
								<tr role="row" class="even">
									<td class="sorting_1" tabindex="0">2</td>
									<td>63629-4697</td>
									<td>Indonesia</td>
									<td>Cihaur</td>
									<td>Emelita Giraldez</td>
									<td>8/6/2017</td>
									<td><span
										class="kt-badge  kt-badge--danger kt-badge--inline kt-badge--pill">Danger</span></td>
									<td><span class="kt-badge kt-badge--success kt-badge--dot"></span>&nbsp;<span
										class="kt-font-bold kt-font-success">Direct</span></td>
									<td><span class="dropdown"> <a href="#"
											class="btn btn-sm btn-clean btn-icon btn-icon-md"
											data-toggle="dropdown" aria-expanded="true"> <i
												class="la la-ellipsis-h"></i>
										</a>
											<div class="dropdown-menu dropdown-menu-right">
												<a class="dropdown-item" href="#"><i class="la la-edit"></i>
													Edit Details</a> <a class="dropdown-item" href="#"><i
													class="la la-leaf"></i> Update Status</a> <a
													class="dropdown-item" href="#"><i class="la la-print"></i>
													Generate Report</a>
											</div>
									</span> <a href="#" class="btn btn-sm btn-clean btn-icon btn-icon-md"
										title="View"> <i class="la la-edit"></i>
									</a></td>
								</tr>
								<tr role="row" class="odd">
									<td class="sorting_1" tabindex="0">3</td>
									<td>68084-123</td>
									<td>Argentina</td>
									<td>Puerto Iguazú</td>
									<td>Ula Luckin</td>
									<td>5/26/2016</td>
									<td><span
										class="kt-badge kt-badge--brand kt-badge--inline kt-badge--pill">Pending</span></td>
									<td><span class="kt-badge kt-badge--primary kt-badge--dot"></span>&nbsp;<span
										class="kt-font-bold kt-font-primary">Retail</span></td>
									<td><span class="dropdown"> <a href="#"
											class="btn btn-sm btn-clean btn-icon btn-icon-md"
											data-toggle="dropdown" aria-expanded="true"> <i
												class="la la-ellipsis-h"></i>
										</a>
											<div class="dropdown-menu dropdown-menu-right">
												<a class="dropdown-item" href="#"><i class="la la-edit"></i>
													Edit Details</a> <a class="dropdown-item" href="#"><i
													class="la la-leaf"></i> Update Status</a> <a
													class="dropdown-item" href="#"><i class="la la-print"></i>
													Generate Report</a>
											</div>
									</span> <a href="#" class="btn btn-sm btn-clean btn-icon btn-icon-md"
										title="View"> <i class="la la-edit"></i>
									</a></td>
								</tr>
								<tr role="row" class="even">
									<td class="sorting_1" tabindex="0">4</td>
									<td>67457-428</td>
									<td>Indonesia</td>
									<td>Talok</td>
									<td>Evangeline Cure</td>
									<td>7/2/2016</td>
									<td><span
										class="kt-badge kt-badge--brand kt-badge--inline kt-badge--pill">Pending</span></td>
									<td><span class="kt-badge kt-badge--success kt-badge--dot"></span>&nbsp;<span
										class="kt-font-bold kt-font-success">Direct</span></td>
									<td><span class="dropdown"> <a href="#"
											class="btn btn-sm btn-clean btn-icon btn-icon-md"
											data-toggle="dropdown" aria-expanded="true"> <i
												class="la la-ellipsis-h"></i>
										</a>
											<div class="dropdown-menu dropdown-menu-right">
												<a class="dropdown-item" href="#"><i class="la la-edit"></i>
													Edit Details</a> <a class="dropdown-item" href="#"><i
													class="la la-leaf"></i> Update Status</a> <a
													class="dropdown-item" href="#"><i class="la la-print"></i>
													Generate Report</a>
											</div>
									</span> <a href="#" class="btn btn-sm btn-clean btn-icon btn-icon-md"
										title="View"> <i class="la la-edit"></i>
									</a></td>
								</tr>
								<tr role="row" class="odd">
									<td class="sorting_1" tabindex="0">5</td>
									<td>31722-529</td>
									<td>Austria</td>
									<td>Sankt Andrä-Höch</td>
									<td>Tierney St. Louis</td>
									<td>5/20/2017</td>
									<td><span
										class="kt-badge  kt-badge--danger kt-badge--inline kt-badge--pill">Delivered</span></td>
									<td><span class="kt-badge kt-badge--success kt-badge--dot"></span>&nbsp;<span
										class="kt-font-bold kt-font-success">Direct</span></td>
									<td><span class="dropdown"> <a href="#"
											class="btn btn-sm btn-clean btn-icon btn-icon-md"
											data-toggle="dropdown" aria-expanded="true"> <i
												class="la la-ellipsis-h"></i>
										</a>
											<div class="dropdown-menu dropdown-menu-right">
												<a class="dropdown-item" href="#"><i class="la la-edit"></i>
													Edit Details</a> <a class="dropdown-item" href="#"><i
													class="la la-leaf"></i> Update Status</a> <a
													class="dropdown-item" href="#"><i class="la la-print"></i>
													Generate Report</a>
											</div>
									</span> <a href="#" class="btn btn-sm btn-clean btn-icon btn-icon-md"
										title="View"> <i class="la la-edit"></i>
									</a></td>
								</tr>
								<tr role="row" class="even">
									<td class="sorting_1" tabindex="0">6</td>
									<td>64117-168</td>
									<td>China</td>
									<td>Rongkou</td>
									<td>Gerhard Reinhard</td>
									<td>11/26/2016</td>
									<td><span
										class="kt-badge  kt-badge--info kt-badge--inline kt-badge--pill">Info</span></td>
									<td><span class="kt-badge kt-badge--success kt-badge--dot"></span>&nbsp;<span
										class="kt-font-bold kt-font-success">Direct</span></td>
									<td><span class="dropdown"> <a href="#"
											class="btn btn-sm btn-clean btn-icon btn-icon-md"
											data-toggle="dropdown" aria-expanded="true"> <i
												class="la la-ellipsis-h"></i>
										</a>
											<div class="dropdown-menu dropdown-menu-right">
												<a class="dropdown-item" href="#"><i class="la la-edit"></i>
													Edit Details</a> <a class="dropdown-item" href="#"><i
													class="la la-leaf"></i> Update Status</a> <a
													class="dropdown-item" href="#"><i class="la la-print"></i>
													Generate Report</a>
											</div>
									</span> <a href="#" class="btn btn-sm btn-clean btn-icon btn-icon-md"
										title="View"> <i class="la la-edit"></i>
									</a></td>
								</tr>
								<tr role="row" class="odd">
									<td class="sorting_1" tabindex="0">7</td>
									<td>43857-0331</td>
									<td>China</td>
									<td>Baiguo</td>
									<td>Englebert Shelley</td>
									<td>6/28/2016</td>
									<td><span
										class="kt-badge  kt-badge--danger kt-badge--inline kt-badge--pill">Delivered</span></td>
									<td><span class="kt-badge kt-badge--success kt-badge--dot"></span>&nbsp;<span
										class="kt-font-bold kt-font-success">Direct</span></td>
									<td><span class="dropdown"> <a href="#"
											class="btn btn-sm btn-clean btn-icon btn-icon-md"
											data-toggle="dropdown" aria-expanded="true"> <i
												class="la la-ellipsis-h"></i>
										</a>
											<div class="dropdown-menu dropdown-menu-right">
												<a class="dropdown-item" href="#"><i class="la la-edit"></i>
													Edit Details</a> <a class="dropdown-item" href="#"><i
													class="la la-leaf"></i> Update Status</a> <a
													class="dropdown-item" href="#"><i class="la la-print"></i>
													Generate Report</a>
											</div>
									</span> <a href="#" class="btn btn-sm btn-clean btn-icon btn-icon-md"
										title="View"> <i class="la la-edit"></i>
									</a></td>
								</tr>
								<tr role="row" class="even">
									<td class="sorting_1" tabindex="0">8</td>
									<td>64980-196</td>
									<td>Croatia</td>
									<td>Vinica</td>
									<td>Hazlett Kite</td>
									<td>8/5/2016</td>
									<td><span
										class="kt-badge  kt-badge--danger kt-badge--inline kt-badge--pill">Danger</span></td>
									<td><span class="kt-badge kt-badge--danger kt-badge--dot"></span>&nbsp;<span
										class="kt-font-bold kt-font-danger">Online</span></td>
									<td><span class="dropdown"> <a href="#"
											class="btn btn-sm btn-clean btn-icon btn-icon-md"
											data-toggle="dropdown" aria-expanded="true"> <i
												class="la la-ellipsis-h"></i>
										</a>
											<div class="dropdown-menu dropdown-menu-right">
												<a class="dropdown-item" href="#"><i class="la la-edit"></i>
													Edit Details</a> <a class="dropdown-item" href="#"><i
													class="la la-leaf"></i> Update Status</a> <a
													class="dropdown-item" href="#"><i class="la la-print"></i>
													Generate Report</a>
											</div>
									</span> <a href="#" class="btn btn-sm btn-clean btn-icon btn-icon-md"
										title="View"> <i class="la la-edit"></i>
									</a></td>
								</tr>
								<tr role="row" class="odd">
									<td class="sorting_1" tabindex="0">9</td>
									<td>0404-0360</td>
									<td>Colombia</td>
									<td>San Carlos</td>
									<td>Freida Morby</td>
									<td>3/31/2017</td>
									<td><span
										class="kt-badge  kt-badge--danger kt-badge--inline kt-badge--pill">Delivered</span></td>
									<td><span class="kt-badge kt-badge--danger kt-badge--dot"></span>&nbsp;<span
										class="kt-font-bold kt-font-danger">Online</span></td>
									<td><span class="dropdown"> <a href="#"
											class="btn btn-sm btn-clean btn-icon btn-icon-md"
											data-toggle="dropdown" aria-expanded="true"> <i
												class="la la-ellipsis-h"></i>
										</a>
											<div class="dropdown-menu dropdown-menu-right">
												<a class="dropdown-item" href="#"><i class="la la-edit"></i>
													Edit Details</a> <a class="dropdown-item" href="#"><i
													class="la la-leaf"></i> Update Status</a> <a
													class="dropdown-item" href="#"><i class="la la-print"></i>
													Generate Report</a>
											</div>
									</span> <a href="#" class="btn btn-sm btn-clean btn-icon btn-icon-md"
										title="View"> <i class="la la-edit"></i>
									</a></td>
								</tr>
								<tr role="row" class="even">
									<td class="sorting_1" tabindex="0">10</td>
									<td>52125-267</td>
									<td>Thailand</td>
									<td>Maha Sarakham</td>
									<td>Obed Helian</td>
									<td>1/26/2017</td>
									<td><span
										class="kt-badge kt-badge--brand kt-badge--inline kt-badge--pill">Pending</span></td>
									<td><span class="kt-badge kt-badge--success kt-badge--dot"></span>&nbsp;<span
										class="kt-font-bold kt-font-success">Direct</span></td>
									<td><span class="dropdown"> <a href="#"
											class="btn btn-sm btn-clean btn-icon btn-icon-md"
											data-toggle="dropdown" aria-expanded="true"> <i
												class="la la-ellipsis-h"></i>
										</a>
											<div class="dropdown-menu dropdown-menu-right">
												<a class="dropdown-item" href="#"><i class="la la-edit"></i>
													Edit Details</a> <a class="dropdown-item" href="#"><i
													class="la la-leaf"></i> Update Status</a> <a
													class="dropdown-item" href="#"><i class="la la-print"></i>
													Generate Report</a>
											</div>
									</span> <a href="#" class="btn btn-sm btn-clean btn-icon btn-icon-md"
										title="View"> <i class="la la-edit"></i>
									</a></td>
								</tr>
							</tbody>
						</table>
						<div id="kt_table_1_processing" class="dataTables_processing card"
							style="display: none;">Processing...</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12 col-md-5">
						<div class="dataTables_info" id="kt_table_1_info" role="status"
							aria-live="polite">Showing 1 to 10 of 40 entries</div>
					</div>
					<div class="col-sm-12 col-md-7 dataTables_pager">
						<div class="dataTables_length" id="kt_table_1_length">
							<label>Display <select name="kt_table_1_length"
								aria-controls="kt_table_1"
								class="custom-select custom-select-sm form-control form-control-sm"><option
										value="5">5</option>
									<option value="10">10</option>
									<option value="25">25</option>
									<option value="50">50</option></select></label>
						</div>
						<div class="dataTables_paginate paging_simple_numbers"
							id="kt_table_1_paginate">
							<ul class="pagination">
								<li class="paginate_button page-item previous disabled"
									id="kt_table_1_previous"><a href="#"
									aria-controls="kt_table_1" data-dt-idx="0" tabindex="0"
									class="page-link"><i class="la la-angle-left"></i></a></li>
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
								<li class="paginate_button page-item next" id="kt_table_1_next"><a
									href="#" aria-controls="kt_table_1" data-dt-idx="5"
									tabindex="0" class="page-link"><i class="la la-angle-right"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!--end: Datatable -->
		</div>
	</div>
	</div>
</html>