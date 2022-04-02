package com.customerservice.staff.domain.event;

import org.springframework.data.domain.AbstractAggregateRoot;


public class HealthTaskEventGenerator extends AbstractAggregateRoot<HealthTaskEventGenerator> {

	public void createTaskCreatedEvent() {
		
		TaskCreatedEvent taskCreatedEvent = new TaskCreatedEvent();
		
		this.registerEvent(taskCreatedEvent);
	}
	
	public void createTaskUpdatedEvent() {
		
		TaskUpdatedEvent taskUpdatedEvent = new TaskUpdatedEvent();
		
		this.registerEvent(taskUpdatedEvent);
	}	
}
