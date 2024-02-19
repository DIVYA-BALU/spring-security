package com.divya.jwtauthentication.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.divya.jwtauthentication.Model.Orders;

public interface OrderRepository extends MongoRepository<Orders, String>{
    
}
