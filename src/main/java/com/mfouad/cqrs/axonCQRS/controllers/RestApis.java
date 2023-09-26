package com.mfouad.cqrs.axonCQRS.controllers;

import java.util.List;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfouad.cqrs.axonCQRS.ProductEntity;
import com.mfouad.cqrs.axonCQRS.ProductRestModel;
import com.mfouad.cqrs.axonCQRS.commands.ConfirmOrderCommand;
import com.mfouad.cqrs.axonCQRS.commands.CreateOrderCommand;
import com.mfouad.cqrs.axonCQRS.commands.CreateProductCommand;
import com.mfouad.cqrs.axonCQRS.commands.ShipOrderCommand;
import com.mfouad.cqrs.axonCQRS.queries.GetProductsQuery;

@RestController
@RequestMapping("")
public class RestApis {

    private CommandGateway gateway;
    private QueryGateway queryGateway;

    public RestApis(CommandGateway gateway,QueryGateway queryGateway) {
        this.gateway = gateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping("/products")
    public String addProduct(@RequestBody ProductRestModel model){
       CreateProductCommand command= CreateProductCommand.builder()
       .ident(UUID.randomUUID().toString())
       .name(model.getName())
       .price(model.getPrice())
       .quantity(model.getQuantity())
        .build();
       String resutl = gateway.sendAndWait(command);
        return resutl;
    }
     @GetMapping("/products")
     public List<ProductEntity> getProducts(){

      return queryGateway.query(new GetProductsQuery(),
      ResponseTypes.multipleInstancesOf(ProductEntity.class)).join();
     }

    @PostMapping("/order")
     public String createOrder(){
        CreateOrderCommand command = CreateOrderCommand.builder()
        .orderId(UUID.randomUUID().toString())
        .productsCount(3)
        .build();
         String resutl = gateway.sendAndWait(command);
        return resutl;

     }

     @PostMapping("/order/{id}")
     public void confirmOrder( @PathVariable (name = "id") String id){
        ConfirmOrderCommand command = ConfirmOrderCommand.builder().orderId(id).build();
        gateway.sendAndWait(command);
     }

     @PostMapping("/order/{id}/ship")
     public void shipOrder( @PathVariable (name = "id") String id){
        ShipOrderCommand command = ShipOrderCommand.builder().orderId(id).build();
        gateway.sendAndWait(command);
     }
    
}
