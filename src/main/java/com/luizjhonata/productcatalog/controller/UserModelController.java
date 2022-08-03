package com.luizjhonata.productcatalog.controller;

import com.luizjhonata.productcatalog.models.ProductModel;
import com.luizjhonata.productcatalog.models.UserModel;
import com.luizjhonata.productcatalog.service.UserModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserModelController {

    @Autowired
    private UserModelService service;

    @PostMapping(value = "/insert")
    public ResponseEntity<UserModel> insert(@RequestBody UserModel newUser) {
        newUser.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));
        newUser = service.insert(newUser);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> findAll() {
        List<UserModel> listUserModel = service.findAll();
        return ResponseEntity.ok().body(listUserModel);
    }
}
