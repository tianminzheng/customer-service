package com.customerservice.ticket.interfaces.rest.assembler;

import com.customerservice.ticket.domain.command.ProcessTicketCommand;
import com.customerservice.ticket.interfaces.rest.dto.ProcessTicketDTO;

public class ProcessTicketCommandDTOAssembler {

	public static ProcessTicketCommand toCommandFromDTO(ProcessTicketDTO processTicketDTO) {

		ProcessTicketCommand processTicketCommand = new ProcessTicketCommand(processTicketDTO.getTicketId(),
				processTicketDTO.getMessageSource(), processTicketDTO.getMessage());
		return processTicketCommand;
	}
}
