package com.mfouad.cqrs.axonCQRS.events;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OrderEventsHandler {
    

    @EventHandler
    public void on(OrderCreatedEvent event){
        log.info("create new order event with id {}",event.getOrderId());

    }

    @EventHandler
    public void on(ConfirmOrderEvent event){
        log.info("confirm  order with id {}",event.getOrderId());

    }

     @EventHandler
    public void on(ShipOrderEvent event){
        log.info("ship  order with id {}",event.getOrderId());

    }

}
