package my.web.issam.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import my.web.issam.store.model.Category;
import my.web.issam.store.service.interfaces.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/category={categoryId}", method = RequestMethod.GET)
	public String getCategories(@PathVariable String categoryId, Model model){
		List<Category> allCategories = categoryService.findAllCategories();
		model.addAttribute("categories", allCategories);
		return "category-all";
		
	}
	
	@RequestMapping(value = "createNewCategory")
	public String createCategoryPage(){
		return "category-new";
	}
	
	@RequestMapping(value = "newCategory", method = RequestMethod.POST)
	public String saveCategory(@Valid Category category, BindingResult result){
		if(result.hasErrors()){
			return "category-new";
		}
		categoryService.saveCategory(category);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/editCategory={categoryId}", method = RequestMethod.GET)
	public String editCategory(@PathVariable int categoryId, Model model){
		Category category = categoryService.findCategoryById(categoryId);
		model.addAttribute("categories", category);
		return "category-edit";
	}
	
	@RequestMapping(value = "/editCategory", method = RequestMethod.POST)
	public String editCategory(@RequestParam(value = "categoryId") int categoryId,@RequestParam(value = "name") String name,
			@RequestParam(value = "description") String description){
		categoryService.editCategory(categoryId, name, description);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/deleteCategory={categoryId}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("categoryId") int categoryId){
		categoryService.deleteCategory(categoryId);
		return "redirect:/";
	}
}
