<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.mt {
	margin-top: 2%
}
</style>
<meta charset="UTF-8">
<title>Cập nhật thông tin khách hàng</title>
</head>
<body>
	<h1 style="text-align: center;">Cập nhật thông tin khách hàng</h1>
	<br>
	<h2 style="color: red">${tbao}</h2>
	<a href="checker_one">Về trang danh sách</a>
	<form method="post" class="mt">
		<input type="hidden" name="old_cus_id" value="${ old_cus.cus_id }">
		<input type="hidden" name="action" value="update">
		<div class="mt">
			<label for="cus_name"> Họ & Tên mới: <input type="text"
				name="cus_name" id="cus_name" value="${ old_cus.cus_name }">
			</label>
		</div>
		<div class="mt">
			Giới tính: <select name="gender">
				<option value="1" ${ old_cus.gender==1 ?'selected':'' }>Nam</option>
				<option value="2" ${ old_cus.gender==2 ?'selected':'' }>Nữ</option>
				<option value="3" ${ old_cus.gender==3 ?'selected':'' }>Khác</option>
			</select>
		</div>
		<div class="mt">
			<label for="birth_day"> Ngày sinh mới: <input type="date"
				name="birth_day" id="birth_day" value="${ old_cus.birth_day }">
			</label>
		</div>
		<div class="mt">
			<label for="country"> Quê quán mới: <input type="text"
				name="country" id="country" value="${ old_cus.country }">
			</label>
		</div>
		<div class="mt">
			<label for="email"> Email mới: <input type="email"
				name="email" id="email" value="${ old_cus.email }">
			</label>
		</div>
		<div class="mt">
			<label for="phone_number"> Số điện thoại mới: <input
				type="number" name="phone_number" id="phone_number"
				value="${ old_cus.phone_number }">
			</label>
		</div>
		<div class="mt">
			<label for="bank_number"> Số tài khoản mới: <input
				type="number" name="bank_number" id="bank_number"
				value="${ old_cus.bank_number }">
			</label>
		</div>
		<div class="mt">
			<label for="banking"> Số tài khoản mới: <select
				name="banking">
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