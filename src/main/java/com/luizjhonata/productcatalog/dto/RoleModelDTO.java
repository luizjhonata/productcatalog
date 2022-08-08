package com.luizjhonata.productcatalog.dto;

import com.luizjhonata.productcatalog.enums.RoleName;
import com.luizjhonata.productcatalog.models.RoleModel;

public class RoleModelDTO {

    private Integer roleId;

    private RoleName roleName;

    public RoleModelDTO() {
    }

    public RoleModelDTO(Integer roleId, RoleName roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public RoleModelDTO(RoleModel roleModel) {
        roleId = roleModel.getRoleId();
        roleName = roleModel.getRoleName();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
}
