package com.example.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

@Service
public class ClientDetailServiceImpl implements ClientDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		//fetch client info from db here
		BaseClientDetails baseClientDetails = new BaseClientDetails();
		baseClientDetails.setClientId(clientId);
		baseClientDetails.setClientSecret(passwordEncoder.encode("pass"));
		baseClientDetails.setAuthorizedGrantTypes(
				Arrays.asList("refresh_token", "authorization_code", "password", "client_credentials"));
		baseClientDetails.setScope(Arrays.asList("READ", "WRITE"));
		baseClientDetails.setAccessTokenValiditySeconds(30);
		baseClientDetails.setRefreshTokenValiditySeconds(3600);
		return baseClientDetails;
	}

}


