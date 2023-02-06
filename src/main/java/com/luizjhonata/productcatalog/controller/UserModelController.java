package com.luizjhonata.productcatalog.controller;

import com.luizjhonata.productcatalog.dto.UserModelDTO;
import com.luizjhonata.productcatalog.models.RoleModel;
import com.luizjhonata.productcatalog.service.UserModelService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "users")
public class UserModelController {

    @Autowired
    private UserModelService service;

    //Endpoint to insert a new user
    @Operation(summary = "Insert a New User")
    @PostMapping(value = "/insert")
    public ResponseEntity<UserModelDTO> insert(@Valid @RequestBody UserModelDTO newUserDTO) throws Exception {
        service.insert(newUserDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newUserDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(newUserDTO);
    }

    //Endpoint to get all users
    @Operation(summary = "Get a list of all users")
    @GetMapping
    public ResponseEntity<List<UserModelDTO>> findAll() {
        List<UserModelDTO> listUserModel = service.findAll();
        return ResponseEntity.ok().body(listUserModel);
    }

    //Endpoint to get a user by username
    @Operation(summary = "Find a user by his USERNAME")
    @GetMapping(value = "/username/{username}")
    public ResponseEntity<List<UserModelDTO>> findByUsername(@PathVariable String username) {
        List<UserModelDTO> listUserModel = service.findByUsername(username);
        return ResponseEntity.ok().body(listUserModel);
    }

    //Endpoint to get a user by ID
    @Operation(summary = "Find a user by his ID")
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<List<UserModelDTO>> findById(@PathVariable Integer id) {
        List<UserModelDTO> listUserModel = service.findById(id);
        return ResponseEntity.ok().body(listUserModel);
    }

    //Endpoint to update the username in a user
    @Operation(summary = "Update the USERNAME with his ID")
    @PutMapping(value = "/update/username/{id}")
    public ResponseEntity<UserModelDTO> updateUsername(@PathVariable Integer id, String username) {
        UserModelDTO updateUsernameUser = service.updateUsername(id, username);
        return ResponseEntity.ok(updateUsernameUser);
    }

    //Endpoint to update the name in a user
    @Operation(summary = "Update the NAME user with his ID")
    @PutMapping(value = "/update/name/{id}")
    public ResponseEntity<UserModelDTO> updateName(@PathVariable Integer id, String name) {
        UserModelDTO updateNameUser = service.updateName(id, name);
        return ResponseEntity.ok(updateNameUser);
    }

    //Endpoint to update a user's password
    @Operation(summary = "Update the PASSWORD user with his ID")
    @PutMapping(value = "/update/password/{id}")
    public ResponseEntity<UserModelDTO> updatePassword(@PathVariable Integer id, String password) throws Exception {
//        UserModelDTO updatePasswordUser = service.updatePassword(id, new BCryptPasswordEncoder().encode(password));
        UserModelDTO updatePasswordUser = service.updatePassword(id, password);
        return ResponseEntity.ok(updatePasswordUser);
    }

    //Endpoint to update all data in a user
    @Operation(summary = "Update ALL user data with his ID")
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<UserModelDTO> update(@PathVariable Integer id, @RequestBody UserModelDTO userModelUpdate) {
        service.updateUser(userModelUpdate);
        return ResponseEntity.ok(userModelUpdate);
    }

    //Endpoint to delete a user with his ID
    @Operation(summary = "Delete a user data with his ID")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }

    @PostMapping("/role/save")
    public ResponseEntity<RoleModel> saveRole(@RequestBody RoleModel role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/role/save").toUriString());
        return ResponseEntity.created(uri).body(service.saveRole(role));
    }

//    @PostMapping("/role/addtouser")
//    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
//        service.addRoleToUser(form.getUsername(), form.getRoleName());
//        return ResponseEntity.ok().build();
//    }

}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}