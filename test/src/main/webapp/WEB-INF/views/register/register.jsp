<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>인사관리시스템</title>
<link rel="shortcut icon" href="#">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/css/w3.css">
<link rel="stylesheet" href="/resources/css/register/register.css">
<link rel="stylesheet" href="/resources/css/register/registerform.css">
<script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="/js/register.js"></script>

</head>
<script type="text/javascript">

</script>
<body>
	<header class="tophead">
		<div class="head">
			<h4 class="brand"> PINOSOFT </h4>
		</div>
		<div class="menu"> 
			<a class="home" href="/main/main.pino">HOME</a>
			<a class="input" href="/register/register.pino">INPUT</a>
			<a class="search" href="/search/search.pino">SEARCH</a>
		</div>
	</header>
	
	<section>
		<div>
			<h2 class="empdetail">직원 상세 정보</h2>
			<div class="w3-right" style="padding-right: 25px; height: 50px;">
				<button type="submit" class="register" id="register">등록</button>
				<button class="reset">초기화</button>
				<button class="previous">이전</button>
			</div>
		</div>
		<form class="fields" id="fields" method="POST" action="/register/registerproc.pino">
			<input type="hidden" id="fname" name="name" value="">
			<input type="hidden" id="fregno" name="reg_no" value="">
			<input type="hidden" id="fhp" name="hp" value="">
			<input type="hidden" id="fid" name="id" value="">
			<input type="hidden" id="fpwd" name="pwd" value="">
			<input type="hidden" id="femail" name="email" value="">


			<img class="profilepic" src="/images/noimage.jpg">
			
			<label class="empno" for="empnum">*사번</label>
			<input type="text" class="empnum" name="empnum" id="empno" disabled/>		
			
			<label class="empname" for="empkrname">*한글성명</label>
			<input type="text" class="empkrname" name="empkrname" id="empkrname">		
			
			<label class="empname2" for="empenname">영문성명</label>
			<input type="text" class="empenname" name="eng_name" id="empenname">
			
			<label class="empiden" for="empid">*아이디</label>
			<input type="text" class="empid" name="empid" id="empid">
			
			<label class="emppass" for="emppw">*패스워드</label>
			<input type="password" class="emppw" name="emppw" id="emppw">
			
			<label class="emppass2" for="emppwcheck">*패스워드 확인</label>
			<input type="password" class="emppwcheck" name="emppwcheck" id="emppwcheck">
			
			<label class="empphone" for="emptel">전화번호</label>
			<input type="text" class="emptel" name="phone" id="emptel">
			
			<label class="empmob" for="empmobile">*핸드폰번호</label>
			<input type="text" class="empmobile" name="empmobile" id="empmobile">
				
			<label class="emprrn" for="empjoomin">*주민번호</label>
			<input type="text" class="empjoomin" name="empjoomin" id="empjoomin" maxlength="14">
			<input type="hidden" class="empjoomin2" name="reg_no" id="empjoomin2">

			<label class="empage" for="empyear">연령</label>
			<input type="text" class="empyear" name="years" id="empyear" onclick="showAge();" value="">
				
			<label class="empeadd" for="empemail">*이메일</label>
			<div class="emaildiv">
			<input type="text" class="empemail" name="empemail" id="empemail">
			<select class="empmailprovider" name="empmailprovider" id="empmailprovider">
				<option value="">(선택)</option>
<c:forEach var="eplist" items="${eplist}">
				<option value="${eplist.emailprovider}">${eplist.emailprovider}</option>
</c:forEach>
			</select>
			<input type="hidden" class="empemailfull" name="empemailfull" id="empemailfull">
			</div>
	
			<label class="empjt" for="empjobtypeselect">직종체크</label>
			<div class="jobandsex">
			<select class="empjobtypeselect" name="job_type" id="empjobtype">
				<option value="">(선택)</option>
<c:forEach var="jtlist" items="${jobtype}">
				<option value="${jtlist.job_type}">${jtlist.job_type}</option>
</c:forEach>
			</select>
			<label class="empgen" for="empgenselect">성별</label>
			<select class="empgenselect" name="sex" id="empgenselect">
				<option value="">(선택)</option>
				<option value="M">남</option>
				<option value="F">여</option>
			</select>
			</div>
			
			<label class="empadd" for="empadd">주소</label>
			<div class="field14">
				<input type="text" name="zip" id="empadd" placeholder="우편번호">
				<button type="button" class="empaddsearchbutton" id="empaddsearchbutton" onclick='execDaumPostCode()'>주소검색</button>
			</div>
			<input type="text" class="empaddsearch" name="addr1" id="empaddsearch" placeholder="주소" style="text-align:left;">
			<input type="text" class="empaddspec" name="addr2" id="empaddspec" placeholder="세부주소" style="text-align:left;">

			<button type="submit" class="button uploadbutton" id="uploadbutton">사진올리기</button>
			<input type="file" name="profilepic" id="profilepic" style="display:none;">
			
			<label class="emprank" for="emprankselect">직위</label>
			<select class="emprankselect" name="job_rank" id="emprankselect">
				<option value="">(선택)</option>
<c:forEach var="jobrank" items="${jobrank}">
				<option value="${jobrank.job_rank}">${jobrank.job_rank}</option>
