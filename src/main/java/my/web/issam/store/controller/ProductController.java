package my.web.issam.store.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import my.web.issam.store.dto.ProductAllDTO;
import my.web.issam.store.model.Category;
import my.web.issam.store.model.Product;
import my.web.issam.store.service.interfaces.CategoryService;
import my.web.issam.store.service.interfaces.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/allProducts", method = RequestMethod.GET)
	public String getProducts(Model model) {
		List<ProductAllDTO> allProducts = productService.findAllProductsDTO();
		model.addAttribute("products", allProducts);
		return "product-all";
	}

	// @RequestMapping(value = "/createNewProduct")
	// public String createProductPage(Model model) {
	// model.addAttribute("product", new Product());
	// model.addAttribute("categories", categoryService.findAllCategories());
	// return "product-new";
	// }

	@RequestMapping(value = "/createNewProduct", method = RequestMethod.GET)
	public String createProductPage(Model model) {
		List<Category> allCategories = categoryService.findAllCategories();
		model.addAttribute("categories", allCategories);
		return "product-new";
	}

	@RequestMapping(value = "/newProduct", method = RequestMethod.POST)
	public String createProduct(@RequestParam("name") String name,
			@RequestParam(value = "description") String description, @RequestParam(value = "city") String city,
			@RequestParam(value = "price") double price, @RequestParam(value = "imagePath") MultipartFile file,
			@RequestParam(value = "category") String category) {
		productService.addProduct(name, description, city, price, file, category);
		return "redirect:/";
	}

	@RequestMapping(value = "/editProduct={productId}", method = RequestMethod.GET)
	public String editProduct(@PathVariable int productId, Model model){
		Product product = productService.findProductById(productId);
		model.addAttribute("products", product);
		return "product-edit";
	}

	@RequestMapping(value = "/editProduct", method = RequestMethod.POST)
	public String editProduct(@RequestParam("productId") int productId,@RequestParam("name") String name,
			@RequestParam(value = "description") String description, @RequestParam(value = "city") String city,
			@RequestParam(value = "price") double price, @RequestParam(value = "imagePath") MultipartFile file){
		productService.editProduct(productId, name, description, price, file);
		return "redirect:/";
	}
	@RequestMapping(value = "/deleteProduct={productId}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("productId") int productId){
		productService.deleteProduct(productId);
		return "redirect:/";
	}
}