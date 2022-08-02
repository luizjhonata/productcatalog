package com.luizjhonata.productcatalog.controller;

import com.luizjhonata.productcatalog.models.ProductModel;
import com.luizjhonata.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "products")
public class ProductController {

    @Autowired
    private ProductService service;

    //Method to list all products
    @GetMapping
    public ResponseEntity<List<ProductModel>> findAll() {
        List<ProductModel> listProductModel = service.findAll();
        return ResponseEntity.ok().body(listProductModel);
    }

    //Method to find a product by id
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Optional<ProductModel>> findById(@PathVariable Integer id) {
        Optional<ProductModel> product = service.findById(id);
        return ResponseEntity.ok().body(product);
    }

    //Method to find a product by cod
    @GetMapping(value = "/cod/{cod}")
    public ResponseEntity<Optional<ProductModel>> findByCod(@PathVariable String cod) {
        Optional<ProductModel> product = service.findByCod(cod);
        return ResponseEntity.ok().body(product);
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<ProductModel> insert(@RequestBody ProductModel productModel) {
        productModel = service.insert(productModel);
        return ResponseEntity.ok(productModel);

    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ProductModel> update(@PathVariable Integer id, @RequestBody ProductModel productModel) {
        productModel = service.update(productModel);

        return ResponseEntity.ok(productModel);

    }

}
