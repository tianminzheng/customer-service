package com.customerservice.ticket.domain.command;


public class FinishTicketCommand {

	private String ticketId;
	private String message;
	private Integer score;	
	
	public FinishTicketCommand(String ticketId, String message, Integer score) {
		super();
		this.ticketId = ticketId;
		this.message = message;
		this.score = score;
	}
	
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	
	
}
