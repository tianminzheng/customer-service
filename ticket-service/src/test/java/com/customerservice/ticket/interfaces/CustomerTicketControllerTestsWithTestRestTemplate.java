package com.customerservice.ticket.interfaces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.customerservice.domain.model.entity.OrderProfile;
import com.customerservice.domain.model.entity.StaffProfile;
import com.customerservice.domain.model.valueobject.GoodsProfile;
import com.customerservice.ticket.application.commandservice.CustomerTicketCommandService;
import com.customerservice.ticket.application.queryservice.CustomerTicketQueryService;
import com.customerservice.ticket.domain.command.ApplyTicketCommand;
import com.customerservice.ticket.domain.model.aggregate.CustomerTicket;
import com.customerservice.ticket.domain.model.aggregate.TicketId;
import com.customerservice.ticket.interfaces.rest.assembler.ApplyTicketCommandDTOAssembler;
import com.customerservice.ticket.interfaces.rest.dto.ApplyTicketDTO;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerTicketControllerTestsWithTestRestTemplate {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@MockBean
	private CustomerTicketCommandService customerTicketCommandService;

	@MockBean
	private CustomerTicketQueryService customerTicketQueryService;

	@Test
	public void testApplyTicket() throws Exception {

		ApplyTicketDTO applyTicketDTO = buildApplyTicketDTO();

		String ticketId = testRestTemplate.postForObject("/tickets/application", applyTicketDTO, String.class);
	}

	@Test
	public void testGetCustomerTicketById() throws Exception {

		CustomerTicket customerTicket = initCustomerTicket();

		String ticketId = "ticketId1";

		given(this.customerTicketQueryService.findByTicketId(ticketId)).willReturn(customerTicket);

		CustomerTicket actual = testRestTemplate.getForObject("/tickets/" + ticketId, CustomerTicket.class);
		assertThat(actual.getTicketId().getTicketId()).isEqualTo(ticketId);
	}

	private ApplyTicketDTO buildApplyTicketDTO() {

		ApplyTicketDTO applyTicketDTO = new ApplyTicketDTO("tianyalan", "orderNumber1", "myInquire");

		return applyTicketDTO;
	}

	// 初始化一个CustomerTicket
	private CustomerTicket initCustomerTicket() {

		ApplyTicketCommand applyTicketCommand = new ApplyTicketCommand("tianyalan", "orderNumber1", "myInquire");
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
		StaffProfile staffProfile = new StaffProfile("staffId1", "staffName1", "description1");

		return staffProfile;
	}
}
