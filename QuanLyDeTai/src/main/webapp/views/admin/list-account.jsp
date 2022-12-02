<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<table id="example" class="table table-striped table-bordered"
	style="width: 100%">
	<thead>
		<tr>
			<th>STT</th>
			<th>Tài khoản</th>
			<th>Mật khẩu</th>
			<th>Quyền</th>
			<th>Chức năng</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${accList}" var="acc" varStatus="STT">	
			<tr>
				<td>${STT.index+1 }</td>
				<td>${acc.userName }</td>
				<td>${acc.password }</td>
				<td>${acc.role }</td>
				<td><a
					href="<c:url value='/admin/account/edit?id=${acc.userName }'/>"
					class="center">Sửa</a> | <a
					href="<c:url value='/admin/account/delete?id=${acc.userName }'/>"
					class="center">Xóa</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript">$(document).ready(function() {
    $('#example').DataTable();
	});></script>