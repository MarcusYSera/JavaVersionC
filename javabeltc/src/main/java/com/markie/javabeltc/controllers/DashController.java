package com.markie.javabeltc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

import com.markie.javabeltc.models.IdeaModel;
import com.markie.javabeltc.services.IdeaService;
import com.markie.javabeltc.repositories.*;
import com.markie.javabeltc.models.UserModel;
import com.markie.javabeltc.services.UserService;


@Controller
public class DashController {
    private final IdeaService ideaServe;
    private final UserService userServe;
    private final IdeaRepository ideaRepo;
    private final UserRepository userRepo;
	public DashController(IdeaService x, UserService xx, IdeaRepository xxx, UserRepository xxxx) {
        this.ideaServe=x;
        this.userServe=xx;
        this.ideaRepo=xxx;
        this.userRepo=xxxx;
    }

	@RequestMapping("/dash")
	public String startHere(@ModelAttribute("ideaDisplay")IdeaModel x, HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        UserModel u = userServe.findUserById(userId);
        model.addAttribute("user", u);
        model.addAttribute("ideaDisplay", x.getUsers());
        List<IdeaModel> ideasList = ideaRepo.findAll();
        model.addAttribute("ideasList", ideasList);


        // model.addAttribute("highLikes", highLikes);
        // model.addAttribute("lowLikes",lowLikes);
        return "Dash.jsp";
    }

    @RequestMapping(value="/join/{id}")
    public String userLikesIdea(@PathVariable("id")Long ideaId, HttpSession session){
        Long userId = (Long) session.getAttribute("userId");
        UserModel u = userServe.findUserById(userId);
        IdeaModel i = ideaServe.findIdeaId(ideaId);
        List<UserModel> a = i.getUsers();
        a.add(u);
        i.setUsers(a);
        ideaRepo.save(i);
        return "redirect:/dash";
    }

    @RequestMapping(value="/cancel/join/{id}")
    public String cancelAttendance(@PathVariable("id")Long ideaId, HttpSession session){
        Long userId = (Long) session.getAttribute("userId");
        UserModel u = userServe.findUserById(userId);
        IdeaModel e = ideaServe.findIdeaId(ideaId);
        List<UserModel> a = e.getUsers();
        a.remove(u);
        e.setUsers(a);
        ideaRepo.save(e);
        return "redirect:/dash";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
}