package com.java.AssignmentCon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.DAO.AccountDAO;
import com.java.entity.Account;

@Controller
public class SignupController {
	
	@Autowired
    AccountDAO accountDAO;
    
	
	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping("/signup")
    public String signUp(Model model, @RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("email") String email) {
        
        // Check if the username already exists
        if (accountDAO.existsById(username)) {
            model.addAttribute("message", "Username already exists");
            return "signup";
        }
        
        // Create a new account
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setEmail(email);
        account.setRoles(0); // Set the default admin value
        
        // Save the account to the database
        accountDAO.save(account);
        
        model.addAttribute("message", "Sign up successful");
        return "login"; // Redirect to the login page
    }
    
   
}
