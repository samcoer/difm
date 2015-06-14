package info.difm.biz.service;

import info.difm.db.bo.UserProfile;

import java.util.List;

public interface UserProfileService {
	
		public UserProfile getUser(Long id) throws Exception;
	    public void addUser(UserProfile userProfile) throws Exception;
	    public void updateUser(UserProfile userProfile) throws Exception;
	    public List<UserProfile> listUser() throws Exception;
	    public void removeUser(Long id) throws Exception;
		public List<UserProfile> listUsers() throws Exception;
		public UserProfile findUserByUserName(String userName, String password) throws Exception;
	}
