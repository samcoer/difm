package info.difm.biz.service;

import info.difm.db.bo.Order;

import java.util.List;

public interface OrderService {
	
		public List<Order> listOrders() throws Exception;
		public Order getOrder(Long id) throws Exception;
		public void updateOrder(Order order) throws Exception;
		public void addOrder(Order order) throws Exception;	    	    
	    public void deleteOrder(Long id) throws Exception;
		
	}
