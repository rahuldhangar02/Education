package com.education.Service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.model.UploadContent;
import com.education.repository.UploadContentRepository;

@Service
public class UploadContentService {

	@Autowired
	UploadContentRepository repo;
	
	/// save all Content
	public List<UploadContent> viewAllContent()
	{
		//return repo.findAll(Sort(new))
		return repo.findAll();
	}
	
	/// save Content Data
	 
	public void saveContentData(UploadContent content)
	{
		repo.save(content);
	}
	
	// delete Records..
	
	public void deleteContentData(int id)
	{
		
		repo.deleteById(id);
	}
	
	// get content by By
	
	public UploadContent getContentById(int id)
	{
		UploadContent c=repo.findById(id).get();
		return c;
		
	}
}
