package com.divya.jwtauthentication.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.divya.jwtauthentication.Model.Permissions;

@Repository
public interface PermissionsRepository extends MongoRepository<Permissions,String>{

    
} 
