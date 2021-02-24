package com.education.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.model.Student;
import com.education.repository.StudentRepository;

@Service
public class StudentService {

	
	@Autowired
	private StudentRepository studRepository;
	
	//List all
	public List<Student> getAllStudent()
	{
		
		return studRepository.findAll();
	}
	// save all student
	public void saveStudent(Student s)
	{
		 studRepository.save(s);
	}
	// delete Student
	public void deleteStudent(int id)
	{
		studRepository.deleteById(id);
	}
	// get Student by Id
	public Student getStudentById(int id)
	{
		Student s=studRepository.findById(id).get();
		return s;
	}
	
}
