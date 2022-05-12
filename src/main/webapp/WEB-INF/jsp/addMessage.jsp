<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<jsp:include page="default/myNavBar.jsp"></jsp:include>
<head>
<meta charset="UTF-8">
<title>新增留言</title>
</head>

<div class="container">
	<div class="row justify-content-center">
		<div class="col-9">
		<h1>新增留言</h1>
		<div class="card">
  			<div class="card-header">
    			新增訊息
  			</div>
	  		<div class="card-body">
				<form:form method="post" modelAttribute="workMessage">
					<div class="input-group">
						<form:textarea path="text" class="form-control"/>
					</div>
					<input type="submit" name="submit" value="新增">
				</form:form>
  			</div>
		</div>
		</div>
	</div>
</div>