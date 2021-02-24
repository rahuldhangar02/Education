package com.education.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.education.Service.UserServiceDetailsImpl;
import com.education.Service.UserService;
import com.education.config.Message;
import com.education.model.User;

@Controller
public class UserController {


	
	  @Autowired
	  private UserService userService;
	  
	  @Autowired
	  private BCryptPasswordEncoder encoder;

	  @RequestMapping("/login")
	  public String homePage1()
	  {
		  return "login";
	  }
	  
	  @GetMapping("/")
	  public String homePage()
	  {
		  return "index";
	  }
	 
	  
	  @GetMapping("/user")
	  public String user(Model model)
	  {
		  List<User> userlist=userService.getAllUser();
		  model.addAttribute("userlist",userlist);
		  return "adduser";
	  }
	  
	  @PostMapping("/adduser")
	  public String addUser(@ModelAttribute("adduser") User adduser,HttpSession session)
	  {
		  adduser.setRole("Admin");
		  adduser.setPassword(encoder.encode(adduser.getPassword()));
		  userService.saveUser(adduser);  
		  session.setAttribute("message",new Message("User Added Succesfully..","alert-success"));
		  return "redirect:/user";	  
	  }
	  
	  
	  
	  
}


