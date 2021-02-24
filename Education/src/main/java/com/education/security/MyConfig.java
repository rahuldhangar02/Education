package com.education.security;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.education.Service.UserServiceDetailsImpl;



@Configuration
@EnableWebSecurity
public class MyConfig  extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService getUserDetailsService()
	{
		
		return new UserServiceDetailsImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public DaoAuthenticationProvider daoAuthentication()
	{
		DaoAuthenticationProvider dap=new DaoAuthenticationProvider();
		dap.setUserDetailsService(this.getUserDetailsService());
		dap.setPasswordEncoder(this.passwordEncoder());
		return dap;
	}
	/// Configure Method..

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthentication());
	}
   
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
	http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
	.antMatchers("/user/**").hasRole("USER")
	.antMatchers("/**").permitAll().and().formLogin().loginPage("/signin").and().csrf().disable();
	*/
		http.authorizeRequests()
		.antMatchers("/**").permitAll().and().formLogin().and().csrf().disable();
	}
	
}
