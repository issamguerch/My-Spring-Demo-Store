package my.web.issam.store.service.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import my.web.issam.store.dao.CustomerDao;
import my.web.issam.store.model.Customer;
import my.web.issam.store.service.interfaces.CustomerService;

/**
 * @author issam
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Transactional
	public void addCustomer(String login, String password, String firstName, String lastName, String phone,
			String email, Date dateOfBirth) {
		// PASSWORD CRYPTING
		BCryptPasswordEncoder passw = new BCryptPasswordEncoder();
		String encodedPassw = passw.encode(password);
		Customer customer = new Customer(login, encodedPassw, firstName, lastName, phone, email, dateOfBirth);
		
		customerDao.save(customer);
		
	}

	@Transactional
	public void editCustomer(int customerId, String login, String password, String firstName, String lastName,
			String phone, String email, Date dateOfBirth) {
		Customer customer = findCustomerById(customerId);
		if(login != null){
			customer.setLogin(login);
		}
		if (password != null) {
			BCryptPasswordEncoder passw = new BCryptPasswordEncoder();
			String encodedPassw = passw.encode(password);
			customer.setPassword(encodedPassw);
			customer.setPassword(password);
		}
		if(firstName != null){
			customer.setFirstName(firstName);
		}
		if(lastName != null){
			customer.setLastName(lastName);
		}
		if(phone != null){
			customer.setPhone(phone);
		}
		if(email != null){
			customer.setEmail(email);
		}
		if(dateOfBirth != null){
			customer.setDateOfBirth(dateOfBirth);
		}
		customerDao.save(customer);
	}

	@Transactional
	public void deleteCustomer(int customerId) {
		Customer customer = findCustomerById(customerId);
		customerDao.delete(customer);
	}

	@Transactional
	public Customer findCustomerById(int customerId) {
		return customerDao.findOne(customerId);
	}

	@Transactional
	public List<Customer> findAllByFirstName(String firstName) {
		return customerDao.findAllByFirstName(firstName);
	}

	@Transactional
	public List<Customer> findByLastName(String lastName) {
		return customerDao.findByLastName(lastName);
	}

	@Transactional
	public Customer findByLogin(String login) {
		return customerDao.findByLogin(login);
	}

	@Transactional
	public Customer findByPhone(String phone) {
		return customerDao.findByPhone(phone);
	}

	@Transactional
	public Customer findByEmail(String email) {
		return customerDao.findByEmail(email);
	}

	@Transactional
	public List<Customer> findAllCustomers() {
		return customerDao.findAll();
	}

	@Transactional
	public String findCustomerNameById(int customerId) {
		return customerDao.findOne(customerId).getFirstName();
	}

	@Transactional
	public void saveCustomer(Customer customer) {
		customerDao.save(customer);
		
	}
}
