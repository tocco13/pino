$(document).ready(function(){
 	
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
 		var empjoomin = $('#empjoomin').val();
 		var email = $('#empemailfull').val();

		$('#fname').val(krname);
		$('#fregno').val(empjoomin);
		$('#fhp').val(emphp);
		$('#fid').val(empid);
		$('#fpwd').val(emppw);
		$('#femail').val(email);
		
		var salary = $('#empsalary').val();
		alert(salary);
		if(salary == "" || salary == null){
			salary = 0;
		} else {
			salary = parseInt(salary.replace(/\,/g,''), 10);
			alert(salary);
		}
		$('#fixedsalary').val(salary);
		
		var sabun = $('#empno').val();
		$('#realempno').val(sabun);
		
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
	var joomin = document.getElementById("empjoomin").value;
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

// 연봉 입력시 콤마찍기
function comma(str) {
    str = String(str);
    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}
//콤마풀기
function uncomma(str) {
    str = String(str);
    return str.replace(/,/g, '');
}
//값 입력시 콤마찍기
function inputNumberFormat(obj) {
    obj.value = comma(uncomma(obj.value));
}