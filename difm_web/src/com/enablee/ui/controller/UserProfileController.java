package com.enablee.ui.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.enablee.biz.service.UserProfileService;
import com.enablee.db.bo.UserProfile;
 
@Controller
public class UserProfileController {
	
	@Autowired
    private UserProfileService userProfileService;
	
	@RequestMapping("index")
    public String showHome(Map<String, Object> map) {
         return "home";
    }
    
    @RequestMapping("/userprofile")
    public String listUser(Map<String, Object> map) throws Exception {
 
        map.put("userProfile", new UserProfile());
        map.put("userList", userProfileService.listUser());
 
        return "userProfile";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userProfile")
    UserProfile userProfile, BindingResult result) throws Exception {
 
    	userProfileService.addUser(userProfile);
 
        return "redirect:/index.htm";
    }
 
    @RequestMapping("/delete/{userID}")
    public String deleteContact(@PathVariable("userID")Long userID) throws Exception {
 
    	userProfileService.removeUser(userID);
 
        return "redirect:/index.htm";
    }
    @RequestMapping
    public ModelAndView showUsers() {
         
        return new ModelAndView("userProfile", "command", new UserProfile());
    }
}
