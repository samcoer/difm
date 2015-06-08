package com.enablee.biz.service;

import java.util.List;

import com.enablee.db.bo.UserProfile;

public interface UserProfileService {
	
		public UserProfile getUser(Long id) throws Exception;
	    public void addUser(UserProfile userProfile) throws Exception;
	    public void updateUser(UserProfile userProfile) throws Exception;
	    public List<UserProfile> listUser() throws Exception;
	    public void removeUser(Long id) throws Exception;
		public List<UserProfile> listUsers() throws Exception;
	}
