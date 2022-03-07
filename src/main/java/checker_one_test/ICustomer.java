package checker_one_test;

import java.util.List;

public interface ICustomer {
	public List<Customer> getAll();
	public boolean create_new(Customer customer);
	public boolean update(String old_id, Customer customer);
	public boolean delete(String id_delete);
	public Customer get_infor(String id_delail);
	public List<Customer> find_by_name(String name);
	public List<Customer> find_by_country(String country);
	public List<Customer> find_by_phone(String pphone);
}
