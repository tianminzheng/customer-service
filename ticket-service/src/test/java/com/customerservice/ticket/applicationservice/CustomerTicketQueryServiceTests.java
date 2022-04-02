package com.customerservice.ticket.applicationservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.customerservice.domain.model.entity.OrderProfile;
import com.customerservice.domain.model.entity.StaffProfile;
import com.customerservice.domain.model.valueobject.GoodsProfile;
import com.customerservice.ticket.application.queryservice.CustomerTicketQueryService;
import com.customerservice.ticket.domain.command.ApplyTicketCommand;
import com.customerservice.ticket.domain.model.aggregate.CustomerTicket;
import com.customerservice.ticket.domain.model.valueobject.TicketStatus;
import com.customerservice.ticket.domain.query.CustomerTicketSummary;
import com.customerservice.ticket.domain.respository.CustomerTicketRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class CustomerTicketQueryServiceTests {

	@MockBean
	private CustomerTicketRepository customerTicketRepository;

	@Autowired
	private CustomerTicketQueryService CustomerTicketQueryService;	
	
	@Test
	public void testFindByTicketId() throws Exception {
		CustomerTicket customerTicket = initCustomerTicket();
		
		Mockito.when(customerTicketRepository.findByTicketId("ticketId1")).thenReturn(customerTicket);
	
		CustomerTicket actual = CustomerTicketQueryService.findByTicketId("ticketId1");
		
		assertThat(actual.getTicketId().getTicketId()).isEqualTo("ticketId1");
		assertThat(actual.getStatus()).isEqualTo(TicketStatus.INITIALIZED);
		assertThat(actual.getScore().getScore()).isEqualTo(0);
	
	}
	
	@Test
	public void testFindSummaryByTicketId() throws Exception {
		CustomerTicket customerTicket = initCustomerTicket();
		
		Mockito.when(customerTicketRepository.findByTicketId("ticketId1")).thenReturn(customerTicket);
	
		CustomerTicketSummary actual = CustomerTicketQueryService.findSummaryByTicketId("ticketId1");
		
		assertThat(actual.getTicketId()).isEqualTo("ticketId1");
		assertThat(actual.getStatus()).isEqualTo(TicketStatus.INITIALIZED.toString());
		assertThat(actual.getScore()).isEqualTo(0);
	
	}	

	//初始化一个CustomerTicket
	private CustomerTicket initCustomerTicket() {
		
		ApplyTicketCommand applyTicketCommand = new ApplyTicketCommand(
				"tianyalan",
				"orderNumber1",
				"myInquire"
				);
		applyTicketCommand.setTicketId("ticketId1");
		applyTicketCommand.setOrder(createOrderProfile());
		applyTicketCommand.setStaff(createStaffProfile());
		
		CustomerTicket customerTicket = new CustomerTicket(applyTicketCommand);
		
		return customerTicket;
	}
	
	private OrderProfile createOrderProfile() {
		OrderProfile orderProfile = new OrderProfile();
		orderProfile.setOrderNumber("orderNumber1");
		List<GoodsProfile> goodsList = new ArrayList<GoodsProfile>();
		goodsList.add(new GoodsProfile("goodsCode1", "goodsName1", 100F));
		orderProfile.setGoodsList(goodsList);
		orderProfile.setDeliveryAddress("deliveryAddress1");
		
		return orderProfile;
	}
	
	private StaffProfile createStaffProfile() {
		StaffProfile staffProfile = new StaffProfile(
				"staffId1",
				"staffName1",
				"description1");
		
		return staffProfile;
	}
}
