<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form role="form" action="add" method="post"
		enctype="multipart/form-data">
		<div class="form-group">
			<label>Mã số sinh viên:</label> <input type="text" class="form-control"
				placeholder="please enter MSSV" name="MSSV" />
			<label>Họ và Tên:</label> <input type="text" class="form-control"
				placeholder="please enter Name" name="name" />
				
			<div class="form-group"> Giới tính:
				<label>Nam</label> <input type="checkbox" class="form-control" name="gender" />
				<label>Nữ</label> <input type="checkbox" class="form-control" name="gender" />
			</div>
			
			<div class="form-group">
				<label>Ngày sinh:</label>
				<input type="date" class="form-control" name="birth"/>
				
				<label>Email:</label>
				<input type="email" class="form-control" placeholder="please enter your email" name="email"/>
				
				<label>Số điện thoại:</label>
				<input type="number" class="form-control" placeholder="please enter your phone" name="phone"/>
			</div>
		</div>
		<div class="form-group">
			<label>Địa chỉ:</label>
			<input type="text" class="form-control" placeholder="please enter your address" name="address"/>
		
		</div>
		<button type="submit" class="btn btn-default">Thêm</button>
		<button type="reset" class="btn btn-primary">Hủy</button>
	</form>
</body>
</html>