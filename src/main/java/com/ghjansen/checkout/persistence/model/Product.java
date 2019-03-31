package com.ghjansen.checkout.persistence.model;

import javax.validation.constraints.NotNull;

public class Product implements Entity {

    @NotNull(message = "Product id is required")
    private Long id;
    @NotNull(message = "Product code is required")
    private String code;
    @NotNull(message = "Product name is required")
    private String name;
    @NotNull(message = "Product value is required")
    private Double value;
    private String pictureUrl;

    public Product(@NotNull(message = "Product id is required") final Long id, @NotNull(message = "Product code is required") final String code, @NotNull(message = "Product name is required") final String name, @NotNull(message = "Product value is required") final Double value, final String pictureUrl) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.value = value;
        this.pictureUrl = pictureUrl;
    }

    public Product(@NotNull(message = "Product code is required") final String code, @NotNull(message = "Product name is required") final String name, @NotNull(message = "Product value is required") final Double value, final String pictureUrl) {
        this(null, code, name, value, pictureUrl);
    }

    public Product(){

    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(final Double value) {
        this.value = value;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(final String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
