package com.java.AssignmentCon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.DAO.AccountDAO;
import com.java.entity.Account;

@Controller
public class AccountController {
    @Autowired
    private AccountDAO dao;

    @ModelAttribute("role")
    public Map< Integer,String> getRoleOption() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Admins");
        map.put(0, "User");
        return map;
    }

    @GetMapping("/admin/account")
    public String index(Model model) {
        List<Account> accountList = dao.findAll();
        model.addAttribute("accountList", accountList);
        model.addAttribute("account", new Account());
        return "admin/Account";
    }

    @GetMapping("/editAcc/{username}")
    public String editAccountForm(Model model, @PathVariable("username") String username) {
        Account account = dao.getOne(username);
        model.addAttribute("account", account);
        List<Account> accountList = dao.findAll();
        model.addAttribute("accountList", accountList);
        return "admin/Account";
    }
    
    @PostMapping("/updateAcc/{username}")
    public String updateAccount(@ModelAttribute("account") Account account) {
        dao.saveAndFlush(account);
        return "redirect:/admin/account";
    }
    
    @GetMapping("/deleteAcc/{username}")
    public String deleteAccount(@PathVariable("username") String username) {
        dao.deleteById(username);
        return "redirect:/admin/account";
    }
}
