package info.difm.db.dao;

import info.difm.db.bo.UserProfile;

import com.cerebsoft.fw.dao.BaseDao;
 
public interface UserProfileDAO extends BaseDao<UserProfile, Long>{
	public UserProfile findUserByUserName(String userName, String password) throws Exception;
}