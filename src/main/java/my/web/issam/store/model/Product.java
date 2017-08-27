package my.web.issam.store.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	// Attributes

	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	
	@Column(name = "product_name", nullable = false)
	private String name;
	
	@Column(name = "product_description", nullable = false)
	private String description;
	
	@Column(name = "product_city", nullable = false)
	private String city;
	
	@Column(name = "product_price", nullable = false)
	private double price;
	
	@Lob
	private byte[] imagePath;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	private List<OrderDetails> orderDetails;
	
	// Constructors

	public Product(){
		
	}

	public Product(String name, String description, String city, double price) {
		this.name = name;
		this.description = description;
		this.city = city;
		this.price = price;
//		this.category = category;
	}

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getCity() {
		return city;
	}

	public double getPrice() {
		return price;
	}

	public byte[] getImagePath() {
		return imagePath;
	}

	public Category getCategory() {
		return category;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setImagePath(byte[] imagePath) {
		this.imagePath = imagePath;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + Arrays.hashCode(imagePath);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((orderDetails == null) ? 0 : orderDetails.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + productId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (!Arrays.equals(imagePath, other.imagePath))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (orderDetails == null) {
			if (other.orderDetails != null)
				return false;
		} else if (!orderDetails.equals(other.orderDetails))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (productId != other.productId)
			return false;
		return true;
	}

	
	
}
