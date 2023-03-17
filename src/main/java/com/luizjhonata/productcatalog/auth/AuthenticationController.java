package com.luizjhonata.productcatalog.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/authenticate")
    @CrossOrigin(origins = {"https://roaring-hummingbird-96066b.netlify.app" })
//    @CrossOrigin(origins = {"http://127.0.0.1:5173/",  "http://localhost:3000/"})
    public ResponseEntity<AuthenticationResponse> authenticate (
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }
}
