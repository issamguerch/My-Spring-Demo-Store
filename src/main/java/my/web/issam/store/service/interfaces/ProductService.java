package my.web.issam.store.service.interfaces;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import my.web.issam.store.dto.ProductDTO;
import my.web.issam.store.model.Category;
import my.web.issam.store.model.Product;

/**
 * @author issam
 *
 */
public interface ProductService {
	
	void addProduct(String name, String description, String city, double price, MultipartFile file, String category);
	
	void saveProduct(Product product);
	
	void editProduct(int productId, String name, String description, double price, MultipartFile file);
	
	void deleteProduct(int productId);
	
	Product findProductById(int productId);
	
	List<Product> findProductByCity(String city);
	
	List<Product> findAllProducts();
	
	List<ProductDTO> findAllProductsDTO();
	
}
