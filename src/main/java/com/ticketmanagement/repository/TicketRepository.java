package com.ticketmanagement.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ticketmanagement.entities.Tickets;


public interface TicketRepository extends JpaRepository<Tickets, Long>{
	
	List<Tickets> findAllByUserUserId(Long id);
	
	List<Tickets> findAllByIsApprovedTrueAndIsRejectedFalse();

}
