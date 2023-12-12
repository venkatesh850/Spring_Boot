package com.learn.service;

import java.util.List;

import com.learn.dto.UserDto;
import com.learn.entity.User;

public interface UserService {
	
	//createing user
	public UserDto createUser(UserDto user);
	
	//get all the users
	public List<UserDto> getAllUsers();
	
	//get Particular user by id
	public UserDto getUserById(Long id);
	
	//update user using id
	public UserDto updateUser(UserDto user);
	
	//delete the user using id
	public void deleteUserById(Long id);

}
