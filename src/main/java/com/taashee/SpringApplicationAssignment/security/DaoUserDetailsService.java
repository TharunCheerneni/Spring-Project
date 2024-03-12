package com.taashee.SpringApplicationAssignment.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.taashee.SpringApplicationAssignment.repository.UserRepository;


@Service
public class DaoUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user = userDao.findByUsername(username);
        return user;
	}
}
