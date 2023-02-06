package com.luizjhonata.productcatalog.auth;

import com.luizjhonata.productcatalog.config.JwtService;
import com.luizjhonata.productcatalog.repository.UserModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserModelRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    //THIS IS FOR USE IN AN EXTERNAL APPLICATION
//    public AuthenticationResponse register(RegisterRequest request) {
//        var user = UserModel.builder()
//                .name(request.getName())
//                .username(request.getUsername())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .roleModels(RoleModel.USER) //TO USE THAT YOU NEED A ROLEMODEL ENUM
//                .build();
//        repository.save(user);
//        var jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();
//    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = repository.findByUsername(request.getUsername())
                .orElseThrow();
        //NEED TO DO SOME TREATMENT FOR WHEN THE USER TYPE THE WRONG PASSWORD
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
