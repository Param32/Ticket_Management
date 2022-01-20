package com.ticketmanagement.serviceimpl;

import java.util.Date;
import java.util.Random;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.ticketmanagement.dto.TicketDto;
import com.ticketmanagement.entities.Category;
import com.ticketmanagement.entities.Tickets;
import com.ticketmanagement.entities.User;
import com.ticketmanagement.repository.CategoryRepository;
import com.ticketmanagement.repository.TicketRepository;
import com.ticketmanagement.repository.UserRepository;
import com.ticketmanagement.service.TicketService;

@Service
public class TicketServiceImplementation implements TicketService {

	@Autowired
	UserRepository repository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	TicketRepository ticketRepository;

	@Override
	public TicketDto generateTicket(TicketDto dto, Long uid) throws Exception {
	
		TicketDto newdto = new TicketDto();
		Random random = new Random();
		String no = String.format("%04d", random.nextInt(10000));
		User user = repository.getById(uid);
		if (ObjectUtils.isEmpty(user)) {
			throw new Exception("User Not found");
		} else {
			Tickets tickets = new Tickets();

			Category category = categoryRepository.getById(dto.getCategoryId());

			tickets.setTicketName(dto.getTicketName());
			tickets.setTicketDescription(dto.getTicketDescription());
			tickets.setUser(user);
			tickets.setApproved(false);
			tickets.setRejected(false);
			tickets.setTicketGenerationDate(new Date());
			tickets.setTicketNo("TCN" + no);
			tickets.setCategory(category);
			Tickets save = this.ticketRepository.save(tickets);

			BeanUtils.copyProperties(save, newdto);

		}
		return newdto;
	}

}