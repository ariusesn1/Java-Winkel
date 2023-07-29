package com.java.AssignmentCon;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.DAO.CategoryDAO;
import com.java.DAO.ProductDAO;
import com.java.entity.Account;
import com.java.entity.Category;
import com.java.entity.Products;
import com.java.service.SessionService;

@Controller
public class ShopController {
	@Autowired
	SessionService session;
	
	@Autowired
    private ProductDAO dao;
	
    @Autowired
    private CategoryDAO categoryDAO;
	
	@RequestMapping("shop")
	public String shop(Model model,@RequestParam("p") Optional<Integer> p, @RequestParam("keyword") Optional<String> name) {
		List<Category> categories = categoryDAO.findAll();
		model.addAttribute("category", categories);
		String findName;
		if(session.get("keyword") == null) {
			findName = name.orElse("");
		}
		else {
			findName = name.orElse(session.get("keyword"));
		}		
		session.set("keyword", findName);
		Pageable pageable;
		try {
			pageable = PageRequest.of(p.orElse(0), 6);

		} catch (Exception e) {
			pageable = PageRequest.of(0, 6);
		}
		Page<Products> list = dao.findByNamePage("%"+findName+"%", pageable);
		model.addAttribute("Product" , list);
		return "shop";
	}
	
	@RequestMapping("detail/shop")
	public String shopDe(Model model,@RequestParam("p") Optional<Integer> p) {
		List<Category> categories = categoryDAO.findAll();
		model.addAttribute("category", categories);
		Pageable pageable;
		try {
			pageable = PageRequest.of(p.orElse(0), 6);

		} catch (Exception e) {
			pageable = PageRequest.of(0, 6);
		}
		Page<Products> list = dao.findAll(pageable);
		model.addAttribute("Product" , list);
		return "redirect:/shop";
	}
	
	@RequestMapping("detail/{id}")
	public String detail(Model model, @PathVariable("id") int id) {
		Products product = dao.getOne(id);
        model.addAttribute("product", product);
		return "productDetail";
	}

}
