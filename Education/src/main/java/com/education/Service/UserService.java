package com.education.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.model.User;
import com.education.repository.UserRepository;

@Service
public class UserService {

	  @Autowired
	  private UserRepository userRepo;
	  
	  // get All user
	  public List<User> getAllUser()
	  {
		  return userRepo.findAll();
	  }
	  
	  // save User
	  
	  public void saveUser(User user)
	  {
		 userRepo.save(user);
	  }
	  
	  // delete user
	  public void deleteUser(int id)
	  {
		  userRepo.deleteById(id);
	  }
	  ///  get user by id
	  
	  public User getUserById(int id)
	  {
		  
		  return userRepo.findById(id).get();
	  }
	  
	  
	  
}
