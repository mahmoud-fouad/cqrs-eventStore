package com.mfouad.cqrs.axonCQRS.events;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mfouad.cqrs.axonCQRS.ProductEntity;
import com.mfouad.cqrs.axonCQRS.repo.ProductRepo;

@Component
public class ProductsEventHandler {
    
    @Autowired
    ProductRepo repo;

    @EventHandler
    public void on(CreateProductEvent event){

        ProductEntity entity = new ProductEntity();
        BeanUtils.copyProperties(event, entity);    
        repo.save(entity);

    }
}
