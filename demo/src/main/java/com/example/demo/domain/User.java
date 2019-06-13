package com.example.demo.domain;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class User {

	@ApiModelProperty(name = "id", example = "1", value = "User identifier")
	@NotNull
	private long id;
	
	@ApiModelProperty(name = "name", example = "Laura", value = "Name of the user")
	private String name;
	
	@ApiModelProperty(name = "Last name", example = "Michel", value = "Last name of  the user")
	@NotNull
	private String lastName;
	
	@ApiModelProperty(name = "age", example = "22", value = "Age of the user")
	@NotNull
	private String age;

}