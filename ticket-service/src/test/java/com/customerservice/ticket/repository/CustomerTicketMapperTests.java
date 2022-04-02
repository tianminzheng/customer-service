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
import com.customerservice.ticket.infrastructure.repository.po.CustomerTicketPO;
import com.customerservice.ticket.infrastructure.repository.po.MessagePO;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CustomerTicketMapperTests {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private CustomerTicketMapper customerTicketMapper;
	
	@Test
	public void testFindByTicketId() throws Exception {
		
		CustomerTicketPO customerTicketPO = buildCustomerTicketPO();
		this.entityManager.persist(customerTicketPO);
		
		CustomerTicketPO target = this.customerTicketMapper.findByTicketId("ticketId1");
		assertThat(target).isNotNull();
		assertThat(target.getTicketId()).isEqualTo("ticketId1");
	}
		
	private CustomerTicketPO buildCustomerTicketPO() {
		
		CustomerTicketPO customerTicketPO = new CustomerTicketPO();
		customerTicketPO.setTicketId("ticketId1");
		customerTicketPO.setStatus(TicketStatus.INITIALIZED);
		customerTicketPO.setScore(0);
		customerTicketPO.setAccount("account1");
		customerTicketPO.setInquire("myInquire");
		customerTicketPO.setOrderNumber("orderNumber1");
		
		customerTicketPO.setStaffId("staffId1");
		customerTicketPO.setStaffName("staffName1");
		customerTicketPO.setStaffDescription("staffDescription");
		
		return customerTicketPO;
	}	

}
