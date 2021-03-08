$(document).ready(function(){
 	
 	$.datepicker.setDefaults({
        dateFormat: 'yy-mm-dd',	//날짜 포맷이다. 보통 yy-mm-dd 를 많이 사용하는것 같다.
        prevText: '이전 달',	// 마우스 오버시 이전달 텍스트
        nextText: '다음 달',	// 마우스 오버시 다음달 텍스트
        closeText: '닫기', // 닫기 버튼 텍스트 변경
        currentText: '', // 오늘 텍스트 변경
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],	//한글 캘린더중 월 표시를 위한 부분
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],	//한글 캘린더 중 월 표시를 위한 부분
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],	//한글 캘린더 요일 표시 부분
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],	//한글 요일 표시 부분
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],	// 한글 요일 표시 부분
        showMonthAfterYear: true,	// true : 년 월  false : 월 년 순으로 보여줌
        yearSuffix: '년',	//
        showButtonPanel: true,	// 오늘로 가는 버튼과 달력 닫기 버튼 보기 옵션
 	    buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif",
        buttonImageOnly: true
    });
 	
 	$(function(){
 		$("#datepicker").datepicker();
 	});
 	
 	$(function(){
 		$("#datepicker2").datepicker();
 	});
		
	$('#checkall').click(function(){
		if($('#checkall').is(':checked')) {
			for(var i = 0; i < document.getElementsByClassName('deletecheck').length; i++){
				document.getElementsByClassName('deletecheck')[i].checked=true;
			}
		} else {
			for(var i = 0; i < document.getElementsByClassName('deletecheck').length; i++){
				document.getElementsByClassName('deletecheck')[i].checked=false;
			}
		}
	});
	
	$('#deletebtn').click(function(){
		var count = 0;
		var tmp = 0;
		var arr = []
		//삭제버튼 누른 시점에서 체크하기때문에 그 전에는 선택했다 해제해도 상관없다.
		if(confirm("삭제하시겠습니까?")){
			//체크된 체크박스 갯수만큼 반복
			for(var i = 0; i < $('input:checkbox:checked').length; i++){
				tmp = $('input:checkbox:checked')[i].getAttribute('value');
				//전체선택용 체크박스는 값이 null이니 그럴 경우 스킵하게
				if(tmp == null || tmp == ''){
					continue;
				}
				//배열에 추가
				arr.push(tmp);
			}
			console.log(arr);
			console.log(arr.length);
			$.ajax({
				traditional: true,
				type: "POST",
				url: "/deleteMultiProc.pino",
				data: {"array" : arr},
				success: function(data){
					alert('자료가 삭제되었습니다.');
				},
				error: function(error){
				}, complete: function(){
					alert('자료가 삭제되었습니다.');
					location.reload();
				}
			});
		} else {
			return;
		}
	});
});

function check(event){
//	event.preventDefault();
//	var sabun = $('#empsabun').val();
//	var name = $('#empkrname').val();
//	var current = $('#empstate').val();
//	var put = $('#insertstate').val();
//	var pos = $('#emprank').val();
//	var join = $('#join_day').val();
//	var retire = $('#retire_day').val();
//	var jobtype = $('#jobtypebox').val();

	var formdata = new FormData();
	$('#fields').submit();
}

function pageMove(pagenum){
	var f = document.fields
	$('#movePage').val(pagenum);
	f.submit();
}

function pagePrevious(pagenum){
	var f = document.fields
	$('#movePage').val($('#startPage').val());
	f.submit();
}

function pageNext(pagenum){
	var f = document.fields
	$('#movePage').val($('#endPage').val());
	f.submit();
}

function empDetail(sabun){
	//var p = document.getElementById("sabuntag").innerText;

	$('#sabunparam').val(sabun);

	document.getElementById("editform").submit();
}