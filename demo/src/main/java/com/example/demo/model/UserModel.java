package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name = "Users")
@ApiModel(value = "All details about the users")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// to describe the properties of the User model
	@ApiModelProperty(value = "The user Id", name = "userId", example = "[1, 2, 3]")
	private long id;

	@NotNull
	@Column(name = "NAME")
	@ApiModelProperty(value = "The user name", name = "userName", example = "[Maria, Juan, Pedro, Yamile]")
	private String name;

	@NotNull
	@Column(name = "LAST_NAME")
	@ApiModelProperty(value = "The user last name", name = "userLastName", example = "[Michel, Manzo, Juarez, Gonzalez]")
	private String lastName;

	@NotNull
	@Column(name = "AGE")
	@ApiModelProperty(value = "The user age", name = "userAge", example = "[22, 23, 44, 55]")
	private String age;

}