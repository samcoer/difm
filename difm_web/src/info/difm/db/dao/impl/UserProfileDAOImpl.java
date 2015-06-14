package info.difm.db.dao.impl;

import java.util.List;

import info.difm.db.bo.UserProfile;
import info.difm.db.dao.UserProfileDAO;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cerebsoft.fw.dao.impl.HibernateDaoImpl;
 
@Repository
public class UserProfileDAOImpl extends HibernateDaoImpl<UserProfile, Long> implements UserProfileDAO {
	public UserProfile findUserByUserName(String userName, String password) throws Exception{
		String hql = "FROM UserProfile U WHERE U.userName = :userName and U.password = :password";
		Query query = getSession().createQuery(hql);
		query.setParameter("userName",userName);
		query.setParameter("password",password);
		List results = query.list();
		if(results.isEmpty()){
			return null;
		}
		return (UserProfile)results.get(0);
	}
}

