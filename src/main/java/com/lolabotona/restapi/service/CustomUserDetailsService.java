package com.lolabotona.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lolabotona.restapi.service.CustomUserDetails;
import com.lolabotona.restapi.model.User;
import com.lolabotona.restapi.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		CustomUserDetails userDetails = null; 
		
		if(user!=null) {
			userDetails = new CustomUserDetails(); 
			userDetails.setUser(user); 
		}else {
			throw new UsernameNotFoundException("El usuario "+ username + "no se ha encontrado en la base de datos");
		}
		
		return userDetails;
	}
	
	

	
}