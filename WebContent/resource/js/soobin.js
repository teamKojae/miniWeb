$(function() {
	ajax();
	ajax1();
	ajax2();
});

//$('input[type="file"]').change(function(e) {
//	var fileName = e.target.files[0].name;
//	alert("this file" + fileName + "has been select");
//})

function ajax() {

	$("#examDate")
			.on(
					"click",
					function(event) {
						event.preventDefault();
						$
								.ajax({
									url : "/SelectExamRequest.do",
									type : 'POST',
									datatype : 'JSON',
									success : function(data) {
										var stop = 1;
										var results = JSON.parse(data);
										var yearSetting = '<option value="">년도 선택</option>';
										var examCodeSetting = '<option value="">회차 선택</option>';
										$
												.each(
														results,
														function(key, value) {
															yearSetting += '<option value="'
																	+ value.examDate
																	+ '">'
																	+ value.examDate
																	+ '</option>';
															examCodeSetting += '<option value="'
																	+ value.examCode
																	+ '">'
																	+ value.examCode
																	+ '회차</option>';

														});
										$("#examDate > option").remove();
										$("#examCode > option").remove();
										$("#examDate").append(yearSetting);
										$("#examCode").append(examCodeSetting);
										$(this).off(event);

									},
									error : function(data) {
										alert(error);
									}
								});
					});
}
function ajax1(){
	$("#examDate").bind("change",function(event) {
		event.preventDefault();
		var str="examDate="+$("#examDate").val();
		console.log(str);
		$.ajax({
			url : "/SelectExamRequest.do",
			type : 'POST',
			datatype : 'JSON',
			data : str,
			success : function(data) {
				var results = JSON.parse(data);
				var examCodeSetting='<option value="">회차 선택</option>';
				$.each(results, function(key, value) {
					examCodeSetting+='<option value="'+value.examCode+'">'+value.examCode+'회차</option>';
				});
				$("#examCode > option").remove();
				$("#examCode").append(examCodeSetting);
			},
			error : function(data) {
				alert(error);
			}
		});

	});

}
function ajax2() {
	$("#kt_search")
			.bind(
					'click',
					function(event) {
						event.preventDefault();
						var str = $("#form123").serialize();
						$
								.ajax({
									url : "/SelectFilterRequest.do",
									type : 'POST',
									contentType : "application/x-www-form-urlencoded; charset=UTF-8",
									datatype : 'JSON',
									data : str,
									success : function(data) {
										var i = 1;
										var results = JSON.parse(data);
										var tableSetting = '<TBODY><TR>';
										$.each(results, function(key, value) {
											tableSetting += '<TD>' + i++
													+ '</TD><TD>'
													+ value.studentNo
													+ '</TD><TD>'
													+ value.StudentName
													+ '</TD><TD>'
													+ value.ExamDate
													+ '</TD><TD>'
													+ value.examNo + '</TD>'
													+ '<TD>'
													+ value.koreanScore
													+ '</TD><TD>'
													+ value.englishScore
													+ '</TD><TD>'
													+ value.mathScore + '</TD>'
													+ '<TD>'
													+ value.scienceScore
													+ '</TD><TD>'
													+ value.historyScore
													+ '</TD><TD>'
													+ value.totalScore
													+ '</TD>' + '<TD>'
													+ value.averageScore
													+ '</TD>';
											tableSetting += '</TR></TBODY>';
										});
										$("#kt_table_1 > TBODY").remove();
										$("#kt_table_1").append(tableSetting);
										page();
									},
									error : function(data) {
										alert(error);
									}
								});
					});
}

