package com.customerservice.ticket.infrastructure.repository.mapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.customerservice.ticket.infrastructure.repository.po.CustomerTicketPO;


@Repository
public interface CustomerTicketMapper extends JpaRepository<CustomerTicketPO, Long>  {

	CustomerTicketPO findByTicketId(String ticketId);
		
	List<String> findAllTicketIds();
	
	@Query("select t from CustomerTicketPO t where t.account = ?1")
	List<CustomerTicketPO> findByAccount(String account);	
}
