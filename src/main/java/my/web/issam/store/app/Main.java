package my.web.issam.store.app;

import java.sql.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import my.web.issam.store.service.interfaces.CustomerService;

public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/appContext.xml");
		CustomerService cs = applicationContext.getBean(CustomerService.class);
		
		Date date = new Date(1993-03-15);
		
		cs.addCustomer("one", "one", "one", "one", "0639317913", "one", date);
	}

}
