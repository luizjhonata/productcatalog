package com.luizjhonata.productcatalog.repository;

import com.luizjhonata.productcatalog.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByCod(String cod);


}
