package com.learn.service;

import java.util.List;

import com.learn.entity.User;

public interface UserService {
	
	//createing user
	public User createUser(User user);
	
	//get all the users
	public List<User> getAllUsers();
	
	//get Particular user by id
	public User getUserById(Long id);
	
	//update user using id
	public User updateUser(User user);
	
	//delete the user using id
	public void deleteUserById(Long id);

}
