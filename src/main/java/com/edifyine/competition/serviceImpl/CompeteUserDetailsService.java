package com.edifyine.competition.serviceImpl;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edifyine.competition.pojo.CompeteUser;
import com.edifyine.competition.service.UserService;

@Service
public class CompeteUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Optional<CompeteUser> user = userService.loadUserByUserId(userId);
		user.orElseThrow(()-> new UsernameNotFoundException("Not Found:"+userId));
		CompeteUser competeUser = user.get();
		List<GrantedAuthority> authorities = Arrays.stream(competeUser.getRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		return new User(competeUser.getUserName(), competeUser.getPassword(), authorities);
	}
}
