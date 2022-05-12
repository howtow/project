<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
<title>Insert title here</title>
<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	    <a class="navbar-brand" href="#">Navbar</a>
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
	      <div class="navbar-nav">
	        <a class="nav-item nav-link active" href="${contextRoot}">Home <span class="sr-only">(current)</span></a>
	        <a class="nav-item nav-link" href="${contextRoot}/about">關於</a>
	        <a class="nav-item nav-link" href="${contextRoot}/message/add">新增留言</a>
	        <a class="nav-item nav-link" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
	      </div>
  	  </div>
  	 </nav>
	

	<script src="${contextRoot}/js/jquery-3.6.0.min.js"></script>
	<script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>
</body>
</html>