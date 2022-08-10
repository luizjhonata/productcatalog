package com.luizjhonata.productcatalog.repository;

import com.luizjhonata.productcatalog.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductModel, Integer> {


    //method to find products by cod
    Optional<ProductModel> findByCod(String cod);


    //method to list all products sorted by cod in alphabetical order
    List<ProductModel> findAllByOrderByCodAsc();



}
