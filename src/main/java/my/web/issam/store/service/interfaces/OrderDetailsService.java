package my.web.issam.store.service.interfaces;

import java.util.Calendar;

import my.web.issam.store.model.OrderDetails;
import my.web.issam.store.model.Product;

/**
 * @author issam
 *
 */
public interface OrderDetailsService {

	void addOrderDetails(Calendar orderDate, int quantity, Product product);
	
	void addOrderDetails(OrderDetails orderDetails);
	
	void editOrderDetails(int orderDetailsId, Calendar orderDate, int quantity);
	
	void deleteOrderDetails(int orderDetailsId);
	
	OrderDetails findOrderDetailsById(int orderDetailsId);
	
	void deleteAllOrderDetails();
	
	OrderDetails findOrderDetailsByProductId(int productId);
}
