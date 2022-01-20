package com.ticketmanagement.service;

import java.util.List;
import com.ticketmanagement.dto.ApproverDto;
import com.ticketmanagement.dto.LoginDto;
import com.ticketmanagement.entities.Tickets;

public interface ApproverService {

	ApproverDto addApprover(ApproverDto approverDto);

	List<Tickets> approverLogin(LoginDto dto);

	boolean approveTickets(List<Tickets> list);

}
