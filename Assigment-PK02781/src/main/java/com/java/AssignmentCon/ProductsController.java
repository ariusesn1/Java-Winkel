package com.java.AssignmentCon;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.java.DAO.CategoryDAO;
import com.java.DAO.ProductDAO;
import com.java.entity.CartItem;
import com.java.entity.Category;
import com.java.entity.Products;
import com.java.service.UploadService;

import javax.validation.Valid;

@Controller
public class ProductsController {
    @Autowired
    private ProductDAO dao;
    
    @Autowired
    private UploadService uploadService;

    @Autowired
    private CategoryDAO categoryDAO;

	@GetMapping("/admin/product")
	public String index(Model model ) {
		
		Products entity = new Products();
		model.addAttribute("product", entity);
		List<Category> categories = categoryDAO.findAll();
		model.addAttribute("category", categories);
		List<Products> list = dao.findAll();
		model.addAttribute("Product" , list);
		return "admin/Products";
	}
	
	
	@PostMapping("/saveProd")
	public String save(Model model, @ModelAttribute("product") @Valid Products entity, BindingResult result,
					   @RequestParam("file") MultipartFile file) {
		if (result.hasErrors()) {
			List<Products> list = dao.findAll();
			model.addAttribute("Product", list);
			List<Category> categories = categoryDAO.findAll();
			model.addAttribute("category", categories);
			return "admin/Products";
		}

		if (!file.isEmpty()) {
			String imagePath = uploadService.save(file);
			int maxLength = 255;
			if (imagePath.length() > maxLength) {
				imagePath = imagePath.substring(0, maxLength);
			}
			entity.setImage(imagePath);
		}

		dao.save(entity);
		return "redirect:/admin/product";
	}
	
	@PostMapping("/updateProd/{id}")
	public String update(Model model, @ModelAttribute("product") Products entity, @RequestParam("file") MultipartFile file) {
	    Products existingProduct = dao.getOne(entity.getId());
	    if (!file.isEmpty()) {
	        String imagePath = uploadService.save(file);
	        int maxLength = 255; 
	        if (imagePath.length() > maxLength) {
	            imagePath = imagePath.substring(0, maxLength);
	        }
	        entity.setImage(imagePath);
	    } else {
	        entity.setImage(existingProduct.getImage());
	    }
	    
	    dao.saveAndFlush(entity);
	    return "redirect:/admin/product";
	}

	
	@GetMapping("/deleteProd/{id}")
	public String delete(Model model, @PathVariable("id") int id) {
		dao.deleteById(id);
		return "redirect:/admin/product";
	}
	
	@GetMapping("/editProd/{id}")
	public String edit(Model model, @ModelAttribute("product") Products entity, @PathVariable("id") int id) {
		entity = dao.getOne(id);
		List<Category> categories = categoryDAO.findAll();
		model.addAttribute("category", categories);
		model.addAttribute("product", entity);
		List<Products> list = dao.findAll();
		model.addAttribute("Product", list);
		return "admin/Products";
	}
	
	
	@GetMapping("/product/sort")
	public String sort(Model model, @RequestParam("field") String field, @ModelAttribute("product") Products entity) {
	    Sort sort = Sort.by(Direction.DESC,field);
		model.addAttribute("product", entity);
	    model.addAttribute("field", field.toUpperCase());
	    List<Products> list = dao.findAll(sort);
	    model.addAttribute("Product", list);
	    return "admin/Products";
	}
	
	@GetMapping("/redirect")
	public String performRedirect() {
	    return "redirect:index";
	}
	
	@RequestMapping("/price")
	public String index(Model model, @RequestParam("min") Optional<Double> min, @RequestParam("max") Optional<Double> max) {
		Products entity = new Products();
		model.addAttribute("product", entity);
		double priceMin = min.orElse(Double.MIN_VALUE);
		double priceMax = max.orElse(Double.MAX_VALUE);
		List<Category> categories = categoryDAO.findAll();
		model.addAttribute("category", categories);
		List<Products> list = dao.findByPrice(priceMin,priceMax);
		model.addAttribute("Product", list);
		return "admin/Products";
	}
}
