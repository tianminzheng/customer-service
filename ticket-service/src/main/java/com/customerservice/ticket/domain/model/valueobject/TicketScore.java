package com.customerservice.ticket.domain.model.valueobject;


public class TicketScore {

	private int score;//健康分值
	
	public TicketScore() {
		super();
	}

	public TicketScore(int score) {
		super();
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
}
