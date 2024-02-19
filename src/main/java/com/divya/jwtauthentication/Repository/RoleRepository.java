package com.divya.jwtauthentication.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.divya.jwtauthentication.Model.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role,String> {

    Role findByRole(String role);

    
}
