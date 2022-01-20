package com.ticketmanagement.serviceimpl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.ticketmanagement.dto.LoginDto;
import com.ticketmanagement.dto.UserDto;
import com.ticketmanagement.entities.Tickets;
import com.ticketmanagement.entities.User;
import com.ticketmanagement.exception.ResourceNotFoundException;
import com.ticketmanagement.repository.TicketRepository;
import com.ticketmanagement.repository.UserRepository;
import com.ticketmanagement.service.UserService;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TicketRepository repository;

	@Override
	public UserDto addUser(UserDto userDto) {
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setUserEmail(userDto.getUserEmail());
		user.setUserPassword(userDto.getUserPassword());
		user.setUserMobileNo(userDto.getUserMobileNo());
		user.setCreatedDate(new Date());

		User user2 = new User();
		user2 = userRepository.save(user);

		BeanUtils.copyProperties(user2, userDto);
		return userDto;

	}

	@Override
	public List<Tickets> userLogin(LoginDto dto) {
		User user = userRepository.findByuserEmail(dto.getEmail());

		if (ObjectUtils.isEmpty(user)) {
			throw new ResourceNotFoundException("invalid Email");
		}
		if (user.getUserPassword().equalsIgnoreCase(dto.getPassword())) {
			List<Tickets> mylist = repository.findAllByUserUserId(user.getUserId());
			return mylist;

		} else {
			throw new ResourceNotFoundException("invalid Password");
		}
	}

}
