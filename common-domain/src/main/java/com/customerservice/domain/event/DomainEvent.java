package com.customerservice.domain.event;

import java.util.Date;
import java.util.UUID;

public abstract class DomainEvent {

	private String eventId;
	private Date eventTime;

	public DomainEvent() {
		this.eventId = "Event" + UUID.randomUUID().toString().toUpperCase();
		this.eventTime = new Date();
	}

	public String getEventId() {
		return eventId;
	}

	public Date getEventTime() {
		return eventTime;
	}
}