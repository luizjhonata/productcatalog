package com.luizjhonata.productcatalog.dto;

import com.luizjhonata.productcatalog.models.RoleModel;
import com.luizjhonata.productcatalog.models.UserModel;

import java.util.List;

public class UserModelDTO {


    private Integer userId;

    private String name;

    private String username;

    private String password;

    private List<RoleModel> roleModels;

    public UserModelDTO() {
    }

    public UserModelDTO(Integer userId, String name, String username, String password, List<RoleModel> roleModels) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.roleModels = roleModels;
    }

    public UserModelDTO(UserModel userModel) {
        userId = userModel.getUserId();
        name = userModel.getName();
        username = userModel.getUsername();
        password = userModel.getPassword();
        roleModels = userModel.getRoleModels();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
