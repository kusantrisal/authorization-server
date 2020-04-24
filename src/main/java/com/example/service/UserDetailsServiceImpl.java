package com.example.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
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
		//fetch authuser info from db here
		AuthUser authUser = AuthUser.builder()
				.username("kush")
				.password(passwordEncoder.encode("pass"))
				.enabled(true)
				.accountNonExpired(true)
				.accountNonLocked(true)
				.credentialsNonExpired(true)
				.grantedAuthorities(Arrays.asList(new SimpleGrantedAuthority("ADMIN")))
				.build();
		
		return new UserDetails() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isEnabled() {
				return authUser.isEnabled();
			}
			
			@Override
			public boolean isCredentialsNonExpired() {
				return authUser.isCredentialsNonExpired();
			}
			
			@Override
			public boolean isAccountNonLocked() {
				return authUser.isAccountNonLocked();
			}
			
			@Override
			public boolean isAccountNonExpired() {
				return authUser.isAccountNonExpired();
			}
			
			@Override
			public String getUsername() {
				return authUser.getUsername();
			}
			
			@Override
			public String getPassword() {
				return authUser.getPassword();
			}
			
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				return authUser.getGrantedAuthorities();
			}
		};
	}

}
