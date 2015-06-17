package info.difm.biz.service.impl;

import info.difm.biz.service.OrderService;
import info.difm.db.bo.Order;
import info.difm.db.dao.OrderDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
    private OrderDAO orderDAO; 

	@Override
	@Transactional
	public List<Order> listOrders() throws Exception {
		// TODO Auto-generated method stub
		return orderDAO.findAll(Order.class);
	}

	@Override
	@Transactional
	public Order getOrder(Long id) throws Exception {
		// TODO Auto-generated method stub
		return orderDAO.find(Order.class, id);
	}

	@Override
	@Transactional
	public void updateOrder(Order order) throws Exception {
		orderDAO.update(order);
		
	}

	@Override
	@Transactional
	public void addOrder(Order order) throws Exception {
		orderDAO.create(order);
		
	}

	@Override
	@Transactional
	public void deleteOrder(Long id) throws Exception {
		Order order = orderDAO.find(Order.class, id);
		orderDAO.delete(Order.class, id);
		
	}
}
