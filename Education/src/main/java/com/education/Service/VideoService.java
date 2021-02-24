package com.education.Service;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.education.model.Video;
import com.education.repository.VideoRepository;

@Service
public class VideoService {

	 @Autowired
	 private VideoRepository vrepo;

	// List all Video
	 
	public List<Video> getAllVideo()
	 {
		 return vrepo.findAll();
	 }
	 
	 // save video
	 public void saveVideo(Video v)
	 {
		 vrepo.save(v);
	 }
	 
	 // delete video by id
	 
	 public void deleteVideo(int id)
	 {
		 
		 vrepo.deleteById(id);
	 }
	 
	 // get by id
	 public Video getVideoById(int id)
	 {
		 Video v=vrepo.findById(id).get();
		 return v;
	 }
	 
	
	
}
