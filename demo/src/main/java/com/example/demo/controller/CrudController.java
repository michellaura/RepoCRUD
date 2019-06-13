//HTTP Request
package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.service.CrudService;
import com.example.demo.validators.ValidationsAddNewUser;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = "User Managment System")
//mapping web request
@RequestMapping(value = "/user")
public class CrudController {

	// Dependency Injection
	@Autowired
	private CrudService crudService;

	@ApiOperation(value = "Get a list of Users", notes = "This operation should return a list of users")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"), })
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/Users")
	public List<User> getUsers() {
		List<User> user = crudService.getUsers();
		return user;
	}

	@ApiOperation(value = "Get an user by Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved user"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/Users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getById(
			@ApiParam(value = "User id from wich user object retrieve") @PathVariable(value = "id", required = true) long id) {
		User user = crudService.getById(id);
		return ResponseEntity.ok().body(user);
	}

	@ApiOperation(value = "Add an user")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "User created"),
			@ApiResponse(code = 400, message = "Bad request") })
	@PostMapping(value = "/Users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addNewUser(
			@ApiParam(value = "User object store in database table", required = true) @Valid @RequestBody User user) {
		if (crudService.addNewUser(user)) {
			return new ResponseEntity<String>("User created : user", HttpStatus.CREATED);
		}

		else {
			return new ResponseEntity<String>("User already exist", HttpStatus.CONFLICT);

		}
	}

	@ApiOperation(value = "update an user by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully update user"),
			@ApiResponse(code = 400, message = "Bad request") })
	@PutMapping(value = "/Users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateById(
			@ApiParam(value = "Update employee by id") @PathVariable(value = "id", required = true) long id,
			@RequestBody User user) {
		crudService.updateById(id, user);
		return new ResponseEntity<String>("Client Updated : client", HttpStatus.OK);

	}

	@ApiOperation(value = "Delete an user by Id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully delete user", response = CrudController.class),
			@ApiResponse(code = 500, message = "User not found") })
	@DeleteMapping(value = "/Users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(
			@ApiParam(value = "The deleteById method is successfully") @PathVariable(value = "id", required = true) long id) {
		crudService.deleteById(id);
		return new ResponseEntity<>("Client deleted : client", HttpStatus.OK);
	}

}
