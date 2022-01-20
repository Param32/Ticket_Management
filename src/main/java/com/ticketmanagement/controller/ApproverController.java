package com.ticketmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ticketmanagement.dto.ApproverDto;
import com.ticketmanagement.dto.LoginDto;
import com.ticketmanagement.entities.Tickets;
import com.ticketmanagement.service.ApproverService;

@RestController
public class ApproverController {

	@Autowired
	ApproverService approverService;

	@PostMapping("/addApprover")
	public ApproverDto addApprover(@RequestBody ApproverDto dto) {
		return this.approverService.addApprover(dto);
	}
	
	@PostMapping("/login")
	public List<Tickets> approverLogin(@RequestBody LoginDto dto) {
		return this.approverService.approverLogin(dto);
	}
	
	@PostMapping("/getTicketList")
	public boolean showTicketsToApprover(@RequestBody List<Tickets> list) {
		return this.approverService.approveTickets(list);
	}

}
