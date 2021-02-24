package com.education.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.education.model.User;
import com.education.repository.UserRepository;

@Service
public class UserDetailsImpl implements UserDetailsService {

	 @Autowired
	 private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		  User user=userRepo.getUserByName(username);
		  if(user==null)
		  {
			  System.out.println("user should not be null");
		  }
		 CustomUserDetails cud=new CustomUserDetails(user);
		  
		return cud;
	}

}
