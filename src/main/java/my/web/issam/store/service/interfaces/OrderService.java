package my.web.issam.store.service.interfaces;


import java.util.List;
import java.util.Map;

import my.web.issam.store.model.Customer;
import my.web.issam.store.model.Order;
import my.web.issam.store.model.Product;

/**
 * @author issam
 *
 */
public interface OrderService {
	
	void addOrder(Order order);
	
	void addOrder(Map<Product, Integer> cartContents, Customer purchasedBy);
	
	void deleteOrder(int orderId);

	Order findOrderById(int orderId);
	
	List<Order> findAllOrders();
}
