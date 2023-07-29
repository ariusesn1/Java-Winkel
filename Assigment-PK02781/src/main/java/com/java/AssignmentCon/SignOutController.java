package com.java.AssignmentCon;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.service.SessionService;

@Controller
public class SignOutController {
    
    @Autowired
    SessionService session;
    
    @GetMapping("/signout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        
        return "redirect:/signin";
    }
    
    @RequestMapping("/admin/signout")
    public String logoutAd(HttpSession httpSession) {
        httpSession.invalidate();
        
        return "redirect:/signin";
    }
}
