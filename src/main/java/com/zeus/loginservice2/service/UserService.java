package com.zeus.loginservice2.service;

import com.zeus.loginservice2.repository.UserRepository;
import com.zeus.loginservice2.repository.entity.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

 @Autowired
 private UserRepository userRepository;

 @Override
 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
	com.zeus.loginservice2.repository.entity.User user = userRepository.findByUsername(username);
	return new User(user.getUsername(),user.getPassword(),user.isActive(),user.isActive(),
			true,true,buildGranted(user.getRoles()));

 }

private List<GrantedAuthority> buildGranted(List<Roles> roles){
	List<GrantedAuthority> lGrantedAuthority =  new ArrayList<>();
	for(Roles rol : roles){
		lGrantedAuthority.add(new SimpleGrantedAuthority(rol.getRolName()));
	}

	return lGrantedAuthority;
} 

}