</c:forEach>
			</select>
				
			<label class="empdept" for="empdeptselect">부서</label>
			<select class="empdeptselect" name="dept_code" id="empdeptselect">
				<option value="">(선택)</option>
<c:forEach var="dept" items="${dept}">
				<option value="${dept.dept}">${dept.dept}</option>
</c:forEach>
			</select>

			<label class="empsal" for="empsalary">연봉</label>
			<input type="text" class="empsalary" name="salary" id="empsalary" placeholder="(만원)" style="text-align: right;">


			<label class="empstatus" for="empstat">입사구분</label>
			<div class="field20">
				<select class="empstatselect" name="current_yn" id="empstatselect">
					<option value="">(선택)</option>
					<option value="Y">입사</option>
					<option value="N">퇴사</option>
				</select>
			</div>
			<label class="emplvl" for="emplevel">등급</label>
			<div class="field21">
				<select class="emplevel" name="gart_level" id="emplevel">
					<option value="">(선택)</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
				</select>
			</div>
			<label class="empins" for="empinsert">투입여부</label>
			<div class="field22">
				<select class="empinsert" name="put_yn" id="empinsert">
					<option value="default">(선택)</option>
					<option value="Y">투입</option>
					<option value="N">대기</option>
				</select>
			</div>
			<label class="empmilstat" for="empmilstate">입대여부</label>
			<div class="field23">
				<select class="empmilstate" name="mil_yn" id="empmilstate">
					<option value="">(선택)</option>
					<option value="N">미필</option>
					<option value="Y">군필</option>
				</select>
			</div>		
			<label class="milt" for="miltype">군별</label>
			<div class="field24">
				<select class="miltype" name="mil_type" id="miltype" disabled="true">
					<option value="">(선택)</option>
<c:forEach var="miltype" items="${miltype}">
					<option value="${miltype.mil_type}">${miltype.mil_type}</option>
</c:forEach>
				</select>
			</div>			
			<label class="milr" for="milrank">계급</label>
			<div class="field25">
				<select class="milrank" name="mil_level" id="milrank" disabled="true">
					<option value="">(선택)</option>
<c:forEach var="milrank" items="${milrank}">
				<option value="${milrank.mil_level}">${milrank.mil_level}</option>
</c:forEach>
				</select>
			</div>			
			<label class="milindate">입영일자</label>
			<div class="field26">
				<input class="mildate" type="text" name="mil_startdate" id="datepicker" disabled="true">
			</div>
			<label class="miloutdate">전역일자</label>
			<div class="field27">
				<input class="mildate" type="text" name="mil_enddate" id="datepicker2" disabled="true">
			</div>

			<label class="kosa" for="kosareg">KOSA등록</label>
			<div class="field28">
				<select class="kosareg" name="kosa_reg_yn" id="kosareg">
					<option value="">(선택)</option>
					<option value="Y">등록</option>
					<option value="N">미등록</option>
				</select>
			</div>			
			<label class="kosa2" for="kosarank">KOSA등급</label>
			<div class="field29">
				<select class="kosarank" name="kosa_class_code" id="kosarank" disabled="true">
					<option value="default">(선택)</option>
<c:forEach var="kclass" items="${kosaclass}">
					<option value="${kclass.kosa_class_code}">${kclass.kosa_class_code}</option>
</c:forEach>
				</select>
			</div>			
			<label class="empindate">입사일자</label>
			<div class="field30">
				<input class="empdate" type="text" name="join_day" id="datepicker3">
			</div>
			<label class="empoutdate">퇴사일자</label>
			<div class="field31">
				<input class="empdate" type="text" name="retire_day" id="datepicker4">
			</div>
			
			<label class="business" for="businessno">사업자번호</label>
			<div class="field32">
				<input class="businessno" type="text" name="cmp_reg_no" id="businessno">
			</div>
			<label class="business2" for="businessname">업체명</label>
			<div class="field33">
				<input class="businessname" type="text" name="crm_name" id="businessname">
			</div>
			<label class="business3" for="businesscert">사업자등록증</label>
			<div class="field34">
				<input class="businesscert" type="text" name="cmp_reg_image" id="businesscert">
			</div>
			<div class="field35">
				<input class="businesscert2" type="file" name="businesscert2" id="businesscert2" accept="image/png, image/jpeg, image/jpg" style="display:none;">
				<input class="uploadcertbtn" id="uploadcertbtn" type="button" value="등록">
				<input class="previewcertbtn" id="previewcertbtn" type="button" value="미리보기">
			</div>
			
			<label class="intro" for="selfintro">자기소개</label>
			<div class="field36">
				<textarea class="selfintro" name="self_intro" id="selfintro"></textarea>
			</div>
			<label class="resume" for="resumelink">이력서</label>
			<div class="field37">
				<input class="resumelink" type="text" name="resume" id="resumelink">
			</div>
			<div class="field38">
				<input class="resume2" type="file" name="resume2" id="resume2" style="display:none;">
				<input class="ruploadbtn" id="uploadbtn" type="button" value="파일 업로드">
				<input class="rpreviewbtn" id="previewbtn" type="button" value="미리보기">
			</div>
		</form>
	</section>
</body>
</html>