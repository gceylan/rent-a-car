package com.gceylan.rentacar.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gceylan.rentacar.service.UserService;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		com.gceylan.rentacar.domain.User domainUser = userService.getUserByUsername(username);
		
		return new User(
				domainUser.getUsername(), 
				domainUser.getPassword(), 
				domainUser.isEnabled(), 
				domainUser.isAccountNonExpired(), 
				domainUser.isCredentialsNonExpired(),
				domainUser.isAccountNonLocked(), 
				getAuthorities(domainUser.getRole().getName())
		);
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(String roleName) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(roleName));
		return authList;
	}
	
	private List<String> getRoles(String roleName) {
		List<String> roles = new ArrayList<String>();
		
		if (roleName.equals("Admin")) {  
			roles.add("ROLE_USER");  
			roles.add("ROLE_ADMIN");  
		} else if (roleName.equals("User")) {  
			roles.add("ROLE_USER");  
		}
		
		return roles;
	}

	private List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
			System.out.println("role: " + role);
		}
		
		return authorities;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
