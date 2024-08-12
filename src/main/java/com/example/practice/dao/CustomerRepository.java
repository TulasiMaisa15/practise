package com.example.practice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practice.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
