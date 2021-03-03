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
<script type="text/javascript" src="/js/registerfiletest.js"></script>

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
		</div>
		<form class="test" id="test" method="POST" action="/upload.pino" enctype="multipart/form-data">
		
			<div>
		<c:if test="${empty path}">
			<img class="profilepic" src="/images/noimage.jpg">
		</c:if>
		<c:if test="${not empty path}">
			<img class="profilepic" src="<% request.getSession().getServletContext().getRealPath("\\");%>${path}">
		</c:if>
			<label for="profilepic">사진업로드</label>
			<input type="file" name="profilepic" id="profilepic" style="display:none;visibility: hidden;">
			<input type="submit" value="서브밋"/>
			</div>
		</form>
	</section>
</body>
</html>