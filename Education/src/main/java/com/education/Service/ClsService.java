package com.education.Service;



import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import com.education.model.StudentClass;
import com.education.repository.ClsRepository;

@Service
@Transactional
public class ClsService {

	@Autowired
	private ClsRepository clsRepo;
	
	// get all Records
	public List<StudentClass> getAllClass()
	{
		return clsRepo.findAll(Sort.by("id").descending());
	}
	
	
	
	// save Student class
	
	public void saveClass(StudentClass studentClass)
	{
		clsRepo.save(studentClass);
	}
	 
	// delete class by Id
	public void deleteClassById(int id)
	{
		clsRepo.deleteById(id);
	}
	
	//
	public StudentClass getClassById(int id)
	{
		StudentClass getid=clsRepo.findById(id).get();
		return getid;
	}

	
}
