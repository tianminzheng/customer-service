package com.customerservice.ticket.integration.acl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.customerservice.domain.model.entity.OrderProfile;
import com.customerservice.ticket.infrastructure.config.AclConfig;

@Service
public class AclOrderService {

	@Autowired
	private AclConfig aclConfig;

    @Autowired
    RestTemplate restTemplate;
    
	public OrderProfile getOrderInfo(String orderNumber) {
		ResponseEntity<OrderProfile> result =
                restTemplate.exchange(aclConfig.getOrderServiceUrl(), HttpMethod.GET, null,
                		OrderProfile.class, orderNumber);

		OrderProfile orderProfile = result.getBody();
		return fillOrderProfile(orderProfile);
	}	
	
	private OrderProfile fillOrderProfile(OrderProfile orderProfile) {
		//可以对从远程获取的OrderProfile对象进行一些预处理操作
		return orderProfile;
	}
}
