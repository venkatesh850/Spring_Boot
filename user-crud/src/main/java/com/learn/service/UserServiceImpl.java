package com.learn.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.learn.dto.UserDto;
import com.learn.entity.User;
import com.learn.mapper.AutoUserMapper;
import com.learn.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		//convert userDto into jpa entity
		//User user = modelMapper.map(userDto, User.class);
		User user = AutoUserMapper.MAPPER.mapToUser(userDto);
		User savedUser = userRepository.save(user);
		//convert jpa entity into USer DTO
		UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);
		return savedUserDto;
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = userRepository.findAll();
//		return users.stream().map((user) -> modelMapper.map(user, UserDto.class))
//						.collect(Collectors.toList());
		return users.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDto(user))
				.collect(Collectors.toList());
	}

	@Override
	public UserDto getUserById(Long id) {
		// TODO Auto-generated method stub
		Optional<User> optionalUser = userRepository.findById(id);
		User user = optionalUser.get();
//		return modelMapper.map(user, UserDto.class);
		return AutoUserMapper.MAPPER.mapToUserDto(optionalUser.get());
	}

	@Override
	public UserDto updateUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User existinguser = userRepository.findById(userDto.getId()).get();
		existinguser.setFirstName(userDto.getFirstName());
		existinguser.setLastName(userDto.getLastName());
		existinguser.setEmail(userDto.getEmail());
		
		User updatedUser = userRepository.save(existinguser);
		return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
	}

}
