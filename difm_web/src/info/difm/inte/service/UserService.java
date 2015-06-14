package info.difm.inte.service;

import info.difm.biz.service.UserProfileService;
import info.difm.db.bo.Address;
import info.difm.db.bo.UserProfile;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserService {

	@Autowired
	private UserProfileService userProfileService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public UserProfile get(HttpServletRequest request, @PathVariable("id") Long id)
			throws Exception {
		if(id==0L){
			UserProfile user = new UserProfile();
			user.setAddress(Arrays.asList(new Address()));
			return user;
		}
		return userProfileService.getUser(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<UserProfile> list(HttpServletRequest request)
			throws Exception {
		return userProfileService.listUsers();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void create(HttpServletRequest request, @RequestBody String user)
			throws Exception {
		// TODO: validation and data cleansing
		org.codehaus.jackson.map.ObjectMapper objectMapper = new org.codehaus.jackson.map.ObjectMapper(); 
		UserProfile userProfile = objectMapper. readValue(user, UserProfile.class);
		
		userProfileService.addUser(userProfile);
	}
	
	@RequestMapping(value = "/{id}/mock", method = RequestMethod.POST)
	public void mockUser(HttpServletRequest request, @PathVariable("id") Long id)
			throws Exception {
		if(id == null){
			//set default
			id = 20L;
		}
		request.getSession().setAttribute("USER_ID", id);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public boolean login(HttpServletRequest request, @RequestParam("userName") String userName, @RequestParam("password") String password)
			throws Exception {
		UserProfile userProfile = userProfileService.findUserByUserName(userName, password);
		if(userProfile != null){
			request.getSession().setAttribute("USER", userProfile);
			return true;
		}else{
			return false;
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("id") Long ixd,
			@RequestBody String user) throws Exception {
		// TODO: validation and data cleansing
		org.codehaus.jackson.map.ObjectMapper objectMapper = new org.codehaus.jackson.map.ObjectMapper(); 
		UserProfile userProfile = objectMapper. readValue(user, UserProfile.class);
		userProfileService.updateUser(userProfile);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id)
			throws Exception {
		userProfileService.removeUser(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}