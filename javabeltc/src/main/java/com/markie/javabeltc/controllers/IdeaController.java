package com.markie.javabeltc.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

import com.markie.javabeltc.models.IdeaModel;
import com.markie.javabeltc.services.IdeaService;
import com.markie.javabeltc.repositories.*;
import com.markie.javabeltc.models.UserModel;
import com.markie.javabeltc.services.UserService;

@Controller
public class IdeaController {
	private final IdeaService ideaServe;
	private final UserService userServe;
	private final IdeaRepository ideaRepo;

	public IdeaController(IdeaService x, UserService xx, IdeaRepository xxx) {
		this.ideaServe = x;
		this.userServe = xx;
		this.ideaRepo = xxx;
	}

	@RequestMapping("/ideas/new")
	public String startHere(@ModelAttribute("createIdea") IdeaModel x, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		UserModel u = userServe.findUserById(userId);
		model.addAttribute("user", u);
		return "Add.jsp";
	}

	@PostMapping("/idea/create")
	public String creatingIdea(@Valid @ModelAttribute("createIdea") IdeaModel x, BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {
			Long userId = (Long) session.getAttribute("userId");
			UserModel u = userServe.findUserById(userId);
			model.addAttribute("user", u);
			return "Add.jsp";
		} else {
			ideaRepo.save(x);
			return "redirect:/dash";
		}
	}

	@RequestMapping("/ideas/{id}")
	public String viewIdea(@ModelAttribute("viewIdea") IdeaModel x, Model model, @PathVariable("id") Long ideaId) {
		IdeaModel a = ideaServe.findIdeaId(ideaId);
		model.addAttribute("viewIdea", a);
		return "View.jsp";
	}

	@RequestMapping("/ideas/{id}/edit")
	public String editDisplay(@ModelAttribute("editTheIdea")IdeaModel x, Model model, @PathVariable("id")Long ideaId){
		IdeaModel a = ideaServe.findIdeaId(ideaId);
		model.addAttribute("viewIdea", a);
		return "Edit.jsp";
	}

	@PostMapping("/ideas/edit/here/{id}")
	public String editHere(@Valid @ModelAttribute("editTheIdea")IdeaModel x, BindingResult result, Model model, @PathVariable("id")Long ideaId, HttpSession session){
		if(result.hasErrors()){
			IdeaModel y = ideaServe.findIdeaId(ideaId);
			model.addAttribute("viewIdea", y);
			return "Edit.jsp";
		}else{
			IdeaModel i = ideaServe.findIdeaId(ideaId);
			List<UserModel> a = i.getUsers();
			x.setUsers(a);
			ideaRepo.save(x);
			return "redirect:/dash";
		}
	}

	@RequestMapping("/ideas/delete/{id}")
	public String destroy(@PathVariable("id")Long id){
		ideaRepo.deleteById(id);
		return "redirect:/dash";
	}
}