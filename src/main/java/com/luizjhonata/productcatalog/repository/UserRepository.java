package com.luizjhonata.productcatalog.repository;

import com.luizjhonata.productcatalog.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

    UserModel findByUsername(String username);

}
