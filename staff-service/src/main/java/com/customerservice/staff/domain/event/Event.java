package com.customerservice.staff.domain.event;

import java.util.Date;
import java.util.UUID;

public abstract class Event {

	private String eventId;
	private Date eventTime;

	public Event() {
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
