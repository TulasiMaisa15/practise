package com.example.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.model.Customer;
import com.example.practice.model.User;
import com.example.practice.service.CustomerService;
import com.example.practice.service.Userservice;

@RestController
@RequestMapping("/api")
public class Uccontroller<Post> {
	@Autowired
	private Userservice userservice;
	@Autowired
	private CustomerService customerservice;
	
	 public Uccontroller(Userservice userService, CustomerService customerservice) {
	        this.userservice = userService;
	        this.customerservice = customerservice;
	    }
	
	 @GetMapping("/users")
	    public List<User> getAllUsers() {
	        return userservice.findAll();
	    }
	  @PostMapping("/users")
	    public User createUser(@RequestBody User user) {
	        return userservice.save(user);
	    }
	  @GetMapping("/posts")
	    public List<Customer> getAllPosts() {
	        return customerservice.findAll();
	    }
	  @PostMapping("/posts")
	    public Customer createPost(@RequestBody Customer customer) {
	        return customerservice.save(customer);
	    }
	  @PostMapping("/users/{userId}/posts")
	    public Customer createPostForUser(@PathVariable int userId, @RequestBody Customer customer) {
	        User user = userservice.findById(userId);
	        if (user != null) {
	            customer.setUser(user);
	            return customerservice.save(customer);
	        } else {
	            throw new RuntimeException("User not found");
	        }
	    }
}
