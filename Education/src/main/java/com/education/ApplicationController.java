package com.education;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("admin")
public class ApplicationController {

	  @GetMapping("/index")
	  public String  adminPage()
	  {
		  return "index";
	  }
	  
}
