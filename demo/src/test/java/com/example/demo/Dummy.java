package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.User;
import com.example.demo.model.UserModel;

public class Dummy {
	
	private List<UserModel> usersM = new ArrayList<UserModel>();
	private List<User> usersD = new ArrayList<User>();
	
	
	public List<UserModel> getUsersModelDummy(){
		
		UserModel user = new UserModel();
		usersM.add(user);
		
		user.setId(22);
		user.setName("Laura");
		user.setLastName("Michel");
		user.setAge("22");
		return usersM;
	}
	
	public List<User> getUsersDomainDummy(){
		
		User user = new User();
		usersD.add(user);
		
		user.setId(3);
		user.setName("Maria");
		user.setLastName("Manzo");
		user.setAge("44");
		return usersD;
	}
	
	public UserModel getUserModelDummy(){
		
		UserModel user = new UserModel();
		
		user.setId(56);
		user.setName("Juan");
		user.setLastName("Perez");
		user.setAge("21");
		return user;
	}
	
	public User getUserDomainDummy(){
		
		User user = new User();
		
		user.setId(1);
		user.setName("Alan");
		user.setLastName("Arambula");
		user.setAge("21");
		return user;
		
	}
}
