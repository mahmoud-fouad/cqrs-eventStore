package com.mfouad.cqrs.axonCQRS.events;




import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateProductEvent {


    private String name;
    private Double price;
    private int quantity;
    private  String  ident;
    
}
