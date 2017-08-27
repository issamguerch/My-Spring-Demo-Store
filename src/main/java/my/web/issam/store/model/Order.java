package my.web.issam.store.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Order {

	// Attributes

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_date", nullable = false)
	private Calendar orderDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
	private List<OrderDetails> orderDetails;
	
	// Constructors

	public Order(){
		
	}

	public Order(Calendar orderDate, Customer customer) {
		this.orderDate = orderDate;
		this.customer = customer;
	}

	public int getOrderId() {
		return orderId;
	}

	public Calendar getOrderDate() {
		return this.orderDate;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public List<OrderDetails> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}



}
