package com.ticketmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private String firstName;
	private String lastName;
	private String userEmail;
	private String userPassword;
	private Long userMobileNo;

}
