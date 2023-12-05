package com.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.demo.entity.ProfileEntity;
import com.demo.model.Profile;
import com.demo.service.ProfileService;

import java.util.List;

/**
 * @author  sivaK
 */
@RestController
@RequestMapping("/api")
public class ProfileController {
	
	
	private ProfileService service;
	
	public ProfileController(ProfileService service) {
		super();
		this.service = service;
	}

	@Value("${message}")
     private String message;

	@PostMapping(path = "/addData")
	public ResponseEntity<ProfileEntity> addDataBasedOnProfiles(@RequestBody Profile profile){
		System.out.println(message);
		ProfileEntity pf= service.addProfiles(profile);
		if(pf!=null) {
			System.out.println(message);
			return new ResponseEntity<ProfileEntity>(pf, HttpStatus.OK);
		}else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getalldata")
	public ResponseEntity<List<Profile>> getAllProfile(){
		List<Profile> list=service.getAllData();
		if(list!=null){
			return new ResponseEntity<List<Profile>>(list,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
