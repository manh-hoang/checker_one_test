package checker_one_test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerImp implements ICustomer {
	private Connection connects = Connect_DB.getConnect();

	@Override
	public List<Customer> getAll() {
		String sql = "{call get_all()}";
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			callableStatement = connects.prepareCall(sql);
			callableStatement.executeQuery();
			rs = callableStatement.getResultSet();
			List<Customer> ls_cus = new ArrayList<>();
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					String cus_id = rs.getString("cus_id");
					String cus_name = rs.getString("cus_name");
					int gender = rs.getInt("gender");
					Date birth_day = fmt.parse(rs.getString("birth_day"));
					String country = rs.getString("country");
					String email = rs.getString("email");
					String phone_number = rs.getString("phone_number");
					String bank_number = rs.getString("bank_number");
					String banking = rs.getString("banking");
					Customer new_cus = new Customer(cus_id, cus_name, gender, birth_day, country, email, phone_number,
							bank_number, banking);
					ls_cus.add(new_cus);
				}
			}
			return ls_cus;

		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean create_new(Customer customer) {
		CallableStatement cs = null;
		String sql = "{call cre_new_cus(?,?,?,?,?,?,?,?,?)}";

		try {
			cs = connects.prepareCall(sql);
			cs.setString(1, customer.getCus_id());
			cs.setString(2, customer.getCus_name());
			cs.setInt(3, customer.getGender());
			cs.setDate(4, new java.sql.Date(customer.getBirth_day().getTime()));
			cs.setString(5, customer.getCountry());
			cs.setString(6, customer.getEmail());
			cs.setString(7, customer.getPhone_number());
			cs.setString(8, customer.getBank_number());
			cs.setString(9, customer.getBanking());

			int check = cs.executeUpdate();
			if (check > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(String old_id, Customer customer) {
		CallableStatement cs = null;
		String sql = "{call update_cus(?,?,?,?,?,?,?,?,?)}";

		try {
			cs = connects.prepareCall(sql);
			cs.setString(1, old_id);
			cs.setString(2, customer.getCus_name());
			cs.setInt(3, customer.getGender());
			cs.setDate(4, new java.sql.Date(customer.getBirth_day().getTime()));
			cs.setString(5, customer.getCountry());
			cs.setString(6, customer.getEmail());
			cs.setString(7, customer.getPhone_number());
			cs.setString(8, customer.getBank_number());
			cs.setString(9, customer.getBanking());

			int check = cs.executeUpdate();
			if (check > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(String id_delete) {
		CallableStatement cs = null;
		String sql = "{call delete_cus(?)}";

		try {
			cs = connects.prepareCall(sql);
			cs.setString(1, id_delete);
			int check_deleted = cs.executeUpdate();
			if (check_deleted > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Customer get_infor(String id_detail) {
		String sql = "{call view_inf(?)}";
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		try {
			callableStatement = connects.prepareCall(sql);
			callableStatement.setString(1, id_detail);
			callableStatement.executeQuery();
			rs = callableStatement.getResultSet();

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					String cus_id = rs.getString("cus_id");
					String cus_name = rs.getString("cus_name");
					int gender = rs.getInt("gender");
					Date birth_day = rs.getDate("birth_day");
					String country = rs.getString("country");
					String email = rs.getString("email");
					String phone_number = rs.getString("phone_number");
					String bank_number = rs.getString("bank_number");
					String banking = rs.getString("banking");

					Customer new_cus = new Customer(cus_id, cus_name, gender, birth_day, country, email, phone_number,
							bank_number, banking);
					return new_cus;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Customer> find_by_name(String name) {
		String sql = "{call find_by_name(?)}";
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		try {
			callableStatement = connects.prepareCall(sql);
			callableStatement.setString(1, name);
			callableStatement.executeQuery();
			rs = callableStatement.getResultSet();
			List<Customer> lst_name = new ArrayList<>();
			while (rs.next()) {
				String cus_id = rs.getString("cus_id");
				String cus_name = rs.getString("cus_name");
				int gender = rs.getInt("gender");
				Date birth_day = rs.getDate("birth_day");
				String country = rs.getString("country");
				String email = rs.getString("email");
				String phone_number = rs.getString("phone_number");
				String bank_number = rs.getString("bank_number");
				String banking = rs.getString("banking");

				Customer new_cus = new Customer(cus_id, cus_name, gender, birth_day, country, email, phone_number,
						bank_number, banking);
				lst_name.add(new_cus);
				return lst_name;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Customer> find_by_country(String country_wanted) {
		String sql = "{call find_by_country(?)}";
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		try {
			callableStatement = connects.prepareCall(sql);
			callableStatement.setString(1, country_wanted);
			callableStatement.executeQuery();
			rs = callableStatement.getResultSet();
			List<Customer> lst_country = new ArrayList<>();
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					String cus_id = rs.getString("cus_id");
					String cus_name = rs.getString("cus_name");
					int gender = rs.getInt("gender");
					Date birth_day = rs.getDate("birth_day");
					String country = rs.getString("country");
					String email = rs.getString("email");
					String phone_number = rs.getString("phone_number");
					String bank_number = rs.getString("bank_number");
					String banking = rs.getString("banking");

					Customer new_cus = new Customer(cus_id, cus_name, gender, birth_day, country, email, phone_number,
							bank_number, banking);
					lst_country.add(new_cus);
					return lst_country;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> find_by_phone(String phone) {
		String sql = "{call find_by_phone(?)}";
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		try {
			callableStatement = connects.prepareCall(sql);
			callableStatement.setString(1, phone);
			callableStatement.executeQuery();
			rs = callableStatement.getResultSet();
			List<Customer> lst_phone = new ArrayList<>();
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					String cus_id = rs.getString("cus_id");
					String cus_name = rs.getString("cus_name");
					int gender = rs.getInt("gender");
					Date birth_day = rs.getDate("birth_day");
					String country = rs.getString("country");
					String email = rs.getString("email");
					String phone_number = rs.getString("phone_number");
					String bank_number = rs.getString("bank_number");
					String banking = rs.getString("banking");

					Customer new_cus = new Customer(cus_id, cus_name, gender, birth_day, country, email, phone_number,
							bank_number, banking);
					lst_phone.add(new_cus);
					return lst_phone;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
