package com.mfouad.cqrs.axonCQRS.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import com.mfouad.cqrs.axonCQRS.UnconfirmedOrderException;
import com.mfouad.cqrs.axonCQRS.commands.ConfirmOrderCommand;
import com.mfouad.cqrs.axonCQRS.commands.CreateOrderCommand;
import com.mfouad.cqrs.axonCQRS.commands.ShipOrderCommand;
import com.mfouad.cqrs.axonCQRS.events.ConfirmOrderEvent;
import com.mfouad.cqrs.axonCQRS.events.OrderCreatedEvent;
import com.mfouad.cqrs.axonCQRS.events.ShipOrderEvent;

import lombok.extern.slf4j.Slf4j;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@Slf4j
public class OrderAggregate {

    @AggregateIdentifier
    private  String orderId;
    private boolean orderConfirmed;

    CreateOrderCommand createCommand ;

    @CommandHandler
    public OrderAggregate(CreateOrderCommand command){
        this.createCommand= command;
        this.orderConfirmed=false;
        OrderCreatedEvent event = new OrderCreatedEvent();
        event.setOrderId(command.getOrderId());
        apply(event);
    }

    public OrderAggregate(){

    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent event) {
        this.orderId = event.getOrderId();
        orderConfirmed = false;
    }

    @EventSourcingHandler 
public void on(ConfirmOrderEvent event) { 
    orderConfirmed = true; 
    log.info("order with id {} confirmed {}",event.getOrderId(),orderConfirmed);
}

@CommandHandler 
    public void handle(ConfirmOrderCommand command) { 
    if (orderConfirmed) {
        return;
    }
    apply(new ConfirmOrderEvent(orderId)); 
} 

@CommandHandler 
public void handle(ShipOrderCommand command) { 
    if (!orderConfirmed) { 
        throw new UnconfirmedOrderException(); 
    } 
    apply(new ShipOrderEvent(orderId)); 
} 
    
    
}
