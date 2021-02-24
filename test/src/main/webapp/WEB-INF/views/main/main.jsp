<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>인사관리시스템</title>
<meta charset="UTF-8">
<link rel="shortcut icon" href="#">
<link rel="stylesheet" href="/resources/css/w3.css">
<link rel="stylesheet" href="/resources/css/main.css">
<script type="text/javascript" src="/js/jquery-3.5.1.min.js"></script>
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
		<article> 
			<div class="title w3-center">
				<h2>인사관리 시스템</h2>
			</div>
			<div class="options w3-center">
				<span>인사정보 입력</span>
				<button type="button" class="hrinput" id="hrinput" onClick="location.href='/register/register.pino'">입력</button>
			</div>
			<div class="options w3-center">
				<span>인사정보 조회</span>
				<button type="button" class="hrview" id="hrview" onClick="location.href='/search/search.pino'">조회</button>
			</div>
		</article>
	</section>
	
</body>
</html>