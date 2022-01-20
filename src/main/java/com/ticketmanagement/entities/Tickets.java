package com.ticketmanagement.entities;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tickets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketId;

	@Column(name = "ticket_no")
	private String ticketNo;

	@Column(name = "ticket_name")
	private String TicketName;

	@Column(name = "ticket_description")
	private String ticketDescription;

	@OneToOne
	@JsonIgnore
	private Category category;

	@Column(name = "ticket_generation_date")
	private Date ticketGenerationDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	@JsonIgnore
	private User user;

	@Column(name = "is_approved")
	private boolean isApproved;

	@Column(name = "is_rejected")
	private boolean isRejected;

}
