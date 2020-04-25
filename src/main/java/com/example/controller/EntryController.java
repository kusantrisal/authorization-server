package com.example.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntryController {

	@GetMapping("/getPrincipal")
	public Principal getPrincipal(Principal princpal) {
		System.out.println("====== AUTH SERVICE Called to get principle using token ======");
		return princpal;
	}

	@GetMapping("/getMemberUuid")
	public Map<String, String> getMemberUuid(Principal princpal) {
		System.out.println("getMemberUuid");
		Map<String, String> map = new HashMap<>();
		map.put("application", "maestro-be-in-express");
		map.put("memberUuid", "memberUuid");
		return map;
	}
}
