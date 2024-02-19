package com.divya.jwtauthentication.Auth;

import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.divya.jwtauthentication.Exception.EmailAlreadyExistsException;
import com.divya.jwtauthentication.Repository.RolePermissionsRepository;
import com.divya.jwtauthentication.Repository.RoleRepository;
import com.divya.jwtauthentication.Repository.TokenRepository;
import com.divya.jwtauthentication.Repository.UserRepository;
import com.divya.jwtauthentication.Service.JwtService;
// import com.divya.jwtauthentication.Users.Role;
import com.divya.jwtauthentication.Users.User;
import com.divya.jwtauthentication.token.TokenType;
import com.divya.jwtauthentication.token.Token;
import com.divya.jwtauthentication.Model.Role;
import com.divya.jwtauthentication.Model.RolePermissions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {

        private final UserRepository userRepository;
        private final TokenRepository tokenRepository;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;
        private final JwtService jwtService;
        private final RoleRepository roleRepository;
        private final RolePermissionsRepository rolePermissionsRepository;

        public AuthenticationResponse register(RegisterRequest request){
                Role role = roleRepository.findByRole(request.getRole().toLowerCase());
                System.out.println("Role................"+role);
                User user = User.builder()
                                .firstname(request.getFirstname())
                                .lastname(request.getLastname())
                                .email(request.getEmail())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .role(role) 
                                .permissions(getPermissions(role))
                                .build();

                System.out.println(request.getRole());
                if (userRepository.existsByEmail(user.getEmail())) {
                        throw new EmailAlreadyExistsException("Email already exists");
                }
                User savedUser = userRepository.save(user);

                var jwt = jwtService.generateToken(user);
                saveUserToken(savedUser,jwt);
                return AuthenticationResponse.builder()
                                .token(jwt)
                                .build();
        }


        private Set<RolePermissions> getPermissions(Role role) {
                ObjectId roleId = new ObjectId(role.get_id());
                System.out.println(roleId);

                List<RolePermissions> permissionsList = rolePermissionsRepository.findByRoleId(roleId);
                System.out.println("Permissions............"+permissionsList);
                Set<RolePermissions> permissions = Set.copyOf(permissionsList);
                log.info("Permissions............"+permissions);
                return permissions;
        }


        private void revokeAllUserTokens(User user)
        {
        List<Token> validUserTokens = tokenRepository.findActiveTokensByUserId(user.get_id());
        
        if(validUserTokens.isEmpty())
        {
                return;
        }

        validUserTokens.forEach(
                t -> {
                        t.setExpired(true);
                        t.setRevoked(true);
                }
        );
        tokenRepository.saveAll(validUserTokens); 
    }

        private void saveUserToken(User user, String token) {
                var usertoken = Token.builder()
                .user(user)
                .token(token)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .build();
        tokenRepository.save(usertoken);
        }

        public AuthenticationResponse authenticate(AuthenticationRequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
                var user = userRepository.findByEmail(request.getEmail())
                                .orElseThrow();
                var jwtToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user,jwtToken);
                return AuthenticationResponse.builder()
                                .token(jwtToken)
                                .build();

        }

}
