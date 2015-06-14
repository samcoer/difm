package info.difm.biz.service;

import info.difm.db.bo.UserProfile;
import info.difm.db.dao.UserProfileDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserProfileServiceImpl implements UserProfileService{
	@Autowired
    private UserProfileDAO userProfileDAO;
	
    @Transactional
    public void addUser(UserProfile userProfile) throws Exception {
    	if(userProfile.getUserName() == null || userProfile.getUserName().isEmpty()){
    		userProfile.setUserName(userProfile.getEmail());
    	}
    	userProfileDAO.create(userProfile);
    }
 
    @Transactional
    public List<UserProfile> listUser() throws Exception {
        return userProfileDAO.findAll(UserProfile.class);
    }
 
    @Transactional
    public void removeUser(Long id) throws Exception {
    	UserProfile userProfile = userProfileDAO.find(UserProfile.class, id);
    	userProfileDAO.delete(UserProfile.class, id);
    }

	@Override
	@Transactional
	public UserProfile getUser(Long id) throws Exception {
		return userProfileDAO.find(UserProfile.class, id);
	}
	
	@Override
	@Transactional
	public UserProfile findUserByUserName(String userName, String password) throws Exception {
		return userProfileDAO.findUserByUserName(userName, password);
	}

	@Override
	@Transactional
	public void updateUser(UserProfile userProfile) throws Exception {
		userProfileDAO.update(userProfile);
	}

	@Override
	@Transactional
	public List<UserProfile> listUsers() throws Exception {
		return userProfileDAO.findAll(UserProfile.class);
	}
}
