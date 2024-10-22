package com.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth.entity.User;
import com.auth.repo.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
        User user = repository.findByUserName(username);
        List<GrantedAuthority> authorities=new ArrayList<>();
        
        authorities.add(new SimpleGrantedAuthority(user.getRoles()));
        
        return new org.springframework.security.core.userdetails
        						.User(user.getUserName(), user.getPassword(), authorities);
        
    }
}