package com.customerservice.ticket.infrastructure.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomerTicketSource {

    @Output("ticketApplicationOutput")
    MessageChannel ticketApplication();
    
//	@Output("ticketProcessingChannel")
//    MessageChannel ticketProcessing();
//	
//	@Output("ticketFinishingChannel")
//    MessageChannel ticketFinishing();
}
