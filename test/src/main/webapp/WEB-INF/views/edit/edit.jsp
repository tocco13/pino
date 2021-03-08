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
<link rel="shortcut icon" href="resources/images/noimage.jpg">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/css/w3.css">
<link rel="stylesheet" href="/resources/css/register/register.css">
<link rel="stylesheet" href="/resources/css/register/registerform.css">
<script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="/js/edit.js"></script>

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
				<button type="button" class="editbtn" id="editbtn">수정</button>
				<button class="delete" id="deletebtn">삭제</button>
				<button class="previous" id="gobackbtn">이전</button>
			</div>
		</div>
		<form class="pic" id="pic" method="POST" action="/upload.pino" enctype="multipart/form-data">
		<input type="file" name="profilepic" id="profilepic" style="display:none;" onchange="setThumbnail(event,'profilepic2');">
		<input type="hidden" id="fid2" name="id" value="${list['profilelink']}">
		</form>
		<form class="bcert" id="bcertform" method="POST" enctype="multipart/form-data">
		<input type="file" name="certpic" id="uploadcert" style="display:none;" onchange="preview(event,'imgbcert'); showFile(this,'businesscert');">
		<input type="hidden" id="fid3" name="id" value="${list['cmp_reg_link']}">
		</form>
		<form class="resume" id="resumeform" enctype="multipart/form-data">
		<input type="file" class="resume2" name="resume" id="uploadres" style="display:none;" onchange="preview(event,'imgres');showFile(this, 'resumename');">
		<input type="hidden" id="fid4" name="id" value="${list[resumelink]}">
		</form>
		<form class="fields" id="fields" method="POST" action="/edit/editproc.pino">
			<input type="hidden" id="femail" name="email" value="">
	<c:if test="${list['profile'] eq null }">
			<img class="profilepic" id="profilepic2" src="../resources/images/noimage.jpg"/>
	</c:if>
	<c:if test="${list['profile'] ne null }">
			<img class="profilepic" id="profilepic2" src="../resources/images/uploads/<c:out value="${list['profile'] }"/>"/>
	</c:if>
	
			<label class="empno" for="empnum">*사번</label>
			<input type="text" class="empnum" name="sabun" id="empno" readonly="readonly" value=" <c:out value="${list['sabun']}"/>" />	
			
			<label class="empname" for="empkrname">*한글성명</label>
			<input type="text" class="empkrname" name="name" id="empkrname" value="<c:out value="${list['name']}"/>">		
			
			<label class="empname2" for="empenname">영문성명</label>
			<input type="text" class="empenname" name="eng_name" id="empenname" value="<c:out value="${list['eng_name']}"/>">
					
			<label class="empiden" for="empid">*아이디</label>
			<input type="text" class="empid" name="id" id="empid" value="<c:out value="${list['id']}"/>">
			
			<label class="emppass" for="emppw">*패스워드</label>
			<input type="password" class="emppw" name="pwd" id="emppw" value="<c:out value="${list['pwd']}"/>">
			
			<label class="emppass2" for="emppwcheck">*패스워드 확인</label>
			<input type="password" class="emppwcheck" name="emppwcheck" id="emppwcheck" value="<c:out value="${list['pwd']}"/>">
			
			<label class="empphone" for="emptel">전화번호</label>
			<input type="text" class="emptel" name="phone" id="emptel" value="<c:out value="${list['phone']}"/>">
		
			<label class="empmob" for="empmobile">*핸드폰번호</label>
			<input type="text" class="empmobile" name="hp" id="empmobile" value="<c:out value="${list['hp']}"/>">
				
			<label class="emprrn" for="empjoomin">*주민번호</label>
			<input type="text" class="empjoomin" name="reg_no" id="empjoomin" onchange="showAge();showGen();" maxlength="14" value="<c:out value="${list['reg_no']}"/>">
			
			<label class="empage" for="empyear">연령</label>
			<input type="text" class="empyear" name="years" id="empyear" value="<c:out value="${list['years']}"/>" readonly="readonly">
				
			<label class="empeadd" for="empemail">*이메일</label>
			<div class="emaildiv">
			<input type="text" class="empemail" name="empemail" id="empemail" value="<c:out value="${list['email']}"/>">
			<select class="empmailprovider" name="empmailprovider" id="empmailprovider">
				<option value="<c:out value="${list['emailprovider']}"/>"><c:out value="${list['emailprovider']}"/></option>
