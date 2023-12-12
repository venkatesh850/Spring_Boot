package com.learn.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.learn.dto.UserDto;
import com.learn.entity.User;

@Mapper
public interface AutoUserMapper {
	
	AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);	
	//automatically converts from userdto to jpa entity at compile time
	UserDto mapToUserDto(User user);
	
	//automatically converts from jpa entity into userdto at compile time
	User mapToUser(UserDto userDto);
	

}
