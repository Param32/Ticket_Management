package com.ticketmanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ticketmanagement.dto.LoginDto;
import com.ticketmanagement.dto.UserDto;
import com.ticketmanagement.entities.Tickets;
import com.ticketmanagement.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/save")
	public UserDto addUser(@RequestBody UserDto user) {
		return userService.addUser(user);
	}

	@PostMapping("/userLogin")
	public List<Tickets> findAll(@RequestBody LoginDto dto) {

		return this.userService.userLogin(dto);

	}
}
