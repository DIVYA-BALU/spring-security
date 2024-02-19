package com.divya.jwtauthentication.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.divya.jwtauthentication.Model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{
    
}
