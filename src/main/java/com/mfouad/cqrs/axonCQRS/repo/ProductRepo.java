package com.mfouad.cqrs.axonCQRS.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mfouad.cqrs.axonCQRS.ProductEntity;

public interface ProductRepo  extends JpaRepository<ProductEntity,String>{
    
}
