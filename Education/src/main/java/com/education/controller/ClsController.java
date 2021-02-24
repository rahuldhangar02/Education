package com.education.controller;




import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.education.Service.ClsService;
import com.education.config.Message;
import com.education.model.StudentClass;
import com.education.repository.ClsRepository;






@Controller

public class ClsController {
	
	 @Autowired
	 ClsService clsService;
	 
	 @Autowired
	 ClsRepository clsRepo;
	
	
	 // View Class Records..
	  @RequestMapping("/cls")
	  public String homePage(Model model)
	  {
		 List<StudentClass> list=clsService.getAllClass();
		 model.addAttribute("classlist",list);
		  return "addclass";
	  }
	  
	  // add Class Records
	@PostMapping("/addclass")
	public String addClass(@ModelAttribute("addcls") StudentClass addcls,HttpSession session)
	{
		clsService.saveClass(addcls);
		  session.setAttribute("message",new Message("Class Added Succesfully..","alert-success"));
		return "redirect:/cls";
	}
	//delete Class Records..
	@GetMapping("/deleteclass/{id}")
	public String deleteClassRecords(@PathVariable("id") int id,HttpSession session)
	{
		
		clsService.deleteClassById(id);
		session.setAttribute("message1",new Message("Class Delete Succesfully.."+ id,"alert-success"));
		return "redirect:/cls";
	}
	
	  /// get Class Records By Id
	@GetMapping("/getClassById/{id}")
	public String getClassRecords(@PathVariable("id") int id,Model model)
	{
		StudentClass getclsid=clsService.getClassById(id);
		model.addAttribute("addcls",getclsid);
		
		return "updateclass";
	}
	
	/// update Records
	@PostMapping("/updateClassById/{id}")
	public String updateClassById(@PathVariable("id") int id,StudentClass cls,HttpSession session)
	{
		StudentClass existingclass=clsService.getClassById(id);
		existingclass.setClsname(existingclass.getClsname());
	     clsRepo.save(existingclass);
		session.setAttribute("message",new Message("Class Updated Succesfully.."+id,"alert-success"));
		return "updateclass";
	}
    
}
