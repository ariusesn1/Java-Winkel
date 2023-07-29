package com.java.AssignmentCon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.DAO.ProductDAO;
import com.java.entity.Report;

@Controller
public class InventoryController {

	@Autowired
	ProductDAO dao;
	
	@RequestMapping("/admin/inventory")
	public String inventory(Model model) {
		List<Report> list = dao.getInventoryByCategory();
		model.addAttribute("list", list);
		return "admin/Inventory";
	}
}
