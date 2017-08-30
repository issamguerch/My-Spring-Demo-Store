package my.web.issam.store.service.interfaces;

import java.util.Date;
import java.util.List;

import my.web.issam.store.model.Customer;

/**
 * @author issam
 *
 */
public interface CustomerService {

	void addCustomer(String login, String password, String firstName, String lastName, String phone, String email, Date dateOfBirth);
	
	void editCustomer(int customerId, String login, String password, String firstName, String lastName, String phone, String email, Date dateOfBirth);
	
	void deleteCustomer(int customerId);
	
	Customer findCustomerById(int customerId);
	
	List<Customer> findAllByFirstName(String firstName);
	
	List<Customer> findByLastName(String lastName);
	
	Customer findByLogin(String login);
	
	Customer findByPhone(String phone);
	
	Customer findByEmail(String email);
	
	List<Customer> findAllCustomers();
	
	String findCustomerNameById(int customerId);
}