<c:forEach var="eplist" items="${eplist}">
				<option value="${eplist.emailprovider}">${eplist.emailprovider}</option>
</c:forEach>
			</select>
			<input type="hidden" class="empemailfull" name="email" id="empemailfull" value="">
			</div>
			
			<label class="empjt" for="empjobtypeselect">직종체크</label>
			<div class="jobandsex">
			<select class="empjobtypeselect" name="job_type" id="empjobtype">
				<option  value="<c:out value="${list['job_type']}"/>"><c:out value="${list['job_type']}"/></option>
<c:forEach var="jtlist" items="${jobtype}">
				<option value="${jtlist.job_type}">${jtlist.job_type}</option>
</c:forEach>
			</select>
	
			<label class="empgen" for="empgenselect">성별</label>
			<select class="empgenselect" name="sex" id="empgenselect" readonly="readonly">
				<option value="<c:out value="${list['sex']}"/>"> 
			<c:set var="gen"><c:out value="${list['sex']}"/></c:set>
			<c:if test="${gen eq 'M' }">
				남
			</c:if>
			<c:if test="${gen eq 'F' }">
				여
			</c:if>
				</option>
			</select>
			</div>
			
			<label class="empadd" for="empadd">주소</label>
			<div class="field14">
				<input type="text" name="zip" id="empadd"  value="<c:out value="${list['zip']}"/>"">
				<button type="button" class="empaddsearchbutton" id="empaddsearchbutton" onclick='execDaumPostCode()'>주소검색</button>
			</div>
			<input type="text" class="empaddsearch" name="addr1" id="empaddsearch"  value="<c:out value="${list['addr1']}"/>" style="text-align:left;">
			<input type="text" class="empaddspec" name="addr2" id="empaddspec" value="<c:out value="${list['addr2']}"/>" style="text-align:left;">

			<label for="profilepic" class="uploadbutton">사진업로드</label>
			
			<label class="emprank" for="emprankselect">직위</label>
			<select class="emprankselect" name="pos_gbn_code" id="emprankselect">
				<option  value="<c:out value="${list['pos_gbn_code']}"/>"><c:out value="${list['pos_gbn_code']}"/></option>
<c:forEach var="jobrank" items="${jobrank}">
				<option value="${jobrank.pos_gbn_code}">${jobrank.pos_gbn_code}</option>
</c:forEach>
			</select>
				
			<label class="empdept" for="empdeptselect">부서</label>
			<select class="empdeptselect" name="dept_code" id="empdeptselect">
				<option value="<c:out value="${list['dept_code']}"/>"><c:out value="${list['dept_code']}"/></option>
<c:forEach var="dept" items="${dept}">
				<option value="${dept.dept_code}">${dept.dept_code}</option>
