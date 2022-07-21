package com.luizjhonata.productcatalog.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_product")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String cod;

    private String description;

    private Double price;

    private Integer weigth;

    public Product() {
    }

    public Product(Integer id, String cod, String description, Double price, Integer weigth) {
        this.id = id;
        this.cod = cod;
        this.description = description;
        this.price = price;
        this.weigth = weigth;
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

    public Integer getWeigth() {
        return weigth;
    }

    public void setWeigth(Integer weigth) {
        this.weigth = weigth;
    }
}
