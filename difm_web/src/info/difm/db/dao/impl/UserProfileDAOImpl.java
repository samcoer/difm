package info.difm.db.dao.impl;

import info.difm.db.bo.UserProfile;
import info.difm.db.dao.UserProfileDAO;

import org.springframework.stereotype.Repository;

import com.cerebsoft.fw.dao.impl.HibernateDaoImpl;
 
@Repository
public class UserProfileDAOImpl extends HibernateDaoImpl<UserProfile, Long> implements UserProfileDAO {
	
}

