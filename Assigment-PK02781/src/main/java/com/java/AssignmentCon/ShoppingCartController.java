package com.java.AssignmentCon;

import java.security.Principal;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.DAO.ProductDAO;
import com.java.entity.Account;
import com.java.entity.CartItem;
import com.java.entity.Products;
import com.java.service.SessionService;
import com.java.service.ShoppingCartService;



@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
	
	  @Autowired
	    private SessionService session;
	
	 @Autowired
	    private ShoppingCartService shoppingCartService;
	
	 @Autowired
	 	ProductDAO dao;
	 
	 
	
	    @GetMapping
	    public String viewCart(Model model) {
	        Collection<CartItem> cartItems = shoppingCartService.getCartItems();
	        model.addAttribute("cartItems", cartItems);
	        return "cart";
	    }
	
	    @PostMapping("/add")
	    public String addToCart(@RequestParam("Id") Integer Id, @RequestParam int quantity) {
	        // Retrieve the product information based on the provided productId
	        Optional<Products> productOptional = dao.findById(Id);

	        // Check if the product exists
	        if (productOptional.isEmpty()) {
	            return "redirect:/error";
	        }

	        // Retrieve the product from the Optional
	        Products product = productOptional.get();

	        // Create a CartItem with the retrieved product and provided quantity
	        CartItem cartItem = new CartItem(product, quantity);

	        // Add the cart item to the shopping cart
	        shoppingCartService.add(Id, cartItem);

	        // Redirect to the cart page or any other desired page
	        return "redirect:/cart";
	    }

	    @PostMapping("/remove/{id}")
	    public String removeFromCart(@RequestParam("id") Integer Id) {
	        shoppingCartService.remove(Id);
	        return "redirect:/cart";
	    }

	    @PostMapping("/update/{id}")
	    public String updateCart(@RequestParam("id") Integer Id, @RequestParam int quantity) {
	        shoppingCartService.update(Id, quantity);
	        return "redirect:/cart";
	    }

	   

}
