package com.customerservice.ticket.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AclConfig {

	@Value("${order.service.url}")
    private String orderServiceUrl;
	
	@Value("${staff.service.url}")
    private String staffServiceUrl;

	public String getOrderServiceUrl() {
		return orderServiceUrl;
	}

	public String getStaffServiceUrl() {
		return staffServiceUrl;
	}
}
