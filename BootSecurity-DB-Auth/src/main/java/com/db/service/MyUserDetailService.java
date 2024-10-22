package com.db.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.db.config.MyUserDetails;
import com.db.model.MyUser;
import com.db.repo.UserRepo;
import java.util.logging.Logger;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo repo;

	Logger logger = Logger.getLogger("MyUserDetailService.class");

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
//		Optional<MyUser> user = repo.findByUsername(username)
//
//	    if(user == null){
//	        logger.info(username + " not found");
//	        throw new UsernameNotFoundException(username + " not found");
//	    }


	    //return new user;
		
		

		Optional<MyUser> user = repo.findByUsername(username);

		
		logger.info(username); 
		return user.map(MyUserDetails::new)
				 			.orElseThrow(()->new UsernameNotFoundException("User Not Found" ));
		 

		
//		  if(user.isPresent()) {
//			  logger.info(username); 
//			  return repo.findByUsername(username); 
//		  } else { 
//			  throw new UsernameNotFoundException(username); 
//		  }
		 
	}

}
