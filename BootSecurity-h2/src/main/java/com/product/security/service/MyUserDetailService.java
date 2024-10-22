package com.product.security.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.product.security.repo.UserRepo;

@Service
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		Optional<MyUser> user = repo.findByUsername(username);
		
		if(user.isPresent()) {
			return loadUserByUsername(username);
		} else {
			throw new UsernameNotFoundException(username);
		}

	}

}
