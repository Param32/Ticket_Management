package com.ticketmanagement.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Approver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_Name")
	private String lastName;

	@Column(name = "user_email",unique = true)
	private String userEmail;

	@Column(name = "user_password")
	private String userPassword;

	@Column(name = "user_mobile_no",unique = true)
	private Long userMobileNo;

	@Column(name = "created_date")
	private Date createdDate;

}
