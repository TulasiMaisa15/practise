package com.example.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practice.dao.CustomerRepository;
import com.example.practice.model.Customer;
@Service
public class CustomerService {
	
	@Autowired
	private final CustomerRepository customerrepository;
	
	public CustomerService(CustomerRepository customerrepository) {
        this.customerrepository = customerrepository;
    }

    public List<Customer> findAll() {
        return customerrepository.findAll();
    }

    public Customer save(Customer customer) {
        return customerrepository.save(customer);
    }

    public Customer findById(Integer id) {
        return customerrepository.findById(id).orElse(null);
    }

    public void deleteById(Integer id) {
    	customerrepository.deleteById(id);
    }

}
