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

import com.education.Service.ClsService;
import com.education.Service.StudentService;
import com.education.config.Message;
import com.education.model.Student;
import com.education.model.StudentClass;

@Controller
public class StudentController {

	    @Autowired
	    private StudentService studService;
	    
	    @Autowired
	    private ClsService clsService;
	    
	    @GetMapping("/addstudent")
	    public String addStudent(Model model)
	    {
	        List<StudentClass> clist=clsService.getAllClass();
	        model.addAttribute("classlist",clist);
	    	
	    	return "addstudent";
	    }
	    
	    // view student
	    @GetMapping("/viewstudent")
	    public String viewStudent(Model model)
	    {
	    	List<Student> list=studService.getAllStudent();
	    	model.addAttribute("studentlist",list);
	    	return "/viewstudent";
	    }
	   
	    @PostMapping("/savestudent")
	    public String saveStudent(@ModelAttribute("addstudent") Student addstudent,HttpSession session)
	    {
	    	    addstudent.setStatus("Unverified");
	    			
	    			
	    	studService.saveStudent(addstudent);
	    	session.setAttribute("message",new Message("Student Added Succesfully..","alert-success"));
	    	return "redirect:/addstudent";
	    }
	    
	    // delete by id
	    @GetMapping("/deletestudent/{id}")
	    public String deleteStudentById(@PathVariable("id") int id,HttpSession session)
	    {
	    	//Student s=studService.getStudentById(id);
	    	studService.deleteStudent(id);
	    	session.setAttribute("message1",new Message("Student Delete Succesfully..","alert-success"));
	    	return "redirect:/viewstudent";	    	
	    }
	    // show student id
	    @GetMapping("/verifystudent/{id}")
	    public String verifyStudent(@PathVariable("id") int id,Student s,HttpSession session)
	    {
	        s.setName(s.getName());
	    	s.setStatus("Verified");
	    	
	    	studService.saveStudent(s);
	    	session.setAttribute("message1",new Message("Student Verified Succesfully.."+id,"alert-success"));
	    	
	    	return "redirect:/viewstudent";	  
	    }
}
