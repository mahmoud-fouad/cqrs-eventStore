package com.mfouad.cqrs.axonCQRS.aggregates;

import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.mfouad.cqrs.axonCQRS.commands.CreateProductCommand;
import com.mfouad.cqrs.axonCQRS.events.CreateProductEvent;

@Aggregate
public class ProductsAggregate {

 
    
    @AggregateIdentifier
    private  String ident;
    private String name;
    private Double price;
    private int quantity;

    CreateProductCommand createCommand;

    @CommandHandler
    public ProductsAggregate(CreateProductCommand createCommand) {
        this.createCommand = createCommand;
        CreateProductEvent event = new CreateProductEvent();
        BeanUtils.copyProperties(createCommand, event);
        AggregateLifecycle.apply(event);
    }

    public ProductsAggregate(){

    }

    @EventSourcingHandler
    public void on(CreateProductEvent event){
        this.name=event.getName();
        this.price = event.getPrice();
        this.quantity = event.getQuantity();  
        this.ident = event.getIdent();
    }
    
    
}
