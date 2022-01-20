package com.ticketmanagement.service;

import com.ticketmanagement.dto.TicketDto;

public interface TicketService {

	TicketDto generateTicket(TicketDto dto, Long uid) throws Exception;

}
