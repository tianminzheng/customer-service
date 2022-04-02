package com.customerservice.ticket.integration.acl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.customerservice.ticket.infrastructure.config.AclConfig;
import com.customerservice.domain.model.entity.OrderProfile;
import com.customerservice.domain.model.entity.StaffProfile;
import com.customerservice.dto.FindOptimalStaffDTO;

@Service
public class AclStaffService {
	
	@Autowired
	private AclConfig aclConfig;

    @Autowired
    RestTemplate restTemplate;
    
	public StaffProfile getOptimalStaff(String account, OrderProfile order, String inquire) {
		
		FindOptimalStaffDTO findOptimalStaffDTO = new FindOptimalStaffDTO(order, inquire);
		
		HttpEntity<FindOptimalStaffDTO> httpEntity = new HttpEntity<FindOptimalStaffDTO>(findOptimalStaffDTO);
		ResponseEntity<StaffProfile> result =
                restTemplate.exchange(aclConfig.getStaffServiceUrl(), HttpMethod.POST, httpEntity,
                		StaffProfile.class);

		StaffProfile staffProfile = result.getBody();

		
		return fillStaffProfile(staffProfile);
	}		
		
	private StaffProfile fillStaffProfile(StaffProfile staffProfile) {
		//可以对从远程获取的StaffProfile对象进行一些预处理操作		
		return staffProfile;
	}
}
