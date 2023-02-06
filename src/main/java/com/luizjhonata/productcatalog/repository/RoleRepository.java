package com.luizjhonata.productcatalog.repository;

import com.luizjhonata.productcatalog.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<RoleModel, Integer> {

    RoleModel findByRoleName(String roleName);


}
