package info.difm.inte.service;

import info.difm.biz.service.OrderService;
import info.difm.db.bo.Order;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
@RequestMapping(value = "/order")
public class OrderController {
	
	@Autowired
    private OrderService orderService;
    
	@RequestMapping(method = RequestMethod.POST)
	public void create(HttpServletRequest request, @RequestBody String orderIn)
			throws Exception {
		// TODO: validation and data cleansing
		org.codehaus.jackson.map.ObjectMapper objectMapper = new org.codehaus.jackson.map.ObjectMapper(); 
		Order order = objectMapper. readValue(orderIn, Order.class);		
		orderService.addOrder(order);
	}
    
	@RequestMapping(method = RequestMethod.GET)
    public List<Order> listOrder(Map<String, Object> map) throws Exception {
 
        return orderService.listOrders();
    }

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Order get(HttpServletRequest request, @PathVariable("id") Long id)
			throws Exception {
		return orderService.getOrder(id);
	}	

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id)
			throws Exception {		
		orderService.deleteOrder(id);		
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)	
	public void update(@PathVariable("id") Long id,
			@RequestBody String orderIn) throws Exception {

		org.codehaus.jackson.map.ObjectMapper objectMapper = new org.codehaus.jackson.map.ObjectMapper(); 
		Order order = objectMapper.readValue(orderIn, Order.class);
		orderService.updateOrder(order);
	}
}
