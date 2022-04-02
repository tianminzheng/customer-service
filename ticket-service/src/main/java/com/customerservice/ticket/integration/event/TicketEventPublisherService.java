package com.customerservice.ticket.integration.event;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import com.customerservice.domain.event.TicketAppliedEvent;
import com.customerservice.ticket.infrastructure.messaging.CustomerTicketSource;

@Service
@EnableBinding(CustomerTicketSource.class)
public class TicketEventPublisherService{

	private CustomerTicketSource customerTicketSource;

	public TicketEventPublisherService(CustomerTicketSource customerTicketSource){
        this.customerTicketSource = customerTicketSource;
    }

    @TransactionalEventListener
    public void handleTicketAppliedEvent(TicketAppliedEvent ticketAppliedEvent){
    	
    	customerTicketSource.ticketApplication().send(MessageBuilder.withPayload(ticketAppliedEvent).build());
    }
}
