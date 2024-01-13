package com.divya.jwtauthentication.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.divya.jwtauthentication.Repository.UserRepository;
import com.divya.jwtauthentication.Service.JwtService;
import com.divya.jwtauthentication.Users.Role;
import com.divya.jwtauthentication.Users.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;
        private final JwtService jwtService;

        public AuthenticationResponse register(RegisterRequest request) {
                User user = User.builder()
                                .firstname(request.getFirstname())
                                .lastname(request.getLastname())
                                .email(request.getEmail())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .role(Role.USER)
                                .build();
                //userRepository.save(user);
                System.out.println(user);
                var jwt = jwtService.generateToken(userRepository.save(user));
                System.out.println(jwt);
                return AuthenticationResponse.builder()
                                .token(jwt)
                                .build();
        }

        public AuthenticationResponse authenticate(AuthenticationRequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
                var user = userRepository.findByEmail(request.getEmail())
                                .orElseThrow();
                var jwtToken = jwtService.generateToken(user);
                System.out.println("the                           token is :"+jwtToken);
                return AuthenticationResponse.builder()
                                .token(jwtToken)
                                .build();

        }

}
