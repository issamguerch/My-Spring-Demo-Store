package my.web.issam.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import my.web.issam.store.model.Category;

/**
 * @author issam
 *
 */
public interface CategoryDao extends JpaRepository<Category, Integer>{

	@Query("select c from Category c where c.name like :name")
	Category findCategoryByName(@Param("name")String name);
	
	@Query("select c from Category c where c.description like :description")
	Category findCategoryByDescription(@Param("description")String description);
}
