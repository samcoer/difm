package info.difm.db.dao.impl;

import info.difm.db.bo.Order;
import info.difm.db.dao.OrderDAO;

import org.springframework.stereotype.Repository;

import com.cerebsoft.fw.dao.impl.HibernateDaoImpl;
 
@Repository
public class OrderDAOImpl extends HibernateDaoImpl<Order, Long> implements OrderDAO {
	
}

