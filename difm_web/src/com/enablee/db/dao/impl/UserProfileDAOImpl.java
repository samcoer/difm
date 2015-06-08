package com.enablee.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.cerebsoft.fw.dao.impl.HibernateDaoImpl;
import com.enablee.db.bo.UserProfile;
import com.enablee.db.dao.UserProfileDAO;
 
@Repository
public class UserProfileDAOImpl extends HibernateDaoImpl<UserProfile, Long> implements UserProfileDAO {
	
}

