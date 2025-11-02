package com.wings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wings.dto.AuthRequest;
import com.wings.service.JwtService;

@RestController
@RequestMapping("/api/public")
public class LoginController {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateAndGetToken(@RequestBody AuthRequest authRequest){
//		return null;
		
		try {
	        authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
	        );
	        String token = jwtService.generateToken(authRequest.getUsername());
	        return ResponseEntity.ok(token);
	    } catch (BadCredentialsException e) {
	        return ResponseEntity.status(401).body("Invalid username or password");
	    }
		
	}
	
}
