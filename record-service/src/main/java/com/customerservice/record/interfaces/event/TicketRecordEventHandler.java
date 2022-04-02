package com.customerservice.record.interfaces.event;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

import com.customerservice.domain.event.TicketAppliedEvent;
import com.customerservice.record.application.commandservice.TicketRecordCommandService;
import com.customerservice.record.domain.command.SaveRecordCommand;
import com.customerservice.record.interfaces.event.assembler.SaveRecordCommandEventAssembler;

@Service
@EnableBinding(Sink.class)
public class TicketRecordEventHandler {
	
	private TicketRecordCommandService ticketRecordCommandService;
	
	public TicketRecordEventHandler(TicketRecordCommandService ticketRecordCommandService) {
		this.ticketRecordCommandService = ticketRecordCommandService;
	}
	
	@StreamListener("input")
	public void handleTicketAppliedEvent(TicketAppliedEvent ticketAppliedEvent) {  

		SaveRecordCommand keepRecordCommand = SaveRecordCommandEventAssembler.toCommandFromEvent(ticketAppliedEvent);
	
		ticketRecordCommandService.handleTicketRecordCreation(keepRecordCommand);
	}
}
