package com.example.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
@Getter
@Setter
public class AuthUser extends User {

	public AuthUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	private String additionaInfo;
//	private String username;
//	private String password;
//	private boolean accountNonExpired;
//	private boolean accountNonLocked;
//	private boolean credentialsNonExpired;
//	private boolean enabled;
//	private List<GrantedAuthority> grantedAuthorities;

}
