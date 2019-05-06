package com.ghjansen.checkout.persistence.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Product code is required")
    @Basic(optional = false)
    private String code;
    @NotNull(message = "Product name is required")
    @Basic(optional = false)
    private String name;
    @NotNull(message = "Product value is required")
    @Basic(optional = false)
    private Double value;
    private String pictureUrl;

    public Product(Long id, @NotNull(message = "Product code is required") String code, @NotNull(message = "Product name is required") String name, @NotNull(message = "Product value is required") Double value, String pictureUrl) {
        this.id = id;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
