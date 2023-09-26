package com.mfouad.cqrs.axonCQRS.commands;

import java.io.Serializable;
import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductCommand implements Serializable{

    private String name;
    private Double price;
    private int quantity;

    //command aggregation identifier
    @TargetAggregateIdentifier
    private String ident;
    
}
