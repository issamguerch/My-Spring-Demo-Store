package my.web.issam.store.service.implementation;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import my.web.issam.store.dao.OrderDao;
import my.web.issam.store.dao.OrderDetailsDao;
import my.web.issam.store.model.Customer;
import my.web.issam.store.model.Order;
import my.web.issam.store.model.OrderDetails;
import my.web.issam.store.model.Product;
import my.web.issam.store.service.interfaces.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;

	@Autowired
	private OrderDetailsDao orderDetailsDao;
	
	
	@Transactional
	public void addOrder(Order order) {
		orderDao.save(order);
	}

	@Transactional
	public void deleteOrder(int orderId) {
		Order order = findOrderById(orderId);
		orderDao.delete(order);
	}

	@Transactional
	public Order findOrderById(int orderId) {
		return orderDao.findOne(orderId);
	}

	@Transactional
	public List<Order> findAllOrders() {
		return orderDao.findAll();
	}

	@Transactional
	public void addOrder(Map<Product, Integer> cartContents, Customer purchasedBy) {
		Calendar now = Calendar.getInstance();
		Order order = new Order();
		order.setOrderDate(now);
		order.setCustomer(purchasedBy);
		List<OrderDetails> details = new ArrayList<OrderDetails>();
		for (Entry<Product, Integer> entry : cartContents.entrySet()) {
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setProduct(entry.getKey());
			orderDetails.setQuantity(entry.getValue());
			orderDetails.setOrderDate(now);
			orderDetails.setOrder(order);
			details.add(orderDetails);
			orderDetailsDao.save(orderDetails);
		}
		order.setOrderDetails(details);
		this.addOrder(order);
	}

}
