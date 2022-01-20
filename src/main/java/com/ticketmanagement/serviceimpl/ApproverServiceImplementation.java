package com.ticketmanagement.serviceimpl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.ticketmanagement.dto.ApproverDto;
import com.ticketmanagement.dto.LoginDto;
import com.ticketmanagement.entities.Approver;
import com.ticketmanagement.entities.Tickets;
import com.ticketmanagement.exception.ResourceNotFoundException;
import com.ticketmanagement.repository.ApproverRepository;
import com.ticketmanagement.repository.TicketRepository;
import com.ticketmanagement.service.ApproverService;

@Service
public class ApproverServiceImplementation implements ApproverService {

	@Autowired
	ApproverRepository approverRepository;

	@Autowired
	TicketRepository repository;

	@Override
	public ApproverDto addApprover(ApproverDto approverDto) {
		Approver approver = new Approver();
		approver.setFirstName(approverDto.getFirstName());
		approver.setLastName(approverDto.getLastName());
		approver.setUserEmail(approverDto.getUserEmail());
		approver.setUserPassword(approverDto.getUserPassword());
		approver.setCreatedDate(new Date());
		approver.setUserMobileNo(approverDto.getUserMobileNo());

		ApproverDto dto = new ApproverDto();
		Approver approver2 = approverRepository.save(approver);

		BeanUtils.copyProperties(approver2, dto);
		return dto;
	}

	@Override
	public List<Tickets> approverLogin(LoginDto dto) {

		Approver approver = approverRepository.findByuserEmail(dto.getEmail());

		if (ObjectUtils.isEmpty(approver)) {
			throw new ResourceNotFoundException("invalid Email");
		}
		if (approver.getUserPassword().equalsIgnoreCase(dto.getPassword())) {
			List<Tickets> mylist = repository.findAll();
			return mylist;

		} else {
			throw new ResourceNotFoundException("invalid Password");
		}

	}

	@Override
	public boolean approveTickets(List<Tickets> list) {

		List<Tickets> mylist = list;

		for (Tickets tickets : mylist) {
			tickets.setApproved(true);
			tickets.setRejected(false);
		}
		repository.saveAll(mylist);
		return true;
	}

}
