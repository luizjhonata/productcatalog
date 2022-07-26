package com.luizjhonata.productcatalog.dto;

import com.luizjhonata.productcatalog.models.ProductModel;

public class ProductModelDTO {

    private Integer id;

    private String cod;

    private String description;

    private Double price;

    private Double weight;

    private String details;

    public ProductModelDTO() {
    }

    public ProductModelDTO(Integer id, String cod, String description, Double price, Double weight, String details) {
        this.id = id;
        this.cod = cod;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.details = details;
    }

    public ProductModelDTO(ProductModel productModel) {
        id = productModel.getId();
        cod = productModel.getCod();
        description = productModel.getDescription();
        price = productModel.getPrice();
        weight = productModel.getWeight();
        details = productModel.getDetails();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
