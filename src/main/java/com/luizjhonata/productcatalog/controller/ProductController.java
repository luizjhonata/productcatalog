package com.luizjhonata.productcatalog.controller;

import com.luizjhonata.productcatalog.entities.Product;
import com.luizjhonata.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "products")
public class ProductController {

    @Autowired
    private ProductService service;

    //Method to list all products
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> listProduct = service.findAll();
        return ResponseEntity.ok().body(listProduct);
    }

    //Method to find a product by id
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Integer id) {
        Optional<Product> product = service.findById(id);
        return ResponseEntity.ok().body(product);
    }

    //Method to find a product by cod 
    @GetMapping(value = "/cod/{cod}")
    public ResponseEntity<Optional<Product>> findByCod(@PathVariable String cod) {
        Optional<Product> product = service.findByCod(cod);
        return ResponseEntity.ok().body(product);
    }

}
