package com.luizjhonata.productcatalog.controller;

import com.luizjhonata.productcatalog.dto.UserModelDTO;
import com.luizjhonata.productcatalog.service.UserModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserModelController {

    @Autowired
    private UserModelService service;

    //Endpoint to insert a new user
    @PostMapping(value = "/insert")
    public ResponseEntity<UserModelDTO> insert(@RequestBody UserModelDTO newUserDTO) {
        newUserDTO.setPassword(new BCryptPasswordEncoder().encode(newUserDTO.getPassword()));
        service.insert(newUserDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newUserDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(newUserDTO);
    }

    //Endpoint to get all users
    @GetMapping
    public ResponseEntity<List<UserModelDTO>> findAll() {
        List<UserModelDTO> listUserModel = service.findAll();
        return ResponseEntity.ok().body(listUserModel);
    }

    //Endpoint to get a user by username
    @GetMapping(value = "/username/{username}")
    public ResponseEntity<List<UserModelDTO>> findByUsername(@PathVariable String username) {
        List<UserModelDTO> listUserModel = service.findByUsername(username);
        return ResponseEntity.ok().body(listUserModel);
    }

    //Endpoint to get a user by ID
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<List<UserModelDTO>> findById(@PathVariable Integer id) {
        List<UserModelDTO> listUserModel = service.findById(id);
        return ResponseEntity.ok().body(listUserModel);
    }
}