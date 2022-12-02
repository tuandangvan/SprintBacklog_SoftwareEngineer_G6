<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url value="/admin/account/edit" var="edit"></c:url>
	<form role="form" action="${edit }" method="post"
		enctype="multipart/form-data">
		<input name="acc" value="${acc.userName }" hidden="">
		<div class="form-group">
			<label>Tài khoản: ${acc.userName }</label>
		</div>
		<div class="form-group">
			<label>Mật khẩu:</label> <input type="text" class="form-control"
				value="${acc.password }" name="password" />
		</div>
		<div class="form-group" >
			<label>Quyền:</label>
			<select name="role" >
				<option>${acc.role }</option>
		      	<option>admin</option>
		      	<option>teacher</option>
		      	<option>student</option>
		      
			</select>
		</div>
		<button type="submit" class="btn btn-default">Edit</button>
		<button type="reset" class="btn btn-primary">Reset</button>
	</form>
</body>
</html>