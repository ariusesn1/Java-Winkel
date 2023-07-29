package com.java.AssignmentCon;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.DAO.AccountDAO;
import com.java.entity.Account;
import com.java.service.SessionService;


@Controller
public class SignInController {
	@Autowired
	AccountDAO dao;

	@Autowired
	SessionService session;

	@RequestMapping("/signin")
	public String login() {
		return "login";
	}
	
	 @PostMapping("/signin")
	    public String login(Model model, @Param("username") String username, @Param("password") String password,
	            HttpSession sessions, HttpServletResponse response) {
	        try {
	            Account user = dao.getOne(username);
	            if (!user.getPassword().equals(password)) {
	                System.out.println("error");
	                model.addAttribute("message", "Invalid password");
	            } else {
	                sessions.setAttribute("user", user);
	                Cookie cookie = new Cookie("username", username);
	                cookie.setMaxAge(-1); 
	                response.addCookie(cookie);

	                String uri = session.get("security-uri");
	                if (uri != null) {
	                    return "redirect:" + uri;
	                } else {
	                    model.addAttribute("message", "Login succeed");
	                }
	            }
	        } catch (Exception e) {
	            model.addAttribute("message", "Invalid username");
	        }
	        return "index";
	    }

}