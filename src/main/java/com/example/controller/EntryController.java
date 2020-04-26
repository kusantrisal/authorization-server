package com.example.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AuthUser;

@RestController
public class EntryController {

	@GetMapping("/getPrincipal")
	public Principal getPrincipal(Principal princpal) {
		System.out.println("====== AUTH SERVICE Called to get principle using token ======");
		return princpal;
	}

	@GetMapping("/getMemberByMemberUuid")
	public Principal getMemberUuid(Principal princpal) {
		return  princpal;
	}
}
