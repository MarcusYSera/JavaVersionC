package com.markie.javabeltc.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import com.markie.javabeltc.models.UserModel;
import com.markie.javabeltc.services.UserService;
import com.markie.javabeltc.validators.UserValidator;

@Controller
public class UserController {
    private final UserService serve;
    private final UserValidator UserValidator;
    
    public UserController(UserService x, UserValidator validator) {
        this.serve = x;
        this.UserValidator= validator;
    }
    
    @RequestMapping("/")
    public String registerAndLogin(@ModelAttribute("user") UserModel user) {
        return "Login.jsp";
    }
    
    @PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("user") UserModel user, BindingResult result, HttpSession session) {
        UserValidator.validate(user,result);
        if(result.hasErrors()) {
        	return "Login.jsp";
        }
        UserModel u = serve.registerUser(user);
        session.setAttribute("userId", u.getId());
        return "redirect:/dash";
    }
    
    @PostMapping("/login")
    public String loginUser(@Valid @ModelAttribute("user") UserModel user, BindingResult result, @RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        boolean isAuthenticated = serve.authenticateUser(email,password);
        if(isAuthenticated){
            UserModel u = serve.findByEmail(email);
            session.setAttribute("userId", u.getId());
            return "redirect:/dash";
        }else{
            model.addAttribute("error", "Invalid Credentials. Please try again.");
            return "Login.jsp";
        }
    }
}