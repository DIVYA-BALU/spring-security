package com.divya.jwtauthentication.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.divya.jwtauthentication.Model.Record;

public interface RecordRepository extends MongoRepository<Record, String>{
    
}
