package com.restcrud.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.restcrud.demo.entity.User;
import com.restcrud.demo.repository.UserRepository;

@RestController
public class UserController  {

	@Autowired
	private UserRepository userRepository; 
	
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		
		User user= new User();
		
				user.setId(1);
				user.setName("Mariana");
				user.setSurname("Fleitas");
				user.setBirtdate("27/02/1998");
				user.setPhone("1123893634");
				user.setCountry("Argentina");
				user.setCity("Buenos Aires");
				user.setDirection("Jose Ignacio Gorriti");
				user.setPostCode("1888");
				userRepository.save(user);
		
				model.addAttribute("name" , name);
			return "greeting";
		
}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<User> getUsersById(@PathVariable("id") Long id) {
		return userRepository.findById(id);
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json")
	public void addUser(@RequestBody User user) {
		userRepository.save(user);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.PUT, produces = "application/json")
	public void updateUser(@RequestBody User user) {
		userRepository.save(user);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteUserById(@PathVariable("id") Long id) {
		userRepository.deleteById(id);
	}
	
 
}
