package com.example.demo.mapper;

import com.example.demo.domain.User;
import com.example.demo.model.UserModel;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

public class OrikaMapper extends ConfigurableMapper {

	public MapperFactory mapUserDaoToUser(MapperFactory factory) {
		factory.classMap(UserModel.class, User.class).byDefault().register();
		return factory;
	}

}