package com.mfouad.cqrs.axonCQRS.events;

import lombok.Data;

@Data
public class OrderCreatedEvent {

    private  String orderId;
    
}
