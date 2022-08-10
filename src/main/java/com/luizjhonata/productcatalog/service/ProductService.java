package com.luizjhonata.productcatalog.service;

import com.luizjhonata.productcatalog.dto.ProductModelDTO;
import com.luizjhonata.productcatalog.models.ProductModel;
import com.luizjhonata.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    //Method to list all products sorted by id
    public List<ProductModelDTO> findAll(){
        List<ProductModel> listProduct = repository.findAll();
        return listProduct.stream().map(x -> new ProductModelDTO(x)).collect(Collectors.toList());
    }

    //Method to list all products sorted by cod in alphabetical order
    public List<ProductModelDTO> findAllByOrderCodAsc() {
        List<ProductModel> listProduct = repository.findAllByOrderByCodAsc();
        return listProduct.stream().map(x -> new ProductModelDTO(x)).collect(Collectors.toList());
    }

    //Method to find a product by id
    public List<ProductModelDTO> findById(Integer id) {
        Optional<ProductModel> product = repository.findById(id);
        return product.stream().map(ProductModelDTO::new).collect(Collectors.toList());
    }

    //Method to find a product by cod
    public List<ProductModelDTO> findByCod(String cod) {
        Optional<ProductModel> product = repository.findByCod(cod);
        return product.stream().map(ProductModelDTO::new).collect(Collectors.toList());
    }

    //Method to insert a new product
    public ProductModelDTO insert(@RequestBody ProductModelDTO productModelDTO){
        ProductModel newProduct = new ProductModel(null, productModelDTO.getCod(), productModelDTO.getDescription(),
                productModelDTO.getPrice(), productModelDTO.getWeight());
        newProduct = repository.save(newProduct);
        return new ProductModelDTO(newProduct);
    }

    public ProductModel update(@RequestBody ProductModel productModel) {

        if(repository.existsById(productModel.getId()))
            repository.save(productModel);

        return productModel;
    }



}
