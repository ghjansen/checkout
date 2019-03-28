package com.ghjansen.checkout.persistence.model;

import javax.validation.constraints.NotNull;

public class Product {

    private Long id;
    @NotNull(message = "Product name is required")
    private String name;
    private Double value;
    private String pictureUrl;

    public Product(Long id, @NotNull(message = "Product name is required") String name, Double value, String pictureUrl) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.pictureUrl = pictureUrl;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