</c:forEach>
			</select>

			<label class="empsal" for="empsalary">연봉</label>
			<input type="text" class="empsalary" id="empsalary"  value="<c:out value="${list['salary']}"/>" style="text-align: right;" onkeyup="inputNumberFormat(this);" onchange="inputNumberFormat(this);" >
			<input type="hidden" id="fixedsalary" name="salary"/>

			<label class="empstatus" for="empstat">입사구분</label>
			<div class="field20">
				<select class="empstatselect" name="current_yn" id="empstatselect">
					<option value="<c:out value="${list['current_yn']}"/>">
					<c:set var="current"><c:out value="${list['current_yn']}"/></c:set>
					<c:if test="${current eq 'Y' }">
						입사
					</c:if>
					<c:if test="${current eq 'N' }">
						퇴사
					</c:if>
					</option>
					<option value="Y">입사</option>
					<option value="N">퇴사</option>
				</select>
			</div>
			<label class="emplvl" for="emplevel">등급</label>
			<div class="field21">
				<select class="emplevel" name="gart_level" id="emplevel">
					<option value="<c:out value="${list['gart_level']}"/>">
					<c:out value="${list['gart_level']}"/>
					</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>

				</select>
			</div>
			<label class="empins" for="empinsert">투입여부</label>
			<div class="field22">
				<select class="empinsert" name="put_yn" id="empinsert">
					<option value="<c:out value="${list['put_yn']}"/>">
					
					<c:set var="put"><c:out value="${list['put_yn']}"/></c:set>
					<c:if test="${put eq 'Y' }">
						투입
					</c:if>
					<c:if test="${put eq 'N' }">
						대기
					</c:if>
					
					</option>
					<option value="Y">투입</option>
					<option value="N">대기</option>
				</select>
			</div>
			<label class="empmilstat" for="empmilstate">입대여부</label>
			<div class="field23">
				<select class="empmilstate" name="mil_yn" id="empmilstate">
					<option value="<c:out value="${list['mil_yn']}"/>">
					
					<c:set var="mil"><c:out value="${list['mil_yn']}"/></c:set>
					<c:if test="${mil eq 'Y' }">
						군필
					</c:if>
					<c:if test="${mil eq 'N' }">
						미필
					</c:if>
					
					</option>
					<option value="N">미필</option>
					<option value="Y">군필</option>
				</select>
			</div>		
			<label class="milt" for="miltype">군별</label>
			<div class="field24">
				<select class="miltype" name="mil_type" id="miltype" ${list['mil_yn'] == null ? 'disabled' : 'N' ? 'disabled' : ''}>
					<option value="<c:out value="${list['mil_type']}"/>"><c:out value="${list['mil_type']}"/></option>
<c:forEach var="miltype" items="${miltype}">
					<option value="${miltype.mil_type}">${miltype.mil_type}</option>
</c:forEach>
				</select>
			</div>			
			<label class="milr" for="milrank">계급</label>
			<div class="field25">
				<select class="milrank" name="mil_level" id="milrank" ${list['mil_yn'] == null ? 'disabled' : 'N' ? 'disabled' : ''}>
					<option value="<c:out value="${list['mil_level']}"/>"><c:out value="${list['mil_level']}"/></option>
<c:forEach var="milrank" items="${milrank}">
				<option value="${milrank.mil_level}">${milrank.mil_level}</option>
</c:forEach>
				</select>
			</div>			
			<label class="milindate">입영일자</label>
			<div class="field26">
				<input class="mildate" type="text" name="mil_startdate" id="datepicker1" readonly="readonly" value="<c:out value="${list['mil_startdate']}"/>" readonly="readonly" ${list['mil_yn'] == null ? 'disabled' : 'N' ? 'disabled' : ''}>
			</div>
			<label class="miloutdate">전역일자</label>
			<div class="field27">
				<input class="mildate" type="text" name="mil_enddate" id="datepicker2" readonly="readonly" value="<c:out value="${list['mil_enddate']}"/>" readonly="readonly" ${list['mil_yn'] == null ? 'disabled' : 'N' ? 'disabled' : ''}>
			</div>

			<label class="kosa" for="kosareg">KOSA등록</label>
			<div class="field28">
				<select class="kosareg" name="kosa_reg_yn" id="kosareg" >
					<option value="<c:out value="${list['kosa_reg_yn']}"/>">
					
					<c:set var="kosa"><c:out value="${list['kosa_reg_yn']}"/></c:set>
					<c:if test="${kosa eq 'Y' }">
						등록
					</c:if>
					<c:if test="${kosa eq 'N' }">
						미등록
					</c:if>
					
					</option>
					<option value="Y">등록</option>
					<option value="N">미등록</option>
				</select>
			</div>			
			<label class="kosa2" for="kosarank">KOSA등급</label>
			<div class="field29">
				<select class="kosarank" name="kosa_class_code" id="kosarank" ${list['kosa_reg_yn'] == null ? 'disabled' : 'N' ? 'disabled' : ''}>
					<option value="<c:out value="${list['kosa_class_code']}"/>"><c:out value="${list['kosa_class_code']}"/></option>
