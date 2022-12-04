<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 



<table id="example" class="table table-striped table-bordered"
	style="width: 100%">
	<thead>
		<tr>
			<th>STT</th>
			<th>MSSV</th>
			<th>Họ và tên</th>
			<th>Giới tính</th>
			<th>Ngày sinh</th>
			<th>Email</th>
			<th>Số điện thoại</th>
			<th>Địa chỉ</th>
			<th>Chức năng</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${studentList}" var="student" varStatus="STT">	
			<tr>
				<td>${STT.index+1 }</td>
				<td>${student.studentId }</td>
				<td>${student.studentName }</td>
				<td>${student.gender }</td>
				<td>${student.birth }</td>
				<td>${student.email }</td>
				<td>${student.phone }</td>
				<td>${student.address }</td>
				<td><a
					href="<c:url value='/admin/student/edit?id=${student.studentId }'/>"
					class="center">Sửa</a> | <a
					href="<c:url value='/admin/student/delete?id=${student.studentId }'/>"
					class="center">Xóa</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript">$(document).ready(function() {
    $('#example').DataTable();
	});></script>