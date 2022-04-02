package com.customerservice.order.interfaces.rest.assembler;

import com.customerservice.order.domain.command.CreateOrderCommand;
import com.customerservice.order.interfaces.rest.dto.CreateOrderDTO;

public class CreateOrderCommandDTOAssembler {

	public static CreateOrderCommand toCommandFromDTO(CreateOrderDTO createOrderDTO) {
		
		return new CreateOrderCommand();
	}
}
