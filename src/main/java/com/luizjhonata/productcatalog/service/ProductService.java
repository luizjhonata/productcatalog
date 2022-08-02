package com.luizjhonata.productcatalog.service;

import com.luizjhonata.productcatalog.models.ProductModel;
import com.luizjhonata.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<ProductModel> findAll(){
        List<ProductModel> listProductModels = repository.findAll();
        return listProductModels;
    }

    public Optional<ProductModel> findById(Integer id) {
        Optional<ProductModel> product = repository.findById(id);
        return product;
    }

    public Optional<ProductModel> findByCod(String cod) {
        Optional<ProductModel> product = repository.findByCod(cod);
        return product;
    }



    public ProductModel insert(@RequestBody ProductModel productModel){
        productModel = repository.save(productModel);
        return productModel;
    }

    public ProductModel update(@RequestBody ProductModel productModel) {

        if(repository.existsById(productModel.getId()))
            repository.save(productModel);

        return productModel;
    }



}
