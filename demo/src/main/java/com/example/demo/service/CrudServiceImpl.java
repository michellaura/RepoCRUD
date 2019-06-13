//validations, transfomers
package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.mapper.OrikaMapper;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UsersRepository;
import com.example.demo.validators.ValidationsAddNewUser;

import ma.glasnost.orika.MapperFacade;

@Service
public class CrudServiceImpl implements CrudService {

	// Dependency injection
	@Autowired
	private UsersRepository userRepository;

	private ValidationsAddNewUser validateAddUser;

	// Instantiate OrikaMapper class
	private MapperFacade facade = new OrikaMapper();

	public List<User> getUsers() {
		List<UserModel> responseModel = userRepository.findAll();
		List<User> userDomain = new ArrayList<User>();
		responseModel.forEach((userD) -> {
			userDomain.add(facade.map(userD, User.class));
		});
		return userDomain;
	}

	public User getById(long id) {
		UserModel userModel = new UserModel();
		User userDomain = new User();
		userModel = userRepository.getOne(id);
		userDomain = facade.map(userModel, User.class);
		return userDomain;
	}

	public boolean addNewUser(User user) {
		UserModel userModel = new UserModel();
		userModel = facade.map(user, UserModel.class);
		validateAddUser = new ValidationsAddNewUser();
		try {
			boolean userAdded = ValidationsAddNewUser.validate(userModel.getId(), userModel.getName().trim(),
					userModel.getLastName().trim(), userModel.getAge().trim());
		} catch (NullPointerException e) {
			System.out.println("Hola" + e);

		}

		if (userRepository.findById(user.getId()).isPresent()) {
			return false;
		} else {
			userRepository.save(userModel);
			return true;
		}
	}

	public void updateById(long id, User user) {
		UserModel userModel = new UserModel();
		userModel = facade.map(user, UserModel.class);
		userModel.setId(id);
		userRepository.save(userModel);
	}

	public void deleteById(long id) {
		userRepository.deleteById(id);

	}

}
