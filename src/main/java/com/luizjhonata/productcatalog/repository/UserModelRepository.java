package com.luizjhonata.productcatalog.repository;

import com.luizjhonata.productcatalog.models.UserModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserModelRepository extends JpaRepository<UserModel, Integer> {

    Optional<UserModel> findByUsername(String username);

}
