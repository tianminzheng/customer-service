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
import com.customerservice.ticket.application.commandservice.CustomerTicketCommandService;
import com.customerservice.ticket.domain.command.ApplyTicketCommand;
import com.customerservice.ticket.domain.model.aggregate.CustomerTicket;
import com.customerservice.ticket.domain.model.aggregate.TicketId;
import com.customerservice.ticket.domain.model.valueobject.TicketStatus;
import com.customerservice.ticket.domain.respository.CustomerTicketRepository;
import com.customerservice.ticket.integration.acl.AclOrderService;
import com.customerservice.ticket.integration.acl.AclStaffService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class CustomerTicketCommandServiceTests {

	@Autowired
	private CustomerTicketRepository customerTicketRepository;

	@MockBean
	private AclOrderService aclOrderService;

	@MockBean
	private AclStaffService aclStaffService;

	@Autowired
	private CustomerTicketCommandService customerTicketCommandService;

	@Test
	public void testHandleCustomerTicketApplication() throws Exception {
		ApplyTicketCommand applyTicketCommand = createApplyTicketCommand();
		
		//模拟AclOrderService
		OrderProfile orderProfile = createOrderProfile();
		Mockito.when(aclOrderService.getOrderInfo(applyTicketCommand.getOrderNumber())).thenReturn(orderProfile);
		//模拟AclStaffService
		StaffProfile staffProfile = createStaffProfile();
		Mockito.when(aclStaffService.getOptimalStaff(applyTicketCommand.getAccount(), orderProfile, applyTicketCommand.getInquire())).thenReturn(staffProfile);

		TicketId ticketId = customerTicketCommandService.handleCustomerTicketApplication(applyTicketCommand);
		System.out.print(ticketId.getTicketId());
		
		CustomerTicket customerTicket = customerTicketRepository.findByTicketId(ticketId.getTicketId());
		assertThat(customerTicket.getStatus()).isEqualTo(TicketStatus.INITIALIZED);
	}

	private ApplyTicketCommand createApplyTicketCommand() {

		ApplyTicketCommand applyTicketCommand = new ApplyTicketCommand(
				"tianyalan",
				"orderNumber1",
				"myInquire"
				);

		return applyTicketCommand;
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
