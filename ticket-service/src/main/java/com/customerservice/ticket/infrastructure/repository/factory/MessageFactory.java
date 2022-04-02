package com.customerservice.ticket.infrastructure.repository.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.customerservice.domain.model.valueobject.MessageSource;
import com.customerservice.ticket.domain.model.aggregate.CustomerTicket;
import com.customerservice.ticket.domain.model.valueobject.Message;
import com.customerservice.ticket.infrastructure.repository.po.CustomerTicketPO;
import com.customerservice.ticket.infrastructure.repository.po.MessagePO;

@Service
public class MessageFactory {

	public MessagePO createMessagePO(Message message) {
		MessagePO messagePO = new MessagePO();
		messagePO.setTicketId(message.getTicketId());
		messagePO.setAccount(message.getAccount());
		messagePO.setMessage(message.getMessage());
		messagePO.setMessageSource(message.getMessageSource());
		messagePO.setStaff(message.getStaff());
		
		return messagePO;
	}

	public Message createMessage(MessagePO messagePO) {
		Message message = new Message();
		message.setTicketId(messagePO.getTicketId());
		message.setAccount(messagePO.getAccount());
		message.setMessage(messagePO.getMessage());
		message.setMessageSource(messagePO.getMessageSource());
		message.setStaff(messagePO.getStaff());
		
		return message;
	}
	
	public List<Message> createMessages(List<MessagePO> messagePOs) {
		List<Message> messages = new ArrayList<Message>();

		messagePOs.forEach((po) -> {
			Message message = createMessage(po);
			messages.add(message);
		});
		return messages;
	}
}
