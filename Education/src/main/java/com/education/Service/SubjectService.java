package com.education.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.model.Subject;
import com.education.repository.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository repo;
	
	// get All Data
	public List<Subject> getAllSubject()
	{
		return repo.findAll();
	}
	// save Subject
	public void saveSubject(Subject s)
	{
		repo.save(s);
	}
	
	 // delete Subject
	public void deleteSubject(int id)
	{
		repo.deleteById(id);
	}
	
	// get subject id
	public Subject getSubjectById(int id)
	{
		Subject s=repo.findById(id).get();
		return s;
	}
	
	//
}
