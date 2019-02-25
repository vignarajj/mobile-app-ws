package com.indappz.mobile.ws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indappz.mobile.ws.service.UserService;
import com.indappz.mobile.ws.shared.dto.UserDto;
import com.indappz.mobile.ws.ui.model.request.UserDetailsRequestModel;
import com.indappz.mobile.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("users") // http://localhost:8080/users

public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUser() {
		return "Get User by JSON";
	}

	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetailsRequestModel) {
		UserRest returnValue = new UserRest();
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetailsRequestModel, userDto);
		
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);
		
		
		return returnValue;
	}

	@PutMapping
	public String updateUser() {
		return "Update User Called";
	}

	@DeleteMapping
	public String deleteUser() {
		return "Delete User Called";
	}

}
