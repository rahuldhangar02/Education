package com.education.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.education.Service.ClsService;
import com.education.Service.SubjectService;
import com.education.Service.UploadContentService;
import com.education.config.Message;
import com.education.model.StudentClass;
import com.education.model.Subject;
import com.education.model.UploadContent;

@Controller

public class UploadContentController {

	 @Autowired
	 UploadContentService uservice;
	 
	 @Autowired
	 SubjectService subservice;
	 
	 @Autowired
	 ClsService clsService;
	 
	 @GetMapping("/viewcontent")
	public String viewContent(Model model)
	{
		List<UploadContent> list= uservice.viewAllContent();
		model.addAttribute("contentlist",list);
		return "viewcontent";
	}
	
	@GetMapping("/uploadcontent")
	public String uploadContent(Model model)
	{
	 List<StudentClass> slist=clsService.getAllClass();
	 List<Subject> sublist=subservice.getAllSubject();
	 model.addAttribute("classlist",slist);
	 model.addAttribute("subjectlist",sublist);
		return "uploadcontent";
	}
	
	// save data
	@PostMapping("/upload")
	public String saveContent(@Valid @ModelAttribute("content") UploadContent content,BindingResult result,@RequestParam("fileName") MultipartFile file,Model model,HttpSession session)
	{
		
		 try {
			   if(file.isEmpty())
			   {
				   System.out.println("file is empty");
				   content.setFileName("contact.jpg");
			   }
			   else
			   {
				   
				  content.setFileName(file.getOriginalFilename());
				  File saveFile=new ClassPathResource("static/images").getFile();
				  Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
				  Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
				   System.out.println("File Uploaded Sucessfully...");
				 
			   }
			   
			 
		 }catch (Exception e) {
		e.printStackTrace();
		}
	   
		uservice.saveContentData(content);
		 session.setAttribute("message",new Message("Content Added Succesfully..","alert-success"));
		 return "redirect:/uploadcontent";
	}
}
