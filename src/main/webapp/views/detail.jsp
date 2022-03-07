<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.mt {
	margin-top: 2%
}
</style>
<meta charset="UTF-8">
<title>Thông tin chi tiết khách hàng ${ detail.cus_name }</title>
</head>
<body>
	<h1 style="text-align: center;">Chi tiết khách hàng</h1>
	<div class="mt">Mã khách hàng: ${ detail.cus_name }</div>
	<div class="mt">Họ và tên: ${ detail.cus_name }</div>
	<div class="mt">
		Giới tính:
		<c:if test="${detail.gender  == 1 }">Nam</c:if>
		<c:if test="${detail.gender  == 2 }">Nữ</c:if>
		<c:if test="${detail.gender  == 3 }">Khác</c:if>
	</div>
	<div class="mt">Ngày sinh: ${ detail.birth_day }</div>
	<div class="mt">Quê quán: ${ detail.country }</div>
	<div class="mt">Email: ${ detail.email }</div>
	<div class="mt">Số điện thoại: ${ detail.phone_number }</div>
	<div class="mt">Số tài khoản: ${ detail.bank_number }</div>
	<div class="mt">Tên ngân hàng: ${ detail.banking }</div>
	<a href="checker_one">Trở lại</a>
</body>
</html>