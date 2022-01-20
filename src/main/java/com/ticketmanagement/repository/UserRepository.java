package com.ticketmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ticketmanagement.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByuserEmail(String email);

}
