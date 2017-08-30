package my.web.issam.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import my.web.issam.store.model.Product;

/**
 * @author issam
 *
 */
public interface ProductDao extends JpaRepository<Product, Integer>{

	@Query("select p from Product p where p.name like :name")
	List<Product> findProductByName(@Param("name")String name);
	
	@Query("select p from Product p where p.description like :description")
	List<Product> findProductByDescription(@Param("description")String description);
	
	@Query("select p from Product p where p.city like :city")
	List<Product> findProductByCity(@Param("city")String city);
	
	@Query("select p from Product p where p.price like :price")
	List<Product> findProductByPrice(@Param("price")double price);
	
}
