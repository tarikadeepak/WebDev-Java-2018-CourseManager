package com.example.webdevsummer2018.services;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevsummer2018.models.UserDetail;
import com.example.webdevsummer2018.repositories.UserDetailRepository;

import hashing.HashPassword;

@RestController
@CrossOrigin(origins = "*", maxAge=3600)
public class UserDetailService {
	private static Logger logger = Logger.getLogger(UserDetailService.class);
	@Autowired
	UserDetailRepository userDetailRepository;
	
	@PostMapping("/login")
	public Iterable<UserDetail> login(@RequestBody UserDetail userDetail){
		System.out.println("User Detail fromLogin " + userDetail.toString());
		String password = "";
		try {
			password = new HashPassword().hashPassword(userDetail.getPassword());
			logger.info("Password Hashing Complete");
		} catch (Exception e) {
			System.out.println("Incorrect password");
			return null;
		}
		logger.info("User Detail After " + userDetailRepository.findUserByCredentials(userDetail.getEmail(), userDetail.getPassword()));
		System.out.println("User Detail After " + userDetailRepository.findUserByCredentials(userDetail.getEmail(), userDetail.getPassword()));
		return userDetailRepository.findUserByCredentials(userDetail.getEmail(), userDetail.getPassword());
	}

	@PostMapping("/registration")
	public UserDetail userRegistration(@RequestBody UserDetail userDetail) {
		return userDetailRepository.save(userDetail);
	}
	
	@DeleteMapping("/delete/{email}")
	public void deleteModule(		
			@PathVariable("email") String email) {
		userDetailRepository.deleteById(email);

	}


}
