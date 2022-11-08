package com.luizjhonata.productcatalog.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "tb_product")
public class ProductModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Cod cannot be null")
    @NotEmpty(message = "Cod cannot be empty")
    @NotBlank(message = "Cod cannot be blank")
    @Size(min = 4, message = "Cod must have 4 or more characters")
    private String cod;

    @NotNull(message = "Description cannot be null")
    @NotEmpty(message = "Description cannot be empty")
    @NotBlank(message = "Description cannot be blank")
    @Size(min = 5, message = "Cod must have 5 or more characters")
    private String description;

    @NotNull(message = "Please enter a price")
    @Min(value = 0, message = "Price cannot be less than 0")
    private Double price;

    @NotNull(message = "Please enter a weight")
    @Min(value = 0, message = "Weight cannot be less than 0")
    private Double weight;

    private String details;

    public ProductModel() {
    }

    public ProductModel(Integer id, String cod, String description, Double price, Double weight, String details) {
        this.id = id;
        this.cod = cod;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.details = details;
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
