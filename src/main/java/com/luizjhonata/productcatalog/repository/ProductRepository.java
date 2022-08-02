package com.luizjhonata.productcatalog.repository;

import com.luizjhonata.productcatalog.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductModel, Integer> {

    Optional<ProductModel> findByCod(String cod);


}
