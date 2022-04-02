package com.customerservice.ticket.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.customerservice.ticket.domain.model.aggregate.CustomerTicket;
import com.customerservice.ticket.domain.model.aggregate.TicketId;
import com.customerservice.ticket.domain.model.valueobject.Message;
import com.customerservice.ticket.domain.respository.CustomerTicketRepository;
import com.customerservice.ticket.infrastructure.repository.factory.CustomerTicketFactory;
import com.customerservice.ticket.infrastructure.repository.factory.MessageFactory;
import com.customerservice.ticket.infrastructure.repository.mapper.CustomerTicketMapper;
import com.customerservice.ticket.infrastructure.repository.mapper.MessageMapper;
import com.customerservice.ticket.infrastructure.repository.po.CustomerTicketPO;
import com.customerservice.ticket.infrastructure.repository.po.MessagePO;

@Repository
public class CustomerTicketRepositoryImpl implements CustomerTicketRepository {

	private CustomerTicketMapper customerTicketMapper;
	private MessageMapper messageMapper;
	private CustomerTicketFactory customerTicketFactory;
	private MessageFactory messageFactory;

	public CustomerTicketRepositoryImpl(CustomerTicketMapper customerTicketMapper, 
			MessageMapper messageMapper,
			CustomerTicketFactory customerTicketFactory,
			MessageFactory messageFactory) {
		this.customerTicketMapper = customerTicketMapper;
		this.messageMapper = messageMapper;
		this.customerTicketFactory = customerTicketFactory;
		this.messageFactory = messageFactory;
	}

	@Override
	public void save(CustomerTicket customerTicket) {
		CustomerTicketPO customerTicketPO = customerTicketFactory.createCustomerTicketPO(customerTicket);
		customerTicketMapper.save(customerTicketPO);		
	}

	@Override
	public CustomerTicket findByTicketId(String ticketId) {
		CustomerTicketPO customerTicketPO = customerTicketMapper.findByTicketId(ticketId);
		CustomerTicket customerTicket = customerTicketFactory.createCustomerTicket(customerTicketPO);
				
		List<MessagePO> messagePOs = messageMapper.findByTicketId(ticketId);
		List<Message> messages = messageFactory.createMessages(messagePOs);
		customerTicket.setMessages(messages);
		
		return customerTicket;
	}

	@Override
	public List<CustomerTicket> findAll() {
		List<CustomerTicketPO> customerTicketPOs = customerTicketMapper.findAll();
		return customerTicketFactory.createCustomerTickets(customerTicketPOs);
	}

	@Override
	public List<TicketId> findAllTicketIds() {
		List<TicketId> monitorIds = new ArrayList<TicketId>();
		customerTicketMapper.findAllTicketIds().forEach((id) -> {
			monitorIds.add(new TicketId(id));
		});
		
		return monitorIds;
	}

	@Override
	public List<CustomerTicket> findByAccount(String account) {		
		List<CustomerTicketPO> customerTicketPOs = customerTicketMapper.findByAccount(account);
		return customerTicketFactory.createCustomerTickets(customerTicketPOs);
	}

	@Override
	public void updateCustomerTicket(CustomerTicket customerTicket) {
		//查询-设值-保存
		CustomerTicketPO customerTicketPO = customerTicketMapper.findByTicketId(customerTicket.getTicketId().getTicketId());
		customerTicketPO.setScore(customerTicket.getScore().getScore());
		customerTicketPO.setStatus(customerTicket.getStatus());
		customerTicketMapper.save(customerTicketPO);
		
		//新增
		Message message = customerTicket.getLatestMessage();
		MessagePO messagePO = messageFactory.createMessagePO(message);
		messageMapper.save(messagePO);
	}
	
}
