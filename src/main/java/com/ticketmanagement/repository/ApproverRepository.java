package com.ticketmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ticketmanagement.entities.Approver;

public interface ApproverRepository extends JpaRepository<Approver, Long> {

	
	Approver findByuserEmail(String userEmail);
}
