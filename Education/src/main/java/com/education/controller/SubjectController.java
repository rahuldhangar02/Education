package com.education.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.education.Service.ClsService;
import com.education.Service.SubjectService;
import com.education.config.Message;
import com.education.model.StudentClass;
import com.education.model.Subject;
import com.education.repository.SubjectRepository;

@Controller

public class SubjectController {

	 @Autowired
	private ClsService clsService;
	 
	 @Autowired
	 private SubjectService subService;
	 
	 @Autowired
	 private SubjectRepository subRepo;
	
	@GetMapping("/subject")
	public String subjectPage(Model model)
	{
		 List<StudentClass> list=clsService.getAllClass();
		 List<Subject> subjectlist=subService.getAllSubject();
		
		model.addAttribute("classname",list);
		model.addAttribute("subjectlist",subjectlist);
		return "addsubject";
	}
	
	// add subject
	@PostMapping("/addsubject")
	public String addSubject(@ModelAttribute("addsubject") Subject addsubject,HttpSession session)
	{
		subService.saveSubject(addsubject);
		session.setAttribute("message",new Message("Subject Added Succesfully..","alert-success"));
		
		return "redirect:/subject";
	}
	
	// delete Subject
	@GetMapping("/deletesubject/{id}")
	public String deleteSubject(@PathVariable("id") int id,HttpSession session)
	{
	  	subService.deleteSubject(id);
		session.setAttribute("message1",new Message("Subject Deleted Succesfully..","alert-success"));
		return "redirect:/subject";
	}
	
	/// Show Subject By Id
	@GetMapping("/showsubject/{id}")
     public String showSubject(@PathVariable("id") int id,Model model)
     {
		Subject sid=subService.getSubjectById(id);
		model.addAttribute("subjectlist",sid);
		return "updatesubject";
     }
	// update subject by Id
	@PostMapping("/updatesubject/{id}")
	public String updateClassById(@PathVariable("id") int id,Subject cls,HttpSession session)
	{
		Subject existingclass=subService.getSubjectById(id);
		existingclass.setName(existingclass.getName());
	     subRepo.save(existingclass);
		session.setAttribute("message",new Message("Subject Updated Successfully.."+id,"alert-success"));
		return "updatesubject";
	}
    
	
}
