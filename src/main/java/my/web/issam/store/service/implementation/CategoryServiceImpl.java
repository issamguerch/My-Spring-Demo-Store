package my.web.issam.store.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import my.web.issam.store.dao.CategoryDao;
import my.web.issam.store.model.Category;
import my.web.issam.store.service.interfaces.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	@Transactional
	public void addCategory(String name, String description) {
		Category category = new Category(name, description);
		categoryDao.save(category);
	}

	@Transactional
	public void editCategory(int categoryId, String name, String description) {
		Category category = findCategoryById(categoryId);
		if(name != null){
			category.setName(name);
		}
		if(description != null){
			category.setDescription(description);
		}
		categoryDao.save(category);
	}

	@Transactional
	public void deleteCategory(int categoryId) {
		Category category = findCategoryById(categoryId);
		categoryDao.delete(category);
	}

	@Transactional
	public List<Category> findAllCategories() {
		return categoryDao.findAll();
	}

	@Transactional
	public Category findCategoryById(int categoryId) {
		return categoryDao.findOne(categoryId);
	}

	@Transactional
	public void saveCategory(Category category) {
		categoryDao.save(category);
	}

}
