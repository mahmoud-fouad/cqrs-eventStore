package com.mfouad.cqrs.axonCQRS;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRestModel {

    private String name;
    private Double price;
    private int quantity;
    
}
