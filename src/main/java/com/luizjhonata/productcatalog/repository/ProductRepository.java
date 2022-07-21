package com.luizjhonata.productcatalog.repository;

import com.luizjhonata.productcatalog.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
