package com.customerservice.ticket.infrastructure.repository.mapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customerservice.ticket.infrastructure.repository.po.MessagePO;


@Repository
public interface MessageMapper extends JpaRepository<MessagePO, Long>  {

	List<MessagePO> findByTicketId(String ticketId);	
}
