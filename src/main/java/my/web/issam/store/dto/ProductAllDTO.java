package my.web.issam.store.dto;

public class ProductAllDTO {
	private int productId;
	private String name;
	private String description;
	private String city;
	private double price;
	private String categoryName;
	private String imagePath;
	
	public ProductAllDTO(){
		
	}

	public ProductAllDTO(int productId, String name, String description, String city, double price,
			String categoryName) {
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.city = city;
		this.price = price;
		this.categoryName = categoryName;
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

	public String getCategoryName() {
		return categoryName;
	}

	public String getImagePath() {
		return imagePath;
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

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
}
