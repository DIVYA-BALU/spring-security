package com.divya.jwtauthentication.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.divya.jwtauthentication.Users.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    public Optional<User> findByEmail(String email);

    public boolean existsByEmail(String email);

}
