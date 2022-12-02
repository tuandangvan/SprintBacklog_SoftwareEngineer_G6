<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 



<table id="example" class="table table-striped table-bordered"
	style="width: 100%">
	<thead>
		<tr>
			<th>STT</th>
			<th>Mã đề tài</th>
			<th>Tên đề tài</th>
			<th>Chi tiết</th>
			<th>signUpId</th>
			<th>majorId</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${topicList}" var="topic" varStatus="STT">	
			<tr>
				<td>${STT.index+1 }</td>
				<td>${topic.topicId }</td>
				<td>${topic.topicName }</td>
				<td>${topic.detail }</td>
				<td>${topic.signUpId}</td>
				<td>${topic.majorId }</td>
				<td><a
					href="<c:url value='/admin/topic/edit?id=${topic.topicId }'/>"
					class="center">Sửa</a> | <a
					href="<c:url value='/admin/topic/delete?id=${topic.topicId }'/>"
					class="center">Xóa</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript">$(document).ready(function() {
    $('#example').DataTable();
	});></script>