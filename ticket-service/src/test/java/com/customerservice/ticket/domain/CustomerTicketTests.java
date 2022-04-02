package com.customerservice.ticket.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.customerservice.domain.model.entity.OrderProfile;
import com.customerservice.domain.model.entity.StaffProfile;
import com.customerservice.domain.model.valueobject.GoodsProfile;
import com.customerservice.domain.model.valueobject.MessageSource;
import com.customerservice.ticket.domain.command.ApplyTicketCommand;
import com.customerservice.ticket.domain.command.FinishTicketCommand;
import com.customerservice.ticket.domain.command.ProcessTicketCommand;
import com.customerservice.ticket.domain.model.aggregate.CustomerTicket;
import com.customerservice.ticket.domain.model.valueobject.TicketStatus;


@ExtendWith(SpringExtension.class)
public class CustomerTicketTests {

	@Test
	public void testCustomerTicketCreation() throws Exception {		
		CustomerTicket customerTicket = initCustomerTicket();

		assertThat(customerTicket.getTicketId().getTicketId()).isEqualTo("ticketId1");
		assertThat(customerTicket.getStatus()).isEqualTo(TicketStatus.INITIALIZED);
		assertThat(customerTicket.getScore().getScore()).isEqualTo(0);
	}	

	@Test
	public void testCustomerTicketFinishing() throws Exception {		
		CustomerTicket customerTicket = initCustomerTicket();
		
		FinishTicketCommand finishTicketCommand = new FinishTicketCommand("ticketId", "tickct_is_finished", 100);
				
		customerTicket.finishTicket(finishTicketCommand);
		assertThat(customerTicket.getStatus()).isEqualTo(TicketStatus.CLOSED);	
		assertThat(customerTicket.getScore().getScore()).isEqualTo(100);	
	}
	
	//初始化一个CustomerTicket
	private CustomerTicket initCustomerTicket() {
		
		ApplyTicketCommand applyTicketCommand = new ApplyTicketCommand(
				"tianyalan",
				"orderNumber1",
				"myInquire"
				);
		applyTicketCommand.setTicketId("ticketId1");
		
		OrderProfile order = new OrderProfile();
		order.setOrderNumber("orderNumber1");
		List<GoodsProfile> goodsList = new ArrayList<GoodsProfile>();
		goodsList.add(new GoodsProfile("goodsCode1", "goodsName1", 100F));
		order.setGoodsList(goodsList);
		order.setDeliveryAddress("deliveryAddress1");
		applyTicketCommand.setOrder(order);
		
		StaffProfile staff = new StaffProfile("staff1", "staffname1", "description1");
		applyTicketCommand.setStaff(staff);
		
		CustomerTicket customerTicket = new CustomerTicket(applyTicketCommand);
		
		return customerTicket;
	}
}
