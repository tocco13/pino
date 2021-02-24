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
 			
 	$(function(){
 		$("#datepicker3").datepicker();
 	});
 			
 	$(function(){
 		$("#datepicker4").datepicker();
 	});
 	
 	$("#empkrname").keyup(function(event){
 		if(!(event.keyCode >= 37 && event.keyCode <=40)) {
 			var inputVal = $(this).val();
 			var check = /[a-zA-Z]/;
 			if(check.test(inputVal)){
 			$(this).val("");
 			}
 		}
 	});
 	
 	$("#empenname").keyup(function (event){
 		if(!(event.keyCode >= 37 && event.keyCode <=40)) {
 			var inputVal = $(this).val();
 			var check = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
 			if(check.test(inputVal)){
 			$(this).val("");
 			}
 		}
 	});
 	
 	$('#emppwcheck').focusout(function(){
 		var pw1 = $('#emppw').val();
 		var pw2 = $('#emppwcheck').val();
 		
 		if (pw1 !='' && pw2 ==''){
 			null;
 		} else if (pw1 !=""||pw2 !=""){
 			if (pw1 == pw2) {
 				alert('비밀번호가 일치합니다');
 			} else {
 				alert('비밀번호가 틀립니다');
 			}
 		}
 	});
 	
 			
 	$('#emptel').on('keyup', function() {
 		$(this).val( $(this).val().replace(/[^0-9]/g, "").replace(/(^02|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-") );
 	});
 	
 	$('#empmobile').on('keyup', function() {
 		$(this).val( $(this).val().replace(/[^0-9]/g, "").replace(/(^02|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-") );
 	});
 				
 			
 	$('#empjoomin').on('keyup', function(event){
 		var jooNum = /^[0-9]*$/;
 		var temp = $('#empjoomin').val();
 		if(!jooNum.test(temp)){
 			$('#empjoomin').val(temp.replace(/[^0-9]/g,""));
 		}
 		
 		var str1 = $('#empjoomin').val().substring(0,6);
 		var str2 = $('#empjoomin').val().substring(6, $('#empjoomin').val().length);
 		
 		if($('#empjoomin').val().length > 6){
 			if($('#empjoomin').val().length >= 13){
 				str2 = $('#empjoomin').val().substring(6,13);
 				$('#empjoomin').val(str1+'-'+str2);
 				$('#empjoomin2').val($('#empjoomin').val());				
 			} else {
 				$('#empjoomin').val(str1+'-'+str2);
 				$('#empjoomin2').val($('#empjoomin').val());
 			}
 		} else {
 			str1 = $('#empjoomin').val().substring(0,$('#empjoomin').val().length);
 			$('#empjoomin').val(str1);
 		}
 			
 	});	
 	
 	$('#empsalary').on('keyup', function(event){
 	
 		var salNum = /^[0-9]*$/;
 		var temp = $('#empsalary').val();
 		if(!salNum.test(temp)){
 			$('#empsalary').val(temp.replace(/[^0-9]/g,""));
 		}
 		
 		//input을 사용자가 선택했고 내용이 
 		//공백이 아니면 종료
 		var select = window.getSelection().toString();
 		if (select !== ''){
 			return;
 		}
 		
 		//keyup이벤트가 방향키인 경우 그대로 종료
 		if($.inArray(event.keyCode,[38,40,37,39]) !== -1){
 			return;
 		}
 		
 		//이벤트 발생시킨 this element를 변수에 담고
 		//변수값을 다시 input에 담는다
 		var $this = $('#empsalary');
 		var input = $this.val();
 		
 		//정규식 사용해서 특수문자제거
 		var input = 
 		input.replace(/[\D\s\._\-]+/g,"");
 		
 		//숫자로 변환
 		input = input ? parseInt(input, 10) : 0;
 		
 		//toLocaleString으로 천단위로 쉼표추가
 		$this.val(function(){
 			return (input === 0 ) ? "" : 
 			input.toLocaleString("en-US");
 		});
 	});
 	
 	$('#empmailprovider').change(function(){
 		var str = $('#empemail').val();
 		var str2 = $('#empmailprovider').val();
 		var test = str.concat(str2);
 		$('#empemailfull').attr('value',test);
 	});
 	
 	$('#empmilstate').change(function(){
 		if($(this).val() == 'Y'){
			$('#miltype').prop("disabled",false);
 			$('#milrank').prop("disabled",false);
 			$('#datepicker').prop("disabled",false);
 			$('#datepicker2').prop("disabled",false);
 		} else {
 		 	$('#miltype').prop("disabled",true);
 			$('#milrank').prop("disabled",true);
 			$('#datepicker').prop("disabled",true);
 			$('#datepicker2').prop("disabled",true);
 		}
 	});
 	
 	$('#kosareg').change(function(){
 		if($(this).val() == 'Y'){
 			$('#kosarank').prop("disabled",false);
 		} else {
 			$('#kosarank').prop("disabled",true);
 		}
 	});
 	
 	$('#editbtn').click(function(){
		var krname = $('#empkrname').val();
 		var empid = $('#empid').val();
 		var emppw = $('#emppw').val();
 		var emphp = $('#empmobile').val();
 		var empjoomin = $('#empjoomin2').val();
 		var email = $('#empemailfull').val();

		$('#fname').val(krname);
		$('#fregno').val(empjoomin);
		$('#fhp').val(emphp);
		$('#fid').val(empid);
		$('#fpwd').val(emppw);
		$('#femail').val(email);
		
 		$('#fields').attr('action','/edit/editproc.pino');
 		$('#fields').submit();
 	});
 			
});

function execDaumPostCode() {
	daum.postcode.load(function(){
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById("empadd").value = data.zonecode;
            document.getElementById("empaddsearch").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("empaddspec").focus();
        }
    }).open();
    });
}

function showAge(){
	var age= 0;
	var joomin = document.getElementById("empjoomin2").value;
	alert(joomin);
	if(joomin.length >= 6){
		var yy = joomin.substr(0,2); //생년
		var mm = joomin.substr(2,2); //생월
		var dd = joomin.substr(4,2); //생일
		if(joomin.substr(2,1) == 0){
			mm = joomin.substr(3,1);
		}
	}
	
	//첫 숫자가 0~2가 아니면 1900년대, 맞다면 2000년대생
	today = new Date();
	var i = joomin.substr(0,1);
	var cent = (i>2) ? '19':'20';
	var birthyear = cent+yy;
	var m = today.getMonth()+1; //0-11로 나옴
	var d = today.getDate();
	alert(today.getFullYear());
	var age = today.getFullYear() - birthyear;
	if(mm > m) {
		age--;
	} else if (mm = m){
		if(dd<=d){
			age++;
		} else if (dd > d){
			age--;
		}
	}
	document.getElementById("empyear").value = age;
}