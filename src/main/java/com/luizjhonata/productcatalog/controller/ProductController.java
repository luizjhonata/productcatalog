package com.luizjhonata.productcatalog.controller;

import com.luizjhonata.productcatalog.dto.ProductModelDTO;
import com.luizjhonata.productcatalog.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "products")
public class ProductController {

    @Autowired
    private ProductService service;

    //Endpoint to list all products sorted by id number
    @Operation(summary = "Get a list off all products sorted by id")
//    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @CrossOrigin(origins = "https://roaring-hummingbird-96066b.netlify.app/")
    @GetMapping
    public ResponseEntity<List<ProductModelDTO>> findAll() {
        List<ProductModelDTO> listProduct = service.findAll();
        return ResponseEntity.ok().body(listProduct);
    }

    //Endpoint to list all products sorted by cod in alphabetical order
    @Operation(summary = "Get a list of all products sorted by cod in alphabetical order")
//    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @CrossOrigin(origins = "https://roaring-hummingbird-96066b.netlify.app/")
    @GetMapping(value = "/sorted")
    public ResponseEntity<List<ProductModelDTO>> findAllByOrderCodAsc() {
        List<ProductModelDTO> listProduct = service.findAllByOrderCodAsc();
        return ResponseEntity.ok().body(listProduct);
    }

    //Endpoint to find a product by id
    @Operation(summary = "Find a product by his id")
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<List<ProductModelDTO>> findById(@PathVariable Integer id) {
        List<ProductModelDTO> product = service.findById(id);
        return ResponseEntity.ok(product);
    }

    //Endpoint to find a product by cod
    @Operation(summary = "Find a product by his COD")
    @GetMapping(value = "/cod/{cod}")
    public ResponseEntity<List<ProductModelDTO>> findByCod(@PathVariable String cod) {
        List<ProductModelDTO> product = service.findByCod(cod);
        return ResponseEntity.ok(product);
    }

    //Endpoint to insert a new product
    @Operation(summary = "Insert a new product")
    @PostMapping(value = "/insert")
    public ResponseEntity<ProductModelDTO> insert(@Valid @RequestBody ProductModelDTO productModel) {
        service.insert(productModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(productModel.getId()).toUri();
        return ResponseEntity.created(uri).body(productModel);
    }

    //Endpoint to update all data in a product
    @Operation(summary = "Update all data in a product with his ID")
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ProductModelDTO> update(@PathVariable Integer id, @RequestBody ProductModelDTO productModel) {
        service.update(productModel);
        return ResponseEntity.ok(productModel);
    }

    //Endpoint to update the cod in a product
    @Operation(summary = "Update the product COD with his ID")
    @PutMapping(value = "/update/cod/{id}")
    public ResponseEntity<ProductModelDTO> updateCod(@PathVariable Integer id, String cod) {
        ProductModelDTO updateCodProduct = service.updateCod(id, cod);
        return ResponseEntity.ok(updateCodProduct);
    }

    //Endpoint to update the Description in a product
    @Operation(summary = "Update the product DESCRIPTION with his ID")
    @PutMapping(value = "/update/desc/{id}")
    public ResponseEntity<ProductModelDTO> updateDescription(@PathVariable Integer id, String description) {
        ProductModelDTO updateDescriptionProduct = service.updateDescription(id, description);
        return ResponseEntity.ok(updateDescriptionProduct);
    }

    //Endpoint to update the Price in a product
    @Operation(summary = "Update the product PRICE with his ID")
    @PutMapping(value = "/update/price/{id}")
    public ResponseEntity<ProductModelDTO> updatePrice(@PathVariable Integer id, Double price) {
        ProductModelDTO updatePriceProduct = service.updatePrice(id, price);
        return ResponseEntity.ok(updatePriceProduct);
    }

    //Endpoint to update the Weight in a product
    @Operation(summary = "Update the product WEIGHT with his ID")
    @PutMapping(value = "/update/weight/{id}")
    public ResponseEntity<ProductModelDTO> updateWeight(@PathVariable Integer id, Double weight) {
        ProductModelDTO updateWeightProduct = service.updateWeight(id, weight);
        return ResponseEntity.ok(updateWeightProduct);
    }

    //Endpoint to update the Details in a product
    @Operation(summary = "Update the product DETAILS with his ID")
    @PutMapping(value = "/update/details/{id}")
    public ResponseEntity<ProductModelDTO> updateDetails(@PathVariable Integer id, String details) {
        ProductModelDTO updateDetailsProduct = service.updateDetails(id, details);
        return ResponseEntity.ok(updateDetailsProduct);
    }

    //Endpoint to delete a product with his ID
    @Operation(summary = "Delete a product data with his ID")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }
}
