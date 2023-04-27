package com.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boot.DataStore;
import com.spring.boot.SignupDTO;
import com.spring.boot.dao.SignupEntity;
import com.spring.boot.service.SignupService;

@Controller
//WecomeController is bean or not?? yes
public class SignupController {
	//@Autowired - it pull bean here - >> it is used to inject one bean inside another bean
	@Autowired
	private SignupService  signupService;

	@GetMapping("/clogin")
	public String showLogin() {
		return "login"; // login.jsp
	}

	@GetMapping("/csignup")
	public String showSignup() {
		return "signup"; // signup.jsp
	}

	@PostMapping("/csignup")
	public String posrCreate(@ModelAttribute SignupEntity signupEntity, Model model) {
		signupService.save(signupEntity);
		// JDBC PROGRAMMING
		model.addAttribute("message", "Hey profile is created successfully");
		return "signup"; // signup.jsp
	}
	@PostMapping("/updateSignup")
	public String updateSignupPost(@ModelAttribute SignupEntity signupEntity, Model model) {
		signupService.update(signupEntity);
		List<SignupEntity>   dtos=signupService.findAll();
		DataStore.getSignupDTOs().clear();
		DataStore.getSignupDTOs().addAll(dtos);
		return "showSignups"; // showSignups.jsp
	}
	
	
	@GetMapping("/showSignups")
	public String showSignups() {
		List<SignupEntity>   dtos=signupService.findAll();
		DataStore.getSignupDTOs().clear();
		DataStore.getSignupDTOs().addAll(dtos);
		return "showSignups"; // showSignups.jsp
	}
	
	
	@GetMapping("/deleteData")
	public String deleteSignup(@RequestParam String username, Model model) {
		signupService.deleteByUsername(username);
		List<SignupEntity>   dtos=signupService.findAll();
		DataStore.getSignupDTOs().clear();
		DataStore.getSignupDTOs().addAll(dtos);
		return "showSignups"; // showSignups.jsp
	}
	
	@GetMapping("/editData")
	public String showEditSignup(@RequestParam String username, Model model) {
		SignupEntity signupDTO=signupService.findByUsername(username);
	    model.addAttribute("signupDTO", signupDTO);
	    return "esignup"; // esignup.jsp
	}
	
}