<c:forEach var="kclass" items="${kosaclass}">
					<option value="${kclass.kosa_class_code}">${kclass.kosa_class_code}</option>
</c:forEach>
				</select>
			</div>			
			<label class="empindate">입사일자</label>
			<div class="field30">
				<input class="empdate" type="text" name="join_day" id="datepicker3" readonly="readonly" value="<c:out value="${list['join_day']}"/>"${list['current_yn'] == null ? '' : 'N' ? 'disabled' : ''}>
			</div>
			<label class="empoutdate">퇴사일자</label>
			<div class="field31">
				<input class="empdate" type="text" name="retire_day" id="datepicker4" readonly="readonly" value="<c:out value="${list['retire_day']}"/>" ${list['mil_yn'] == null ? '' : 'N' ? 'disabled' : ''}>
			</div>
			
			<label class="business" for="businessno">사업자번호</label>
			<div class="field32">
				<input class="businessno" type="text" name="cmp_reg_no" id="businessno" value="<c:out value="${list['cmp_reg_no']}"/>">
			</div>
			<label class="business2" for="businessname">업체명</label>
			<div class="field33">
				<input class="businessname" type="text" name="crm_name" id="businessname" value="<c:out value="${list['crm_name']}"/>">
			</div>
			<label class="business3" for="businesscert">사업자등록증</label>
			<div class="field34">
				<input class="businesscert" type="text" name="cmp_reg_image" id="businesscert" value="<c:out value="${list['cmp_reg_image']}"/>">
			</div>
				<div class="field35">
				<label class="uploadcertbtn" for="uploadcert">   등록    </label> 
				<input class="previewcertbtn" id="previewcertbtn" type="button" value="미리보기" onclick="openpreview(event, 'bcertmodal');">
			</div>
			
			<label class="intro" for="selfintro">자기소개</label>
			<div class="field36">
				<textarea class="selfintro" name="self_intro" id="selfintro"><c:out value="${list['self_intro']}"/></textarea>
			</div>
			<label class="resume" for="resumename">이력서</label>
			<div class="field37">
				<input class="resumename" type="text" name="resume" id="resumename" value="<c:out value="${list['resume']}"/>">
			</div>
			<div class="field38">
				<label class="ruploadbtn" for="uploadres">파일 업로드</label>
				<input class="rpreviewbtn" id="previewbtn" type="button" value="미리보기" onclick="openpreview(event, 'resmodal');">
			</div>
<%-- </c:forEach> --%>
		</form>
		
		<!-- 사업자등록증   -->
		<div id="bcertmodal" class="w3-modal dnone">
			<div class="w3-modal-content">
				<div class="w3-container">
					<h2>사업자등록증</h2>
					<span onclick="closepreview(event,'bcertmodal')" class="w3-button w3-display-topright">&times;</span>
			<c:if test="${list['profile'] eq null }">
					<img id="imgbcert" src="../resources/images/noimage.jpg"/>
			</c:if>
			<c:if test="${list['profile'] ne null }">
					<img id="imgbcert" src="../resources/images/bcert/<c:out value="${list['cmp_reg_image']}"/>">
			</c:if>
				</div>
			</div>
		</div>
		
		
		<!-- 이력서 모달창 -->
		<div id="resmodal" class="w3-modal dnone">
			<div class="w3-modal-content">
				<div class="w3-container">
					<h2>이력서</h2>
					<span onclick="closepreview(event, 'resmodal')" class="w3-button w3-display-topright">&times;</span>
			<c:if test="${list['profile'] eq null }">
					<img id="imgres" src="../resources/images/noimage.jpg"/>
			</c:if>
			<c:if test="${list['profile'] ne null }">
					<img  id="imgres" src="../resources/images/resume/<c:out value="${list['resume']}"/>">
			</c:if>
				</div>
			</div>
		</div>
		
	</section>
</body>
</html>