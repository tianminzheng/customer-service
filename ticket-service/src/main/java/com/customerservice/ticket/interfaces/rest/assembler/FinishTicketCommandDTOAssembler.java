package com.customerservice.ticket.interfaces.rest.assembler;

import com.customerservice.ticket.domain.command.FinishTicketCommand;
import com.customerservice.ticket.interfaces.rest.dto.FinishTicketDTO;

public class FinishTicketCommandDTOAssembler {

	public static FinishTicketCommand toCommandFromDTO(FinishTicketDTO finishTicketDTO) {

		FinishTicketCommand finishTicketCommand = new FinishTicketCommand(finishTicketDTO.getTicketId(),
				finishTicketDTO.getMessage(), finishTicketDTO.getScore());

		return finishTicketCommand;
	}
}
