<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bài kiểm tra số 1</title>
</head>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="lang.content" var="msg"/>

<body>
	<a href="changeLg?lang=vi"><fmt:message bundle="${msg}" key="lang.vi" /></a>
	<a href="changeLg?lang=en"><fmt:message bundle="${msg}" key="lang.en" /></a>
	
	<!--<fmt:message bundle="${msg}" key="appname" />  thay h1 danh sach khach hang-->
	
	<h1 style="text-align: center;"><fmt:message bundle="${msg}" key="appname" /></h1>
	<div>
		<a href="?action=login">về trang đăng nhập</a>
		
	</div>
	<div>
		<a href="checker_one">Về trang danh sách</a>
		
	</div>
	<div>
		<a href="?action=create">Thêm mới khách hàng</a>
	</div>		
		<form method="post">
			<input type="hidden" name="action" value="search" required="required">
			<select name="sort_by">
				<option value="name" selected>Tìm theo tên</option>
				<option value="country">Tìm theo quê quán</option>
				<option value="phone_number">Tìm theo số điện thoại</option>
			</select> <input type="text" name="value" placeholder="type somthing!!">
			<button type="submit">Search</button>
		</form>
	</div>

	<table border="1">
		<c:if test="${types == 'search'}">
			<c:if test="${found == null}">
				<h1 style="text-align: center; color: red">Không tìm thấy khách
					hàng nào !!!</h1>
			</c:if>
			<c:if test="${found != null}">
				<tr>
					<th>Mã khách hàng</th>
					<th>Họ Tên</th>
					<th>Giới tính</th>
					<th>Ngày sinh</th>
					<th>Quê quán</th>
					<th>Email</th>
					<th>Số điện thoại</th>
					<th>Số tài khoản</th>
					<th>Ngân hàng</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${found}" var="cus">
					<tr>
						<td>${cus.cus_id}</td>
						<td>${cus.cus_name}</td>
						<td><c:if test="${cus.gender==1}">Nam</c:if> <c:if
								test="${cus.gender==2}">Nữ</c:if> <c:if test="${cus.gender==3}">Khác</c:if>
						</td>
						<td><fmt:formatDate value="${cus.birth_day}" dateStyle="full" /></td>
						<td>${cus.country}</td>
						<td>${cus.email}</td>
						<td>${cus.phone_number}</td>
						<td>${cus.bank_number}</td>
						<td>${cus.banking}</td>
						<td><a href="?action=detail&id_cus=${cus.cus_id}">Detail</a>
							<a href="?action=edit&id_cus=${cus.cus_id}">Update</a> <a
							href="?action=delete&id_delete=${cus.cus_id}"
							onclick="return confirm ('Are you sure?')">Delete</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</c:if>
		<c:if test="${types!='search'}">
			<tr>
				<th>Mã khách hàng</th>
				<th>Họ Tên</th>
				<th>Giới tính</th>
				<th>Ngày sinh</th>
				<th>Quê quán</th>
				<th>Email</th>
				<th>Số điện thoại</th>
				<th>Số tài khoản</th>
				<th>Ngân hàng</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${cus_lst}" var="cus">
				<tr>
					<td>${cus.cus_id}</td>
					<td>${cus.cus_name}</td>
					<td><c:if test="${cus.gender==1}">Nam</c:if> <c:if
							test="${cus.gender==2}">Nữ</c:if> <c:if test="${cus.gender==3}">Khác</c:if>
					</td>
					<td><fmt:formatDate value="${cus.birth_day}" dateStyle="full" /></td>
					<td>${cus.country}</td>
					<td>${cus.email}</td>
					<td>${cus.phone_number}</td>
					<td>${cus.bank_number}</td>
					<td>${cus.banking}</td>
					<td><a href="?action=detail&id_cus=${cus.cus_id}">Detail</a> <a
						href="?action=edit&id_cus=${cus.cus_id}">Edit</a> <a
						href="?action=delete&id_delete=${cus.cus_id}"
						onclick="return confirm ('Suy nghĩ kỹ chưa?')">Delete</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>