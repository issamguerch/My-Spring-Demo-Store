package my.web.issam.store.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import my.web.issam.store.model.Customer;
import my.web.issam.store.service.interfaces.CustomerService;

/**
 * @author issam
 *
 */
@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/customer={customerId}", method = RequestMethod.GET)
	public String getCustomers(@PathVariable String customerId,Model model) {
		List<Customer> allCustomers = customerService.findAllCustomers();
		model.addAttribute("customers", allCustomers);
		return "customer-all";
	}

	@RequestMapping(value = "/createNewCustomer")
	public String createCustomerPage() {
		return "customer-new";
	}

	@RequestMapping(value = "/newCustomer", method = RequestMethod.POST)
	public String createCustomer(@RequestParam(value = "login") String login,
			@RequestParam(value = "password") String password, @RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName, @RequestParam(value = "dateOfBirth") @DateTimeFormat(pattern="yyyy-mm-dd") Date dateOfBirth,
			@RequestParam(value = "phone") String phone, @RequestParam(value = "email") String email) {
		customerService.addCustomer(login, password, firstName, lastName, phone, email, dateOfBirth);
		return "redirect:/";
		
	}
	
	@RequestMapping(value = "/editCustomer={customerId}", method = RequestMethod.GET)
	public String editCustomer(@PathVariable int customerId, Model model){
		Customer customer = customerService.findCustomerById(customerId);
		model.addAttribute("customers", customer);
		return "customer-edit";
	}
	
	@RequestMapping(value = "/editCustomer", method = RequestMethod.POST)
	public String editCustomer(@RequestParam(value = "customerId") int customerId, @RequestParam(value = "login") String login, @RequestParam(value = "password") String password,
			@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName, @RequestParam(value = "phone") String phone, 
			@RequestParam(value = "email") String email, @RequestParam(value = "dateOfBirth") Date dateOfBirth){
		customerService.editCustomer(customerId, login, password, firstName, lastName, phone, email, dateOfBirth);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/deleteCustomer={customerId}", method = RequestMethod.GET)
	public String deleteCustomer(@PathVariable("customerId") int customerId){
		customerService.deleteCustomer(customerId);
		return "redirect:/";
	}
}
