package my.web.issam.store.service.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import my.web.issam.store.dao.CategoryDao;
import my.web.issam.store.dao.ProductDao;
import my.web.issam.store.dto.ProductDTO;
import my.web.issam.store.model.Category;
import my.web.issam.store.model.Product;
import my.web.issam.store.service.interfaces.CategoryService;
import my.web.issam.store.service.interfaces.ProductService;

/**
 * @author issam
 *
 */
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private CategoryService categoryService;

	@Transactional
	public void editProduct(int productId, String name, String description, double price, MultipartFile file) {
		Product product = findProductById(productId);
		if(name != null){
			product.setName(name);
		}
		if(description != null){
			product.setDescription(description);
		}
		if(price != 0){
			product.setPrice(price);
		}
		if(file != null){
			try {
				product.setImagePath(file.getBytes());
			} catch (IOException e) {
				product.setImagePath(new byte[1]);
			}
		}
		
		productDao.save(product);
	}

	@Transactional
	public void deleteProduct(int productId) {
		Product product = findProductById(productId);
		productDao.delete(product);
	}

	@Transactional
	public Product findProductById(int productId) {
		Product product = productDao.findOne(productId);
		return product;
	}

	@Transactional
	public List<Product> findProductByCity(String city) {
		return productDao.findProductByCity(city);
	}

	@Transactional
	public List<Product> findAllProducts() {
		return productDao.findAll();
	}

	@Transactional
	public void saveProduct(Product product) {
		Category category = categoryDao.findOne(product.getCategory().getCategoryId());
		product.setCategory(category);
		productDao.save(product);
		
	}

	@Transactional
	public void addProduct(String name, String description, String city, double price, MultipartFile file, String category) {
		Product product = new Product(name, description, city, price);
		try {
			product.setImagePath(file.getBytes());
		} catch (IOException e) {
			product.setImagePath(new byte[1]);
		}
		product.setCategory(categoryService.findCategoryById(Integer.parseInt(category)));
		productDao.save(product);
	}

	@Transactional
	public List<ProductDTO> findAllProductsDTO() {
		List<ProductDTO> productsAll = new ArrayList<ProductDTO>();
		List<Product> allProducts = productDao.findAll();
		for (Product product : allProducts) {
			ProductDTO ProductDTO = new ProductDTO(product.getProductId(), product.getName(), product.getDescription(),
					product.getCity(), 
					product.getPrice(), 
					product.getCategory()
					.getName());
			 String image = Base64.getEncoder().encodeToString(product.getImagePath());
			 ProductDTO.setImagePath(image);
			productsAll.add(ProductDTO);
		}
		return productsAll;
	}

}
