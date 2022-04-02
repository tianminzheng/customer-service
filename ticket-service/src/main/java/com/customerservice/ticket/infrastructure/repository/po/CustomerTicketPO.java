package com.customerservice.ticket.infrastructure.repository.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.domain.AbstractAggregateRoot;

import com.customerservice.domain.event.TicketAppliedEvent;
import com.customerservice.domain.model.valueobject.MessageSource;
import com.customerservice.ticket.domain.model.valueobject.TicketStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "customer_ticket")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@NamedQueries({    
    @NamedQuery(name = "CustomerTicketPO.findAllTicketIds",
            query = "Select t.ticketId from CustomerTicketPO t") })
public class CustomerTicketPO extends AbstractAggregateRoot<CustomerTicketPO> implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	//CustomerTicket
	@Column(name = "ticket_id")
	private String ticketId;
	@Enumerated(EnumType.STRING)
	private TicketStatus status;
	private int score;
	
	//Consultation
	private String consultationId;
	private String account;
	private String inquire;
	private String orderNumber;
	private String deliveryAddress;
	private String goods;
	
	//StaffProfile
	private String staffId;
	private String staffName;
	private String staffDescription;

	@Transient
	private List<MessagePO> messages = new ArrayList<>();
		
	public CustomerTicketPO() {
		super();
	}

	public CustomerTicketPO(String ticketId, TicketStatus status, int score, String consultationId, String account,
			String inquire, String orderNumber, String deliveryAddress, String staffId, String staffName,
			String staffDescription) {
		super();
		this.ticketId = ticketId;
		this.status = status;
		this.score = score;
		this.consultationId = consultationId;
		this.account = account;
		this.inquire = inquire;
		this.orderNumber = orderNumber;
		this.deliveryAddress = deliveryAddress;
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffDescription = staffDescription;		
		
		TicketAppliedEvent ticketAppliedEvent = new TicketAppliedEvent(
				ticketId, 
				account, 
				staffName, 
				MessageSource.CUSTOMER, 
				inquire);
		this.registerEvent(ticketAppliedEvent);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public TicketStatus getStatus() {
		return status;
	}

	public void setStatus(TicketStatus status) {
		this.status = status;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getConsultationId() {
		return consultationId;
	}

	public void setConsultationId(String consultationId) {
		this.consultationId = consultationId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getInquire() {
		return inquire;
	}

	public void setInquire(String inquire) {
		this.inquire = inquire;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffDescription() {
		return staffDescription;
	}

	public void setStaffDescription(String staffDescription) {
		this.staffDescription = staffDescription;
	}

	public List<MessagePO> getMessages() {
		return messages;
	}

	public void setMessages(List<MessagePO> messages) {
		this.messages = messages;
	}	
}