function page() {

	$('.paginated').each(
			function() {

				var pagesu = 10; // 페이지 번호 갯수
				var currentPage = 0;
				var numPerPage = 30; // 목록의 수
				var $table = $(this);
				var pagination = $("#kt_table_1_paginate");
				// length로 원래 리스트의 전체길이구함
				var numRows = $table.find('tbody tr').length;
				// Math.ceil를 이용하여 반올림
				var numPages = Math.ceil(numRows / numPerPage);
				// 리스트가 없으면 종료
				if (numPages == 0)
					return;
				// pager라는 클래스의 div엘리먼트 작성
				var $pager = $('<div class="pager"></div>');
				var nowp = currentPage;
				var endp = nowp + 10;
				// 페이지를 클릭하면 다시 셋팅
				$table.bind('repaginate', function() {
					// 기본적으로 모두 감춘다, 현재페이지+1 곱하기 현재페이지까지 보여준다
					$table.find('tbody tr').hide().slice(
							currentPage * numPerPage,
							(currentPage + 1) * numPerPage).show();
					$(".pagination").empty();
					if (numPages > 1) { // 한페이지 이상이면
						if (currentPage < 5 && numPages - currentPage >= 5) { // 현재
																				// 5p
																				// 이하이면
							nowp = 0; // 1부터
							endp = pagesu; // 10까지
						} else {
							nowp = currentPage - 5; // 6넘어가면 2부터 찍고
							endp = nowp + pagesu; // 10까지
							pi = 1;
						}
						if (numPages < endp) { // 10페이지가 안되면
							endp = numPages; // 마지막페이지를 갯수 만큼
							nowp = numPages - pagesu; // 시작페이지를 갯수 -10
						}
						if (nowp < 1) { // 시작이 음수 or 0 이면
							nowp = 0; // 1페이지부터 시작
						}
					} else { // 한페이지 이하이면
						nowp = 0; // 한번만 페이징 생성
						endp = numPages;
					}
					
					$('#kt_table_1_paginate').attr('style','display:flex');
					$('#kt_table_1_paginate').append(function(){});
					
					
					// [처음]   Tag 지옥에 오신걸 환영합니다 ^^
					$('<li class=" paginate_button page-item previous" >'+
						'<a href="#" pointer-events: none; class="page-link">'
						+'<i class="fas fa-angle-double-left"></i></a></li>').bind(
							'click',
							{
								newPage : page
							},
							function(event) {

								currentPage = 0;

								$table.trigger('repaginate');

								$($(".pageNum")[2]).addClass('active')
										.siblings().removeClass('active');

							}).appendTo(pagination).addClass('clickable');

					// [이전]

					$('<li class=" paginate_button page-item previous">'+
							'<a href="#" pointer-events: none; class="page-link">'
							+'<i class="fas fa-angle-left"></i></a></li>').bind(
							'click',
							{
								newPage : page
							},
							function(event) {

								if (currentPage == 0)
									return;

								currentPage = currentPage - 1;

								$table.trigger('repaginate');

								$($(".pageNum")[(currentPage - nowp) + 2])
										.addClass('active').siblings()
										.removeClass('active');

							}).appendTo(pagination).addClass('clickable');

					// [1,2,3,4,5,6,7,8]

					for (var page = nowp; page < endp; page++) {

						$('<li class="paginate_button page-item">'
						   +'/li>')
						.html('<a href="#" style="pointer-events: none;" class="page-link">' + (page + 1) +'</a>').bind(
								'click',
								{
									newPage : page
								},
								function(event) {

									currentPage = event.data['newPage'];

									$table.trigger('repaginate');

									$($(".pageNum")[(currentPage - nowp) + 2])
											.addClass('active').siblings()
											.removeClass('active');

								}).appendTo(pagination).addClass('clickable');

					}

					// [다음]

					$('<li class=" paginate_button page-item previous">'+
							'<a href="#" pointer-events: none; class="page-link">'
							+'<i class="fas fa-angle-right"></i></a></li>').bind(
							'click',
							{
								newPage : page
							},
							function(event) {

								if (currentPage == numPages - 1)
									return;

								currentPage = currentPage + 1;

								$table.trigger('repaginate');

								$($(".pageNum")[(currentPage - nowp) + 2])
										.addClass('active').siblings()
										.removeClass('active');

							}).appendTo(pagination).addClass('clickable');

					// [끝]

					$('<li class=" paginate_button page-item previous">'+
							'<a href="#" style= pointer-events: none; class="page-link">'
							+'<i class="fas fa-angle-double-right"></i></a></li>').bind(
							'click',
							{
								newPage : page
							},
							function(event) {

								currentPage = numPages - 1;

								$table.trigger('repaginate');

								$($(".pageNum")[endp - nowp + 1]).addClass(
										'active').siblings().removeClass(
										'active');

							}).appendTo(pagination).addClass('clickable');
					
					
					
					$($(".pageNum")[2]).addClass('active');
				});

				$pager.insertAfter($table).find('span.pageNum:first').next()
						.next().addClass('active');
				$pager.appendTo(pagination);
				$table.trigger('repaginate');

			});

}
