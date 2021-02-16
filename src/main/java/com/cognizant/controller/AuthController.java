package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.exception.ExcetptionRaise;
import com.cognizant.model.AuthResponse;
import com.cognizant.model.UserLoginCredential;

import com.cognizant.repository.UserRepository;
import com.cognizant.service.CustomerDetailsService;
import com.cognizant.service.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin("*")
public class AuthController {

	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private CustomerDetailsService custdetailservice;
	@Autowired
	private UserRepository urepo;

	@GetMapping(path = "/health")
	public ResponseEntity<?> healthCheckup() {
		log.info("AWS Health Check ");
		return new ResponseEntity<>("", HttpStatus.OK);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody UserLoginCredential userlogincredentials) {
		log.debug("Start : {}", "login");
		final UserDetails userdetails;
		try {
		 userdetails = custdetailservice.loadUserByUsername(userlogincredentials.getUserid());
		
		if (userdetails.getPassword().equals(userlogincredentials.getUpassword())) {
			log.debug("End : {}", "login");
			String role = custdetailservice.getRoleBasedOnUser(userlogincredentials.getUserid());
			System.out.println(role);
			return new ResponseEntity<>(
					new UserLoginCredential(userlogincredentials.getUserid(), null,null,role,jwtutil.generateToken(userdetails)),
					HttpStatus.OK);
		} else {
			log.debug("Access Denied : {}", "login");
			throw new ExcetptionRaise("User is not authentic to this portal");
		}
		}
		catch(Exception e)
		{
			throw new ExcetptionRaise("User is not authentic to this portal");
		}
	}

	@GetMapping(value = "/validate")
	public ResponseEntity<AuthResponse> getValidity(@RequestHeader("Authorization") String tok) {
		/*This method will validate the tocken from multiple microservices*/
		log.debug("Start : {}", "getValidity");
	
		String token = tok.substring(7);
		AuthResponse res = new AuthResponse();
		if (jwtutil.validateToken(token)) {
			res.setUid(jwtutil.extractUsername(token));
			res.setValid(true);
			res.setName(urepo.findById(jwtutil.extractUsername(token)).orElse(null).getUname());

		} else
			res.setValid(false);

		log.debug("End : {}", "getValidity");
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
