package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.UserModel;


@Component
public interface UsersRepository extends JpaRepository<UserModel, Long>{
	

}