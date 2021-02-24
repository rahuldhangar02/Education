package com.education.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.descriptor.web.ContextResourceEnvRef;
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
import com.education.Service.VideoService;
import com.education.config.Message;
import com.education.model.StudentClass;
import com.education.model.Subject;
import com.education.model.Video;
import com.education.repository.VideoRepository;


@Controller

public class VideoController {

	@Autowired
	private VideoService vservice;
	
	@Autowired
	private ClsService cservice;
	
	@Autowired
	private SubjectService sservice;
	
	 
	@GetMapping("/videoupload")   
	public String videoPage(Model model)
	{
		List<StudentClass> clist=cservice.getAllClass();
		List<Subject> slist=sservice.getAllSubject();
		
		model.addAttribute("classlist",clist);
		model.addAttribute("subjectlist",slist);	
		
		return "videoupload";
	}
	///
	@GetMapping("/viewvideo")
	public String viewVideo(Model model)
	{
		List<Video> vlist=vservice.getAllVideo();
		model.addAttribute("videolist",vlist);
		return "viewvideo";
	}
	// save all video
	@PostMapping("/saveVideo")
	public String saveVideo(@ModelAttribute("video") Video video,HttpSession session)
	{
		vservice.saveVideo(video);
		session.setAttribute("message",new Message("Video Added Succesfully..","alert-success"));
		return "redirect:/videoupload";
	}
	// delete records by id
	@GetMapping("/deleteVideo/{id}")
	public String deleteVideoById(@PathVariable("id") int id,HttpSession session)
	{
		vservice.deleteVideo(id);
		session.setAttribute("message1",new Message("Video Deleted Succesfully..","alert-success"));
		return "redirect:/viewvideo";
	}
	
	// get id by video
	@GetMapping("/showVideo/{id}")
	public String showVideoById(@PathVariable("id") int id,Model model)
	{
	  Video v=vservice.getVideoById(id);
	  model.addAttribute("video",v);
		
		return "updatevideo";
	}
	 
	/// update Records..
	@PostMapping("/updateVideo/{id}")
	public String updateVideoById(@PathVariable("id") int id,HttpSession session,Video video)
	{
		Video v=vservice.getVideoById(id);
		v.setUrl(video.getUrl());
		vservice.saveVideo(v);
		return "updatevideo";
	}
	
}
