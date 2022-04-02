package com.customerservice.ticket.infrastructure.repository.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.customerservice.domain.model.entity.OrderProfile;
import com.customerservice.domain.model.entity.StaffProfile;
import com.customerservice.ticket.domain.model.aggregate.CustomerTicket;
import com.customerservice.ticket.domain.model.aggregate.TicketId;
import com.customerservice.ticket.domain.model.entity.Consultation;
import com.customerservice.ticket.domain.model.valueobject.TicketScore;
import com.customerservice.ticket.infrastructure.repository.po.CustomerTicketPO;

@Service
public class CustomerTicketFactory {

	public CustomerTicketPO createCustomerTicketPO(CustomerTicket customerTicket) {
		CustomerTicketPO customerTicketPO = new CustomerTicketPO(
				customerTicket.getTicketId().getTicketId(),
				customerTicket.getStatus(),
				customerTicket.getScore().getScore(),
				customerTicket.getConsultation().getConsultationId(),
				customerTicket.getConsultation().getAccount(),
				customerTicket.getConsultation().getInquire(),
				customerTicket.getConsultation().getOrder().getOrderNumber(),
				customerTicket.getConsultation().getOrder().getDeliveryAddress(),
				customerTicket.getStaff().getStaffId(),
				customerTicket.getStaff().getStaffName(),
				customerTicket.getStaff().getDescription());

		return customerTicketPO;
	}

	public CustomerTicket createCustomerTicket(CustomerTicketPO customerTicketPO) {
		CustomerTicket customerTicket = new CustomerTicket();		
		customerTicket.setTicketId(new TicketId(customerTicketPO.getTicketId()));
		customerTicket.setStatus(customerTicketPO.getStatus());
		
		OrderProfile order = new OrderProfile();
		order.setOrderNumber(customerTicketPO.getOrderNumber());
				
		order.setDeliveryAddress(customerTicketPO.getDeliveryAddress());
		
		Consultation consultation = new Consultation(customerTicketPO.getConsultationId(),
				customerTicketPO.getAccount(), order, customerTicketPO.getInquire());
		
		customerTicket.setConsultation(consultation);
		customerTicket.setScore(new TicketScore(customerTicketPO.getScore()));
		
		StaffProfile staff = new StaffProfile(customerTicketPO.getStaffId(),
				customerTicketPO.getStaffName(), customerTicketPO.getStaffDescription());
		customerTicket.setStaff(staff);
		
		return customerTicket;
	}

	public List<CustomerTicket> createCustomerTickets(List<CustomerTicketPO> customerTicketPOs) {
		List<CustomerTicket> customerTickets = new ArrayList<CustomerTicket>();

		customerTicketPOs.forEach((po) -> {
			CustomerTicket customerTicket = createCustomerTicket(po);
			customerTickets.add(customerTicket);
		});
		return customerTickets;
	}
}
