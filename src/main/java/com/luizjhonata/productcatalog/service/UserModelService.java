package com.luizjhonata.productcatalog.service;

import com.luizjhonata.productcatalog.models.UserModel;
import com.luizjhonata.productcatalog.repository.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserModelService {

    @Autowired
    private UserModelRepository repository;

    @Transactional
    public UserModel insert(@RequestBody UserModel newUser) {
        return repository.save(newUser);
    }

    public List<UserModel> findAll() {
        List<UserModel> listUserModel = repository.findAll();
        return listUserModel;
    }
}
