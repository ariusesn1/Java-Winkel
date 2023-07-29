package com.java.AssignmentCon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.DAO.CategoryDAO;
import com.java.entity.Category;



@Controller

public class CategoryController {
	
	@Autowired
	CategoryDAO dao;
	
	@GetMapping("/admin/category")
	public String index(Model model) {
		Category entity = new Category();
		model.addAttribute("category", entity);
		List<Category> list = dao.findAll();
		model.addAttribute("Category", list);
		return "admin/Category";
	}
	
	
	@PostMapping("/saveCate")
	public String save(Model model, @ModelAttribute("category") Category entity) {
		//if(dao.getOne(entity.getId()) == null) {
			dao.save(entity);
		//}		
		return "redirect:/admin/category";
	}
	
	@PostMapping("/updateCate/{id}")
	public String update(Model model, @ModelAttribute("category") Category entity) {
		dao.saveAndFlush(entity);
		return "redirect:/admin/category";
	}
	
	@GetMapping("/deleteCate/{id}")
	public String delete(Model model, @PathVariable("id") int id) {
		dao.deleteById(id);
		return "redirect:/admin/category";
	}
	
	@GetMapping("/editCate/{id}")
	public String edit(Model model, @ModelAttribute("category") Category entity, @PathVariable("id") int id) {
		entity = dao.getOne(id);
		model.addAttribute("category", entity);
		List<Category> list = dao.findAll();
		model.addAttribute("Category", list);
		return "admin/Category";
	}
}
