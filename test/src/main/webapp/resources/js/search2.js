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
 		
	$('#editbtn').click(function(){	
		var p = document.getElementById("sabuntag").innerText;
		$('#sabunparam').val(p);
		document.getElementById("editform").submit();	
	});	
	
	//$('#deletebtn').click(funtion(){
	//	
	//});
	
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
		if(confirm("삭제하시겠습니까?")){
			//체크된 체크박스 갯수만큼 반복
			for(var i = 0; i < $('input:checkbox:checked').length; i++){
			//반복해서 값이 찍힘을 알수있다.
			console.log($('input:checkbox:checked')[i].getAttribute('value'));
			tmp = $('input:checkbox:checked')[i].getAttribute('value');
			arr.push(tmp);
			}
			console.log($('input:checkbox:checked'));
			console.log(arr);
		} else {
			return;
		}
	});
});

function check(event){
//	event.preventDefault();
	var sabun = $('#empsabun').val();
	var name = $('#empkrname').val();
	var current = $('#empstate').val();
	var put = $('#insertstate').val();
	var pos = $('#emprank').val();
	var join = $('#join_day').val();
	var retire = $('#retire_day').val();
	var jobtype = $('#jobtypebox').val();
	
	//모든 인풋 검사
	var input = document.getElementsByClassName("fieldinput");
	//모든 셀렉 검사
	var select = document.getElementsByTagName("select");
	//검사변수
	var exists = 0;
	
//	for(var i = 0; i < input.length; i++){
		//배열로 나오니까 하나씩 담아서
//		var gab = input[i];
//		var gab2 = select[i];
		//값이 있는지 검사해보고
//		if( gab.value.length > 0 || gab2.value.length > 0){
			//검사변수에 값 더해주고
//			exists++;
//		}
//	}
	
//	if(exists >= 1){
		var formdata = new FormData();
		$('#fields').submit();
//	} else if (exists < 1) {
//		alert('검색항목을 한개라도 입력해야합니다');
//		return false;
//	}
	
}
