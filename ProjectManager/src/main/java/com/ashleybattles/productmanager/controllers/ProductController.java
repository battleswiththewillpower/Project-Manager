package com.ashleybattles.productmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashleybattles.productmanager.models.Project;
import com.ashleybattles.productmanager.models.User;
import com.ashleybattles.productmanager.services.ProjectService;
import com.ashleybattles.productmanager.services.UserService;





@Controller
public class ProductController {
	
	@Autowired
	private ProjectService projectServ;
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/project/new")
	public String newProject(@ModelAttribute("newProject") Project project, Model model, HttpSession session) {
		if(session.isNew() || session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		//logged in user
		model.addAttribute("user",userServ.getOne((Long)session.getAttribute("uuid")));
		
		//get a new book
		Project newProject = new Project();
		model.addAttribute("project", newProject);
		
			return "createproject.jsp";
		
	}
	
	//add book to database
	@PostMapping("/project/new")
	public String createProject(@Valid @ModelAttribute("newProject") 
			Project projectobj, 
			BindingResult result, 
			Model model, 
			HttpSession session) {
		//check is user in session
		if(session.isNew() || session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		//logged in user
		User user = userServ.getOne((Long)session.getAttribute("uuid"));
		model.addAttribute("user", user);
		if(result.hasErrors()) {
//			System.out.println(result);
			model.addAttribute("projects", projectServ.getAll());
			return "createproject.jsp";
		}else {
			//create the book
			System.out.println(projectobj.getUser());
			//will connect the user to the author in the DB
			projectobj.setUser(user);
			Project addproject = projectServ.save(projectobj);
			return "redirect:/dashboard";
		}
	}

}
