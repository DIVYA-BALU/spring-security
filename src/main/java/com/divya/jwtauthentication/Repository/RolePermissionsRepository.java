package com.divya.jwtauthentication.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.divya.jwtauthentication.Model.Role;
import com.divya.jwtauthentication.Model.RolePermissions;

@Repository
public interface RolePermissionsRepository extends MongoRepository<RolePermissions,String>{

    @Query(value = "{'role.$id': ?0}")
    List<RolePermissions> findByRoleId(ObjectId roleId);
    
}
