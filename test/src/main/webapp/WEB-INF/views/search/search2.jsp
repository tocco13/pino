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
<link rel="stylesheet" href="/resources/css/search.css">
<script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="/js/search2.js"></script>

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
			<a class="gotosearch" href="/search/search.pino">SEARCH</a>
		</div>
	</header>
	<section>
	<h2 class="emplist">직원 리스트</h2>
	<form class="fields" id="fields" name="fields" action="/search/search2.pino" method="POST">
	<div class="search">
		<label class="empno" for="empsabun">사번 </label>
		<input type="text" class="empsabun" name="empsabun" id="empsabun">
		<label class="empname" for="empkrname">성명</label>
		<input type="text" class="empkrname" name="empkrname" id="empkrname">
		<label class="empstatus" for="empstate">입사구분</label>
		<select class="empstate" id="empstate" name="empstate">
			<option value="">(선택)</option>
			<option value="Y">입사</option>
			<option value="N">퇴사</option>
		</select>
		<label class="empstatus" for="insertstate">투입여부</label>
		<select class="insertstate" id="insertstate" name="insertstate">
			<option value="">(선택)</option>
			<option value="Y">투입</option>
			<option value="N">대기</option>
		</select>
	</div>
	<div class="search" style="margin-top: 20px;">
		<label class="empstatus" for="emprank">직위</label>
		<select class="emprank" id="emprank" name="emprank">
			<option value="">(선택)</option>
<c:forEach var="jobrank" items="${jobrank}">
				<option value="${jobrank.pos_gbn_code}">${jobrank.pos_gbn_code}</option>
</c:forEach>
		</select>
		<label class="empindate" for="empdatein">입사일자</label>
		<input class="empdatein" type="text" id="datepicker" placeholder="">
		<label class="empoutdate" for="empdateout">퇴사일자</label>
		<input class="empdateout" type="text" id="datepicker2" placeholder="">
		<label class="empjobtype" for="jobtypebox">직종</label>
		<select class="jobtypebox" id="jobtypebox" name="jobtype">
			<option value="">(선택)</option>
<c:forEach var="jtlist" items="${jobtype}">
				<option value="${jtlist.job_type}">${jtlist.job_type}</option>
</c:forEach>
		</select>	
	</div>
	<div class="w3-right" style="padding-top: 25px; padding-right: 25px;">
		<button type="button" class="searchbtn" id="searchbtn" >검색</button>
		<button type="reset" class="reset">초기화</button>
		<button type="button" class="previous">이전</button>
	</div>
	<div class="searchtable" style="padding-top: 80px; margin: 0px 50px 0px 50px;'">
		<table class="headrow" id="headrow" style="width: 100%;">
			<thead>
			<tr>
				<th>사번</th>
				<th>성명</th>
				<th>주민번호</th>
				<th>핸드폰번호</th>
				<th>직위</th>
				<th>입사일자</th>
				<th>퇴사일자</th>
				<th>투입여부</th>
				<th>연봉</th>
				<th></th>
			</tr>
			</thead>
			<tbody>
			<c:if test="${empty list}">
			<tr class="searchresult" id="searchresult">
				<td colspan="9" align="center">검색된 데이터가 없습니다</td>
			</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="info" items="${list}">
					<tr class="searchresult" id="searchresult">
						<td align="center" id="sabuntag">${info.sabun}</td>
						<td align="center" id="nametag" align="center">${info.name}</td>
						<td align="center" id="regtag">${info.reg_no}</td>
						<td align="center" id="hptag">${info.hp}</td>
						<td align="center" id="postag">${info.pos_gbn_code}</td>
						<td align="center" id="jdaytag">${info.join_day}</td>
						<td align="center" id="rdaytag">${info.retire_day}</td>
						<td align="center" id="puttag">${info.put_yn}</td>
						<td align="center" id="salarytag">${info.salary}</td>
						<td align="center">
						<input type="button" class="editbtn" id="editbtn" value="수정"/>
						<input type="button" class="deletebtn" id="deletebtn" value="삭제"/>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			</tbody>
		</table>
	</div>
	</form>
	<form id="editform" action="/edit/edit.pino" method="post">
			<input type="hidden" id="nameparam" name="nameparam" value="">
	</form>
	</section>
</body>
</html>