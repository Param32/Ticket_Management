package com.ticketmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticketmanagement.dto.TicketDto;
import com.ticketmanagement.service.TicketService;

@RestController
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	@PostMapping("/create/{uid}")
	public TicketDto createTicket(@PathVariable Long uid,@RequestBody TicketDto dto) throws Exception {
		return this.ticketService.generateTicket(dto, uid);
	}

}
