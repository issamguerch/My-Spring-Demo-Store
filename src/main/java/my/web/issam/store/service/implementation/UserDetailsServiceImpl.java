package my.web.issam.store.service.implementation;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import my.web.issam.store.dao.CustomerDao;
import my.web.issam.store.model.Customer;

/**
 * @author issam
 *
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private CustomerDao customerDao;
	
	@Transactional
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Customer customer = null;
		try{
			
			
		customer = customerDao.findByLogin(login);
		} catch(NoResultException e){
			return null;
		}
		
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		return new User(String.valueOf(customer.getCustomerId()), customer.getPassword(), authorities);
	}

}
