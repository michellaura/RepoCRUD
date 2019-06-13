package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.UserModel;

public class Dummy2 {
	
	private List<UserModel> userM = new ArrayList<UserModel>();
	
	public List<UserModel> getUserModelDummy(){
		
		UserModel user = new UserModel();
		
		
		
		
		userM.add(user);
		

		user.setId(8);
		user.setName("Pepe");
		user.setLastName("jadnsaj");
		user.setAge("6");
		
		
		
		
		return userM;
	}
	
	
	
	

}
