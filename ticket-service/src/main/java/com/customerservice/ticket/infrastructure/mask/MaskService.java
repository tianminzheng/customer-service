package com.customerservice.ticket.infrastructure.mask;

import org.springframework.stereotype.Service;

@Service
public class MaskService {

	public static String performMask(String source) {
		//演示基础设施层组件，直接返回输入，
		String result = source;
		
		return result;
	}
}
