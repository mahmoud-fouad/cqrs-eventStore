package com.mfouad.cqrs.axonCQRS.projections;

import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mfouad.cqrs.axonCQRS.ProductEntity;
import com.mfouad.cqrs.axonCQRS.queries.GetProductsQuery;
import com.mfouad.cqrs.axonCQRS.repo.ProductRepo;

@Component
public class ProductsProjection {
    @Autowired
    ProductRepo repo;

    @QueryHandler
    public List<ProductEntity> handle(GetProductsQuery query){
        return repo.findAll();
    }
}
