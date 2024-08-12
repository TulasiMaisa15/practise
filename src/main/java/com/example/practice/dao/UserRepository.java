package com.example.practice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practice.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
}
