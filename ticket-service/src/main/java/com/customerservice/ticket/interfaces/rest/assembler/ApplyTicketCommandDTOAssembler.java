package com.customerservice.ticket.interfaces.rest.assembler;

import com.customerservice.ticket.domain.command.ApplyTicketCommand;
import com.customerservice.ticket.interfaces.rest.dto.ApplyTicketDTO;

public class ApplyTicketCommandDTOAssembler {

	public static ApplyTicketCommand toCommandFromDTO(ApplyTicketDTO applyTicketDTO) {

		ApplyTicketCommand applyTicketCommand = new ApplyTicketCommand();
		applyTicketCommand.setAccount(applyTicketDTO.getAccount());
		applyTicketCommand.setOrderNumber(applyTicketDTO.getOrderNumber());
		applyTicketCommand.setInquire(applyTicketDTO.getInquire());
		
		return applyTicketCommand;
	}
}
