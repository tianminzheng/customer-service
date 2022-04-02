//package com.customerservice.ticket.domain.event;
//
//import org.springframework.data.domain.AbstractAggregateRoot;
//
//import com.customerservice.domain.event.TicketAppliedEvent;
//import com.customerservice.domain.event.TicketFinishedEvent;
//import com.customerservice.domain.event.TicketProcessedEvent;
//import com.customerservice.domain.model.valueobject.MessageSource;
//
//
//public class TicketEventGenerator extends AbstractAggregateRoot<TicketEventGenerator> {
//
//	public void createTicketAppliedEvent(String ticketId, String account, String staff, MessageSource messageSource, String message) {
//		
//		TicketAppliedEvent ticketAppliedEvent = new TicketAppliedEvent(ticketId, account, staff, messageSource, message);
//		
//		this.registerEvent(ticketAppliedEvent);
//	}
//	
//	public void createTicketProcessedEvent(String ticketId, String account, String staff, MessageSource messageSource, String message) {
//		
//		TicketProcessedEvent ticketProcessedEvent = new TicketProcessedEvent(ticketId, account, staff, messageSource, message);
//		
//		this.registerEvent(ticketProcessedEvent);
//	}
//	
//	public void createTicketFinishedEvent(String ticketId, String account, String staff, MessageSource messageSource, String message) {
//		
//		TicketFinishedEvent ticketFinishedEvent = new TicketFinishedEvent(ticketId, account, staff, messageSource, message);
//		
//		this.registerEvent(ticketFinishedEvent);
//	}
//}
