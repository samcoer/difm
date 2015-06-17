package info.difm.ui.controller;

import info.difm.biz.service.OrderService;
import info.difm.db.bo.Order;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class OrderController {
	
	@Autowired
    private OrderService orderService;
    
    @RequestMapping("/order")
    public String listOrder(Map<String, Object> map) throws Exception {
 
        map.put("order", new Order());
        map.put("orderList", orderService.listOrders());
 
        return "order";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("order")
    Order order, BindingResult result) throws Exception {
 
    	orderService.addOrder(order);
 
        return "redirect:/index.htm";
    }
 
    @RequestMapping("/delete/{orderID}")
    public String deleteOrder(@PathVariable("orderID")Long orderID) throws Exception {
 
    	orderService.deleteOrder(orderID);
 
        return "redirect:/index.htm";
    }
    @RequestMapping
    public ModelAndView showOrders() {
         
        return new ModelAndView("order", "command", new Order());
    }
}
