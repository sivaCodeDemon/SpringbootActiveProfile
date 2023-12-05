package com.demo.service;

import com.demo.Exception.GeneralMessageException;
import com.demo.Queries.ProfileQuery;
import com.demo.errorcodes.ErrorCodes;
import com.demo.errorcodes.ErrorMessages;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.demo.entity.ProfileEntity;
import com.demo.model.Profile;
import com.demo.repo.ProfileRepo;

import java.util.List;

@Service
public class ProfileService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private ProfileRepo profileRepo;
	
	public ProfileService(ProfileRepo profileRepo) {
		super();
		this.profileRepo = profileRepo;
	}



	public ProfileEntity addProfiles(Profile profile ) {
		ProfileEntity pf= new ProfileEntity();
		
		pf.setName(profile.getName());
		pf.setAddBy(profile.getAddBy());
			profileRepo.save(pf);
		
		return pf;
	}

	public List<Profile> getAllData(){
		RowMapper<Profile> getAll=(rs,rowMapper)->{
			Profile p= new Profile();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setAddBy(rs.getString(3));

			return p;
		};
		List<Profile> list= jdbcTemplate.query(ProfileQuery.GET_PROFILES,getAll);
		if(!list.isEmpty()) {
			return list;
		}
		throw  new GeneralMessageException(ErrorCodes.badRequest, ErrorMessages.NO_VALUES_FOUND);
	}
}
