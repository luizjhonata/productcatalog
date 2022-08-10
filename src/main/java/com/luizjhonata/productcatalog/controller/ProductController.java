package com.luizjhonata.productcatalog.controller;

import com.luizjhonata.productcatalog.dto.ProductModelDTO;
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

    //Endpoint to list all products sorted by id number
    @GetMapping
    public ResponseEntity<List<ProductModelDTO>> findAll() {
        List<ProductModelDTO> listProduct = service.findAll();
        return ResponseEntity.ok().body(listProduct);
    }

    //Endpoint to list all products sorted by cod in alphabetical order
    @GetMapping(value = "/sorted")
    public ResponseEntity<List<ProductModelDTO>> findAllByOrderCodAsc() {
        List<ProductModelDTO> listProduct = service.findAllByOrderCodAsc();
        return ResponseEntity.ok().body(listProduct);
    }

    //Endpoint to find a product by id
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<List<ProductModelDTO>> findById(@PathVariable Integer id) {
        List<ProductModelDTO> product = service.findById(id);
        return ResponseEntity.ok(product);
    }

    //Endpoint to find a product by cod
    @GetMapping(value = "/cod/{cod}")
    public ResponseEntity<List<ProductModelDTO>> findByCod(@PathVariable String cod) {
        List<ProductModelDTO> product = service.findByCod(cod);
        return ResponseEntity.ok(product);
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
