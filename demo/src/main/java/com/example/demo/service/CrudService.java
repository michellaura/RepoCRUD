package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.User;

public interface CrudService {

	public List<User> getUsers();

	public User getById(long id);

	// void means that the method has no return value
	public boolean addNewUser(User user);

	public void deleteById(long id);

	public void updateById(long id, User user);
}
