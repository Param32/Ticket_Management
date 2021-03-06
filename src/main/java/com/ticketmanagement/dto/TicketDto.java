package com.ticketmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {
	
	private String TicketName;
	private String ticketDescription;
	private Long categoryId;
}
