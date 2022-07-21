package com.luizjhonata.productcatalog.service;

import com.luizjhonata.productcatalog.entities.Product;
import com.luizjhonata.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    public Optional<Product> findByCod(String cod) {
        Optional<Product> product = repository.findByCod(cod);
        return product;
    }



    public Product insert(@RequestBody Product product){
        product = repository.save(product);
        return product;
    }

    public Product update(@RequestBody Product product) {

        if(repository.existsById(product.getId()))
            repository.save(product);

        return product;
    }

//    public Product update(@PathVariable Integer id) {
//        Optional<Product> product = repository.findById(id);
//        if(productbD.isPresent()) {
//            repository.save(product);
//        }
//
//        return product;
//    }


}
