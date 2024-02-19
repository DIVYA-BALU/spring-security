package com.divya.jwtauthentication.Service;

import java.util.List;

import com.divya.jwtauthentication.Users.User;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(String id);
	User updateUser(User user);
	void deleteUser(String id);
   
}
