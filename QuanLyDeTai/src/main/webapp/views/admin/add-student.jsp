<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quản lý đề tài</title>
</head>
<body>
	<form role="form" action="add" method="post"
		enctype="multipart/form-data">
		<div class="form-group">
			<label>Mã số sinh viên:</label> <input type="text" class="form-control"
				placeholder="please enter MSSV" name="mssv"/>
			<label>Họ và Tên:</label> <input type="text" class="form-control"
				placeholder="please enter Name" name="name" />
				
			<div class="form-group"> 
				<label for="nation">Giới tính</label> 
				<input type="text" class="form-control"
					placeholder="please enter gender" name="gender" />
				<!-- <select name="gender" id="gender" class="form-control">
					<option value="Male">Nam</option>
					<option value="Female">Nữ</option>
				</select> -->
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