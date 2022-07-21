package com.luizjhonata.productcatalog.service;

import com.luizjhonata.productcatalog.entities.Product;
import com.luizjhonata.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        List<Product> listProducts = repository.findAll();
        return listProducts;
    }

}
