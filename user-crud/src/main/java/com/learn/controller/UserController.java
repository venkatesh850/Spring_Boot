package com.learn.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.dto.UserDto;
import com.learn.entity.User;
import com.learn.service.UserService;

import lombok.AllArgsConstructor;

//requestmapping is used for base uri
@RequestMapping("/users")
@RestController
@AllArgsConstructor
public class UserController {
	
	
	private UserService userService;
	
	//build the post request with status code 201
	//post request is used to create the user on database
	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		UserDto savedUser = userService.createUser(userDto);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	//build the get request with status code 200
	//get request is used to fetch the data from the database
	@GetMapping("/fetch")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> users = userService.getAllUsers();
		return ResponseEntity.ok(users);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
		UserDto user = userService.getUserById(userId);
		return  ResponseEntity.ok(user);
	}
	
	//build the put request with status code 200
	//put request is used to update the existing user information in database
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDto> updateUserById(@RequestBody UserDto user, @PathVariable("id") Long id){
		user.setId(id);
		UserDto updatedUser = userService.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	//build the delete request with status code 200
	//delete request is used to delete the data using id
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") Long userId) {
		userService.deleteUserById(userId);
		return "User deleted successfully";
	}
	
}
