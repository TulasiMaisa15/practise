package com.example.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practice.dao.UserRepository;
import com.example.practice.model.User;

@Service
public class Userservice {
	
	@Autowired
	private UserRepository userrepository;
	
	public Userservice(UserRepository userrepository) {
        this.userrepository = userrepository;
    }

	 public List<User> findAll() {
	        return userrepository.findAll();
	    }

	    public User save(User user) {
	        return userrepository.save(user);
	    }

	    public User findById(Integer id) {
	        return userrepository.findById(id).orElse(null);
	    }

	    public void deleteById(Integer id) {
	        userrepository.deleteById(id);
	    }
}
