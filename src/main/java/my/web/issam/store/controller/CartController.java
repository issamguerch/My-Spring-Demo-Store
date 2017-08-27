package my.web.issam.store.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javassist.NotFoundException;
import my.web.issam.store.beans.Cart;
import my.web.issam.store.dao.CustomerDao;
import my.web.issam.store.model.Customer;
import my.web.issam.store.model.Product;
import my.web.issam.store.service.interfaces.CustomerService;
import my.web.issam.store.service.interfaces.OrderService;
import my.web.issam.store.service.interfaces.ProductService;

@Controller
public class CartController {

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerDao customerDao;
	
	@RequestMapping(value = "cart/add/{productId}")
	public String addToCart(@PathVariable("productId") int productId, @RequestHeader("referer") String referedFrom) {
		Product product = productService.findProductById(productId);
		cart.addProduct(product, 1);
		logger.debug("Adding product to cart " + product);
		return "redirect:" + referedFrom;
	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String showCart(Model model){
		model.addAttribute(cart);
		return "cart";
	}
	
	@RequestMapping(value = "/cart/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(HttpSession httpSession, RedirectAttributes redirectAttributes){
		if(cart.getContents().isEmpty()){
			redirectAttributes.addFlashAttribute("cartMessage", "Cart is empty. Please add products to the cart to make order.");
			return "redirect:/cart";
		}else{
			SecurityContext c = (SecurityContext)httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
			Integer userId = Integer.parseInt(c.getAuthentication().getName());
			orderService.addOrder(cart.getContents(), customerDao.findOne(userId));
			redirectAttributes.addFlashAttribute("cartMessage", "Order is confirmed. Total cost: " + cart.getTotalCost());
			cart.clearCart();
			return "redirect:/cart";
		}
		
	}
}
