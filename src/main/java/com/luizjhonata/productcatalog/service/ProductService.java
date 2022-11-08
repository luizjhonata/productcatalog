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
                productModelDTO.getPrice(), productModelDTO.getWeight(), productModelDTO.getDetails());
        repository.save(newProduct);
        return new ProductModelDTO(newProduct);
    }

    //Method to update all data in a product
    public ProductModelDTO update(@RequestBody ProductModelDTO productModel) {
        if(repository.existsById(productModel.getId())) {
            ProductModel updateProduct = repository.getReferenceById(productModel.getId());
            updateProduct.setCod(productModel.getCod());
            updateProduct.setDescription(productModel.getDescription());
            updateProduct.setPrice(productModel.getPrice());
            updateProduct.setWeight(productModel.getWeight());
            updateProduct.setDetails(productModel.getDetails());
            repository.save(updateProduct);
        }
        return productModel;
    }

    //Method to update the cod in a product
    public ProductModelDTO updateCod(Integer id, String cod) {
        if(repository.existsById(id)) {
            ProductModel updateCodProduct = repository.getReferenceById(id);
            updateCodProduct.setCod(cod);
            repository.save(updateCodProduct);
        }
        return null;
    }

    //Method to update the description in a product
    public ProductModelDTO updateDescription(Integer id, String Description) {
        if(repository.existsById(id)) {
            ProductModel updateDescriptionProduct = repository.getReferenceById(id);
            updateDescriptionProduct.setDescription(Description);
            repository.save(updateDescriptionProduct);
        }
        return null;
    }

    //Method to update the price in a product
    public ProductModelDTO updatePrice(Integer id, Double price) {
        if(repository.existsById(id)) {
            ProductModel updatePriceProduct = repository.getReferenceById(id);
            updatePriceProduct.setPrice(price);
            repository.save(updatePriceProduct);
        }
        return null;
    }

    //Method to update the Weight in a product
    public ProductModelDTO updateWeight(Integer id, Double weight) {
        if(repository.existsById(id)) {
            ProductModel updateWeightProduct = repository.getReferenceById(id);
            updateWeightProduct.setWeight(weight);
            repository.save(updateWeightProduct);
        }
        return null;
    }

    //Method to delete a product
    public void deleteById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}
