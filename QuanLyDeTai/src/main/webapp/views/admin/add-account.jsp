<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add" method="post">
		<div class="form-group">
			<label>Tài khoản:</label> <input type="text" class="form-control"
				placeholder="please enter ID Student" name="userName" /> <br />
			<label>Mật khẩu:</label> <input type="text" class="form-control"
				placeholder="please enter password" name="password" /> <br />
			<label>Quyền:</label>
			<select name="role">
		      <option>admin</option>
		      	<option>teacher</option>
		      	<option>student</option>
			</select>
		</div>
		<button type="submit" class="btn btn-default">Thêm</button>
		<button type="reset" class="btn btn-primary">Hủy</button>
	</form>
</body>
</html>