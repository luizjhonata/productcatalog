package com.luizjhonata.productcatalog.service;

import com.luizjhonata.productcatalog.entities.Product;
import com.luizjhonata.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        List<Product> listProducts = repository.findAll();
        return listProducts;
    }

    public Optional<Product> findById(Integer id) {
        Optional<Product> product = repository.findById(id);
        return product;
    }

}
