package my.web.issam.store.service.interfaces;

import java.util.List;

import my.web.issam.store.model.Category;

/**
 * @author issam
 *
 */
public interface CategoryService {
	
	void addCategory(String name, String description);
	
	void saveCategory(Category category);
	
	void editCategory(int categoryId, String name, String description);
	
	void deleteCategory(int categoryId);
	
	Category findCategoryById(int categoryId);
	
	List<Category> findAllCategories();
}
