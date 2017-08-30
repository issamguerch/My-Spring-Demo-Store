package my.web.issam.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import my.web.issam.store.dto.ProductDTO;
import my.web.issam.store.model.Product;
import my.web.issam.store.service.interfaces.ProductService;

/**
 * @author issam
 *
 */
@Controller
public class HomeController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/")
	public String home(Model model){
		List<ProductDTO> allProducts = productService.findAllProductsDTO();
		model.addAttribute("products", allProducts);
		return "home";
	}
	
	@RequestMapping(value = "/loginpage")
	public String loginPage(){
		return "loginpage";
	}
}
