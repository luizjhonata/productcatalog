package com.luizjhonata.productcatalog.service;

import com.luizjhonata.productcatalog.dto.ProductModelDTO;
import com.luizjhonata.productcatalog.dto.UserModelDTO;
import com.luizjhonata.productcatalog.models.UserModel;
import com.luizjhonata.productcatalog.repository.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
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
       newUser.setPassword(newUserDTO.getPassword());
       newUser.setRoleModels(newUserDTO.getRoleModels());
       repository.save(newUser);
        return new UserModelDTO(newUser);
    }

    //Method to list all users
    public List<UserModelDTO> findAll() {
        List<UserModel> listUserModel = repository.findAll();
        return listUserModel.stream().map(x -> new UserModelDTO(x)).collect(Collectors.toList());
    }
}
