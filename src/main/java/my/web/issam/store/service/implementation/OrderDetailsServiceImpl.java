package my.web.issam.store.service.implementation;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import my.web.issam.store.dao.OrderDetailsDao;
import my.web.issam.store.model.OrderDetails;
import my.web.issam.store.model.Product;
import my.web.issam.store.service.interfaces.OrderDetailsService;

/**
 * @author issam
 *
 */
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{

	@Autowired
	private OrderDetailsDao orderDetailsDao;
	
	@Transactional
	public void addOrderDetails(Calendar orderDetails, int quantity, Product product) {
		OrderDetails od = new OrderDetails(orderDetails, quantity, product);
		orderDetailsDao.save(od);
		
	}

	@Transactional
	public void editOrderDetails(int orderDetailsId, Calendar orderDate, int quantity) {
		OrderDetails od = findOrderDetailsById(orderDetailsId);
		if(orderDate != null){
			od.setOrderDate(orderDate);
		}
		if(quantity != 0){
			od.setQuantity(quantity);
		}
		orderDetailsDao.save(od);
	}

	@Transactional
	public void deleteOrderDetails(int orderDetailsId) {
		OrderDetails od = findOrderDetailsById(orderDetailsId);
		orderDetailsDao.delete(od);
	}

	@Transactional
	public void deleteAllOrderDetails() {
		orderDetailsDao.deleteAll();
	}

	@Transactional
	public OrderDetails findOrderDetailsByProductId(int productId) {
		return orderDetailsDao.findOrderDetailsByProductId(productId);
	}

	@Transactional
	public OrderDetails findOrderDetailsById(int orderDetailsId) {
		return orderDetailsDao.findOne(orderDetailsId);
	}

	@Transactional
	public void addOrderDetails(OrderDetails orderDetails) {
		orderDetailsDao.save(orderDetails);
		
	}

}
