package com.mfouad.cqrs.axonCQRS;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ProductEntity {

    private String name;
    private Double price;
    private int quantity;
    @Id
    private String ident;
    
}
