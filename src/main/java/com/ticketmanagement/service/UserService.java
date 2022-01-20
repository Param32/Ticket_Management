package com.ticketmanagement.service;

import java.util.List;
import com.ticketmanagement.dto.LoginDto;
import com.ticketmanagement.dto.UserDto;
import com.ticketmanagement.entities.Tickets;

public interface UserService {

	UserDto addUser(UserDto userDto);

	List<Tickets> userLogin(LoginDto dto);
	
	

}
