package com.divya.jwtauthentication.Service.Imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.divya.jwtauthentication.Repository.UserRepository;
import com.divya.jwtauthentication.Service.UserService;
import com.divya.jwtauthentication.Users.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(String id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}
    

}
