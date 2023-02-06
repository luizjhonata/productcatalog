package com.luizjhonata.productcatalog.dto;

import com.luizjhonata.productcatalog.models.RoleModel;
import com.luizjhonata.productcatalog.models.UserModel;

import java.util.List;
import java.util.Optional;

public class UserModelDTO {


    private Integer id;

    private String name;

    private String username;

    private String password;

    private List<RoleModel> roleModels;

    public UserModelDTO() {
    }

    public UserModelDTO(Integer id, String name, String username, String password, List<RoleModel> roleModels) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.roleModels = roleModels;
    }

    public UserModelDTO(UserModel userModel) {
        id = userModel.getId();
        name = userModel.getName();
        username = userModel.getUsername();
        password = userModel.getPassword();
        roleModels = userModel.getRoleModels();
    }

    public UserModelDTO(Optional<UserModel> listUserByUsername) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleModel> getRoleModels() {
        return roleModels;
    }

    public void setRoleModels(List<RoleModel> roleModels) {
        this.roleModels = roleModels;
    }
}
