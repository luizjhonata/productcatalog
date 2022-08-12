package com.luizjhonata.productcatalog.service;

import com.luizjhonata.productcatalog.dto.ProductModelDTO;
import com.luizjhonata.productcatalog.dto.UserModelDTO;
import com.luizjhonata.productcatalog.models.ProductModel;
import com.luizjhonata.productcatalog.models.UserModel;
import com.luizjhonata.productcatalog.repository.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserModelService {

    @Autowired
    private UserModelRepository repository;

    //Method to insert new users
    @Transactional
    public UserModelDTO insert(@RequestBody UserModelDTO newUserDTO) {
        UserModel newUser = new UserModel();
        newUser.setName(newUserDTO.getName());
        newUser.setUsername(newUserDTO.getUsername());
        newUser.setPassword(new BCryptPasswordEncoder().encode(newUserDTO.getPassword()));
        newUser.setRoleModels(newUserDTO.getRoleModels());
        repository.save(newUser);
        return new UserModelDTO(newUser);
    }

    //Method to list all users
    public List<UserModelDTO> findAll() {
        List<UserModel> listUserModel = repository.findAll();
        return listUserModel.stream().map(UserModelDTO::new).collect(Collectors.toList());
    }

    //Method to list a user by username
    public List<UserModelDTO> findByUsername(String username) {
        Optional<UserModel> listUserByUsername = repository.findByUsername(username);
        return listUserByUsername.stream().map(UserModelDTO::new).collect(Collectors.toList());
    }

    //Method to list a user by id
    public List<UserModelDTO> findById(Integer id) {
        Optional<UserModel> listUserById = repository.findById(id);
        return listUserById.stream().map(UserModelDTO::new).collect(Collectors.toList());
    }

    //Method to update the username in a user
    public UserModelDTO updateUsername(Integer id, String username) {
        if(repository.existsById(id)) {
            UserModel updateUsernameUser = repository.getReferenceById(id);
            updateUsernameUser.setUsername(username);
            repository.save(updateUsernameUser);
        }
        return null;
    }

    //Method to update the name in a user
    public UserModelDTO updateName(Integer id, String name) {
        if(repository.existsById(id)) {
            UserModel updateNameUser = repository.getReferenceById(id);
            updateNameUser.setName(name);
            repository.save(updateNameUser);
        }
        return null;
    }

    //Method to update a user's password
    public UserModelDTO updatePassword(Integer id, String password) {
        if(repository.existsById(id)) {
            UserModel updatePasswordUser = repository.getReferenceById(id);
            updatePasswordUser.setPassword(new BCryptPasswordEncoder().encode(password));
            repository.save(updatePasswordUser);
        }
        return null;
    }

    //Method to update data in a user
    @Transactional
    public UserModelDTO updateUser(@RequestBody UserModelDTO userModelUpdate) {
        if(repository.existsById(userModelUpdate.getId())) {
            UserModel updateUser = repository.getReferenceById(userModelUpdate.getId());
            updateUser.setName(userModelUpdate.getName());
            updateUser.setUsername(userModelUpdate.getUsername());
            updateUser.setPassword(new BCryptPasswordEncoder().encode(userModelUpdate.getPassword()));
            updateUser.setRoleModels(userModelUpdate.getRoleModels());
            repository.save(updateUser);
        }
        return userModelUpdate;
    }

//    public ProductModelDTO update(@RequestBody ProductModelDTO productModel) {
//        if(repository.existsById(productModel.getId())) {
//            ProductModel updateProduct = repository.getReferenceById(productModel.getId());
//            updateProduct.setCod(productModel.getCod());
//            updateProduct.setDescription(productModel.getDescription());
//            updateProduct.setPrice(productModel.getPrice());
//            updateProduct.setWeight(productModel.getWeight());
//            repository.save(updateProduct);
//        }
//        return productModel;
//    }
}