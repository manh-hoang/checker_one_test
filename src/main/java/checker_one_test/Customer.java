package checker_one_test;

import java.util.Date;

public class Customer {
	private String cus_id;
	private String cus_name;
	private int gender;
	private Date birth_day;
	private String country;
	private String email;
	private String phone_number;
	private String bank_number;
	private String banking;
	
	public Customer() {
		super();
	}
	
	public Customer(String cus_id, String cus_name, int gender, Date birth_day, String country, String email,
			String phone_number, String bank_number, String banking) {
		super();
		this.cus_id = cus_id;
		this.cus_name = cus_name;
		this.gender = gender;
		this.birth_day = birth_day;
		this.country = country;
		this.email = email;
		this.phone_number = phone_number;
		this.bank_number = bank_number;
		this.banking = banking;
	}

	public String getCus_id() {
		return cus_id;
	}

	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}

	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getBirth_day() {
		return birth_day;
	}

	public void setBirth_day(Date birth_day) {
		this.birth_day = birth_day;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getBank_number() {
		return bank_number;
	}

	public void setBank_number(String bank_number) {
		this.bank_number = bank_number;
	}

	public String getBanking() {
		return banking;
	}

	public void setBanking(String banking) {
		this.banking = banking;
	}

	@Override
	public String toString() {
		return "Customer [cus_id=" + cus_id + ", cus_name=" + cus_name + ", gender=" + gender + ", birth_day="
				+ birth_day + ", country=" + country + ", email=" + email + ", phone_number=" + phone_number
				+ ", bank_number=" + bank_number + ", banking=" + banking + "]";
	}
	
	
}
