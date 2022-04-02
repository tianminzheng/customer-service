package com.customerservice.ticket.domain.model.aggregate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.AbstractAggregateRoot;

import com.customerservice.domain.event.TicketAppliedEvent;
import com.customerservice.domain.model.entity.StaffProfile;
import com.customerservice.domain.model.valueobject.MessageSource;
import com.customerservice.ticket.domain.command.ApplyTicketCommand;
import com.customerservice.ticket.domain.command.FinishTicketCommand;
import com.customerservice.ticket.domain.command.ProcessTicketCommand;
import com.customerservice.ticket.domain.model.entity.Consultation;
import com.customerservice.ticket.domain.model.valueobject.Message;
import com.customerservice.ticket.domain.model.valueobject.TicketScore;
import com.customerservice.ticket.domain.model.valueobject.TicketStatus;

public class CustomerTicket {

	private TicketId ticketId;// 客服工单唯一编号
	private Consultation consultation;// 用户咨询
	private StaffProfile staff;// 客服人员
	private TicketStatus status;// 工单状态
	private List<Message> messages;// 工单详细消息列表
	private Message latestMessage;// 工单最近一条消息
	private TicketScore score;// 工单评分
	
	public CustomerTicket() {

	}

	public CustomerTicket(ApplyTicketCommand applyTicketCommand) {
		// 1.设置聚合标识符
		this.ticketId = new TicketId(applyTicketCommand.getTicketId());

		// 2.创建Consultation
		String consultationId = "Consultation" + UUID.randomUUID().toString().toUpperCase();
		this.consultation = new Consultation(consultationId, applyTicketCommand.getAccount(),
				applyTicketCommand.getOrder(), applyTicketCommand.getInquire());
		
		// 3.获取客服信息
		this.staff = applyTicketCommand.getStaff();
		
		// 4.初始化基础信息
		this.status = TicketStatus.INITIALIZED;
		this.messages = new ArrayList<Message>();
		this.score = new TicketScore(0);
	}
		
	public void processTicket(ProcessTicketCommand processTicketCommand) {
		
		// 验证TicketId是否对当前CustomerTicket对象是否有效
		String ticketId = processTicketCommand.getTicketId();
		if(!ticketId.equals(this.ticketId.getTicketId())) {
			return;
		}

		// 构建Message
		Message message = new Message(processTicketCommand.getTicketId(), this.consultation.getAccount(),
				this.staff.getStaffName(), processTicketCommand.getMessageSource(), processTicketCommand.getMessage());
		latestMessage = message;
		this.messages.add(message);

		// 更新工单状态
		this.status = TicketStatus.INPROCESS;
	}

	public void finishTicket(FinishTicketCommand finishTicketCommand) {
		// 构建Message
		Message message = new Message(finishTicketCommand.getTicketId(), this.consultation.getAccount(),
				this.staff.getStaffName(), MessageSource.CUSTOMER, finishTicketCommand.getMessage());
		latestMessage = message;
		this.messages.add(message);
		
		// 更新工单状态
		this.status = TicketStatus.CLOSED;

		// 设置工单评分
		this.score = new TicketScore(finishTicketCommand.getScore());
	}

	public TicketId getTicketId() {
		return ticketId;
	}
	public void setTicketId(TicketId ticketId) {
		this.ticketId = ticketId;
	}
	public Consultation getConsultation() {
		return consultation;
	}
	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}
	public StaffProfile getStaff() {
		return staff;
	}
	public void setStaff(StaffProfile staff) {
		this.staff = staff;
	}
	public TicketStatus getStatus() {
		return status;
	}
	public void setStatus(TicketStatus status) {
		this.status = status;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public Message getLatestMessage() {
		return latestMessage;
	}
	public void setLatestMessage(Message latestMessage) {
		this.latestMessage = latestMessage;
	}
	public TicketScore getScore() {
		return score;
	}
	public void setScore(TicketScore score) {
		this.score = score;
	}
}
