package com.luizjhonata.productcatalog.models;

import javax.persistence.*;

@Entity
@Table(name = "tb_product")
public class ProductModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String cod;

    private String description;

    private Double price;

    private Double weight;

    public ProductModel() {
    }

    public ProductModel(Integer id, String cod, String description, Double price, Double weight) {
        this.id = id;
        this.cod = cod;
        this.description = description;
        this.price = price;
        this.weight = weight;
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
}
