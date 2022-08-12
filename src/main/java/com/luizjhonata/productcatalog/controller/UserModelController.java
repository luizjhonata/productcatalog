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

    //Endpoint to update the username in a user
    @PutMapping(value = "/update/username/{id}")
    public ResponseEntity<UserModelDTO> updateUsername(@PathVariable Integer id, String username) {
        UserModelDTO updateUsernameUser = service.updateUsername(id, username);
        return ResponseEntity.ok(updateUsernameUser);
    }

    //Endpoint to update the name in a user
    @PutMapping(value = "/update/name/{id}")
    public ResponseEntity<UserModelDTO> updateName(@PathVariable Integer id, String name) {
        UserModelDTO updateNameUser = service.updateName(id, name);
        return ResponseEntity.ok(updateNameUser);
    }

    //Endpoint to update a user's password
    @PutMapping(value = "/update/password/{id}")
    public ResponseEntity<UserModelDTO> updatePassword(@PathVariable Integer id, String password) {
        UserModelDTO updatePasswordUser = service.updatePassword(id, new BCryptPasswordEncoder().encode(password));
        return ResponseEntity.ok(updatePasswordUser);
    }

    //Endpoint to update all data in a user
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<UserModelDTO> update(@PathVariable Integer id, @RequestBody UserModelDTO userModelUpdate) {
        service.updateUser(userModelUpdate);
        return ResponseEntity.ok(userModelUpdate);
    }
}