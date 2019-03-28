package com.ghjansen.checkout.persistence.model;

import javax.validation.constraints.NotNull;

public class Product {

    @NotNull(message = "Product code is required")
    private String code;
    @NotNull(message = "Product name is required")
    private String name;
    @NotNull(message = "Product value is required")
    private Double value;
    private String pictureUrl;

    public Product(@NotNull(message = "Product code is required") String code, @NotNull(message = "Product name is required") String name, @NotNull(message = "Product value is required") Double value, String pictureUrl) {
        this.code = code;
        this.name = name;
        this.value = value;
        this.pictureUrl = pictureUrl;
    }

    public Product() {
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
