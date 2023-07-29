package com.java.AssignmentCon;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("index")
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping("about")
	public String about() {
		return "about";
	}
	
	@RequestMapping("contact")
	public String contact() {
		return "contact";
	}
	
	@RequestMapping("detail/index")
	public String indexde(Model model) {
		return "redirect:/index" ;
	}
	
	@RequestMapping("detail/about")
	public String aboutde() {
		return "redirect:/about";
	}
	
	@RequestMapping("detail/contact")
	public String contactde() {
		return "redirect:/contact";
	}
	
	@RequestMapping("detail/cart")
	public String cartde() {
		return "redirect:/cart";
	}
	
}
