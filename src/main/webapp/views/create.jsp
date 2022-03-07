<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.mt {
	margin-top: 2%;
}
</style>
<meta charset="UTF-8">
<title>Thêm mới khách hàng</title>
</head>
<body>
	<h1 style="text-align: center;">Thêm mới khách hàng</h1>
	<br>
	<h2 style="color: red">${tbao}</h2>
	<a href="checker_one">Về trang danh sách</a>
	<form method="post" class="mt" action="checker_one">
		<input type="hidden" name="action" value="create">

		<div class="mt">
			<label for="cus_name"> Họ & Tên: <input type="text"
				name="cus_name" id="cus_name">
			</label>
		</div>
		<div class="mt">
			Giới tính: <select name="gender">
				<option value="1">Nam</option>
				<option value="2">Nữ</option>
				<option value="3">Khác</option>
			</select>
		</div>
		<div class="mt">
			<label for="birth_day"> Ngày sinh: <input type="date"
				name="birth_day" id="birth_day">
			</label>
		</div>
		<div class="mt">
			<label for="country"> Quê quán: <input type="text"
				name="country" id="country">
			</label>
		</div>
		<div class="mt">
			<label for="email"> Email: <input type="email" name="email"
				id="email">
			</label>
		</div>
		<div class="mt">
			<label for="phone_number"> Số điện thoại: <input
				type="number" name="phone_number" id="phone_number">
			</label>
		</div>
		<div class="mt">
			<label for="bank_number"> Số tài khoản: <input type="number"
				name="bank_number" id="bank_number">
			</label>
		</div>
		<div class="mt">
			<label for="banking"> Ngân hàng: <select name="banking">
					<option value="VIB">VIB</option>
					<option value="OCB">OCB</option>
					<option value="CAKE">CAKE</option>
					<option value="MB">MB BANK</option>
					<option value="AGRI">AGRIBANK</option>
					<option value="VCB">VIETCOMBANK</option>
					<option value="TPB">TP BANK</option>
					<option value="VPB">VP BANK</option>
					<option value="SEA">SEA BANK</option>
					<option value="BIDV">BIDV</option>
					<option value="VTB">VIETTIN BANK</option>
					<option value="MSB">MSB</option>
			</select>
			</label>
		</div>
		<div class="mt">
			<button type="submit">Lưu</button>
			<button type="reset">Làm lại</button>
		</div>
	</form>
</body>
</html>