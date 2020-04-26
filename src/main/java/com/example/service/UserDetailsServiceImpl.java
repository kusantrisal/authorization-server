package com.example.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.AuthUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// fetch authuser info from db here
		AuthUser authUser = new AuthUser("kush", passwordEncoder.encode("pass"), true, true, true, true,
				Arrays.asList(new SimpleGrantedAuthority("ADMIN")));

		// TODO while saving user in database use
		// String uniqueID = UUID.randomUUID().toString();
		authUser.setMemberUuid("ef805c9b-320b-4014-9374-ed667c900b96");
		authUser.setFirstName("Jesus");
		authUser.setLastName("Christ");
		authUser.setEmail("fakeemail@hotmail.com");
		authUser.setPhone("123-456-7890");
		
		if (username == null || !username.equalsIgnoreCase(authUser.getUsername())) {
			throw new UsernameNotFoundException("Invalid username" + username);
		}

		return authUser;

	}

}
