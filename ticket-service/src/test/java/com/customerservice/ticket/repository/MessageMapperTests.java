package com.customerservice.ticket.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.customerservice.domain.model.valueobject.MessageSource;
import com.customerservice.ticket.domain.model.valueobject.TicketStatus;
import com.customerservice.ticket.infrastructure.repository.mapper.CustomerTicketMapper;
import com.customerservice.ticket.infrastructure.repository.mapper.MessageMapper;
import com.customerservice.ticket.infrastructure.repository.po.CustomerTicketPO;
import com.customerservice.ticket.infrastructure.repository.po.MessagePO;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class MessageMapperTests {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private MessageMapper messageMapper;
	
	@Test
	public void testFindByTicketId() throws Exception {
		
		MessagePO messagePO1 = buildMessagePO1();
		this.entityManager.persist(messagePO1);
		
		MessagePO messagePO2 = buildMessagePO2();
		this.entityManager.persist(messagePO2);
		
		List<MessagePO> target = this.messageMapper.findByTicketId("ticketId1");
		assertThat(target.size()).isEqualTo(2);
	}
	
	private MessagePO buildMessagePO1() {		
		MessagePO messagePO = new MessagePO();	
		messagePO.setTicketId("ticketId1");
		messagePO.setAccount("account1");
		messagePO.setMessage("message1");
		messagePO.setMessageSource(MessageSource.CUSTOMER);
		messagePO.setStaff("staffId1");
		
		return messagePO;
	}	

	private MessagePO buildMessagePO2() {		
		MessagePO messagePO = new MessagePO();	
		messagePO.setTicketId("ticketId1");
		messagePO.setAccount("account1");
		messagePO.setMessage("message2");
		messagePO.setMessageSource(MessageSource.STAFF);
		messagePO.setStaff("staffId1");
		
		return messagePO;
	}	
}
