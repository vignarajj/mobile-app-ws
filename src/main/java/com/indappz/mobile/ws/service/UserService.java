package com.indappz.mobile.ws.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.indappz.mobile.ws.shared.dto.UserDto;

public interface UserService extends UserDetailsService{
	UserDto createUser(UserDto user);
}
